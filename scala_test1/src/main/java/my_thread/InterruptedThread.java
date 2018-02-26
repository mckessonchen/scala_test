package my_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by chenteng on 2017/3/28.
 */

public class InterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future f = executorService.submit(new SynchronizedBlocked());
        Thread.currentThread().sleep(3000);
        executorService.shutdown();
        f.cancel(true);
        Thread.currentThread().sleep(3000);
    }
}

class SynchronizedBlocked implements Runnable{
    private synchronized void f(){
        while (true){
            Thread.yield();
        }
    }

    SynchronizedBlocked(){
        new Thread(){
            public void run(){
                f();
            }
        }.start();
    }


    @Override
    public void run() {
        System.out.println("try to call f()");
        f();
        System.out.println("Exiting Synchronizedblocked.run()");
    }
}
