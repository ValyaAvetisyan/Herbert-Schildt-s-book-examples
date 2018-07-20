package stringUtil;

public class MyStringUtilTest {
    public static void main(String[] args) {
        MyStringUtil myStringUtil = new MyStringUtil();
        System.out.println(myStringUtil.trim("     Hello   "));
        System.out.println(myStringUtil.StringToCharArray("Hello"));
    }
}
