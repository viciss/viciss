package com.samhouse.javalearning.example2dash1;

public class App
{
  public static void main(String[] args)
  {
    String[] greeting = new String[3];
    greeting[0] = "Welcome to Core Java";
    greeting[1] = "by Cay Horstmann";
    greeting[2] = "and Gary Cornell";

    for (String g : greeting)
      System.out.println(g);
  }
}
