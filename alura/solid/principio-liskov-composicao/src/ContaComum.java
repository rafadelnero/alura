
public class ContaComum {

    private ManipuladorDeSaldo manipuladorDeSaldo;

    public ContaComum() {
    	manipuladorDeSaldo = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
    	manipuladorDeSaldo.deposita(valor);
    }

    public void saca(double valor) {
    	manipuladorDeSaldo.saca(valor);
    }

    public void somaInvestimento(){
        manipuladorDeSaldo.somaInvestimento();
    }

    public double getSaldo() {
        return manipuladorDeSaldo.getSaldo();
    }

}