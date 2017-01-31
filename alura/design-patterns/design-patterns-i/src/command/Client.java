package command;

public class Client {
	public static void main(String[] args) {
		Mapping mapping = new Mapping();
		mapping.register("/create", new CreateAction());
		mapping.register("/remove", new RemoveAction());
		mapping.register("/update", new UpdateAction());

		mapping.execute("/remove");
	}
}
