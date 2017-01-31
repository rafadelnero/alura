package iterator;

import java.util.ArrayList;

public class BasketFruits {
	private ArrayList<Product> fruits;

	public BasketFruits() {
		fruits = new ArrayList<>();

		addProduct("Orange", "bla bla", 3);
		addProduct("Apple", "bla bla", 2);
		addProduct("Limon", "C", 2.45);
	}

	public void addProduct(String name, String description, double price) {
		Product product = new Product(name, description, price);
		fruits.add(product);
	}

	public ArrayList<Product> getProductsWithoutIterator() {
		return this.fruits;
	}

	public Iterator getProducts() {
		return new FruitsIterator(this.fruits);
	}
}
