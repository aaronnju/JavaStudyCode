/**
 * Created by shuming.wang on 2017/8/23.
 */
public class ABCTest {
    public static void main(String args[]){
        //Object lockA = new Object();
        //Object lockB = new Object();
        //Object lockC = new Object();
        //new ThreadN("A", lockA, lockB).start();
        //new ThreadN("B", lockB, lockC).start();
        //new ThreadN("C", lockC, lockA).start();
        //synchronized (lockA) {
        //    lockA.notify();
        //}

        Object lock = new Object();
        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("enter A");
                    try {
                        lock.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wake up A");
                }
            }
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("enter B");
                    try {
                        lock.notify();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wake up B");
                }
            }
        }).start();
    }
}
