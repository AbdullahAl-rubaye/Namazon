import com.codedifferently.namazonshoping.accounts.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

public class CustomerTest {

    @Test
    @DisplayName("customer test")
    public void constructerTest1(){
        Customer customer=new Customer("matt","smith","mattsmith@gmail.com","1234");
        String expected="matt smith mattsmith@gmail.com 1234 ";
        String actual=customer.toString();
        Assertions.assertEquals(expected,actual);
    }
}
