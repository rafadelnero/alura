package command;

public class RemoveAction implements Command {

	@Override
	public void execute() {
		System.out.println("Remove this bean");
	}

}
