package net.samhouse;

import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 * Created by stone on 17/9/2.
 */
public class ThreadLocalTest
{
  public static void main(String[] args) {
    ThreadLocal<Integer> tls = ThreadLocal.withInitial(() -> -1);
    System.out.println("The initial value of tls is: " + tls.get());

    tls.set(10);
    System.out.println("The new value of tls is: " + tls.get());

    ThreadLocal<DateFormatter> tlsDF = ThreadLocal.withInitial(() -> new DateFormatter());
    Date date = new Date();
    System.out.println("The initial value of tlsDF is: " + tlsDF.get().getFormat().format(date));
  }
}
