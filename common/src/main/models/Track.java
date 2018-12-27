package main.models;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class Track {
    private String name;
    private int trackNumber;

    public Track(String name, int trackNumber) {
        this.name = name;
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
