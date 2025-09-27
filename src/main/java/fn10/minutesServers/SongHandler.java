package fn10.minutesServers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fn10.minutesServers.enums.SongType;
import fn10.minutesServers.exceptions.SongDoesntExistException;
import fn10.minutesServers.songs.SpecialSong;

@RestController
@RequestMapping("/twenty/songs/")
public class SongHandler {

    private static final String[] songs = new String[] {
            "Critical_Error",
            "Dont_Run_Out",
            "Oil_on_the_Rhoad",
            "Shopping_Spree"
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

    @GetMapping(value = "/downloadSong/{quality}/{songName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] downloadSong(@PathVariable String songName, @PathVariable String quality) throws IOException, URISyntaxException {
        URL proposed = getClass().getResource("/static/songs/" + quality + "/" + songName + ".mp3");
        
        if (proposed == null) {
            throw new SongDoesntExistException(quality, songName);
        }
        
        return Files.readAllBytes(Path.of(proposed.toURI()));
    }
}
