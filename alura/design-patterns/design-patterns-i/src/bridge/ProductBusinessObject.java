package bridge;

public class ProductBusinessObject extends BusinessManager {
	public void print() {
		System.out.println();
		System.out.println("Products:");
		super.print();
	}
}
