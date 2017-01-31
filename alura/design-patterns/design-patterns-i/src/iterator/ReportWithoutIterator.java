package iterator;

import java.util.ArrayList;

public class ReportWithoutIterator {
	public static void main(String[] args) {
		BasketFruits basketFruits = new BasketFruits();
		ArrayList<Product> fruits = basketFruits.getProductsWithoutIterator();

		BasketDrinks basketDrinks = new BasketDrinks();
		Product[] drinks = basketDrinks.getProductsWithoutIterator();

		for (int i = 0; i < fruits.size(); i++) {
			Product fruit = (Product) fruits.get(i);
			System.out.println(fruit.getName() + ", ");
			System.out.println(fruit.getDescription() + ", ");
			System.out.println(fruit.getPrice());
		}

		for (int i = 0; i < drinks.length; i++) {
			Product drink = (Product) drinks[i];

			if (drink != null) {
				System.out.println(drink.getName() + ", ");
				System.out.println(drink.getDescription() + ", ");
				System.out.println(drink.getPrice());
			}
		}
	}
}
