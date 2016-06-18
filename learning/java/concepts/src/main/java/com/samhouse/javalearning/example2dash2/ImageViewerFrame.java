package com.samhouse.javalearning.example2dash2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class ImageViewerFrame extends JFrame
{
  private JLabel label;
  private JFileChooser chooser;
  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 400;

  public ImageViewerFrame()
  {
    setTitle("ImageViewer");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // Use a label to display the images
    label = new JLabel();
    add(label);

    // set up the file chooser
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("."));

    // set up the menu bar
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem openItem = new JMenuItem("Open");
    menu.add(openItem);
    openItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        // show file chooser dialog
        int result = chooser.showOpenDialog(null);

        // if file selected, set it as icon of the label
        if (result == JFileChooser.APPROVE_OPTION)
        {
          String name = chooser.getSelectedFile().getPath();
          label.setIcon(new ImageIcon(name));
        }
      }
    });

    JMenuItem exitItem = new JMenuItem("Exit");
    menu.add(exitItem);
    exitItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        System.exit(0);
      }
    });
  }
}
