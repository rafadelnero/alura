package template_method_relatorio;

public class RelatorioComplexo extends TemplateRelatorio {
	@Override
	protected void geraCabecalho(Conta conta) {
		System.out.println("Cabe�alho: ");
		System.out.println("Nome: " + conta.getNome() + "Endere�o: " + conta.getEndereco() + "Telefone: "
				+ conta.getTelefone());
	}

	@Override
	protected void geraCorpo(Conta conta) {
		System.out.println("Conte�do: ");
		System.out.println("Titular: " + conta.getTitular() + "Ag�ncia: " + conta.getAgencia() + "Saldo: "
				+ conta.getSaldo() + "N�mero da conta" + conta.getNumeroConta());
	}

	@Override
	protected void geraRodape(Conta conta) {
		System.out.println("Rodap�: ");
		System.out.println("E-mail: " + conta.getEmail() + "Data atual: " + conta.getDataAtual());
	}
}
