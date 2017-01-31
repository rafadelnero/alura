package command;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
	private Map<String, Command> commands = new HashMap<>();

	public void register(String name, Command command) {
		this.commands.put(name, command);
	}

	public void execute(String name) {
		Command command = (Command) this.commands.get(name);
		if (command != null) {
			command.execute();
		}
	}
}
