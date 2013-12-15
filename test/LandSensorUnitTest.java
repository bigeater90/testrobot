import com.robot.Coordinates;
import com.robot.Execept.InaccessibleCoordinateException;
import com.robot.Execept.LandSensorDefaillance;
import com.robot.LandSensor;
import com.robot.enumeration.Land;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * User: Jean
 * Date: 09/12/2013
 */

public class LandSensorUnitTest {

    Coordinates cord1 = new Coordinates(1,1);
    Coordinates cord2 = new Coordinates(1,2);
    LandSensor ls;
    Random rand;

    @Before
    public void init(){
        rand = Mockito.mock(Random.class);
        ls = new LandSensor(rand);
    }

    @Test
    public void testGetPointToPointEnergyCoefficient1(){
        Mockito.when(rand.nextInt(Land.CountLand())).thenReturn(0);
        try {
            Assert.assertEquals(1,(int)ls.getPointToPointEnergyCoefficient(cord1,cord2));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testGetPointToPointEnergyCoefficient2(){
        Mockito.when(rand.nextInt(Land.CountLand())).thenReturn(4);
        try {
            ls.getPointToPointEnergyCoefficient(cord1, cord2);
        }
        catch (Exception ice){
            Assert.assertTrue(true);
            return;
        }
        Assert.assertTrue(false);
    }


}
