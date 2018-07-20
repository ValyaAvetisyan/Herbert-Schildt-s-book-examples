package chapter6;

public class BoxTest {
    public static void main(String[] args) {
        Box elitPlazePool = new Box(20, 5, 2);


        //allocate space from memory and work with it's reference
        Box myBox = new Box();
        myBox.setDim(100, 200, 300);
//        myBox.volume();
//        myBox.depth=100;
//        myBox.height=200;
//        myBox.width=300;
//        System.out.println(myBox.volume());
//        myBox.volume();
//        double vol=myBox.depth*myBox.height*myBox.width;
//        System.out.println(vol);
        Box myBox2 = new Box();
        myBox2.width = 10;
        myBox2.height = 20;
        myBox2.depth = 30;
        myBox2.volume();
//        vol=myBox2.depth*myBox2.height*myBox2.width;
//        System.out.println(vol);
        Box myBox3 = myBox;
        myBox3.volume();
//        System.out.println(myBox.width);
        System.out.println(myBox.square(9));
        int x =myBox.square(5);
        System.out.println(x);

    }
}
