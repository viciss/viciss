package net.samhouse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stone on 17/9/2.
 */
public class test2Test
{
  @Before
  public void setUp() throws Exception
  {

  }

  @After
  public void tearDown() throws Exception
  {

  }

  @Test
  public void testStreamCollect() {
    List<String> collected = Stream.of("a", "b", "c")
        .collect(Collectors.toList());

    assertEquals(Arrays.asList("a", "b", "c"), collected);
  }

  @Test
  public void testStreamMap() {
    List<String> collected = new ArrayList<>();
    for (String string : Arrays.asList("a", "b", "hello")) {
      String uppercaseString = string.toUpperCase();
      collected.add(uppercaseString);
    }

    assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

    collected = Stream.of("a", "b", "hello")
        .map(string -> string.toUpperCase())
        .collect(Collectors.toList());

    assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
  }

  @Test
  public void testStreamFilter() {
    List<String> beginningWithNumbers = new ArrayList<>();
    for (String value : Arrays.asList("a", "1abc", "abc1")) {
      if (isDigit(value.charAt(0))) {
        beginningWithNumbers.add(value);
      }
    }

    assertEquals(Arrays.asList("1abc"), beginningWithNumbers);

    beginningWithNumbers = Stream.of("a", "1abc", "abc1")
        .filter(value -> isDigit(value.charAt(0)))
        .collect(Collectors.toList());

    assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
  }

  @Test
  public void testStreamFlatmap() {
    List<Integer> together = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4))
        .flatMap(numbers -> numbers.stream())
        .collect(Collectors.toList());

    assertEquals(Arrays.asList(1,2,3,4), together);
  }

  @Test
  public void testMinMax() {
    List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
        new Track("Violets for Your Furs", 378),
        new Track("Time Was", 451));

    Track shortestTrack = tracks.stream()
        .min(Comparator.comparing(track -> track.getLength()))
        .get();

    assertEquals(tracks.get(1), shortestTrack);
  }
}
