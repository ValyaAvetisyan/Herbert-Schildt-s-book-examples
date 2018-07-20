package homework;

public class DynamicArray {

    // սա մասիվն է, որը միայն ներքին օգտագործման համար է, և որը հետո extend մեթոդի մեջ մեծանալու է
    private int[] array = new int[16];


    //սա մասիվի մեջի էլեմենտների քանակն է․ սկզբից 0 է, հետո ամեն անգամ երբ կանչենք add մեթոդը, պիտի bookSize-ը մեծանա մեկով
    private int size = 0;


    //այս մեթոդը նախատեսված է մասիվի մեջ ավելացնել ընդունող value-ն; ամեն անգամ ավելացնելուց առաջ պետք է ստուգել
    //արդյոք մասիվի մեջ տեղ կա թե ոչ? եթե չկա, կանչել extend մեթոդը
    public void add(int value) {
        if (array.length == size) {
            extend();
        }
        array[size] = value;
        size++;
    }

    //այս մեթոդի նպատակն է ստեղծել նոր մասիվ, որը կլինի bookArray-ի նախքին չափս + 10 էլեմենտանի, հետո ցիկլով կազմակերպել
    //հին մասիվի էլեմենտների վերագրումը նոր մասիվին, և վերջում հին մասիվին վերագրել նոր մասիվը։
    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    //Այս մեթոդը վերադարձնում է մասիվի -iրդ էլեմենտը
    public int getNum(int i) {
        if (i > 0 && i <= size) {
            return array[i - 1];
        }
        return 0;

    }
        // սա ուղղակի տպում է bookArray մասիվի էլեմենտները։
        public void print () {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i]);
            }

        }
    }
