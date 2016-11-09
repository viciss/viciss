package link;

public interface AbstractList<T>
{
  AbstractList Initialize();
  T FindKth(int k, AbstractList list);
  int Find(T element, AbstractList list);
  void Insert(T element, int i, AbstractList list);
  void Delete(int i, AbstractList list);
  int Length(AbstractList list);
}
