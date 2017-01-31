package template_method_relatorio;

public class RelatorioSimples extends TemplateRelatorio {

	@Override
	protected void geraCabecalho(Conta conta) {
		System.out.println("Cabe�alho: ");
		System.out.println("Titular: " + conta.getTitular() + "Nome da conta: " + conta.getSaldo());
	}

	@Override
	protected void geraCorpo(Conta conta) {
		System.out.println("Conte�do: ");
		System.out.println("Nome do banco: " + conta.getNome() + " Telefone: " + conta.getTelefone());
	}

	@Override
	protected void geraRodape(Conta conta) {
		System.out.println("Rodap�: ");
		System.out.println("Nome do banco: " + conta.getNome() + " Telefone: " + conta.getTelefone());
	}

}
