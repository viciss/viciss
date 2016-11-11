package timing;

public class testTiming
{
  public static void main(String[] args)
  {
    Timing t = new Timing();
    t.start();
    for (int i = 0; i < 1000; i++)
    {
      System.out.println(i);
    }
    t.stop();

    System.out.println("Time for executing 100 system.out.println() is:" + t);

    t.setUsingMili(true);
    t.start();
    for (int i = 0; i < 1000; i++)
    {
      System.out.println(i);
    }
    t.stop();

    System.out.println("Time for executing 100 system.out.println() is:" + t);
  }
}
