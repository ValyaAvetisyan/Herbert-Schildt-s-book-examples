package classWork.Homework;

public class PrimitiveTest {
    public static void main(String[] args) {
        byte bigByteNegativeValue = -128;
        byte bigByteMaxValue = (byte)256;
        System.out.println(bigByteMaxValue);
        for (int i = 7; i >= 0; i--) {
            if (((bigByteMaxValue >> i) & 1) == 1) {
                System.out.print(1);
            }else {
                System.out.print(0);

            }

        }
    }


}
