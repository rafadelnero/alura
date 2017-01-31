package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.infra.componentes.Relogio;
import br.com.caelum.leilao.infra.componentes.RelogioDoSistema;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;

public class GeradorDePagamentoTest {
	
	private RepositorioDePagamentos pagamentos;
	private RepositorioDeLeiloes leiloes;
	private Relogio relogio;
	private Usuario maria;
	private Usuario joao;

	@Before
	public void criaAvaliador() {
		this.pagamentos = mock(RepositorioDePagamentos.class);
		this.leiloes = mock(RepositorioDeLeiloes.class);
		this.relogio = mock(RelogioDoSistema.class);
		this.joao = new Usuario("João");
		this.maria = new Usuario("Maria");
	}

	@Test
	public void deveGerarPagamentoTest() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
        		.lance(joao, 2000.0)
        		.lance(maria, 2500.0)
        		.constroi();
		
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));

		GeradorDePagamento geradorDePagamento = new GeradorDePagamento(leiloes, pagamentos,
				new Avaliador());
		
		geradorDePagamento.gera();

		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamento = argumento.getValue();
		assertEquals(2500.0, pagamento.getValor(), 0.0001);
	}
	
	@Test
	public void deveEmpurrarSabadoParaSegundNoPagamentoTest() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 2000.0)
				.lance(maria, 2500.0)
				.constroi();
		
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		Calendar sabado = Calendar.getInstance();
		sabado.set(2016, 2, 19);
		when(relogio.hoje()).thenReturn(sabado);
		
		GeradorDePagamento geradorDePagamento = new GeradorDePagamento(leiloes, pagamentos,
				new Avaliador(), relogio);
		
		geradorDePagamento.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamentoParaSabado = argumento.getValue();
		assertEquals(2500.0, pagamentoParaSabado.getValor(), 0.0001);
		
		assertEquals(Calendar.MONDAY, pagamentoParaSabado.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(21, pagamentoParaSabado.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void deveEmpurrarDomingoParaSegundaNoPagamentoTest() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 2000.0)
				.lance(maria, 2500.0)
				.constroi();
		
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		Calendar domingo = Calendar.getInstance();
		domingo.set(2016, 2, 20);
		when(relogio.hoje()).thenReturn(domingo);
		
		GeradorDePagamento geradorDePagamento = new GeradorDePagamento(leiloes, pagamentos,
				new Avaliador(), relogio);
		
		geradorDePagamento.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamento = argumento.getValue();
		assertEquals(2500.0, pagamento.getValor(), 0.0001);
		
		assertEquals(Calendar.MONDAY, pagamento.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(21, pagamento.getData().get(Calendar.DAY_OF_MONTH));
	}
}
