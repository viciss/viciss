package net.samhouse;

/**
 * Created by stone on 17/9/18.
 */
public class MultiInterface
{
  public interface Jukebox {
    public default String rock() {
      return "... all over the world!";
    }
  }

  public interface Carriage {
    public default String rock() {
      return "... from side to side";
    }
  }

  public static class MusicalCarriage implements Carriage, Jukebox {

    // we have to override this function, otherwise javac will fail
    @Override
    public String rock()
    {
      return Carriage.super.rock();
    }
  }

  private static MusicalCarriage mc;

  public static void main(String[] args) {
    mc = new MusicalCarriage();
    System.out.println(mc.rock());
  }
}
