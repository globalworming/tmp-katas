package org.example;

import org.example.api.AuthService;
import org.example.api.Database;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class SpotifyPlaySongtestBase {

    AuthService authService = new AuthServiceImpl();

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


    Spotify spotify;

    @BeforeEach
    void setUp() {
        spotify = new Spotify(authService, returningSomeSongs);

    }
}
