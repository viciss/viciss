package com.sam.chattest;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class test
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();

    SdChat sdChat = mapper.readValue(new File("src/json/input_7.json"), SdChat.class);
    System.out.println(mapper.writeValueAsString(sdChat));

    SdChat chat = new SdChat();
    chat.setId("aaaaa");
    chat.setName("bbbb");
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("field1", "value1");
    map.put("field2", "value2");
    chat.setOptionList(map);
    System.out.println(mapper.writeValueAsString(chat));
  }
}
