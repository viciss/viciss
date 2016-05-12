package com.sam.jacksontest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class test1
{
  static String jsonInput =
    "{\"type\":\"dog\",\"name\":\"Spike\"}";

  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    Animal animal = mapper.readValue(jsonInput, Animal.class);
    System.out.println(mapper.writeValueAsString(animal));
  }
}

