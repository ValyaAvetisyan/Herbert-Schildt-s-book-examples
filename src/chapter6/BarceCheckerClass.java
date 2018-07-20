package chapter6;

public class BarceCheckerClass {
    //սա հենց տեքստն է
    private String text;
    private String errorMessage = "";

    public BarceCheckerClass(String text) {
        this.text = text;


    }

    //սա հիմնական մեթոդն է, որի մեջ գրելու ենք ամբողջ լոգիկան․ աշխատելու ենք թե stack-ի հետ, թե վերևի text-ի
    public void check() {
        StackClass stackClass = new StackClass();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char last;
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stackClass.push(c);
                    break;
                case ')':
                    last = (char) stackClass.pop();
                    if (last != '(') {
                        errorMessage += ("error at: " + i + " closed ) " + "but opened " + last + "\n");
                    }
                    break;
                case '}':
                    last = (char) stackClass.pop();
                    if (last != '{') {
                        errorMessage += ("error at: " + i + " closed } " + "but opened " + last + "\n");
                    }
                    break;
                case ']':
                    last = (char) stackClass.pop();
                    if (last != '[') {
                        errorMessage += ("error at: " + i + " closed [ " + "but opened " + last + "\n");
                    }
                    break;
            }

        }

        if (errorMessage.equals("")) {
            System.out.println("Everything is OK");
        } else {
            System.out.println(errorMessage);
        }
    }

}
