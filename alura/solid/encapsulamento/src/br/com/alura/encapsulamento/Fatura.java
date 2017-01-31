package br.com.alura.encapsulamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatura {

    private String cliente;
    private double valor;
    private List<Pagamento> pagamentos;
    private boolean pago;

    public Fatura(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
        this.pagamentos = new ArrayList<Pagamento>();
        this.pago = false;
    }
    
    public void adicionaPagamento(Pagamento pagamento) {
    	this.getPagamentos().add(pagamento);
    	
    	if (valorTotalDosPagamentos() > this.valor) {
    		this.pago = true;
    	}
    }
    
    public double valorTotalDosPagamentos() {
    	double total = 0.0;
    	
    	for (Pagamento pagamento : pagamentos) {
    		total += pagamento.getValor();
		}
    	
    	return total;
    }

    public List<Pagamento> getPagamentos() {
		return Collections.unmodifiableList(pagamentos);
	}

	public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }
}