package bridge;

public abstract class BusinessManager {
	protected DataAccess dataAccess;

	public void setDataAccess(DataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}

	public void insert(String name) {
		dataAccess.create(name);
	}

	public void delete(String name) {
		dataAccess.remove(name);
	}

	public void print() {
		dataAccess.print();
	}
}
