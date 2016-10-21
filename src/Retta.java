import java.awt.Point;

public class Retta{
    public static void main(String [] args){
        Point p1 = new Point(0, 3);
        Point p2 = new Point(2, 4);
        int x = 4;

        System.out.println(x*getM(p1, p2) + getQ(p1, p2));

    }

    public static double getM(Point a, Point b){
        return (b.getY()-a.getY())/(b.getX()-a.getX());
    }

    public static double getQ(Point a, Point b){
        return a.getY()-a.getX()*getM(a, b);
    }
}
