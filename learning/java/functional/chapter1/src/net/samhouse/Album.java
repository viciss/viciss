package net.samhouse;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by stone on 17/9/2.
 */
public class Album
{
  private String name;

  private Track[] tracks;

  private Artist[] musicians;

  public Album() {
  }

  public Album(String name, Track[] tracks, Artist[] musicians) {
    this.name = name;
    this.tracks = tracks;
    this.musicians = musicians;
  }

  public Stream<Artist> getMusicians() {
    return Arrays.asList(musicians).stream();
  }

  public Stream<Track> getTracks() {
    return Arrays.asList(tracks).stream();
  }
}
