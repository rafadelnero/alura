package command_ex_real;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class OpenCommand extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private XLSDocument xls;

	public OpenCommand(XLSDocument xls) {
		super("Open...");
		this.xls = xls;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String file = JOptionPane.showInputDialog((Component) e.getSource(), "Entre com o nome do arquivo:");
		if (file != null && file.length() > 0) {
			xls.open(file);
		}
	}

}
