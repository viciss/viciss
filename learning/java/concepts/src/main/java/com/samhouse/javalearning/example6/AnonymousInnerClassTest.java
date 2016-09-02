package com.samhouse.javalearning.example6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class AnonymousInnerClassTest
{
  public static void main(String[] args)
  {
    TalkingClockAnony clock = new TalkingClockAnony();
    clock.start(1000, true);

    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}

class TalkingClockAnony
{
  public void start(int interval, final boolean beep)
  {
    ActionListener listener = new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Date now = new Date();
        System.out.println("At the tone, the time is " + now);
        if (beep)
          Toolkit.getDefaultToolkit().beep();
      }
    };

    Timer t = new Timer(interval, listener);
    t.start();
  }
}