package homework;

class FigurePainter {
    public static void main(String[] args) {
/*
 * first triangle
 */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("<<<<<<<---------------->>>>>>>");

/*
 *second triangle
  */
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("<<<<<<<---------------->>>>>>>");

        /**
         * third triangle
         */
        for (int i = 1; i < 8; i = i + 2) {
            //printing spaces
            for (int j = 8; j > i ; j--) {
                System.out.print(" ");
            }
//            printing stars
            for (int k = 0; k < i + 1; k = k + 2) {
                System.out.print(" *");
            }
            //separate lines
            System.out.println("");
        }
//Forth triangle
        System.out.println("<<<<<<<---------------->>>>>>>");
        for (int i = 1; i < 8; i = i + 2) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");

            }
            for (int k = 8; k > i - 1; k = k - 2) {
                System.out.print(" *");

            }
            System.out.println("");
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <i ; j++) {

            }

        }
    }


}
