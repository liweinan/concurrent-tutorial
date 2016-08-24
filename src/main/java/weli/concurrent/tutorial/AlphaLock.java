package weli.concurrent.tutorial;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by weli on 7/11/16.
 */
public class AlphaLock implements Lock {
    private Map<Long, Boolean> flags = new ConcurrentHashMap<>();

    public AlphaLock(long threadXId, long threadYId) {
        flags.put(threadXId, false);
        flags.put(threadYId, false);
        System.out.println("Alpha lock hold two threads: " + threadXId + ", " + threadYId);
    }

    public void lock() {
        long currentThreadId = Thread.currentThread().getId();
        long theOtherThreadId = theOtherThreadId(currentThreadId);
        flags.put(currentThreadId, true);
        while (flags.get(theOtherThreadId)) {
        }
    }

    public void unlock() {
        long currentThreadId = Thread.currentThread().getId();
        flags.put(currentThreadId, false);
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
