package net.samhouse;

import java.util.IntSummaryStatistics;

/**
 * Created by stone on 17/9/11.
 */
public class test1
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

    printTrackLengthStatistics(album);
  }

  public static void printTrackLengthStatistics(Album album ) {
    IntSummaryStatistics trackLengthStats
        = album.getTracks()
        .mapToInt(track -> track.getLength())
        .summaryStatistics();
    System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
        trackLengthStats.getMax(),
        trackLengthStats.getMin(),
        trackLengthStats.getAverage(),
        trackLengthStats.getSum());
  }
}
