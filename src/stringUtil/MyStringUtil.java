package stringUtil;

public class MyStringUtil {
    public String trim(String text) {
        int endIndex = 0;
        int beginIndex = 0;
        char[] chr = text.toCharArray();
        while ((beginIndex < text.length()) && (chr[beginIndex] <= ' ')) {
            beginIndex++;
        }
        for (int i = chr.length - 1; i >= 0; i--) {
            if (chr[i] == ' ') {
                endIndex++;
            } else {
                break;
            }
        }
        if (endIndex + beginIndex == 0) {
            return text;
        }
        char[] newChar = new char[text.length() - endIndex - beginIndex];

        for (int i = beginIndex, j = 0; i < text.length() - endIndex; i++, j++) {
            newChar[j] = chr[i];
        }
        return new String(newChar);
    }

    public char[] StringToCharArray(String str) {
        char newArray[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            newArray[i] = str.charAt(i);

        }
        return newArray;
    }
}