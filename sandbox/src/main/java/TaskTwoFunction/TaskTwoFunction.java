package TaskTwoFunction;

public class TaskTwoFunction {
    public static void main(String[] args) {

        Point p1 = new Point(10,80);
        Point p2 = new Point(10,20);

        System.out.println ("Расстояние между точкой №1 (x=" + p1.x + ", y=" + p1.y + ") и точкой №2 (x=" + p2.x + ", y=" + p2.y +
                ") = " + distance(p1,p2));
    }

    public static double distance (Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));

    }

}
