package old.stack;

public class BraceChecker {

    private Stack<BracketItem> stackImpl;
    private String resultMessage;

    public BraceChecker() {
        stackImpl = new StackImpl();
    }

    public String getResultMessage() {
        return resultMessage;
    }

    /**
     *
     * Parses and checks brackets order in the specified 'inputText', if an
     * error exists sets the appropriate message to 'ErrorMessage' field
     * otherwise sets "No Error" as a value of 'ErrorMessage' field.
     *
     * @param inputText to be parsed for brackets order correctness.
     */
    public void parse(String inputText) {
        reset();
        int length = inputText.length();

        BracketItem stackLastElement = null;
        char curr = 0;
        int i = 0;
        int numberInLine = 0;
        int lineNumber = 1;
        lab:


        for (; i < length; i++) {
            curr = inputText.charAt(i);
            numberInLine++;
            switch (curr) {
                case '\n':
                    numberInLine = 0;
                    lineNumber++;
                    break;
                case '{':
                case '(':
                case '[':
                    stackImpl.push(new BracketItem(curr, i, numberInLine, lineNumber));
                    break;
                  
                case '}':
                    stackLastElement = stackImpl.pop();               
                    if (stackLastElement == null  ||stackLastElement.getValue() != '{') {
                        break lab;
                    }
                    break;
                case ']':
                    stackLastElement = stackImpl.pop();
                    if (stackLastElement == null  ||stackLastElement.getValue() != '[') {
                        break lab;
                    }
                    break;
                case ')':
                    stackLastElement = stackImpl.pop();
                    if (stackLastElement == null  ||stackLastElement.getValue() != '(') {
                        break lab;
                    }
                    break;
            }
        }

        if (i < length) {
            if (stackLastElement == null) {
                resultMessage = "Error: Closed '" + curr
                        + "' but not opened ";
            } else {
                resultMessage = "Error: Opened '" + stackLastElement.getValue()
                        + "' but closed '" + curr + "'";
            }
        } else if (!stackImpl.isEmpty()) {
            stackLastElement = stackImpl.pop();
            resultMessage = "Error: Opened '" + stackLastElement.getValue()
                    + "'  but not closed ";
        }
    }

    private void reset() {
        stackImpl.reset();
        resultMessage = "No Error";
    }

    public static class BracketItem {

        private char value;
        private int index;
        private int numberInLine;
        private int lineNumber;

        public BracketItem(char value, int index, int numberInLine, int lineNumber) {
            this.value = value;
            this.index = index;
            this.numberInLine = numberInLine;
            this.lineNumber = lineNumber;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getNumberInLine() {
            return numberInLine;
        }

        public void setNumberInLine(int numberInLine) {
            this.numberInLine = numberInLine;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        @Override
        public String toString() {

            return "BracketItem{"
                    + "value=" + value
                    + ", index=" + index
                    + ", numberInLine=" + numberInLine
                    + ", lineNumber=" + lineNumber
                    + '}';
        }
    }

    public static void main(String[] args) {
//        BraceChecker braceChecker = new BraceChecker();
//        String inputData = "";
////        braceChecker.parse(inputData);
//
//        inputData = ")";
//        braceChecker.parse(inputData);
//        System.out.println(braceChecker.getResultMessage());
}
}