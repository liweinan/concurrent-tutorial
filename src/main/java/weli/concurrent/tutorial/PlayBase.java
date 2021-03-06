package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class PlayBase {
    static ThreadWithLock threadX = new ThreadWithLock() {
        @Override
        public void run() {
            System.out.println("thread X running...");
            getLock().lock();
            System.out.println("thread X got the lock.");
            System.out.println("unlocking thread X...");
            getLock().unlock();
        }
    };

    static ThreadWithLock threadY = new ThreadWithLock() {
        @Override
        public void run() {
            System.out.println("thread Y running...");
            getLock().lock();
            System.out.println("thread Y got the lock.");
            System.out.println("unlocking thread Y...");
            getLock().unlock();
        }
    };
}
