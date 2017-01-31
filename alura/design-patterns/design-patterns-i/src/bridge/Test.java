package bridge;

public class Test {
	public static void main(String[] args) {
		BusinessManager productsManager = new ProductBusinessObject();

		DataAccess notIndexed = new ProductNotIndexedImpl();
		DataAccess indexed = new ProductIndexedImpl();

		productsManager.setDataAccess(notIndexed);
		productsManager.insert("Milk");
		productsManager.insert("Tea");
		productsManager.insert("Bean");
		productsManager.insert("Coffee");
		productsManager.insert("Pizza");

		productsManager.print();

		productsManager.setDataAccess(indexed);
		productsManager.insert("Milk");
		productsManager.insert("Tea");
		productsManager.insert("Bean");
		productsManager.insert("Coffee");
		productsManager.insert("Pizza");

		productsManager.print();
	}
}
