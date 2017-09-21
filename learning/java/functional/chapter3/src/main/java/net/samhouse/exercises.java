package net.samhouse;

import java.util.*;
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
  private static int count = 0;

  public static class handler {
    public Stream<Integer> getSeq() {
      List<Integer> list = new ArrayList<>(10);
      for (int i = 0; i < 10; i++) {
        list.add(count++);
      }
      return list.stream();
    }
  }

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

    getHandleMap();
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

  public static void getHandleMap() {
    List<handler> handlers = new ArrayList<>();
    handlers.add(new handler());
    handlers.add(new handler());

//    HashMap<Integer, handler> hashMap = new HashMap<>();
//    handlers.stream()
//        .map(h -> {
//
//        })
//        .flatMap(h -> h.getSeq())
//        .forEach(h -> {
//          List<Integer> list = h.getSeq();
//          list.stream().forEach(i -> {
//              hashMap.put(i, h);
//          });
//        });
//    System.out.println(hashMap);
  }
}
