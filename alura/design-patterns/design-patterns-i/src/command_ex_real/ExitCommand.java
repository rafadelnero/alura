package command_ex_real;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ExitCommand extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public ExitCommand() {
		super("Exit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
