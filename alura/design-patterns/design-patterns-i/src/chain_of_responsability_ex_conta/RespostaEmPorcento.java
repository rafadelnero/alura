package chain_of_responsability_ex_conta;

public class RespostaEmPorcento implements Resposta {
	private Resposta reposta;

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.PORCENTO) {
			System.out.println(conta.getTitular() + "%" + conta.getSaldo());
		} else {
			assert false : "Não deve chegar aqui!";
		}
	}
}
