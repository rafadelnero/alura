package br.com.caelum.leilao.negocio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.builder.LeilaoBuilder;
import br.com.caelum.leilao.componentes.LeilaoMatcher;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.negocio.Avaliador;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AvaliadorTeste {
	
	private Avaliador leiloeiro;
	private Usuario vladoscar;
	private Usuario zeh;
	private Usuario vlades;
	
	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		
		vladoscar = new Usuario("Vladoscar");
		zeh = new Usuario("Zeh");
		vlades = new Usuario("Vlades");
		
		System.out.println("inicializando teste!");
	}
	
	@After
	public void finaliza() {
	  System.out.println("fim");
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	
	@Test
	public void testaMaiorLance() { 
		Leilao leilao = new LeilaoBuilder("teste")
		.lance(new Usuario("Zeh"), 200).lance(new Usuario("Joao"), 400)
		.lance(new Usuario("Loromba"), 500).constroi();
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(500, leiloeiro.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void testaMenorLance() { 
		Leilao leilao = new LeilaoBuilder("teste").lance(new Usuario("Zeh"), 200)
		.lance(new Usuario("Joao"), 400).lance(new Usuario("Loromba"), 500).constroi();
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void calculaValorMedioDosLancesTeste() { 
		Leilao leilao = new LeilaoBuilder("teste").lance(new Usuario("Zeh"), 200)
				.lance(new Usuario("Joao"), 400).lance(new Usuario("Loromba"), 500).constroi();
		
		double valorMedioDosLances = leiloeiro.calculaValorMedioDosLances(leilao);
		
		Assert.assertEquals(366.66, valorMedioDosLances, 0.5);
	}
	
	@Test
	public void apenasUmLanceTeste() {
		Leilao leilao = new Leilao("teste");
		leilao.propoe(new Lance(new Usuario("Zeh"), 200));
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(200, leiloeiro.getMenorLance(), 0.5);
		Assert.assertEquals(200, leiloeiro.getMaiorLance(), 0.5);
	}
	
	@Test
	public void lancesComOrdemDecrescenteTeste() {
		Leilao leilao = new LeilaoBuilder("teste").lance(new Usuario("Zeh"), 400).lance(new Usuario("Vlades"), 300)
				.lance(new Usuario("Jão"), 200).lance(new Usuario("Odemar"), 100).constroi();
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(100, leiloeiro.getMenorLance(), 0.5);
		Assert.assertEquals(400, leiloeiro.getMaiorLance(), 0.5);
	}
	
	@Test
	public void tresUltimosLancesMaioresTeste() {
		Leilao leilao = new LeilaoBuilder("teste").lance(zeh, 400).lance(vlades, 300)
				.lance(new Usuario("Jonão"), 200).lance(new Usuario("Jão"), 200).lance(new Usuario("Odemar"), 100)
				.lance(vladoscar, 5000).constroi();
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(5000, leiloeiro.getTresMaiores().get(0).getValor(), 0.5);
		Assert.assertEquals(400, leiloeiro.getTresMaiores().get(1).getValor(), 0.5);
		Assert.assertEquals(300, leiloeiro.getTresMaiores().get(2).getValor(), 0.5);
		
		assertThat(leiloeiro.getTresMaiores(), hasItems(
                new Lance(vladoscar, 5000), 
                new Lance(zeh, 400),
                new Lance(vlades, 300)
        ));
	}
	
	@Test
	public void doisLancesTeste() {
		Leilao leilao = new LeilaoBuilder("teste").lance(new Usuario("Zeh"), 400).lance(new Usuario("Vlades"), 300).constroi();
		
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(400, leiloeiro.getTresMaiores().get(0).getValor(), 0.5);
		Assert.assertEquals(300, leiloeiro.getTresMaiores().get(1).getValor(), 0.5);
	}
	
	@Test
	public void semLanceTeste() {
		Leilao leilao = new Leilao("teste");
	
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(0, leiloeiro.getTresMaiores().size(), 0.5);
	}
	
    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
    	Leilao leilao = new LeilaoBuilder("teste").lance(new Usuario("Zeh"), 300).lance(new Usuario("Zeh"), 300).constroi();
    	
		leiloeiro.avalia(leilao);
		
		Assert.assertEquals(1, leiloeiro.getTresMaiores().size(), 0.5);
    }
    
    @Test
    public void naoDeveAceitarCincoLancesDoMesmoUsuario() {
    	Usuario dodoria = new Usuario("Dodoria");
    	Usuario bozias = new Usuario("Bozias");
    	
    	Leilao leilao = new LeilaoBuilder("teste").lance(bozias, 300).lance(dodoria, 500)
    			.lance(bozias, 600).lance(dodoria, 800).lance(bozias, 900).lance(dodoria, 1000)
    			.lance(bozias, 300).lance(dodoria, 400).lance(bozias, 500).lance(dodoria, 600)
    			.lance(bozias, 800).lance(dodoria, 900).constroi();
    	
    	leiloeiro.avalia(leilao);
    	
    	int indiceDoUltimoLance = leilao.getLances().size() - 1;
    	
    	assertThat(leilao.getLances().size(), equalTo(10));
    	Assert.assertEquals(600, leilao.getLances().get(indiceDoUltimoLance).getValor(), 0.0001);
    }
    
    @Test
    public void deveDobrarLanceTest() {
    	Usuario josafar = new Usuario("Josafar");
    	Usuario bolias = new Usuario("Bolias");
    	
    	Leilao leilao = new LeilaoBuilder("Leilão sem noção").lance(josafar, 100).lance(bolias, 200)
    			.dobraLance(josafar).constroi();
    	
    	leiloeiro.avalia(leilao);
    	
    	int ultimoLance = leilao.getLances().size() - 1;
    	
    	Assert.assertEquals(leilao.getLances().get(ultimoLance).getValor(), 200, 0.0001);
    }
    
    @Test
    public void deveChecarSeLeilaoTemUmLanceTest() {
    	Usuario josafar = new Usuario("Josafar");
    	Usuario bolias = new Usuario("Bolias");
    	
    	Leilao leilao = new LeilaoBuilder("Leilão sem noção").lance(josafar, 100).lance(bolias, 200)
    			.dobraLance(josafar).constroi();
    	
    	leiloeiro.avalia(leilao);
    	
    	assertThat(leilao, LeilaoMatcher.temUmLance(new Lance(josafar, 100)));
    	assertThat(leilao, LeilaoMatcher.temUmLance(new Lance(bolias, 200)));
    }
    
    @Test(expected = RuntimeException.class)
    public void deveLancarExcecaoAoAvaliarLeilaoSemLanceTest() {
    	Leilao leilao = new LeilaoBuilder("Leilão sem noção").constroi();
    	
    	leiloeiro.avalia(leilao);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoAoLancarValorInvalidoTest() {
    	Leilao leilao = new LeilaoBuilder("Leilão sem noção").lance(new Usuario("Bonan"), 0).constroi();
    	
    	leiloeiro.avalia(leilao);
    }

}
