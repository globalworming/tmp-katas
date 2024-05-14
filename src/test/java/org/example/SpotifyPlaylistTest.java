package org.example;

import org.junit.jupiter.api.Test;

public class SpotifyPlaylistTest extends SpotifyPlaylisttestBase {
    String user = "anna";

    @Test
    void addToPlayListFails() {
        spotify.addToPlaylist("song 1", user, "playlist 1");
    }
}
