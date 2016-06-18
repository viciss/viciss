package com.samhouse.javalearning.abstractclass;

import com.samhouse.javalearning.abstractclass.abstractBase;

/**
 * Created by stone on 16/6/17.
 */
public class Base extends abstractBase
{
  public Base()
  {
    System.out.println(getFromHashMap("key1"));
  }
}
