package weli.concurrent.tutorial;

import static weli.concurrent.tutorial.PlayBase.threadX;
import static weli.concurrent.tutorial.PlayBase.threadY;

/**
 * Created by weli on 9/4/16.
 */
public class PlayWithPetersonLock {
    public static void main(String[] args) throws Exception {
        PetersonLock lock = new PetersonLock(threadX.getId(), threadY.getId());

        threadX.setLock(lock);
        threadY.setLock(lock);

        threadX.start();
        threadY.start();
        threadX.join();
        threadY.join();
    }
}
