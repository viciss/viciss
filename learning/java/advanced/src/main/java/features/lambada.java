package features;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class lambada {
  public static void main(String... args)
  {
    String[] strs = new String[] {"a", "b", "c"};
    List<String> I = Arrays.asList(strs);

    I.forEach(e -> System.out.println(e));

    lambada l = new lambada();
    System.out.println(l.factorial.apply(3));

  }

  public UnaryOperator<Integer> factorial = i -> i == 0 ? 1 : i * this.factorial.apply(i - 1);
  public void distinctPrimary(String...numbers)
  {
//    List<String> I = Arrays.asList(numbers);
//    List<Integer> r = I.stream()
//            .map(e -> new Integer(e))
//            .filter(e -> Primes.isPrime(e))
//            .distinct()
//            .collect(Collectors.toList());
  }
}
