
public class Data<T> {
	
	public T variable;

	
	public Data<T>copyMe() {
		return new Data<T>(this);
	}
	
	public Data(Data<T> old) {
		// Copy over any variables etc here
		this.variable = old.variable;
	}
}
