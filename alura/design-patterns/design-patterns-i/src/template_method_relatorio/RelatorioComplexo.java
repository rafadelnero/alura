package template_method_relatorio;

public class RelatorioComplexo extends TemplateRelatorio {
	@Override
	protected void geraCabecalho(Conta conta) {
		System.out.println("Cabeçalho: ");
		System.out.println("Nome: " + conta.getNome() + "Endereço: " + conta.getEndereco() + "Telefone: "
				+ conta.getTelefone());
	}

	@Override
	protected void geraCorpo(Conta conta) {
		System.out.println("Conteúdo: ");
		System.out.println("Titular: " + conta.getTitular() + "Agência: " + conta.getAgencia() + "Saldo: "
				+ conta.getSaldo() + "Número da conta" + conta.getNumeroConta());
	}

	@Override
	protected void geraRodape(Conta conta) {
		System.out.println("Rodapé: ");
		System.out.println("E-mail: " + conta.getEmail() + "Data atual: " + conta.getDataAtual());
	}
}
