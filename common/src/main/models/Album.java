package main.models;

import java.util.List;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class Album {
    private String name;
    private List<Track> tracks;
    private String musician;

    public Album(String name, List<Track> tracks, String musician) {
        this.name = name;
        this.tracks = tracks;
        this.musician = musician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }
}
