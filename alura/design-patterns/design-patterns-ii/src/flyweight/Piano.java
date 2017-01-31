package flyweight;

import java.util.List;

import org.jfugue.Player;

public class Piano {
	public void toca(List<Nota> notas) {
		StringBuilder musicaEmNotas = new StringBuilder();
		
		for (Nota nota : notas) {
			musicaEmNotas.append(nota.simbolo()).append(" ");
		}
		
		new Player().play(musicaEmNotas.toString());
	}
}
