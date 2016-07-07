package com.samhouse.javalearning.example5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest
{
  public static void main(String[] args)
  {
    int[] a = {1, 2, 3};
    a = (int[]) goodCopyOf(a, 10);
    System.out.println(Arrays.toString(a));

    String[] b = {"Tom", "Dick", "Marry"};
    b = (String[]) goodCopyOf(b, 10);
    System.out.println(Arrays.toString(b));

    System.out.println("The following call will generate an exception.");
    b = (String[]) badCopyOf(b, 10);
  }

  // This function returns an array of Object, and cannot convert this array to other type
  // explicitly
  public static Object[] badCopyOf(Object[] a, int newLength)
  {
    Object[] newArray = new Object[newLength];
    System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
    return newArray;
  }

  public static Object goodCopyOf(Object a, int newLength)
  {
    Class cl = a.getClass();
    if ( !cl.isArray() )
      return null;

    Class componentType = cl.getComponentType();
    int length = Array.getLength( a );
    Object newArray = Array.newInstance(componentType, newLength);
    System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
    return newArray;
  }
}
