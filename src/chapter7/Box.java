package chapter7;

public class Box {
    double width;
    double height;
    double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box() {
        width = 5;
        height = 7;
        depth = 9;

    }


    //    void volume(){
//        System.out.print("Volume: ");
//        System.out.println(width*height*depth);
//    }
    double volume() {
        return depth * height * width;
    }

    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
        System.out.println(w * h * d);
    }

    public int square(int n) {

        return n * n;
    }


}
