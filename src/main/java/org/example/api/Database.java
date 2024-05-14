package org.example.api;

import java.util.List;

public interface Database {

    public void addToPlaylist(String song, String playlist);

    public List<String> songsFor(String playlist);

}
