/*package ReusablePages;

public class AdminPage {

}*/
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminPage {

    @DataProvider(name = "dummy")
    public Object[][] data() {
        return new Object[][] { {"Hello"} };
    }

    @Test(dataProvider = "dummy")
    public void check(String val) {
        System.out.println(val);
    }
}


