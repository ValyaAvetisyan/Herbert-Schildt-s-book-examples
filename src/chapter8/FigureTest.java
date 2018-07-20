package chapter8;

public class FigureTest {
    public static void main(String[] args) {
//        Figure figure = new Figure(20,3);
//        Rectangle rectangle = new Rectangle(10,20);
//        Triangle triangle = new Triangle(1,2);
//        System.out.println(figure.area());
//        System.out.println(rectangle.area());
//        System.out.println(triangle.area());
    Figure figure = new Figure(2, 5) {
        @Override
        double area() {
            return 0;
        }
    };
    figure.area();
    }

}
