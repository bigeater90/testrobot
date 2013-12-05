import com.robot.Battery;
import com.robot.Execept.InsufficientChargeException;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * User: Jean
 * Date: 27/11/2013
 */

public class BatteryUnitTest {

    @Test
    public void testGetChargeLevel(){
        Battery bat = new Battery();
        Assert.assertEquals((float)100,bat.getChargeLevel());
    }

    @Test
    public void testCharge(){
        Battery bat = new Battery();
        bat.charge();
        Assert.assertEquals((float)110,bat.getChargeLevel());
    }

    @Test
    public void testUse(){
        Battery bat = new Battery();
        try {
            bat.use(110);
        }
        catch (InsufficientChargeException ice){
            Assert.assertTrue(true);
            return;
        }
        Assert.assertTrue(false);
    }

    @Ignore
    @Test
    public void testSetUp() throws InterruptedException {
        Battery bat = new Battery();
        bat.setUp();
        Thread.sleep(1000);
        Assert.assertEquals((float) 1000, bat.getChargeLevel());
    }

}
