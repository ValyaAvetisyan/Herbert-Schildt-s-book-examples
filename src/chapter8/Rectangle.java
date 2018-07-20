package chapter8;

public class Rectangle extends Figure {
    Rectangle(double a, double b){
        super(a,b);
    }
    double area(){
        System.out.println("Rectangle's area");
        return dim1*dim2;
    }
}
