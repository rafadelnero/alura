package memento;

import java.util.Date;

public class Programa {
	public static void main(String[] args) {
		HistoricoContrato historicoContrato = new HistoricoContrato();
		
		Contrato contrato = new Contrato(new Date(), "Josefo", Tipo.NOVO);
		
		historicoContrato.adiciona(contrato.salvaEstado());
		
		contrato.avanca();
		
		historicoContrato.adiciona(contrato.salvaEstado());
		
		contrato.avanca();
		historicoContrato.adiciona(contrato.salvaEstado());
		
		contrato.avanca();
		historicoContrato.adiciona(contrato.salvaEstado());
		
		System.out.println(historicoContrato.pega(3).getContrato());
	}
}
