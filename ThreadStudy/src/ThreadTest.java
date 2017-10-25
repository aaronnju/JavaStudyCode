import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shuming.wang on 2017/8/23.
 */
public class ThreadTest {
    static class ThreadN extends  Thread{
        String name ;
        Object lockMyself;
        Object lockNext;
        ThreadN(String name, Object lockA, Object lockB){
            this.name = name;
            this.lockMyself = lockA;
            this.lockNext = lockB;
        }
        @Override
        public void run() {
            for (int i=0; i<10; ++i) {
                synchronized (lockMyself) {
                    try {
                        lockMyself.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name);
                    synchronized (lockNext) {
                        lockNext.notify();
                    }
                }

            }
        }
    }

    static class RunableOne implements Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String args[]){
        double d = 1.1;
        d = d % 1;
        List lst = new ArrayList<>();
        lst.add(new Integer(1));
        lst.add(new String("d"));

        String[] strArray = new String[2];
        Integer[] intArray = new Integer[2];
        Class<?> c = strArray.getClass();
        Class<?> c2 = intArray.getClass();
        Class sp = c.getSuperclass();
        Class sp2 = c2.getSuperclass();


        ExecutorService service = Executors.newCachedThreadPool();
        AtomicLong al = new AtomicLong(12);
        al.incrementAndGet();
        ConcurrentHashMap<String, Integer> numbers = new ConcurrentHashMap<String, Integer>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        BlockingQueue bq= new ArrayBlockingQueue(3);
        Iterator<Entry<String, Integer>> iter = numbers.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Integer> e = iter.next();
            System.out.println("Key: "+e.getKey()+" & Value: "+e.getValue());
        }
        //ConcurrentHashMap
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
