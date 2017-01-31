package iterator;

public class DrinksIterator implements Iterator {

	private Product[] product;
	private int index = 0;

	public DrinksIterator(Product[] products) {
		this.product = products;
	}

	@Override
	public boolean hasNext() {
		return index < product.length && product[index] != null;
	}

	@Override
	public Object next() {
		return product[index++];
	}

}
