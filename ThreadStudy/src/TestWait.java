/**
 * Created by shuming.wang on 2017-1-23.
 */
public class TestWait implements Runnable {

    private String name;
    private Object self;
    private Object next;

    private TestWait(String name, Object self, Object next) {
        this.name = name;
        this.self = self;
        this.next = next;
    }

    @Override
    public void run() {
        int count = 10;
        System.out.println( name + " start");
        while (count > 0) {
            synchronized (self) {
                System.out.println(name + " get self lock");
                synchronized (next) {
                    System.out.println(name + " get next lock");
                    System.out.println(count + "" + name);
                    count--;
                    System.out.println(name + ".next notify");
                    next.notify();
                }
                try {
                    if (count == 1) {
                        return;     // 最后一次循环, 将直接退出 不再进行等待
                    }
                    System.out.println(name + ".wait");
                    self.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\n" + name + " end");
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        TestWait pa = new TestWait("A", c, a);
        TestWait pb = new TestWait("B", a, b);
        TestWait pc = new TestWait("C", b, c);

        Thread t1 = new Thread(pa);
        Thread t2 = new Thread(pb);
        Thread t3 = new Thread(pc);
        t1.start();
        Thread.sleep(10);
        t2.start();
        Thread.sleep(10);
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Main end");
    }
}