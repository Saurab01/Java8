package main.utils;

import main.models.Album;
import main.models.Artist;
import main.models.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class CreateDemoData {
    public static List<Artist> demoArtistsCreate(){
        List<Artist> artistList=new ArrayList<>();
        artistList.add(new Artist("Saurabh","A","Pune"));
        artistList.add(new Artist("Agrawal","B","Pune"));
        artistList.add(new Artist("Gaurav","A","Chennai"));
        artistList.add(new Artist("Sharma","B","Benaras"));
        artistList.add(new Artist("Sarthak","C","Lucknow"));
        return artistList;
    }
    public static List<Track> demoTrackLists(){
        return Arrays.asList(new Track("Bakai", 60),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
    }

    public static List<Album> demoAlbumsCreate() {
        List<Track> track1=Arrays.asList(new Track("Bakai", 60),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        List<Track> track2=Arrays.asList(new Track("Bakai", 60),
                new Track("Violets for Your Furs", 378));
        List<Track> track3=Arrays.asList(
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        return Arrays.asList(new Album("chameli",track1,"Hitesh"),
                new Album("aabhi ja",track2,"Reshamiya"),
                new Album("Sanam",track3,"Sunidhi"),
                new Album("yun na kar",track1,"Hitesh"),
                new Album("Sitam",track2,"Chauhan"));
    }
}
