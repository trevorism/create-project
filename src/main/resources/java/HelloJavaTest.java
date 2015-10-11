import org.junit.Assert;
import org.junit.Test;

public class HelloJavaTest {
    @Test
    public void testHello(){
        Assert.assertEquals("hello world", new HelloJava().sayHello());
    }
}
