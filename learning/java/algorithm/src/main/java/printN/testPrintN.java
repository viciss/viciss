package printN;

import timing.Timing;

import java.util.Arrays;
import java.util.function.Consumer;

public class testPrintN
{
  public static void main(String[] args)
  {
    final int n = 20;
    Timing t = new Timing();
    t.setUsingMili(true);
    System.out.print("For version printN:");
    t.start();
    PrintN_for(n);
    t.stop();
    System.out.println("Using " + t);

    System.out.print("Recursive version printN:");
    t.start();
    PrintN_recursive(n);
    t.stop();
    System.out.println("Using " + t);

    System.out.print("Recursive version_1 printN:");
    t.start();
    PrintN_recursive_1(n);
    t.stop();
    System.out.println("Using " + t);

    System.out.print("Recursive version_2 printN:");
    t.start();
    PrintN_recursive_2(n, n);
    t.stop();
    System.out.println("Using " + t);

    System.out.print("Lambda version printN:");
    t.start();
    PrintN_lambda(n);
    t.stop();
    System.out.println("Using " + t);
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
