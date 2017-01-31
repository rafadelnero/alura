package decorator_ex_filtro;

import java.util.ArrayList;
import java.util.List;

public class FiltroSaldoMenor100 extends Filtro {
	public FiltroSaldoMenor100(Filtro outroFiltro) {
		super(outroFiltro);
	}

	public FiltroSaldoMenor100() {
		super();
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta conta : contas) {
			if (conta.getSaldo() < 100) {
				filtrada.add(conta);
			}
		}

		filtrada.addAll(proximo(contas));

		return filtrada;
	}
}
