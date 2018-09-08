package TaskTwoMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskThreeTests {

    @Test
    public void testDistancePassed () {
        Point p1 = new Point(10,36.92);
        Point p2 = new Point(10,0.92);
        Assert.assertEquals(p1.distance(p2),36.0);

    }

    @Test
    public void testDistanceFailed () {
        Point p1 = new Point(-10,36.92);
        Point p2 = new Point(10,-0.92);
        Assert.assertEquals(p1.distance(p2),42.80029906437571);

    }

    @Test
    public void testDistanceZero () {
        Point p1 = new Point(-10,1234567891.99);
        Point p2 = new Point(-10,1234567891.99);
        Assert.assertEquals(p1.distance(p2),0.0);

    }
}
