package com.samhouse.javalearning.example6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class InnerClassTest
{
  public static void main(String[] args)
  {
    TalkingClock clock = new TalkingClock(1000, true);
    clock.start();

    // 公有内部类还可以如下方式引用
    TalkingClock jabberer = new TalkingClock(1000, true);
    TalkingClock.TimePrinter listener = jabberer.new TimePrinter();

    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}

class TalkingClock
{
  private int interval;
  private boolean beep;

  public TalkingClock(int interval, boolean beep)
  {
    this.interval = interval;
    this.beep = beep;
  }

  public void start()
  {
    // 也可以这样：
    // ... listner = this.new TimePrinter();
    ActionListener listener = new TimePrinter();
    Timer t = new Timer(interval, listener);
    t.start();
  }

  public class TimePrinter implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Date now = new Date();
      System.out.println("At the tone. the time is " + now);

      // 还可以通过这种方式来引用
      // if (TalkingClock.this.beep) ...
      if ( beep )
        Toolkit.getDefaultToolkit().beep();
    }
  }
}