package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class BetaLock implements Lock {
    private volatile long victim;

    public void lock() {
        victim = Thread.currentThread().getId();
        while (victim == Thread.currentThread().getId()) ;

    }

    public void unlock() {
        victim = Thread.currentThread().getId();
    }
}
