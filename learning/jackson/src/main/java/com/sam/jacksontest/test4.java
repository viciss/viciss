package com.sam.jacksontest;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class test4
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy( new CamelCaseNamingStrategy() );
    PolyZoo zoo = mapper.readValue(new File("src/json/input_4.json"), PolyZoo.class);
    System.out.println(mapper.writeValueAsString(zoo));
  }
}
