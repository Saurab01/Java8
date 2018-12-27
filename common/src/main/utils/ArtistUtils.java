package main.utils;

import main.models.Artist;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class ArtistUtils {
    public static boolean isFrom(Artist a,String place){
        return a.getOrigin().equalsIgnoreCase(place);
    }
}
