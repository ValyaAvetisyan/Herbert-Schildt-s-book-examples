package genericsCollectionsExamples;

import java.util.Set;
import java.util.TreeSet;

public class GenDemo {
    public static void main(String[] args) {
        Generic<Integer> iobj;
iobj= new Generic<Integer>(88);
iobj.showType();
        int v = iobj.getObj();
        System.out.println("value: " + v);
        System.out.println();
        Generic<String>str=new Generic<String>("barev");
        str.showType();
        String s=str.getObj();
        System.out.println("value:"+s);
        Set<User> users =new TreeSet<>();
        users.add(new User("name", "surname",15));
        users.add(new User("poxos","poxosyan",55));
        for (User user : users) {
            System.out.println(user);
        }

    }
}