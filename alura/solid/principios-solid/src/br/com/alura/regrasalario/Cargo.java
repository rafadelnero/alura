package br.com.alura.regrasalario;

import br.com.alura.regrasalario.porcentagemsalario.DezOuVintePorcento;
import br.com.alura.regrasalario.porcentagemsalario.QuinzeOuVinteCincoPorcento;
import br.com.alura.regrasalario.porcentagemsalario.RegraSalario;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorcento()),
    DBA(new QuinzeOuVinteCincoPorcento()),
    TESTER(new QuinzeOuVinteCincoPorcento());
    
	private RegraSalario regraSalario;
	
	private Cargo(RegraSalario regraSalario) {
		this.regraSalario = regraSalario;
	}

	public RegraSalario getRegraSalario() {
		return regraSalario;
	}
}