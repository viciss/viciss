package com.samhouse.javalearning.example3;

import java.util.Arrays;

public class CodeSnippets
{
  public static void main(String[] args)
  {
    int[] smallPrimes = {2,3,5,7,11,13};
    System.out.println(Arrays.toString(smallPrimes));

    int[] anotherArray = new int[] {17,19,23,29,31,37};
    System.out.println(Arrays.toString(anotherArray));

    // smallPrimes和anotherArray指向同一个数组
    // 此时，smallPrimes和anotherArray有点类似于C中的数组指针概念
    smallPrimes = anotherArray;
    anotherArray[0] = 41;
    System.out.println(Arrays.toString(smallPrimes));

    // Arrays.copyOf will copy value from one array to another
    int[] copyArray = Arrays.copyOf(anotherArray, 2*anotherArray.length);
    anotherArray[0] = 17;
    System.out.println(Arrays.toString(anotherArray));
    System.out.println(Arrays.toString(copyArray));

    int[] emptyArray = new int[0];
    System.out.println(Arrays.toString(emptyArray));
  }
}
