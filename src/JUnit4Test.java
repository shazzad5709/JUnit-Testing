import org.junit.Assert;
import org.junit.Test;

public class JUnit4Test {
    @Test
    public void Test() {
        String a = "Happy";
        String b = new String("Happy");
        Assert.assertEquals("They are equal", a, b);
    }
}
