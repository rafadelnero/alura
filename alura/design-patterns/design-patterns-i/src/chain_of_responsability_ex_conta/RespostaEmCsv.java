package chain_of_responsability_ex_conta;

public class RespostaEmCsv implements Resposta {
	private Resposta resposta;

	public RespostaEmCsv(Resposta resposta) {
		this.resposta = resposta;
	}

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.CSV) {
			System.out.println(conta.getTitular() + ";" + conta.getSaldo());
		} else {
			resposta.responde(req, conta);
		}
	}
}
