package memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoricoContrato {
	private List<EstadoContrato> estadosContratosSalvos = new ArrayList<>();
	
	public EstadoContrato pega(int indice) {
		return estadosContratosSalvos.get(indice);
	}
	
	public List<EstadoContrato> todosContratosSalvos() {
		return Collections.unmodifiableList(estadosContratosSalvos);
	}
	
	public void adiciona(EstadoContrato estadoContrato) {
		estadosContratosSalvos.add(estadoContrato);
	}
}
