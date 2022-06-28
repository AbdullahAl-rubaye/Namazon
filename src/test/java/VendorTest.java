import com.codedifferently.namazonshoping.Address;
import com.codedifferently.namazonshoping.accounts.Vendor;
import com.codedifferently.namazonshoping.orders.Order;
import com.codedifferently.namazonshoping.orders.OrderStatus;
import com.codedifferently.namazonshoping.product.Product;
import com.codedifferently.namazonshoping.product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

public class VendorTest {

    @Test
    @DisplayName("cancel test")
    public void constructerCancelTest1(){
        Order order=new Order(new Product(121L,"order",12.3, ProductCategory.CLOTHING),
                new Address("12","odaniel","newark","nj"), OrderStatus.PENDING);
        Vendor vendor =new Vendor("john","doe","johndoe@yahoo.com","122","gucci");
        vendor.getOrders().add(order);
        Assertions.assertTrue(vendor.cancelOrder(order));



    }
    @Test
    @DisplayName("add product vendor test")
    public void addProductVendorTest(){
        Vendor vendor =new Vendor("abe","smith","asmith@gmail.com","123","gucci");
        vendor.addProduct(new Product(14L,"abe",1.2, ProductCategory.ATHLETICS));
        Integer expected=1;
        Integer actual=vendor.getInventory().size();
        Assertions.assertEquals(expected ,actual);
    }


    @Test
    @DisplayName("remove product vendor test")
    public void removeProductVendorTest(){
        Vendor vendor =new Vendor("aba","john","asjohn@gmail.com","133","versace");
        Product product=new Product(14L,"aba",1.2, ProductCategory.CLOTHING);
        vendor.addProduct(product);
        vendor.removeProduct(product);
        Integer expected=0;
        Integer actual=vendor.getInventory().size();
        Assertions.assertEquals(expected ,actual);
    }

}
