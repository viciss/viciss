package Employee;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

class SerialCloneable implements Cloneable, Serializable
{
  public Object clone()
  {
    try
    {
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(bout);
      out.writeObject(this);
      out.close();

      ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
      ObjectInputStream in = new ObjectInputStream(bin);
      Object ret = in.readObject();
      in.close();

      return ret;
    }
    catch (Exception e)
    {
      return null;
    }
  }
}

public class Employee extends SerialCloneable
{
  private String name;
  private double salary;
  private Date   hireDay;

  public static final int NAME_SIZE = 40;
  public static final int RECORD_SIZE = 100;

  public Employee(String n, double s, int year, int month, int day)
  {
    name = n;
    salary = s;
    GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
    hireDay = calendar.getTime();
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

  public Date getHireDay()
  {
    return hireDay;
  }

  public void raiseSalary(double byPercent)
  {
    double raise = salary * byPercent / 100.0;
    salary = salary + raise;
  }

  public boolean equals(Object otherObject)
  {
    if ( this == otherObject )
      return true;

    if ( otherObject == null )
      return false;

    if ( getClass() != otherObject.getClass() )
      return false;

    Employee other = (Employee) otherObject;

    return Objects.equals(name, other.name) && salary == other.salary &&
        Objects.equals(hireDay, other.hireDay);
  }

  public int hashCode()
  {
    return Objects.hash(name, salary, hireDay);
  }

  public String toString()
  {
    return getClass().getName() + "[name=" + name + ",salary=" + salary +
        ",hireDay=" + hireDay + "]";
  }

//  public Employee clone() throws CloneNotSupportedException
//  {
//    Employee cloned = (Employee) super.clone();
//
//    cloned.hireDay = (Date) hireDay.clone();
//    cloned.name = name;
//    cloned.salary = salary;
//
//    return cloned;
//  }
}

