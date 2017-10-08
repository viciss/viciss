package net.samhouse;

import java.util.Arrays;
import java.util.stream.Stream;

public class sample1 {
    public static void main(String[] args) {

        Album[] albums = {
                new Album("test",
                        new Track[] {new Track("Bakai", 524)},
                        new Artist[] {
                                new Artist("The Beatles",
                                        new Artist[]
                                                {
                                                        new Artist("John Lennon","London"),
                                                        new Artist("Paul McCartney", "London"),
                                                        new Artist("George Harrison", "London"),
                                                        new Artist("Ringo Starr", "London")
                                                }, "London")}),
                new Album("Aloha",
                        new Track[] {new Track("Hawaii", 540)},
                        new Artist[] {
                                new Artist("Oche",
                                        null, "Shanghai")})
        };

        int count = Stream.of(albums)
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();

        System.out.println("Num of tracks is: " + count);

        count = Arrays.asList(albums).parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();

        System.out.println("paralle Num of tracks is: " + count);
    }
}
