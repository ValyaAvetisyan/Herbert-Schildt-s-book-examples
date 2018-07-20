package chapter11;

public class NewThread implements Runnable {
    Thread t;
//    NewThread(){
//        t= new Thread(this,"demo");
//        System.out.println("child thread"+t);
//        t.start();
//    }
    @Override
    public void run() {
        for (int i = 5; i >0 ; i--) {
            System.out.println("child"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void ThreadExample() throws InterruptedException {
//        Thread t = Thread.currentThread();
//        System.out.println(t);
        Thread t = new Thread();
//        t.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
            Thread.sleep(1000);

        }

    }
}
