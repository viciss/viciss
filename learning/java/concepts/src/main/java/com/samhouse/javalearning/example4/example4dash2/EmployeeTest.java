package com.samhouse.javalearning.example4.example4dash2;

import java.util.Arrays;

public class EmployeeTest
{
  public static void main(String[] args)
  {
    Employee[] employees = new Employee[]
        {
            new Employee("Carl", 30000.0, 1977, 11, 12),
            new Employee("Harry", 40000.0, 1987, 10, 10)
        };

    // fill the staff array with three Employee objects
    Employee[] staff = new Employee[3];

    staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
    staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
    staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

    // raise everyone's salary by 5%
    for (Employee e : staff)
      e.raiseSalary(5);

    // print out information about all Employee objects
    for (Employee e : staff)
      System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()
        + ",hireDay=" + e.getHireDay());
  }
}
