package singleton;

public class Servico {
	private static Servico servico;
	
	public Servico getServico() {
		if (servico == null) {
			servico = new Servico();
		}
		
		return servico;
	}
}
