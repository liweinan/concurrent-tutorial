package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class ThreadWithLock extends Thread {

    private Lock lock;

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Lock getLock() {
        return lock;
    }

}
