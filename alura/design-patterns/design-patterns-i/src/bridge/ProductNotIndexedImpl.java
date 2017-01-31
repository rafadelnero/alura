package bridge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductNotIndexedImpl extends DataAccess {

	List productList = new ArrayList<>();

	@Override
	public void create(String name) {
		this.productList.add(name);
	}

	@Override
	public void remove(String name) {
		this.productList.remove(name);
	}

	@Override
	public void print() {
		Iterator i = productList.iterator();

		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
