package chapter6;

public class StackTest {
    public static void main(String[] args) {
        Stack stack= new Stack();
//        stack.get();
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(8);
//        stack.push(9);
//        stack.push(10);
//        stack.push(11);
//        stack.push(12);
//        stack.push(13);
//        stack.push(14);

        while (stack.get() !=0){
            System.out.println(stack.pop());
        }
        stack.push('9');
        stack.push('8');
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(')');
//        System.out.println((char)stack.pop());
//        stack.push(')');
//        System.out.println(stack.pop());
    }
}
