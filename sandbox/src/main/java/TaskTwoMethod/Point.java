package TaskTwoMethod;

public class Point {

    double x,y;

    Point (double х, double у) {
        this.x = х;
        this.y = у;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow((this.x-p2.x),2)+Math.pow((this.y-p2.y),2));
    }
}
