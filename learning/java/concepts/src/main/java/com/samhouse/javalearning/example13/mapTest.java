package com.samhouse.javalearning.example13;

import java.util.HashMap;
import java.util.Map;

import com.samhouse.javalearning.example5.example5dash3.Employee;

public class mapTest
{
  public static void main(String[] args)
  {
    Map<String, Employee> staff = new HashMap<>();
    staff.put("144-25-5464", new Employee("Amy Lee", 11111, 2016, 1, 1));
    staff.put("576-24-2546", new Employee("Harry Hacker", 11111, 2016, 1, 1));
    staff.put("157-62-7935", new Employee("Gary Cooper", 11111, 2016, 1, 1));
    staff.put("456-62-5527", new Employee("Francesca Cruz", 11111, 2016, 1, 1));

    System.out.println(staff);

    staff.remove("576-24-2546");

    staff.put("456-62-5527", new Employee("Francesca Miller", 11111, 2016, 1, 1));

    System.out.println(staff.get("157-62-7935"));

    for (Map.Entry<String, Employee> entry : staff.entrySet())
    {
      String key = entry.getKey();
      Employee value = entry.getValue();
      System.out.println("key=" + key + ", value=" + value);
    }
  }
}
