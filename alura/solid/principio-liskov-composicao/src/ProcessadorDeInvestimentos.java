public class ProcessadorDeInvestimentos {

    public static void main(String[] args) {
    	ContaComum contaComum = new ContaComum();
    	contaComum.deposita(1000);
    	contaComum.saca(550);
    	
    	System.out.println(contaComum.getSaldo());
    	
    	ContaDeEstudante contaDeEstudante = new ContaDeEstudante();
    	contaDeEstudante.deposita(600);
    	contaDeEstudante.saca(550);
    	
    	System.out.println(contaDeEstudante.getSaldo());
    }
}