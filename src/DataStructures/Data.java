package dataStructures;


public class Data<T> {
	
	private T value;

	public T getValue() {
		return this.value;
	}
	
	public Data<T>copyMe() {
		return new Data<T>(this);
	}
	
	public Data(T var) {
		this.value = var;
	}
	
	/**
	 * Copy constructor
	 * @param old
	 */
	public Data(Data<T> old) {
		// Copy over any variables etc here
		this.value = old.value;
	}
}
