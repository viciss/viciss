package com.samhouse.javalearning.codesnippets;

import java.util.Scanner;

import static java.lang.Math.*;

public class CodeSnippets
{
  // '\u0000' stands for a unicode character
  // in theory, following code should work
  //public static void main(String\u005B\u005D args)

  public static void main(String[] args)
  {
    int n = 9;
    int fourthBitfromRight = (n & (1<<3)) >> 3;

    System.out.println("fourth bit from right of 9 is:" + fourthBitfromRight);

    n = 7;
    fourthBitfromRight = (n & (1<<3)) >> 3;
    System.out.println("fourth bit from right of 7 is:" + fourthBitfromRight);

    System.out.println("The square root of \u03C0 is " + sqrt(PI));

    String greetingInEng = "hello";
    String greetingInChn = "你好";

    // 最后一个字是属于U+0x10000以后的字符，所以需要2个UNICODE16的编码来表示
    // java中的字符串是unicode16编码的，length算的是按照UNICODE16为单位的长度
    // 因此最后一个字符将占用两个unicode16
    String specialString = "㍽㍻㍿䶠𡑼";

    int nLenEng = greetingInEng.length();
    int nLenChn = greetingInChn.length();
    int nLenSpe = specialString.length();// 4+2=6

    System.out.println("length of " + greetingInEng + " is " + nLenEng);
    System.out.println("length of " + greetingInChn + " is " + nLenChn);
    System.out.println("length of " + specialString + " is " + nLenSpe);

    int cpLenEng = greetingInEng.codePointCount(0, greetingInEng.length());
    int cpLenChn = greetingInChn.codePointCount(0, greetingInChn.length());
    int cpLenSpe = specialString.codePointCount(0, specialString.length());

    System.out.println("code point length of " + greetingInEng + " is " + cpLenEng);
    System.out.println("code point length of " + greetingInChn + " is " + cpLenChn);
    // 事实上只有5个字符
    System.out.println("code point length of " + specialString + " is " + cpLenSpe);

    StringBuffer sbuff = new StringBuffer();
    StringBuilder sb = new StringBuilder();

    Scanner in = new Scanner(System.in);
    System.out.print("What is your name? ");
    String name = in.nextLine();
  }
}
