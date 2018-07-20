package chapter8;

public class BoxTest {
    public static void main(String[] args) {
        BoxWeight boxWeight=new BoxWeight(5,5,4,6);
//        Box box= new BoxWeight(6);
        boxWeight.volume();
        boxWeight.weight=5;

    }
}
