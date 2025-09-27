package fn10.minutesServers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fn10.minutesServers.enums.SongType;
import fn10.minutesServers.songs.SpecialSong;

@RestController
@RequestMapping("/twenty/songs/")
public class SongHandler {

    private static final String[] songs = new String[] {
        ""
    };

    private static final SpecialSong[] specialSongs = new SpecialSong[] {
        new SpecialSong(SongType.title, "20_Minutes")
    };

    @GetMapping("/songList")
    public String[] getRandomSongList() {
        return songs;
    }

    @GetMapping("/specialSongs")
    public SpecialSong[] getSpecialSongs() {
        return specialSongs;
    }



    @GetMapping("/error")
    public String error() {
        return "THIS WORKS!";
    }
}
 