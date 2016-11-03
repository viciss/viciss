package link;

public class reverseLink
{
  public static void main(String[] args)
  {
    data header = new data();

    for (int i = 0; i < 10; i++)
    {
      data temp = new data();
      temp.setNode("node" + i);
      temp.setNext(header.getNext());
      header.setNext(temp);
    }

    data iterator = header.getNext();
    while (iterator != null)
    {
      System.out.println(iterator.getNode());
      iterator = iterator.getNext();
    }
  }
}

class data
{
  private String node;
  private data next;

  public data()
  {
    node = null;
    next = null;
  }

  public String getNode()
  {
    return this.node;
  }

  public void setNode(String node)
  {
    this.node = node;
  }

  public data getNext()
  {
    return this.next;
  }

  public void setNext(data next)
  {
    this.next = next;
  }
}