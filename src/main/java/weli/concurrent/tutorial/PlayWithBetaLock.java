package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class PlayWithBetaLock extends PlayBase {
    public static void main(String[] args) throws Exception {
        BetaLock lock = new BetaLock();

        threadX.setLock(lock);
        threadY.setLock(lock);

        threadX.start();
        Thread.sleep(1000);
        threadY.start();
        threadX.join();
        threadY.join();
    }
}
