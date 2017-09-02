package net.samhouse;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by stone on 17/9/2.
 */
public class Artist
{
  private String name;

  private Artist[] members;

  private String origin;

  public Artist() {};

  public Artist(String name, Artist[] members, String origin) {
    this.name = name;
    this.members = members;
    this.origin = origin;
  }

  public Artist(String name, String origin) {
    this.name = name;
    this.origin = origin;
    this.members = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Stream<Artist> getMembers() {
    return Arrays.asList(members).stream();
  }

  public void setMembers(Artist[] members) {
    this.members = members;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getNationality() {
    return getOrigin();
  }

  public boolean isFrom(String from) {
    if (origin.equals(from))
      return true;
    return false;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("[")
        .append(name)
        .append("]");

    String memberList = Stream.of(members).map(member -> "["+member.getName()+"]").reduce("", (acc, member) -> acc + member);
    sb.append(memberList);
    sb.append(origin);

    return sb.toString();
  }
}
