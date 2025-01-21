package rahul;

class MultiThread extends Thread {
     @Override
     public void run() {
         try {

             for (int i = 0; i < 5; i++) {
                 System.out.println("T1 "+i);
                 Thread.sleep(500);
             }
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

     }
 }
class MultiThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("T2 "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiThreading {
        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(new MultiThread2(),"Interface");
            MultiThread thread1 =new MultiThread();

            thread.start();
            Thread.sleep(10);
            thread1.start();

            thread.join();
            thread1.join();
            System.out.println("joined");
        }
}