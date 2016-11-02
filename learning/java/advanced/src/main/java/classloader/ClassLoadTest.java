package classloader;

public class ClassLoadTest {
  public static void main(String[] args)
  {
    ClassLoader loader = ClassLoadTest.class.getClassLoader();
    while (loader != null)
    {
      System.out.println(loader);
      loader = loader.getParent();
    }
    System.out.println(loader);
  }
}
