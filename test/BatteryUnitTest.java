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

    @Test (expected = InsufficientChargeException.class)
    public void testUse() throws Exception{
        Battery bat = new Battery();
        bat.use(110);
    }

    @Test
    public void testCanDeliver(){
        Battery bat = new Battery();
        Assert.assertTrue(bat.canDeliver(100));
    }

    @Test
    public void testTimeToSufficientCharge(){
        Battery bat = new Battery();
        Assert.assertEquals(10000,bat.timeToSufficientCharge(200));
    }

    @Ignore
    @Test
    public void testSetUp() throws InterruptedException {
        Battery bat = new Battery();
        bat.setUp();
        Thread.sleep(10000);    //System.out.println(bat.timeToSufficientCharge(200));
        Assert.assertEquals((float) 200, bat.getChargeLevel());
    }

}
