package com.samhouse.javalearning;

/**
 * Hello world!
 */
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

    String lan = "bbb";
    lan = getSelfTest(lan);
    System.out.println(lan);

    lan = "aaa";
    lan = getSelfTest(lan);
    System.out.println(lan);

    Base base = new Base();
    String value = abstractBase.getFromHashMap("ccc");
    System.out.println(value);
  }

  public static String getSelfTest(String language)
  {
    if ( language.equals("aaa") )
      return "aaa";
    else
      return language;
  }
}
