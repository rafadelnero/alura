package template_method_relatorio;

import java.util.Date;

public class TesteRelatorio {
	public static void main(String[] args) {
		RelatorioComplexo relatorioComplexo = new RelatorioComplexo();

		Conta conta = new Conta();
		conta.setAgencia("4343");
		conta.setDataAtual(new Date());
		conta.setEmail("lol@lol.com");
		conta.setNome("Conta 1");
		conta.setTitular("Teste");
		conta.setSaldo(90000);
		conta.setNumeroConta("43435454");
		conta.setTelefone("45545661");
		conta.setEndereco("Rua Teste");

		relatorioComplexo.geraRelatorio(conta);

		RelatorioSimples relatorioSimples = new RelatorioSimples();
		relatorioSimples.geraRelatorio(conta);
	}
}
