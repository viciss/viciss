package com.sam.jacksontest;

import java.io.File;
import java.util.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class test2
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    Collection<Animal> animals =
        mapper.readValue(new File("src/json/input_2.json"),
            new TypeReference<Collection<Animal>>() {});

    System.out.println(mapper.writeValueAsString(animals));

    Collection<Animal> animals2 =
        mapper.readValue(new File("src/json/input_2.json"),
            TypeFactory.defaultInstance().constructParametricType(
                Collection.class, Animal.class));

    System.out.println(mapper.writeValueAsString(animals2));
  }
}
