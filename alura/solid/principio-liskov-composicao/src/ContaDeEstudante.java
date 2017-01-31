
public class ContaDeEstudante {
	
	private ManipuladorDeSaldo manipuladorDeSaldo;
    private int milhas;
    
    public ContaDeEstudante() {
    	manipuladorDeSaldo = new ManipuladorDeSaldo();
	}

    public void saca(double valor) {
    	manipuladorDeSaldo.saca(valor);
    }

    public void deposita(double valor) {
    	manipuladorDeSaldo.deposita(valor);
        this.milhas += (int)valor;
    }

    public int getMilhas() {
        return milhas;
    }

    public double getSaldo() {
    	return manipuladorDeSaldo.getSaldo();
    }
}