package online_test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Created by chenteng on 2017/3/22.
 */

public class ReferencesTest {
    public static class VeryBig {
        private static final int SIZE = 10000;
        private long[] la = new long[SIZE];
        private String ident;

        public VeryBig(String id) {
            this.ident = id;
        }

        public String toString() {
            return ident;
        }

        public void finalize() {
            System.out.println("Finalizing " + ident);
        }
    }

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue();

    public static void checkQueue() {

        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue " + inq.get());
        }

    }

    public static void main(String[] args) throws Exception {
        int size = 10;
        LinkedList<SoftReference<VeryBig>> sr = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sr.add(new SoftReference<VeryBig>(new VeryBig("soft [" + i + "]"),rq));
            System.out.println("Just create "+ sr.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wr = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wr.add(new WeakReference<VeryBig>(new VeryBig("Weak [" + i + "]"),rq));
            System.out.println("Just create "+ sr.getLast());
            checkQueue();
        }
        System.gc();
        checkQueue();


    }
}
