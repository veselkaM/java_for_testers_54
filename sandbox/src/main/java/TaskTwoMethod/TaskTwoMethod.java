package TaskTwoMethod;

public class TaskTwoMethod {
    public static void main(String[] args) {

        Point p1 = new Point(5,6);
        Point p2 = new Point(3,4);
        Point p3 = new Point(10,80);

        System.out.println ("Расстояние между точкой №1 (x=" + p1.x + ", y=" + p1.y + ") и точкой №2 (x=" + p2.x + ", y=" + p2.y +
                ") = " + p1.distance(p1,p2));

        System.out.println ("Расстояние между точкой №1 (x=" + p1.x + ", y=" + p1.y + ") и точкой №3 (x=" + p3.x + ", y=" + p3.y +
                ") = " + p1.distance(p1,p3));

        System.out.println ("Расстояние между точкой №2 (x=" + p2.x + ", y=" + p2.y + ") и точкой №3 (x=" + p3.x + ", y=" + p3.y +
                ") = " + p1.distance(p2,p3));
    }

}
