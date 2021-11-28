import java.util.*;

class LCE_359LoggerRateLimiter {
    Map<String, Integer> store;
    public Logger() {
        store = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(store.containsKey(message)) {
            int futureTimestamp = store.get(message);
            if(timestamp < futureTimestamp) {
                return false;
            }
        }
        store.put(message, timestamp + 10);
        return true;
    }
}
