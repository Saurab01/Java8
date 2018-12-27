package main.basics_1;

import main.models.Album;
import main.models.Artist;
import main.models.Track;
import main.utils.ArtistUtils;
import main.utils.CreateDemoData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by saurabhagrawal on 27/12/18.
 */
public class StreamsBasics {
    private List<Artist> allArtists= CreateDemoData.demoArtistsCreate();
    private List<Track> tracks=CreateDemoData.demoTrackLists();
    private List<Album> allAlbums= CreateDemoData.demoAlbumsCreate();
    public static void main(String[] a){
        StreamsBasics basics=new StreamsBasics();
        basics.getOriginBased("Pune");

        basics.testToCollect();
        basics.testMap();
        basics.testFlatMap();
        basics.testMinMax();

        basics.getNamesForTrackGreater();


    }

    private void getNamesForTrackGreater() {

        Set<String> trackNames = new HashSet<>();

        for(Album album : allAlbums) {
            for (Track track : album.getTracks()) {
                if (track.getTrackNumber() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        System.out.println("*****\nTrack name::"+trackNames);

        //Case1
        Set<String> trackNames2 =new HashSet<>();
        for(Album album : allAlbums) {
            album.getTracks().stream()
                    .filter((track)->track.getTrackNumber()>60)
                    .map(track->track.getName()) //or .map(Track::getName)
                    .forEach(name->trackNames2.add(name)); //or .forEach(name->trackNames2.add(name))
        }
        System.out.println("Case 1 Track name::"+trackNames2);

        //case 2
        //now since we need to meger multiple streams---so use flatmap
        Set<String> trackNames_flat =new HashSet<>();
        //TODO: correct this
        /*trackNames_flat=allAlbums.stream()
                .flatMap(album -> album.getTracks())
                    .filter((track)->track.getTrackNumber()>60)
                    .map(track->track.getName())
                    .collect(Collectors.toSet());*/
        System.out.println("Case 2 Track name using flatmap::"+trackNames_flat);

    }


    private void getOriginBased(String place) {
        //using counting forloop
        int count = 0;
        for (Artist artist : allArtists) {
            if (ArtistUtils.isFrom(artist,place)) {
                count++;
            }
        }
        System.out.println("*****\nusing counting for loop::"+count);

        //using iterator
        count=0;
        Iterator<Artist> iterator = allArtists.iterator();
        while(iterator.hasNext()) {
            Artist artist = iterator.next();
            if (ArtistUtils.isFrom(artist,place)) {
                count++;
            }
        }
        System.out.println("using iterator::"+count);

        //using internal iteration
         long count2 = allArtists.stream()
                .filter(artist -> {
                    System.out.println("Check place for :"+ artist.getName());
                    return ArtistUtils.isFrom(artist,place) ; //filter acceps predicate--true or false
                })
                .count();  //long returned always

         System.out.println("using stream::"+count+"\n*******");


    }

    private void testToCollect() {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(collected);
        //Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);
    }
    private void testMap() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())   //convert each to upper case
                .collect(Collectors.toList());
        System.out.println("***\n Map results::"+collected);
    }
    private void testFlatMap() {
        //Flatmap--lets you replace a value with a Stream and concatenates all the streams together.
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        //Assert(Arrays.asList(1, 2, 3, 4), together);
    }
    private void testMinMax() {
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getTrackNumber()))
                .get();  //important we can pull value using get()
        System.out.println("*****Minumim track==="+shortestTrack);

        List<Track> emptyTracks=new ArrayList<>();
        System.out.println(emptyTracks.stream()
                .max(Comparator.comparing(track -> track.getTrackNumber())));
        //Important:: max can be called on empty list--return Optional.empty , but doing.get() will throw excepton
    }



}
