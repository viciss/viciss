package net.samhouse;

import java.util.List;

/**
 * Created by stone on 17/9/18.
 */
public class Artists
{
  private List<Artist> artists;

  public Artists(List<Artist> artists) {
    this.artists = artists;
  }

  public Artist getArtist(int index) {
    if (index < 0 || index >= artists.size()) {
      indexException(index);
    }
    return artists.get(index);
  }

  private void indexException(int index) {
    throw new IllegalArgumentException(index +
        "doesn't correspond to an Artist");
  }

  public String getArtistName(int index) {
    try {
      Artist artist = getArtist(index);
      return artist.getName();
    }
    catch (IllegalArgumentException e) {
      return "Unknown";
    }
  }
}
