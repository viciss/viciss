package timing;

public class Timing
{
  private long start_timing = 0;
  private long duration = 0;
  private boolean using_mili = false;

  public Timing()
  {
  }

  public Timing(boolean using_mili)
  {
    this.using_mili = using_mili;
  }

  public void setUsingMili(boolean using_mili)
  {
    this.using_mili = using_mili;
  }

  public void start()
  {
    duration = 0;
    if ( using_mili )
      start_timing = System.currentTimeMillis();
    else
      start_timing = System.nanoTime();
  }

  public void stop()
  {
    long stop_timing = 0;
    if ( using_mili )
      stop_timing = System.currentTimeMillis();
    else
      stop_timing = System.nanoTime();
    duration = stop_timing - start_timing;
  }

  public long getAverageTiming(int times)
  {
    if ( duration != 0 && times != 0 )
      return duration / times;
    return 0;
  }

  @Override
  public String toString()
  {
    return new Long(duration).toString() + ( using_mili == true ? "milis" : "nanos" );
  }
}
