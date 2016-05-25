package com.sam.chattest;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdChat
{
  @JsonProperty("Id")
  private String id;

  @JsonProperty("name")
  private String name;

  private HashMap<String, String> optionList = new HashMap<String, String>();

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @JsonAnyGetter
  public HashMap<String, String> getOptionList()
  {
    return optionList;
  }

  @JsonAnySetter
  public void setOptionList( String key, String value )
  {
    optionList.put(key, value);
  }

  public void setOptionList(HashMap<String, String> map)
  {
    this.optionList = map;
  }
}
