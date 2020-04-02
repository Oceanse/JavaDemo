import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {

    @Test
    public void test(){
        String str="hello";
        Assert.assertEquals(str,"hello");
    }
}
