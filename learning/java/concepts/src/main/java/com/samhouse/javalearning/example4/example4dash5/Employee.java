package com.samhouse.javalearning.example4.example4dash5;

import java.util.Random;

public class Employee
{
  private static int nextId;

  private int id;
  private String name = "";
  private double salary;

  // static initialization block
  static
  {
    Random generator = new Random();
    nextId = generator.nextInt(10000);
  }

  // object initialization block
  {
    id = nextId;
    nextId++;
  }

  public Employee(String n, double s)
  {
    name = n;
    salary = s;
  }

  public Employee(double s)
  {
    // calls the Employee(String, double) constructor
    this("Employee #" + nextId, s);
  }

  public Employee()
  {
  }

  public String getName()
  {
    return name;
  }

  public double getSalary()
  {
    return salary;
  }

  public int getId()
  {
    return id;
  }
}
