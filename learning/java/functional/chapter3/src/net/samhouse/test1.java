package net.samhouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stone on 17/9/2.
 */
public class test1
{
  public static void main(String[] args) {
    List<Artist> allArtists = new ArrayList<>();
    allArtists.add(new Artist("The Beatles",
        new Artist[]
            {
                new Artist("John Lennon","London"),
                new Artist("Paul McCartney", "London"),
                new Artist("George Harrison", "London"),
                new Artist("Ringo Starr", "London")
            }, "London"));

    for1(allArtists);
    for2(allArtists);

    long count = allArtists.stream()
        .filter(artist -> {
          System.out.println("all artist is " + artist);
          return artist.isFrom("London");
        })
        .count();

  }

  private static void for1(List<Artist> allArtists) {
    int count = 0;

    for (Artist artist : allArtists) {
      if (artist.isFrom("London")) {
        count++;
      }
    }
  }

  private static void for2(List<Artist> allArtists) {
    int count = 0;

    Iterator<Artist> iterator = allArtists.iterator();
    while (iterator.hasNext()) {
      Artist artist = iterator.next();
      if (artist.isFrom("London")) {
        count++;
      }
    }
  }
}
