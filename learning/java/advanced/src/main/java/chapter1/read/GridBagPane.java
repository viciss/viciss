package chapter1.read;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class GridBagPane extends JPanel
{
  private GridBagConstraints constraints;

  public GridBagPane(File file)
  {
    setLayout(new GridBagLayout());
    constraints = new GridBagConstraints();

    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(true);

      if (file.toString().contains("-schema"))
      {
        factory.setNamespaceAware(true);
        final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
      }

      factory.setIgnoringElementContentWhitespace(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(file);
      parseGridbag(doc.getDocumentElement());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public Component get(String name)
  {
    Component[] components = getComponents();
    for (int i = 0; i < components.length; i++)
    {
      if (components[i].getName().equals(name))
        return components[i];
    }
    return null;
  }

  private void parseGridbag(Element e)
  {
    NodeList rows = e.getChildNodes();
    for (int i = 0; i < rows.getLength(); i++)
    {
      Element row = (Element) rows.item(i);
      NodeList cells = row.getChildNodes();
      for (int j = 0; j < cells.getLength(); j++)
      {
        Element cell = (Element) cells.item(j);
        parseCell(cell, i, j);
      }
    }
  }

  private void parseCell(Element e, int r, int c)
  {

  }

  private Object parseBean(Element e)
  {

  }

  private Object parseValue(Element e)
  {
    Element child = (Element) e.getFirstChild();
    if (child.getTagName().equals("bean"))
      return parseBean(child);

    String text = ((Text) child.getFirstChild()).getData();
    if (child.getTagName().equals("int"))
      return new Integer(text);
    else if (child.getTagName().equals("boolean"))
      return new Boolean(text);
    else if (child.getTagName().equals("string"))
      return text;
    else
      return null;
  }
}
