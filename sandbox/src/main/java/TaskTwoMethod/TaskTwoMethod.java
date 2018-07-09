package TaskTwoMethod;

public class TaskTwoMethod {
    public static void main(String[] args) {

        Point p1 = new Point(-5,6.022);
        Point p2 = new Point(380,0);

        System.out.println ("Расстояние между точкой №1 (x=" + p1.x + ", y=" + p1.y + ") и точкой №2 (x=" + p2.x + ", y=" + p2.y +
                ") = " + p1.distance(p2));

    }

}
