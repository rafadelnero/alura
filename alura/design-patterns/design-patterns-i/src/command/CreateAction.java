package command;

public class CreateAction implements Command {

	@Override
	public void execute() {
		System.out.println("Create bean");
	}

}
