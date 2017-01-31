package template_method_relatorio;

public abstract class TemplateRelatorio implements Relatorio {

	@Override
	public final void geraRelatorio(Conta conta) {
		geraCabecalho(conta);
		geraCorpo(conta);
		geraRodape(conta);
	}

	protected abstract void geraCabecalho(Conta conta);

	protected abstract void geraCorpo(Conta conta);

	protected abstract void geraRodape(Conta conta);
}