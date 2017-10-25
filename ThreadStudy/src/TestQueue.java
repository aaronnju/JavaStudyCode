import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by shuming.wang on 2016-5-9.
 */
public class TestQueue {
    public static void main(String[] args) {
        // Let's create a blocking queue that can hold at most 5 elements.
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        // The two threads will access the same queue, in order
        // to test its blocking capabilities.
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
    public static void testmain() {
//        Synchronized.test();

//        try {
////            MyCompletionService.main_MyCompletionService();
////            TestCountDownLatch.main_TestCountDownLatch();
////            TestCyclicBarrier.main_TestCyclicBarrier();
////            TestScheduledThread.main_TestScheduledThread();
//
//            new beacon().testbeacon();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        MyThread.main_MyReentrantLock(args);

//        ArrayBlockingQueueExample();
        // write your code here
    }
}
