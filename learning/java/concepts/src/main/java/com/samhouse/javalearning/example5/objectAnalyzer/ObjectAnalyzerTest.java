package com.samhouse.javalearning.example5.objectAnalyzer;

import java.util.ArrayList;

public class ObjectAnalyzerTest
{
  public static void main(String[] args)
  {
    ArrayList<Integer> squares = new ArrayList<>();
    for ( int i = 1; i <= 5; i++ )
      squares.add( i * i );
    System.out.println(new ObjectAnalyzer().toString(squares));

    int[] intArray = new int[5];
    for ( int i = 0; i < 5; i++ )
    {
      intArray[i] = ( i + 1 ) * ( i + 1 );
    }
    System.out.println(new ObjectAnalyzer().toString(intArray));
  }
}
