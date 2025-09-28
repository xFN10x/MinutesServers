package fn10.minutesServers.auth;

import java.time.Instant;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class KeyDistrobuter {

    public static Map<Long, Key> active = new ConcurrentHashMap<>();
    public static Long issued = 0L;

    @Scheduled(fixedRate = 5000)
    public static void check() {
        for (Entry<Long, Key> entry : active.entrySet()) {
            if (entry.getValue().expire.isBefore(Instant.now())) {
                active.remove(entry.getKey());
                System.out.println("Removed key: " + entry.getValue().string);
            }
        }
        System.out.println(active.entrySet());
    }

    public static Key issueNew() {
        Key newKey = new Key(Instant.now().plusSeconds(15));

        active.put(issued + 1, newKey);
        issued++;
        return newKey;
    }

    public static boolean isActive(Key toBeChecked) {
        for (Entry<Long, Key> entry : active.entrySet()) {
            if (entry.getValue().equals(toBeChecked)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unlikely-arg-type")
    public static boolean isActive(String toBeChecked) {
        for (Entry<Long, Key> entry : active.entrySet()) {
            if (entry.getValue().equals(toBeChecked)) {
                return true;
            }
        }
        System.out.println("Key: " + toBeChecked + " is not available.");
        return false;
    }

}
