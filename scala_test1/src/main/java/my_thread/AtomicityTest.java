package my_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenteng on 2017/3/27.
 */

public class AtomicityTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue(){
        return i.get();
    }

    public void ensureIncrement(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true)
            ensureIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        Thread.sleep(3);
        while (true){
            int i = at.getValue();
            if (i%2!=0){
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}
