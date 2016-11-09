package link;

public class ArrayList<T> implements AbstractList<T>
{
  private static final int MAXSIZE = 100;
  private T[] data;

  public ArrayList()
  {
    
  }

  public AbstractList Initialize()
  {
    return this;
  }
  public T FindKth(int k, AbstractList list)
  {
    return data[k];
  }
  public int Find(T element, AbstractList list)
  {
    return -1;
  }
  public void Insert(T element, int i, AbstractList list)
  {

  }
  public void Delete(int i, AbstractList list)
  {

  }
  public int Length(AbstractList list)
  {
    return -1;
  }
}
