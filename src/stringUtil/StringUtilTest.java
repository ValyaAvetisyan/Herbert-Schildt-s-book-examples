package stringUtil;

import java.awt.*;

public class StringUtilTest {
    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();

        System.out.println(stringUtil.trim("  Imagine there's no heaven, It's easy if you try   "));
        System.out.println(stringUtil.trim2("     Hello   "));
        System.out.println(stringUtil.getCountBySymbol("Above us only sky Imagine all the people Living for today.", 'l'));
        char[] chars = {'i', 's', 'e'};
        System.out.println(stringUtil.getCountBySymbols("imagine there's no countries, It isn't hard to do", chars));
        System.out.println(stringUtil.middleTwo("Imagine"));
        System.out.println(stringUtil.endsLy("Lovely"));
        System.out.println(stringUtil.theEndOrFront("Miracle", true));
        System.out.println(stringUtil.hasBad("Badly"));
        System.out.println(stringUtil.firstTwo("Dreamer"));
        System.out.println(stringUtil.bobThere("bobik"));
        System.out.println(stringUtil.repeatEnd("Happy", 2));
        System.out.println(stringUtil.mixString("beautiful", "pretty"));
        System.out.println(stringUtil.reverse("You may say I'm a dreamer,But I'm not the only one"));
        System.out.println(stringUtil.StringToCharArray("Hello"));

    }


}
