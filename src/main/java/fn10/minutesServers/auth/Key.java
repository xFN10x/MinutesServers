package fn10.minutesServers.auth;

import java.time.Instant;
import java.util.UUID;

public class Key {

    public String string;
    public Instant expire;

    public Key(Instant expire) {
        this.expire = expire;
        this.string = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Key) {
            return ((Key) other).string.equals(string);
        } else if (other instanceof String)  {
            return other.equals(string);
        } else 
            return false;
    }

    @Override
    public String toString() {
        return string;
    }
}
