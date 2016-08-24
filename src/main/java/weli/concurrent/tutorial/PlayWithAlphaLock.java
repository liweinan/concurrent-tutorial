package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class PlayWithAlphaLock {
    public static void main(String[] args) throws Exception {
        ThreadWithLock threadX = new ThreadWithLock() {
            @Override
            public void run() {
                System.out.println("thread X running...");
                getLock().lock();
                System.out.println("thread X got the lock.");
                System.out.println("unlocking thread X...");
                getLock().unlock();
            }
        };

        ThreadWithLock threadY = new ThreadWithLock() {
            @Override
            public void run() {
                System.out.println("thread Y running...");
                getLock().lock();
                System.out.println("thread Y got the lock.");
                System.out.println("unlocking thread Y...");
                getLock().unlock();
            }
        };

        AlphaLock lock = new AlphaLock(threadX.getId(), threadY.getId());

        threadX.setLock(lock);
        threadY.setLock(lock);

        threadX.start();
        Thread.sleep(1000);
        threadY.start();
        threadX.join();
        threadY.join();
    }

}
