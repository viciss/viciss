package com.samhouse.javalearning.example12;


public class pairTest1
{
  public static void main(String[] args)
  {
    String[] words = {"Mary", "had", "a", "little", "lamb"};
    Pair<String> mm = ArrayAlg.mimax(words);
    System.out.println("min = " + mm.getFirst());
    System.out.println("max = " + mm.getSecond());
  }
}

class ArrayAlg
{
  public static Pair<String> mimax(String[] a)
  {
    if ( a == null || a.length == 0 )
      return null;
    String min = a[0];
    String max = a[0];

    for ( int i = 1; i < a.length; i++ )
    {
      if ( min.compareTo(a[i]) > 0 )
        min = a[i];
      if ( max.compareTo(a[i]) < 0 )
        max = a[i];
    }

    return new Pair<>(min, max);
  }
}
