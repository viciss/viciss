package com.samhouse.javalearning.example6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest
{
  public static void main(String[] args)
  {
    ActionListener listener = new TimePrinter();

    Timer t = new Timer(10000, listener);
    t.start();

    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}

class TimePrinter implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    Date now = new Date();
    System.out.println("At the tone, the tim is " + now);
    Toolkit.getDefaultToolkit().beep();
  }
}