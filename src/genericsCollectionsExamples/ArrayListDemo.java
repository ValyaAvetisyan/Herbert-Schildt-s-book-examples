package genericsCollectionsExamples;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String args[]) {
// Create an array list.
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Initial size of al: " +
                al.size());
// Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " +
                al.size());
        for (String s : al) {
            System.out.println(s);
        }
        // Display the array list.
        System.out.println("Contents of al: " + al);
// Remove elements from the array list.
        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after deletions: " +
                al.size());
        System.out.println("Contents of al: " + al);

        ArrayList<Integer> all = new ArrayList<>();
// Add elements to the array list.
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        System.out.println("Contents of all: " + all);
// Get the array.
        Integer ia[] = new Integer[all.size()];
        ia = all.toArray(ia);
        int sum = 0;
// Sum the array.
        for(int i : ia) sum += i;
        System.out.println("Sum is: " + sum);

    }

    }
