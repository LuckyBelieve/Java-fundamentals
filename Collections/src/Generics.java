import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Point<R extends Number>{
    private R x;
    private R y;
    public Point(R x, R y){
        this.x = x;
        this.y = y;
    }

    public R getX() {
        return x;
    }

    public void setX(R x) {
        this.x = x;
    }

    public R getY() {
        return y;
    }

    public void setY(R y) {
        this.y = y;
    }

    public void doSomething(ArrayList<?> arr){
        for( Object i:arr){
            System.out.println(i);
        }
    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Generics {
    public static void main(String[] args) {
        Point<Integer> p = new Point<Integer>(33,40);
        List<Point> d = new ArrayList<Point>();
        d.add(new Point<Integer>(3,4));
        d.add(p);
        p.doSomething(new ArrayList<Point>(d));
    }

}
