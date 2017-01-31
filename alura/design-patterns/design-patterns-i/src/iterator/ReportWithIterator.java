package iterator;

public class ReportWithIterator {
	public void printProducts(Iterator iterator) {
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			System.out.print(product.getName() + ", ");
			System.out.print(product.getDescription() + ", ");
			System.out.println(product.getPrice());
		}
	}

	public static void main(String[] args) {
		ReportWithIterator report = new ReportWithIterator();
		report.printProducts(new BasketFruits().getProducts());
		report.printProducts(new BasketDrinks().getProducts());
	}
}
