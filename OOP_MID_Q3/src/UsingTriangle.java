import javax.swing.text.MutableAttributeSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UsingTriangle {
    public static void main(String[] args) {
        Triangle triangle;
        Scanner scanner = new Scanner(System.in);
        triangle = Triangle.create(scanner);
        System.out.printf("The length of Edge AB = %.2f\n", triangle.c());
        System.out.printf("The Angle of A = %.2f\n", 180/Math.PI*triangle.argA());
        System.out.printf("The Circumference ABC = %.2f\n", 2*triangle.p());
        System.out.printf("The Area of ABC = %.2f\n", triangle.area());
    }
}

class Triangle {
    static ArrayList<Point> points = new ArrayList<>();

    public static Triangle create(Scanner scanner) {
        Triangle triangle = new Triangle();
        int i = 0 ;
        try {
            for(i = 0 ; i < 3 ; i++){
                points.add(new Point(scanner.next() , scanner.nextDouble() , scanner.nextDouble(),scanner.nextDouble()));
            }
        }catch (InputMismatchException e){
            System.out.println("INVALID INPUT!");
        }
        return triangle ;
    }

    public void println(){
        int i = 0 ;
        if(Check()){
            for (Point point :points){
                System.out.print(point.name+"("+point.x + ", " + point.y + ", " + point.z+ ")");
                i += 1 ;
                if(i == 3)
                    break;
                System.out.print(" , ");
            }
        }
        else
            System.out.println("The points do not form a triangle!");
    }
    public boolean Check(){
        int temp = 0 ;
        for (Point point : points){
            for (Point point1 : points){
                for (Point point2 : points)
                    if (point.name == point1.name)
                        continue;
                    else if(point.name == point2.name)
                        continue;
                    else if(point1.name == point2.name)
                        continue;
                    else {
                        if(length(point , point1) + length(point1 , point2) <= length(point , point2))
                            temp += 1 ;
                        else if (length(point , point1) + length(point , point2) <= length(point1 , point2))
                            temp += 1 ;
                        else if (length(point1 , point2) + length(point , point2) <= length(point1 , point))
                            temp += 1 ;
                    }

            }
        }
        if(temp == 0)
            return true ;
        return false ;

    }

    public double length(Point p1 , Point p2){
        return Math.sqrt(Math.pow((p1.x - p2.x) , 2) + Math.pow((p1.y - p2.y) , 2) + Math.pow((p1.z - p2.z) , 2)) ;
    }

    public double argA(){
        double AB = length(points.get(0) , points.get(1));
        double AC = length(points.get(0) , points.get(2));
        double BC = length(points.get(1) , points.get(2));
        return  Math.acos((AB*AB + AC*AC - BC*BC) / (2*AB*AC)) ;

    }
    public double c(){
        return length(points.get(0) , points.get(1) );

    }
    public double area(){
        double S ;
        S = (length(points.get(0) , points.get(1))+ length(points.get(0) , points.get(2)) + length(points.get(1) , points.get(2)))/2 ;
        return ((Math.sqrt(S*(S-length(points.get(0) , points.get(1)))*(S-length(points.get(0) , points.get(2)))*(S-length(points.get(1) , points.get(2)))) ));
    }
    public double p(){
        return 0.5*((length(points.get(0) , points.get(1)) + length(points.get(0) , points.get(2)) + length(points.get(1) , points.get(2))));
    }
}
class Point {
    String name ;
    public double x , y , z ;

    public Point(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
