package com.sam.finaltest;

import java.io.File;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sam.jacksontest.CamelCaseNamingStrategy;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    AnimalDeserializer deserializer =
        new AnimalDeserializer();

    deserializer.registerAnimal("leash_color", Dog.class);
    deserializer.registerAnimal("favorite_toy", Cat.class);
    deserializer.registerAnimal("wing_span", Bird.class);

    SimpleModule module =
        new SimpleModule("PolymorphicAnimalDeserializerModule",
            new Version(1,0,0,null,null,null));
    module.addDeserializer(Animal.class, deserializer);

    ObjectMapper mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
    mapper.registerModule(module);

    Zoo zoo = mapper.readValue(new File("src/json/input_6.json"), Zoo.class);
    System.out.println(mapper.writeValueAsString(zoo));
  }
}
