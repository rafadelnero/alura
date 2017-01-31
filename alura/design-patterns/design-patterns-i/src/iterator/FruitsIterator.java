package iterator;

import java.util.ArrayList;

public class FruitsIterator implements Iterator {

	private ArrayList<Product> products;
	private int index = 0;

	public FruitsIterator(ArrayList<Product> products) {
		this.products = products;
	}

	@Override
	public boolean hasNext() {
		return index < products.size() && products.get(index) != null;
	}

	@Override
	public Object next() {
		return products.get(index++);
	}
}
