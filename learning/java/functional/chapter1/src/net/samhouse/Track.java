package net.samhouse;

/**
 * Created by stone on 17/9/2.
 */
public class Track
{
  private String name;

  private int length;

  public Track() {};

  public Track(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getLength() {
    return length;
  }
}
