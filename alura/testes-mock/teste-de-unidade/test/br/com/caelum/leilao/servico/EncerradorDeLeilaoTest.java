package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.componentes.EnviadorDeEmail;
import br.com.caelum.leilao.infra.dao.LeilaoDao;

public class EncerradorDeLeilaoTest {
	
	private LeilaoDao daoFalso;
	
	private EnviadorDeEmail enviadorDeEmail;
	
	@Before
	public void setUp() {
		daoFalso = mock(LeilaoDao.class);
		enviadorDeEmail = mock(EnviadorDeEmail.class);
	}
	
	@Test
	public void deveEncerrarLeiloesQueComecaramHaMaisDeUmaSemanaTest() {
		Calendar calendarAntigo = Calendar.getInstance();
		calendarAntigo.add(Calendar.WEEK_OF_YEAR, -2);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Playstation 4").naData(calendarAntigo).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Xbox One").naData(calendarAntigo).constroi();
		
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());

		assertEquals(2, encerradorDeLeilao.getTotalEncerrados());
	}
	
	@Test
	public void naoDeveEncerrarLeiloesQueComecaramOntemTest() {
		Calendar calendarDeOntem = Calendar.getInstance();
		calendarDeOntem.add(Calendar.DAY_OF_YEAR, -1);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Playstation 4").naData(calendarDeOntem).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Xbox One").naData(calendarDeOntem).constroi();
		
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		verify(daoFalso, never()).atualiza(leilao1);
		verify(daoFalso, never()).atualiza(leilao2);
		
		List<Leilao> resultados = daoFalso.correntes();
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
		assertFalse(resultados.get(0).isEncerrado());
		assertFalse(resultados.get(1).isEncerrado());
		
		assertEquals(0, encerradorDeLeilao.getTotalEncerrados());
	}
	
	@Test
	public void deveRetornarUmaListaVaziaAoEncerrarTest() {
		LeilaoDao daoFalso = mock(LeilaoDao.class);
		
		when(daoFalso.correntes()).thenReturn(new ArrayList<>());
		
		List<Leilao> leiloes = daoFalso.correntes();
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
		assertTrue(leiloes.isEmpty());
	}
	
	@Test
	public void deveAtualizarAoEncerrarTest() {
		Calendar calendarAntigo = Calendar.getInstance();
		calendarAntigo.add(Calendar.WEEK_OF_YEAR, -2);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Playstation 4").naData(calendarAntigo).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Xbox One").naData(calendarAntigo).constroi();
		
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		List<Leilao> leiloes = daoFalso.correntes();
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
        InOrder inOrder = inOrder(daoFalso, enviadorDeEmail);
        inOrder.verify(daoFalso, times(1)).atualiza(leiloes.get(0));
        inOrder.verify(enviadorDeEmail, times(1)).envia(leiloes.get(0));
        inOrder.verify(daoFalso, times(1)).atualiza(leiloes.get(1));
		inOrder.verify(enviadorDeEmail, times(1)).envia(leiloes.get(1));
	}
	
	@Test
	public void deveLancarExcecaoEAtualizarEmSeguidaAoEncerrarTest() {
		Calendar calendarAntigo = Calendar.getInstance();
		calendarAntigo.add(Calendar.WEEK_OF_YEAR, -2);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Playstation 4").naData(calendarAntigo).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Xbox One").naData(calendarAntigo).constroi();
		
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);
		
		List<Leilao> leiloes = daoFalso.correntes();
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
		InOrder inOrder = inOrder(daoFalso, enviadorDeEmail);
		inOrder.verify(daoFalso, times(1)).atualiza(leiloes.get(0));
		inOrder.verify(enviadorDeEmail, never()).envia(leiloes.get(0));
		inOrder.verify(daoFalso, times(1)).atualiza(leiloes.get(1));
		inOrder.verify(enviadorDeEmail, times(1)).envia(leiloes.get(1));
	}
	
	@Test
	public void deveLancarExcecaoEmTodosOsCasosAoEncerrarTest() {
		Calendar calendarAntigo = Calendar.getInstance();
		calendarAntigo.add(Calendar.WEEK_OF_YEAR, -2);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Playstation 4").naData(calendarAntigo).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Xbox One").naData(calendarAntigo).constroi();
		
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao2);
		
		EncerradorDeLeilao encerradorDeLeilao = new EncerradorDeLeilao(daoFalso, enviadorDeEmail);
		
		encerradorDeLeilao.encerra();
		
		InOrder inOrder = inOrder(daoFalso, enviadorDeEmail);
		
		inOrder.verify(enviadorDeEmail, never()).envia(any(Leilao.class));
	}
}
