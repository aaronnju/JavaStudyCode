/**
 * Created by shuming.wang on 2017/8/23.
 */
public class ReentrantTest {
    Object lock = new Object();
    synchronized void fn1(){
        System.out.println("fn1");
        fn2();
    }
    synchronized void fn2(){
        System.out.println("fn2");
    }

    void fn3(){
        synchronized (lock) {
            try {
                fn4();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fn3");
        }
    }
    void fn4(){
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fn4");
        }
    }
   // private final ReentrantLock lock = new ReentrantLock();
   //
   // public void m() {
   //  lock.lock();  // block until condition holds
   //  try {
   //      m();
   //      Thread.sleep(1000);
   //  } catch (InterruptedException e) {
   //      e.printStackTrace();
   //  } finally {
   //    lock.unlock();
   //  }
   //}
    public static void main(String args[]){
        ReentrantTest t = new ReentrantTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.fn3();

            }
        }).start();
    }
}
