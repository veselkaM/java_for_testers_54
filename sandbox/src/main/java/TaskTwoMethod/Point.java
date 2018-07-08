package TaskTwoMethod;

public class Point {

    double x,y;

    Point (int х, int у) {
        this.x = х;
        this.y = у;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }
}
