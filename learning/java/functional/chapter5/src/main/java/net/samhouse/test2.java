package net.samhouse;

import java.util.stream.Stream;

public class test2 {
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

        String result =
                Stream.of(artists)
                .map(Artist::getName)
                .reduce(new StringCombiner(",", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge).toString();

        System.out.println("Result of combiner is: " + result);

        result = Stream.of(artists)
                .map(Artist::getName)
                .collect(new StringCollector(", ", "[", "]"));
        System.out.println("Result of StringCollector is: " + result);
    }
}
