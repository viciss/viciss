package net.samhouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isLowerCase;
import javafx.util.Pair;

/**
 * Created by stone on 17/9/2.
 */
public class exercises
{
  public static void main(String[] args) {
    int total = Stream.of(1, 2, 3, 4, 5)
        .reduce(0, (acc, element) -> acc + element);
    System.out.println("1+2+3+4+5=" + total);

    List<Pair<String, String>> list = Stream.of("aa", "bb", "cc", "dd")
        .map(value -> new Pair<>(value+value.toUpperCase(), value))
        .collect(Collectors.toList());

    System.out.println(list.toString());

    List<Artist> allArtists = new ArrayList<>();
    allArtists.add(new Artist("The Beatles",
        new Artist[]
            {
                new Artist("John Lennon","London"),
                new Artist("Paul McCartney", "London"),
                new Artist("George Harrison", "London"),
                new Artist("Ringo Starr", "London")
            }, "London"));

    long memberCount = allArtists.stream()
        .flatMap(artist -> artist.getMembers())
        .distinct()
        .count();

    System.out.println(memberCount);

    AtomicInteger count = new AtomicInteger(0);
    allArtists.get(0).getMembers().forEach(member -> count.incrementAndGet());
    System.out.println(count.get());

    findMostLowercase();
  }

  public static Optional<String> findMostLowercase() {
    List<String> list = new ArrayList<>();
    list.add("ABCDefghe");
    list.add("aaaaabED");

    Optional<String> ret = Optional.of(
    list.stream()
        .map(str -> new Pair<String, Long>(str, str.chars().filter(ch -> isLowerCase(ch)).count()))
        .max(Comparator.comparing(pair -> pair.getValue()))
        .orElseGet(()->{return new Pair<String, Long>("", (long) 0);})
        .getKey());

    System.out.println(ret.get());
    return ret;
  }
}
