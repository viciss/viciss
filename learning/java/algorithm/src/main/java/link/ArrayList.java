package link;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

public class ArrayList<T extends Cloneable> implements AbstractList<T>
{
  private static final int DEFAULT_SIZE = 100;
  private T[] data = null;
  private int size = DEFAULT_SIZE;

  public ArrayList()
  {
    // Using refection to initialize a generic array
    data = (T[]) Array.newInstance(data.getClass().getComponentType(), DEFAULT_SIZE);
  }

  // Using lambda to initialize a generic array
  public void Initialize(IntFunction<T[]> arrayConstructor, int size)
  {
    if (size < 0 )
      return;
    data = arrayConstructor.apply(size);
    this.size = size;
  }

  public T FindKth(int k)
  {
    if ( k < 0 || k >= size )
      return null;
    return data[k];
  }

  public int Find(T element)
  {
    for (int i = 0; i < size; i++)
    {
      if (data[i].equals(element))
      {
        return i;
      }
    }
    return -1;
  }

  // TODO try to use System.arraycopy
  public void Insert(T element, int i)
  {
    if (i < 0 || i >= size)
      return;
    for (int k = size - 2; k >= i; k--)
    {
      data[k+1] = data[k];
    }
    data[i] = element;
  }

  public void Delete(int i)
  {
    if ( i < 0 || i >= size)
      return;
    data[size - 1] = null;
    for (int k = i; k < size - 2; k++)
    {
      data[k] = data[k+1];
    }
  }

  public int Length()
  {
    return size;
  }
}
