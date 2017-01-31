package decorator_ex_filtro;

import java.util.ArrayList;
import java.util.List;

public class FiltroSaldoMaior500Mil extends Filtro {
	public FiltroSaldoMaior500Mil(Filtro outroFiltro) {
		super(outroFiltro);
	}

	public FiltroSaldoMaior500Mil() {
		super();
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<>();
		for (Conta conta : contas) {
			if (conta.getSaldo() > 500000) {
				filtrada.add(conta);
			}
		}
		filtrada.addAll(proximo(contas));

		return filtrada;
	}
}
