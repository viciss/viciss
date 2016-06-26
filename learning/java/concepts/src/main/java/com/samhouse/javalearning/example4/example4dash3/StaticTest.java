package com.samhouse.javalearning.example4.example4dash3;

class StaticTest
{
  public static void main(String[] args)
  {
    Employee[] staff = new Employee[]
        {
            new Employee("Tom", 40000),
            new Employee("Dick", 60000),
            new Employee("Harry", 65000)
        };

    for (Employee e : staff)
    {
      e.setId();
      System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
    }

    int n = Employee.getNextId();
    System.out.println("Next available id =" + n);
  }
}
