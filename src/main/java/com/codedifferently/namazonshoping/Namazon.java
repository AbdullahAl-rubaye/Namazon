package com.codedifferently.namazonshoping;

import com.codedifferently.namazonshoping.accounts.Account;
import com.codedifferently.namazonshoping.accounts.Customer;
import com.codedifferently.namazonshoping.accounts.Vendor;
import com.codedifferently.namazonshoping.exceptions.AccountAuthenticationException;
import com.codedifferently.namazonshoping.exceptions.AccountCreationException;
import com.codedifferently.namazonshoping.exceptions.AccountDoesntExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Namazon {
    private List<Customer> Customers;
    private List<Vendor> Vendors;
    private Account currentUser=null;
    private static final Scanner scanner = new Scanner(System.in);
    public Namazon() {
        this.Customers = new ArrayList<>();;
        this.Vendors = new ArrayList<>();;
    }

    public List<Customer> getCustomers() {
        return Customers;
    }

    public void setCustomers(List<Customer> customers) {
        Customers = customers;
    }

    public List<Vendor> getVendors() {
        return Vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        Vendors = vendors;
    }

    public Account SignIn(String email, String password) throws AccountDoesntExistException,AccountCreationException {


        for(Vendor vendor: Vendors) {
            if (vendor.getEmail().equals(email) && vendor.getPassword().equals(password)) {
                return vendor;
            }
        }
        for(Customer customer: Customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
            throw new AccountDoesntExistException("msg");


    }

    public Vendor signUpAsVendor(String firstName,String lastName,String email,String password,String brandName) throws AccountCreationException{
        for(Vendor vendor : Vendors) {
            if (email.equals(vendor.getEmail())) {
                throw new AccountCreationException("User with email exists: " + email);
            }
        }
        Vendor vendor = new Vendor(firstName,lastName,email,password,brandName);
        Vendors.add( vendor);
        return vendor;
    }
    public Customer signUpAsCustomer(String firstName,String lastName,String email,String password)throws AccountCreationException{
        for(Customer customer : Customers) {
            if (email.equals(customer.getEmail())) {
                throw new AccountCreationException("User with email exists: " + email);
            }
        }
        Customer customer = new Customer(firstName,lastName,email,password);
        Customers.add( customer);
        return customer;
    }

    public Vendor selectVendor(){
        String Svendor;
        String no="try again";
        Scanner s = new Scanner(System.in);
        System.out.print("select vendor:");//username:user
        Svendor = s.nextLine();
        for(Vendor vendor : Vendors) {
            if(vendor.equals(Svendor)){
                return vendor;
            }
        }

        return null;
    }
    public void run() throws AccountDoesntExistException, AccountCreationException, AccountAuthenticationException {
        Boolean flag = true;
        while (flag){
            if(currentUser == null)
                flag = welcomeScreen();
            else{
                userOptionsScreen();
            }
        }
    }

    private Boolean userOptionsScreen(){
        String msg = String.format("Welcome %s, here are your options", Customers);
        Scanner s = new Scanner(System.in);
        msg += "\nPress 3 to log out";
        System.out.println(msg);
        String selection = scanner.next();
        switch (selection){
            case "3":
                currentUser = null;
                return false;
            default:
                return true;
        }

    }
    private Boolean welcomeScreen() throws AccountCreationException, AccountDoesntExistException, AccountAuthenticationException {
        Boolean flag = true;
        String output = "Welcome to Namazon :) . Please select from the following options."
                +"\nPress 1 to login"
                +"\nPress 2 to create new account"
                +"\nPress 3 to exit";
        System.out.println(output);
        String selection = scanner.next();
        switch (selection){
            case "1":
                attemptSignIn();
                break;
            case "2":
                attemptSignUp();
                break;
            case "3":
            default:
                System.out.println("Good Bye");
                flag = false;
        }
        return flag;
    }

    private void attemptSignIn() throws AccountCreationException,AccountDoesntExistException,AccountAuthenticationException{
        try {

            System.out.println("Please enter valid email:");
            String email = scanner.next();
            System.out.println("Please enter valid password");
            String password = scanner.next();
            Account customer =  SignIn(email,password);
        } catch (AccountDoesntExistException e) {
            System.out.println("You entered the wrong password");
        } catch (AccountCreationException e) {
            System.out.println("The password was incorrect");
        }

    }

    private void attemptSignUp()throws AccountCreationException{
        try {
            System.out.println("Please enter first name");
            String firstName = scanner.next();
            System.out.println("Please enter last name");
            String lastName = scanner.next();
            System.out.println("Please enter email");
            String email = scanner.next();
            System.out.println("Please enter password");
            String password = scanner.next();
            currentUser = (Customer )signUpAsCustomer(firstName, lastName, email, password);
        } catch (AccountCreationException e) {
            System.out.println("User with email all ready exist");
        }
    }

    public static void main(String[] args) throws AccountDoesntExistException, AccountCreationException, AccountAuthenticationException {
        Namazon mainApplication = new Namazon();
        mainApplication.run();
    }
}
