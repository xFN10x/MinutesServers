package fn10.minutesServers.exceptions;

public class SongDoesntExistException extends RuntimeException {

    public SongDoesntExistException(String quailty, String name) {
        super("Song \"" + name + "\" at qualitiy \"" + quailty + "\" doesnt exist.");
    }

}
