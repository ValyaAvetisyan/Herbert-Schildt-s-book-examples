package stringUtil;

public class StringUtil {
    //Տրված տեքստից Ջնջում ենք սկզբի և վերջի բացատները(պռաբելները) և արդյունքը վերադարձնում ենք
    public String trim(String text) {
        System.out.println("There is no spaces in the beginning and in the end of the text");
        return text.trim();

    }
    public String trim2(String text) {
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


    //Վերադարձնում ենք տրված տեքստի մեջ տրված սինվոլի քանակը․
    public int getCountBySymbol(String text, char symbol) {
        System.out.print("The count of given symbol is:  ");
        char[] chars = text.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == symbol) {
                count++;
            }
        }

        return count;
    }

    //Վերադարձնում ենք տրված տեքստի մեջ տրված սինվոլների ընդհանուր քանակը․
    public int getCountBySymbols(String text, char[] symbols) {
        System.out.print("General count of symbols is:   ");
        char[] chars = text.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                if (chars[i] == symbols[j]) {
                    count++;


                }

            }
        }

        return count;
    }

    //Վերադարձնում է մեջտեղի 2 տառերը
    public String middleTwo(String str) {
        System.out.print("Two middle letters are:  ");
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);

    }

    //Վերադարձնում է true եթե տրված տեքստը վերջանում է ly-ով, հակառակ դեպքում false
    public boolean endsLy(String str) {
        System.out.print("Return true if the word ends with ly:   ");
        return str.endsWith("ly");

    }

    //Եթե front-փոփոխականը տանք true կվերադարձնի տրված str-ի առաջին տառը, հակառակ դեպքում վերջինը։
    public String theEndOrFront(String str, boolean front) {
        System.out.print("Return first or last letter of word in the condition of front:  ");
        if (front) {
            return str.substring(0, 1);
        }
        return str.substring(str.length() - 1);
    }

    //վերադարձնում է true, եթե տրված տեքստը սկսվում է bad բառով,
    // կամ 2րդ տառից սկսած է պարունակում bad բառը։ օր․ xbadxx -> true, xxbadxx -> false
    public boolean hasBad(String str) {
        System.out.print("The word begins with bad:  ");
        return (str.startsWith("Bad") || str.startsWith("Bad", 1));
    }

    //Վերադարձնում է առաջին 2 տառերը։ օր․ Hello-> He
    public String firstTwo(String str) {
        System.out.print("Two first letters of the word:  ");
        return str.substring(0, 2);
    }

    //Հետաքրքիր է ։Ճ
    //Վերադարձնում է true եթե տեքստը պարունակում է bob բառը, բայց o-ի տեղը կարող է լինել ցանկացած սինվոլ։
    //օր․ abcbob → true, b9b -> true, բայց ասենք bac-> false
    public boolean bobThere(String str) {
        System.out.print("The word contains bob:  ");

        int length = str.length();
        for (int i = 0; i < length-2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
                return true;
        }
        return false;


    }

    //Ավելի հետաքրքիր է ։Ճ
    //Վերադարձնում է տրված տեքստի վերջին n քանակի սինվոլները n անգամ
    //օր․ ("Hello", 3) → "llollollo", ("Hello", 2) → "lolo", ("Hello", 1) → "o"
    public String repeatEnd(String str, int n) {
        System.out.print("Repeating the end of the word   :");
        String result;
        result = str.substring(str.length() - n);
        for (int i = 1; i < n; i++)
            result = result.concat(str.substring(str.length() - n));
        return result;
    }


    //Վերադարձնում է 2 ընդունող տեքստերի խառնուրդը))
    //օր․ ("abc", "xyz") → "axbycz",    ("Hi", "There") → "HTihere", ("xxxx", "There") → "xTxhxexre"
    public String mixString(String a, String b) {
        System.out.print("Mix of the Strings:  ");
        int result = a.length() + b.length();
        String text = "";
        for (int i = 0; i < result; i++) {
            if (i < a.length()) {
                text += (a.substring(i, i + 1));
                if (i < b.length()) {
                    text += b.substring(i, i + 1);
                }
            }

        }
        return text;
    }
    //Վերադարձնում ենք տրված տեքստի revers եղած տարբերակը․

    public String reverse(String str) {
        System.out.print("Reverse text:  ");
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }

        return result;
    }
    public char[] StringToCharArray(String str) {
        char newArray[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            newArray[i] = str.charAt(i);

        }
        return newArray;
    }
}

