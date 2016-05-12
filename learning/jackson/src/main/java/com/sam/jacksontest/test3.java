package com.sam.jacksontest;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class test3
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    Zoo zoo =
        mapper.readValue(new File("src/json/input_3.json"), Zoo.class);
    System.out.println(mapper.writeValueAsString(zoo));
  }
}
