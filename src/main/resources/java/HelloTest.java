import org.junit.Assert;
import org.junit.Test;

public class HelloTest {
    @Test
    public void testHello(){
        Assert.assertEquals("hello world", new Hello().sayHello());
    }
}
