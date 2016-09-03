package weli.concurrent.tutorial;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by weli on 9/3/16.
 */
public class PetersonLock implements Lock {
    private Map<Long, Boolean> flags = new ConcurrentHashMap<>();
    private volatile long victim;

    public PetersonLock(long threadXId, long threadYId) {
        flags.put(threadXId, false);
        flags.put(threadYId, false);
    }

    public void lock() {
        long currentThreadId = Thread.currentThread().getId();
        long theOtherThreadId = theOtherThreadId(currentThreadId);
        flags.put(currentThreadId, true); // alpha lock
        victim = currentThreadId; // beta lock
        while (flags.get(theOtherThreadId) && victim == currentThreadId) {
        }
    }

    public void unlock() {
        victim = Thread.currentThread().getId();
        flags.put(Thread.currentThread().getId(), false);
    }

    private long theOtherThreadId(long currentThreadId) {
        for (Map.Entry<Long, Boolean> flag : flags.entrySet()) {
            if (flag.getKey() == currentThreadId)
                continue;
            return flag.getKey();
        }
        return -1; // never reach here
    }
}
