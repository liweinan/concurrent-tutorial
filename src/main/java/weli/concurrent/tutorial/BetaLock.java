package weli.concurrent.tutorial;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by weli on 8/25/16.
 */
public class BetaLock {
    private volatile long victim;

    public void lock() {
        victim = Thread.currentThread().getId();
        while (victim == Thread.currentThread().getId()) ;

    }

    public void unlock() {
        victim = Thread.currentThread().getId();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {

            }
        };
    }
}
