package com.samhouse.javalearning;

import java.util.Hashtable;

/**
 * Created by stone on 16/6/17.
 */
public abstract class abstractBase
{
  private static Hashtable<String, String> hashmap = new Hashtable<String, String>();
  {
    hashmap.put("aaa","bbb");
    hashmap.put("ccc","ddd");
  }

  public static String getFromHashMap(String key)
  {
    return hashmap.get(key);
  }
  public abstractBase()
  {

  }
}
