package figurePainter;

public class FigurePaint {
    public void figureOne(int countOfLines, char symbol) {

        for (int i = 0; i < countOfLines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println("");
        }
    }

    public void figureTwo(int countOfLines, char symbol) {
        for (int i = 1; i < countOfLines; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");

            }
            for (int k = 1; k < i + 1; k++) {

                System.out.print(symbol);
            }

            System.out.println("");

        }
    }

    public void figureThree(int countOfLines, String symbol) {
        for (int i = countOfLines; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(symbol);
            }
            System.out.println("");
        }
    }

    public void figureFour(int countOfLines, String symbol) {
        for (int i = 0; i < countOfLines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    public void figureFive(int countOfLines,char symbol){
        for (int i = 0; i < countOfLines; i++) {
            for (int j = 4; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(symbol+" " );
            }
            System.out.println();
        }
        for (int i = 0; i < countOfLines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 3; k > i; k--) {
                System.out.print(" "+symbol);
            }
            System.out.println();
        }
    }

}
