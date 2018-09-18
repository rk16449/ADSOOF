package dataStructures;

public interface IHashTable<T> {
	public void insert(T obj);
	public void delete(T obj);
	public boolean exists(T obj);
	public void resize(int num);
}
