package br.com.caelum.leilao.componentes;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class LeilaoMatcher extends TypeSafeMatcher<Leilao> {
	private Lance lance;
	
	public LeilaoMatcher(Lance lance) {
		this.lance = lance;
	}

	@Factory
	public static Matcher<Leilao> temUmLance(Lance lance) {
	    return new LeilaoMatcher(lance);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("O leilão não tem o lance:").appendValue(lance);
	}

	@Override
	protected boolean matchesSafely(Leilao leilao) {
		return leilao.getLances().contains(lance);
	}
}
