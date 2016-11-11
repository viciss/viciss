package link;

import java.util.function.IntFunction;

public interface AbstractList<T>
{
  void Initialize(IntFunction<T[]> arrayConstructor, int size);
  T FindKth(int k);
  int Find(T element);
  void Insert(T element, int i);
  void Delete(int i);
  int Length();
}
