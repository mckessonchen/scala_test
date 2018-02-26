package my_thread;

import java.io.IOException;

/**
 * Created by chenteng on 2017/3/27.
 */

public class ResponsiveUI extends Thread {

    private static volatile double d = 1;

    ResponsiveUI(){
        setDaemon(true);
        start();
    }

    public void run() {
        while (true)
            d = (Math.PI+Math.E)/d;
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }

}
