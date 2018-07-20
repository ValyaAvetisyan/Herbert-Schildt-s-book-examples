package chapter11;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
// wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }

//        NewThread newThread =new NewThread();
//        newThread.ThreadExample();
//        Thread t = new Thread(newThread);
//        new NewThread();
//        Thread t = Thread.currentThread();
//        t.setName("MyThread");
//        System.out.println("Current thread"+t);
//        for (int i = 5; i >0 ; i--) {
//            System.out.println("main"+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}
