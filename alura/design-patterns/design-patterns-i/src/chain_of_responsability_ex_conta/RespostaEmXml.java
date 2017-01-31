package chain_of_responsability_ex_conta;

public class RespostaEmXml implements Resposta {
	private Resposta reposta;

	public RespostaEmXml(Resposta resposta) {
		this.reposta = resposta;
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.XML) {
			System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo()
					+ "</saldo></conta>");
		} else {
			reposta.responde(req, conta);
		}
	}
}
