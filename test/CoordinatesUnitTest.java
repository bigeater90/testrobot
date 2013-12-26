import com.robot.Coordinates;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

/**
 * User: Jean
 * Date: 26/12/2013
 */

public class CoordinatesUnitTest {

    Coordinates co;

    @Before
    public void init(){
        co = new Coordinates(0,0);
    }

    @Test
    public void testGetX(){
        Assert.assertEquals(0,co.getX());
    }

    @Test
    public void testGetY(){
        Assert.assertEquals(0,co.getY());
    }

}
