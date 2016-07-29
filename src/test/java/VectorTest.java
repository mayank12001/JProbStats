import org.junit.Assert;
import org.junit.Test;

import com.jprobstats.ml.vector.Vector;

public class VectorTest {

    @Test
    public void testDefaultVector() {
        Vector v = new Vector();
        double [] vector = v.getComponents();
        Assert.assertEquals(vector.length, 1);
    }
    
    @Test
    public void testZeroVector() {
        Vector v = new Vector(4);
        double [] vector = v.getComponents();
        Assert.assertEquals(vector.length, 4);
    }
    
    @Test
    public void testVector() {
        Vector v = new Vector(4, 1, 2, 3, 4);
        double [] vector = v.getComponents();
        Assert.assertEquals(vector.length, 4);
    }
}
