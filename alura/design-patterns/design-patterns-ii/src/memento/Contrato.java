package memento;

import java.util.Date;

public class Contrato {
	private Date data;
	private String nomeCliente;
	private Tipo tipo;
	
	public void avanca() {
		if (tipo == Tipo.NOVO) {
			tipo = Tipo.EM_ANDAMENTO;
		} else if (tipo == Tipo.EM_ANDAMENTO) {
			tipo = Tipo.ACERTADO;
		} else {
			tipo = Tipo.CONCLUIDO;
		}
	}
	
	public Contrato(Date data, String nomeCliente, Tipo tipo) {
		super();
		this.data = data;
		this.nomeCliente = nomeCliente;
		this.tipo = tipo;
	}
	
	
	public EstadoContrato salvaEstado() {
		return new EstadoContrato(new Contrato(this.getData(), this.getNomeCliente(), this.getTipo()));
	}

	public Date getData() {
		return data;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Contrato [data=" + data + ", nomeCliente=" + nomeCliente + ", tipo=" + tipo + "]";
	}
}
