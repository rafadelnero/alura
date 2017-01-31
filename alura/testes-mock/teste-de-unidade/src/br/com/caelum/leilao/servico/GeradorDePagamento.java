package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.infra.componentes.Relogio;
import br.com.caelum.leilao.infra.componentes.RelogioDoSistema;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;

public class GeradorDePagamento {

	private final RepositorioDePagamentos pagamentos;
	private final RepositorioDeLeiloes leiloes;
	private final Avaliador avaliador;
	private final Relogio relogio;

	public GeradorDePagamento(RepositorioDeLeiloes leiloes, RepositorioDePagamentos pagamentos, Avaliador avaliador, 
			Relogio relogio) {
		this.leiloes = leiloes;
		this.pagamentos = pagamentos;
		this.avaliador = avaliador;
		this.relogio = relogio;
	}
	
	public GeradorDePagamento(RepositorioDeLeiloes leiloes, RepositorioDePagamentos pagamentos, Avaliador avaliador) {
		this(leiloes, pagamentos, avaliador, new RelogioDoSistema());
	}

	public void gera() {

		List<Leilao> leiloesEncerrados = leiloes.encerrados();
		for (Leilao leilao : leiloesEncerrados) {
			avaliador.avalia(leilao);

			Pagamento novoPagamento = new Pagamento(avaliador.getMaiorLance(), primeiroDiaUtil());

			pagamentos.salva(novoPagamento);
		}
	}

	private Calendar primeiroDiaUtil() {
		Calendar primeiroDiaUtil = relogio.hoje();
		
		if (primeiroDiaUtil.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) primeiroDiaUtil.add(Calendar.DAY_OF_WEEK, 2);
		if (primeiroDiaUtil.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) primeiroDiaUtil.add(Calendar.DAY_OF_WEEK, 1);
		
		return primeiroDiaUtil;
	}
}
