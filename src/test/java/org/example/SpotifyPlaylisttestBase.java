package org.example;

import org.example.api.AuthService;
import org.example.api.Database;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class SpotifyPlaylisttestBase {

    AuthService authService = new AuthServiceThatPermitsSomeUsers(List.of("pater", "anna"));

    Database returningSomeSongs = new Database() {
        @Override
        public void addToPlaylist(String song, String playlist) {
            throw new RuntimeException("not implemented");
        }

        @Override
        public List<String> songsFor(String playlist) {
            return List.of("song 1", "song2");
        }
    };

    Database thatSaysNoSUchPlaylist = new Database() {
        @Override
        public void addToPlaylist(String song, String playlist) {
            throw new IllegalArgumentException("no such playlist");
        }

        @Override
        public List<String> songsFor(String playlist) {
            throw new RuntimeException("not implemented");
        }
    };


    Spotify spotify;

    @BeforeEach
    void setUp() {
        spotify = new Spotify(authService, thatSaysNoSUchPlaylist);

    }
}
