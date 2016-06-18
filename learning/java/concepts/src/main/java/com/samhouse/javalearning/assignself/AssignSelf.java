package com.samhouse.javalearning.assignself;


public class AssignSelf
{
  public static void main(String[] args)
  {
    String lan = "bbb";
    lan = getSelfTest(lan);
    System.out.println(lan);

    lan = "aaa";
    lan = getSelfTest(lan);
    System.out.println(lan);
  }

  // 在java中的String更像是C／C++中的字符串指针
  // 我们没有办法改变字符串“bbb”中的值，但是我们可以
  // 新建一个String对象，重新构建一个以“bbb”为基础的新的字符串
  public static String getSelfTest(String language)
  {
    if ( language.equals("aaa") )
      return "aaa";
    else
      return language;
  }
 }
