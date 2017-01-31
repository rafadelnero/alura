package command_ex_real;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;

	public Client(JMenuBar menuBar) {
		setTitle("Sample Command");
		setSize(500, 250);
		setJMenuBar(menuBar);
		setVisible(true);
	}

	public static void main(String[] args) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Commands");

		XLSDocument xls = new XLSDocument();
		OpenCommand opening = new OpenCommand(xls);
		ExitCommand existing = new ExitCommand();

		menu.add(opening);
		menu.add(existing);

		menuBar.add(menu);

		new Client(menuBar);
	}
}
