1. StringBuilder和StringBuffer是不同的，StringBuffer可以用在多线程的环境，而StringBuilder不可以
2. 敏感字符串信息应该存储在字符数组中，而不是String中
```
Console cons = System.console();
String username = cons.readLine("User Name: ");
char[] passwd = cons.readPassword("password: ");
```