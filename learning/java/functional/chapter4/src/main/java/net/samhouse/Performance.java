package net.samhouse;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by stone on 17/9/18.
 */
public interface Performance
{
  String getName();

  Stream<Artist> getMusicians();

  default Stream<String> getAllMusicians() {
    Stream<Artist> artistStream = getMusicians();
    return artistStream.flatMap(artist -> artist.getMembers()).map(performer -> performer.getName());
  }
}
