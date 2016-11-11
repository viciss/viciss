package chapter1.write;

import java.awt.*;
import javax.swing.*;

public class XMLWriteTest
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        JFrame frame = new XMLWriteFrame();
        frame.setTitle("XMLWriteTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}
