package iterator;

public class BasketDrinks {
	static final int MAX_PRODUCTS = 4;
	int index = 0;
	Product[] drinks;

	public BasketDrinks() {
		drinks = new Product[MAX_PRODUCTS];

		addProduct("Wine", "bla bla", 25.80);
		addProduct("Beer", "bla bla", 5.50);
	}

	public void addProduct(String name, String description, double price) {
		Product product = new Product(name, description, price);

		if (index < MAX_PRODUCTS) {
			drinks[index] = product;
			index++;
		}
	}

	public Product[] getProductsWithoutIterator() {
		return this.drinks;
	}

	public Iterator getProducts() {
		return new DrinksIterator(this.drinks);
	}
}
