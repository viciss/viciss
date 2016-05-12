package com.sam.jacksontest;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @Type(value = Cat.class, name = "cat" ),
    @Type(value = Dog.class, name = "dog" )
})
abstract class AbstractAnimal
{
    public String name;
}
