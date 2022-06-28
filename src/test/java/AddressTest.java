import com.codedifferently.namazonshoping.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

public class AddressTest {



    @Test
    @DisplayName("address test display")
    public void constructer1(){
        Address address=new Address("12","odaniel","newark","Nj");
        String expected="12 odaniel newark Nj";
        String actual=address.toString();
        Assertions.assertEquals(expected,actual);
    }
}
