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
    }

    public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.filter(artist -> artist.isSolo() == false).collect(Collectors.maxBy(comparing(getCount)));
    }

    public static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }
}
