package net.samhouse;

import java.awt.event.ActionListener;
import java.lang.Runnable;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by stone on 17/9/2.
 */
public class LamdaExpresses
{
  public static void main(String[] args) {
    Runnable noArguments = () -> System.out.println("Hello world!");

    ActionListener oneArgument = event -> System.out.println("Button clicked!");

    Runnable multiStatement = () -> {
      System.out.println("Hello");
      System.out.println("World");
    };

    BinaryOperator<Long> add = (x, y) -> x + y;
    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

    Predicate<Integer> atLeast5 = x -> x > 5;
  }

  private boolean check(IntPred predicate) {
    return false;
  }

  private boolean check(Predicate<Integer> predicate) {
    return false;
  }
}
