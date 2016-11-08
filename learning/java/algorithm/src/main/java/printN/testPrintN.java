package printN;

import java.util.Arrays;
import java.util.function.Consumer;

public class testPrintN
{
  public static void main(String[] args)
  {
    final int n = 10;
    System.out.print("For version printN:");
    PrintN_for(n);
    System.out.println();
    System.out.print("Recursive version printN:");
    PrintN_recursive(n);
    System.out.println();
    System.out.print("Recursive version_1 printN:");
    PrintN_recursive_1(n);
    System.out.println();
    System.out.print("Recursive version_2 printN:");
    PrintN_recursive_2(n, n);
    System.out.println();
    System.out.print("Lambda version printN:");
    PrintN_lambda(n);
    System.out.println();
  }

  static void PrintN_for(int n)
  {
    for (int i = 0; i < n; i++)
    {
      System.out.print(i + " ");
    }
  }

  static void PrintN_recursive(int n)
  {
    if (n > 0)
    {
      System.out.print(n - 1 + " ");
      PrintN_recursive(n - 1);
    }
  }

  static void PrintN_recursive_1(int n)
  {
    if (n > 0)
    {
      PrintN_recursive_1(n - 1);
      System.out.print(n - 1 + " ");
    }
  }

  static void PrintN_recursive_2(int n, final int max)
  {
    if (max - n < max)
    {
      System.out.print(max - n + " ");
      PrintN_recursive_2(n - 1, max);
    }
  }

  static void PrintN_lambda(int n)
  {
    Integer[] values = new Integer[n];
    Arrays.parallelSetAll(values, i -> i);
    Arrays.asList(values).forEach(x -> System.out.print(x + " "));
  }
}
