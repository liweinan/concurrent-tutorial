package weli.concurrent.tutorial;

/**
 * Created by weli on 8/25/16.
 */
public class PlayWithAlphaLock extends PlayBase {
    public static void main(String[] args) throws Exception {

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
