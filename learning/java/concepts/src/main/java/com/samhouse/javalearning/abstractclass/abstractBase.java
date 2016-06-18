package com.samhouse.javalearning.abstractclass;

import java.util.Hashtable;

/**
 * Created by stone on 16/6/17.
 */
public abstract class abstractBase
{
  private static Hashtable<String, String> hashmap = new Hashtable<String, String>();
  {
    hashmap.put("key1","value1");
    hashmap.put("key2","value2");
  }

  public static String getFromHashMap(String key)
  {
    return hashmap.get(key);
  }
  public abstractBase()
  {

  }
}
