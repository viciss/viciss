package net.samhouse;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class test1 {
    public static void main(String[] args) {
        Artist[] artists =
        new Artist[] {
                new Artist("The Beatles",
                        new Artist[]
                                {
                                        new Artist("John Lennon","London"),
                                        new Artist("Paul McCartney", "London"),
                                        new Artist("George Harrison", "London"),
                                        new Artist("Ringo Starr", "London")
                                }, "London"),
                new Artist("Wang Fei", "Beijin"),
                new Artist("The Fake",
                        new Artist[]
                                {
                                        new Artist("No one","Shanghai"),
                                        new Artist("Famous", "Shanghai"),
                                        new Artist("Faceless", "Shanghai"),
                                        new Artist("Shanghainess", "Shanghai"),
                                        new Artist("Handsome", "Shanghai")
                                }, "Shanghai")};

        Optional<Artist> optional = biggestGroup(Arrays.asList(artists).stream());
        System.out.println("optional= " + optional);

        Map<Boolean, List<Artist>> bandSolo = bandsAndSolo(Arrays.asList(artists).stream());
        System.out.println("band And Solo= " + bandSolo);

        String result =
                Stream.of(artists).map(Artist::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("result of joining= " + result);

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

        Map<Artist, Long> artistAlbums = numberOfAlbums(Stream.of(albums));
        System.out.println("Number of artistAlbums is: " + artistAlbums);

        Map<Artist, List<String>> artistAlbumName = nameOfAlbums(Stream.of(albums));
        System.out.println("Name of artistAlbums is: " + artistAlbumName);
    }

    public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.filter(artist -> artist.isSolo() == false).collect(Collectors.maxBy(comparing(getCount)));
    }

    public static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusician(), Collectors.counting()));
    }

    public static Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.mapping(Album::getName, Collectors.toList())));
    }
}
