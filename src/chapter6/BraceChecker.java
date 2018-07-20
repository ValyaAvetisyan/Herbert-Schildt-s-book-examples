package chapter6;

public class BraceChecker {
    private Stack stack = new Stack();
    //սա հենց տեքստն է
    private String text;

    //կլասսի կոնստրուկտորն է, որը պետք է ընդունի String տիպի տեքստ, և վերագրի վերևի տեքստին
    //Որ չկարողանանք BraceChecker-ի օբյեկտը սարքենք առանց text-տալու կոնստրուկտորի միջոցով․
    public BraceChecker(String text) {
        this.text = text;

    }

    //սա հիմնական մեթոդն է, որի մեջ գրելու ենք ամբողջ լոգիկան․ աշխատելու ենք թե stack-ի հետ, թե վերևի text-ի
    public void check() {
        char ch;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            switch (text.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(text.charAt(i));
//                    System.out.println("found opened brace " + text.charAt(i));
                    break;
                case '}':
                    ch = stack.pop();
                    if (ch == '{') {
//                        System.out.println("found pair for {");
                    } else {
                        System.err.println("Error at: " + i);
                    }
                    break;
                case ']':
                    ch = stack.pop();
                    if (ch == '[') {
//                        System.out.println("found pair for [");
                    } else {
                        System.err.println("Error at: " + i);
                    }
                    break;
                case ')':
                    ch = stack.pop();
                    if (ch == '(') {
//                        System.out.println("found pair for (");
                    } else if (ch != ')') {
                        System.err.println("Error at: " + i);
                    }
                    break;
            }
        }
        while (stack.get() != '0') {
            System.out.println("opened  " + stack.pop() + "but not closed");
        }
    }
}
