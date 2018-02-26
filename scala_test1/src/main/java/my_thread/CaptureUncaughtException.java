package my_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by chenteng on 2017/3/27.
 */

public class CaptureUncaughtException {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor(new MyThreadFactory());
        Thread.sleep(3000L);
        es.execute(new ExceptionHandler());
    }
}

class ExceptionHandler implements Runnable{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Exception Handler create"+ thread.getName());
        System.out.println("eh2 = "+thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught Exception:"+e);
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this +"create new Thread");
        Thread thread = new Thread(r);
        System.out.println("create Thread:"+thread.getName());
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh1 = "+thread.getUncaughtExceptionHandler());
        return thread;
    }
}
