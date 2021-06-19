import java.util.Scanner;
import javax.swing.text.MutableAttributeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector3D V1,V2,V3;
        double X,Y,Z;
        X = scanner.nextDouble();
        Y = scanner.nextDouble();
        Z = scanner.nextDouble();
        V1 = new Vector3D(X,Y,Z);
        V2 = new Vector3D(Y,Z,X);
        System.out.println("L= " + V2.getLength());
        V3 = V1.crossProduct(V2);
        System.out.println("CP= " + V3.toString());
        System.out.println("DP= " + V1.dotProduct(V2));
        System.out.println("UV= " + V3.getUnitVector().toString());
    }
}

class Vector3D {
    double X , Y , Z ;

    public Vector3D(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }
    public double getLength(){
        double temp = Math.sqrt(X*X+Y*Y+Z*Z);
        return Math.round(temp*100.00) / 100.00 ;
    }
    public Vector3D crossProduct(Vector3D V){
        Vector3D Result = new Vector3D(X , Y , Z) ;
        Result.X = Math.round((Y*V.Z - Z*V.Y)*1000.00)/1000.00 ;
        Result.Y = Math.round(-(X*V.Z - Z*V.X))*100.00/100.00 ;
        Result.Z = Math.round(X*V.Y - Y*V.X)*100.00/100.00 ;
        return Result ;
    }
    public double dotProduct(Vector3D V){
        return  Math.round((X*V.X + Y*V.Y + Z*V.Z)*100.00)/100.00 ;

    }
    public Vector3D getUnitVector(){
        Vector3D temp = new Vector3D(X , Y , Z);
        temp.X = (Math.round(X / getLength()*100.00))/100.00 ;
        temp.Y = (Math.round(Y / getLength()*100.00))/100.00 ;
        temp.Z = (Math.round(Z / getLength()*100.00))/100.00 ;
        return temp ;
    }
    public String toString(){
        return String.valueOf(Math.round(X*100.00)/100.00) +","+String.valueOf(Math.round(Y*100.00)/100.00) + "," + String.valueOf(Math.round(Z*100.00)/100.00);
    }

}

