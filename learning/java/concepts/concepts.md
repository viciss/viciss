1. StringBuilder和StringBuffer是不同的，StringBuffer可以用在多线程的环境，而StringBuilder不可以
2. 敏感字符串信息应该存储在字符数组中，而不是String中
```java
Console cons = System.console();
String username = cons.readLine("User Name: ");
// passwd使用完成后应该被清零
char[] passwd = cons.readPassword("password: ");
```
3. 移位操作符
  和C/C++中不同的是,在Java中>>运算符用符号位填充高位,>>>运算符用0填充高位
  在C/C++中无法确定>>操作执行的是算术移位还是逻辑移位?(此点有待证实)
4. 数组的初始化方式
    1. 空数组的初始化方式
    ```java
    int[] array = new int[0];
    ```
    2. C初始化方式
    ```c
    int[] array = {1,2,3,4,5};
    ```
    3. Java初始化方式
    ```java
    int[] array = new int[] {1,2,3,4,5};
    ```
5. `foreach`处理二维数组的方式
```java
double[][] a = new double[][];
for (double[] row: a)
  for (double value: row)
    // do something with value
```
6. 类之间常见的关系
    1. **dependence** - 某一个类`A`的方法使用了另一个类`B`的对象，那么`A`依赖于`B`
    2. **aggregation** - 类A的对象包含了类B的对象，这种关系也叫关联
    3. **inheritance** - 类A继承了类B
7. 在Java中函数参数的传递方式总是采用值调用的方式
    1. 对于基本数据类型，显而易见
    2. 对于对象类型，函数调用传递的是对象的引用的值，函数无法改变这个对象的引用本身，但是却可以改变这个引用所指向的对象
8. 在Java中可以以`this([parm_1], [parm_2], [parm_n])`的方式来调用当前类的构造函数
9. import static的时候，一定import**某个类**的静态字段或方法
10. 在Java中重载函数的调用一定是动态绑定的，**除了private、static和final的方法**
11. 没有定义为public的类，只能被同一个包中的其他类所访问
12. 在一个Java源文件中，**只能有一个和这个源文件名相同的public类**，如果另外还有一个public类，那么编译就不通过，非public的类可以有多个  
**这是一个by design的行为**
13. main函数不是一定要定义在public的类中的
14. ==比较的是是不是指向同一个对象，只有equals是比较两个对象是不是有相同内容
15. Integer, Long, Float...等对象包装器不可变，（其实String是不是也可以认为是一种包装器呢？）  
  `ArrayList<int>`非法而`ArrayList<Integer>`合法
16. `public static void main(String... args) == public static void main(String[] args)`
17. `ArrayList<xxx> = new ArrayList<>()`是一个对象而不是一个数组