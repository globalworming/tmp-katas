package org.example;

import org.example.api.AuthService;
import org.example.api.Database;


public class Spotify {

    private final AuthService authService;
    private final Database playlistDatabase;

    public Spotify(AuthService authService, Database playlistDatabase) {
        this.authService = authService;
        this.playlistDatabase = playlistDatabase;
    }

    public void addToPlaylist(String song, String user, String playlist) {
        authService.validate(user);
        playlistDatabase.addToPlaylist(playlist, song);
    }
}
