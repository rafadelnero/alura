package chain_of_responsability_ex_conta;

public class TestaRequisicoes {
	public static void main(String[] args) {
		Requisicao requisicaoXML = new Requisicao(Formato.XML);
		Requisicao requisicaoCSV = new Requisicao(Formato.CSV);
		Requisicao requisicaoPorcento = new Requisicao(Formato.PORCENTO);

		Conta conta = new Conta();

		VerificadorDeFormato verificadorDeFormato = new VerificadorDeFormato();

		verificadorDeFormato.verifica(requisicaoXML, conta);
		verificadorDeFormato.verifica(requisicaoCSV, conta);
		verificadorDeFormato.verifica(requisicaoPorcento, conta);
	}
}
