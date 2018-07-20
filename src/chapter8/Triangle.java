package chapter8;

public class Triangle extends Figure{
    Triangle (double a, double b){
        super(a,b);
    }

    @Override
    double area() {
        System.out.println("Triangle's area");
        return dim1*dim2/2;
    }
}
