package chain_of_responsability_ex_conta;

public class VerificadorDeFormato {

	public void verifica(Requisicao requisicao, Conta conta) {
		Resposta respostaPorcento = new RespostaEmPorcento();
		Resposta respostaCsv = new RespostaEmCsv(respostaPorcento);
		Resposta respostaXml = new RespostaEmXml(respostaCsv);

		respostaXml.responde(requisicao, conta);
	}
}
