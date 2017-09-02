package net.samhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by stone on 17/9/2.
 */
public class test2
{
  public static void main(String[] args) {
    Album album = new Album("test",
        new Track[] {new Track("Bakai", 524)},
        new Artist[] {
            new Artist("The Beatles",
                new Artist[]
                    {
                        new Artist("John Lennon","London"),
                        new Artist("Paul McCartney", "London"),
                        new Artist("George Harrison", "London"),
                        new Artist("Ringo Starr", "London")
                    }, "London")});

    Set<String> origins = album.getMusicians()
        .filter(artist -> artist.getName().startsWith("The"))
        .map(artist -> artist.getNationality())
        .collect(Collectors.toSet());

    System.out.println("" + origins.toString());

    List<Album> albums = new ArrayList<>();
    albums.add(album);

    Set<String> trackName = albums.stream().flatMap(ab -> ab.getTracks())
        .filter(track -> track.getLength() > 60)
        .map(track -> track.getName())
        .collect(Collectors.toSet());

    System.out.println("" + trackName.toString());
  }
}
