1. StringBuilder和StringBuffer是不同的，StringBuffer可以用在多线程的环境，而StringBuilder不可以
2. 敏感字符串信息应该存储在字符数组中，而不是String中
```java
Console cons = System.console();
String username = cons.readLine("User Name: ");
// passwd使用完成后应该被清零
char[] passwd = cons.readPassword("password: ");
```
3. 数组的初始化方式
    1. 空数组的初始化方式
    ```java
    int[] array = new int[0];
    ```
    2. C初始化方式
    ```java
    int[] array = {1,2,3,4,5};
    ```
    3. Java初始化方式
    ```java
    int[] array = new int[] {1,2,3,4,5};
    ```
4. `foreach`处理二维数组的方式
```java
double[][] a = new double[][];
for (double[] row: a)
  for (double value: row)
    // do something with value
```
5. 类之间常见的关系
    1. **dependence** - 某一个类`A`的方法使用了另一个类`B`的对象，那么`A`依赖于`B`
    2. **aggregation** - 类A的对象包含了类B的对象，这种关系也叫关联
    3. **inheritance** - 类A继承了类B
6.
