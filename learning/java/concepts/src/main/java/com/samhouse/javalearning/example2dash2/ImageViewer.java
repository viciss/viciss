package com.samhouse.javalearning.example2dash2;

import java.awt.*;
import javax.swing.*;

public class ImageViewer
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        JFrame frame = new ImageViewerFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}
