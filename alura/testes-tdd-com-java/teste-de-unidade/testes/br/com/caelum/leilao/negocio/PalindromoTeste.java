package br.com.caelum.leilao.negocio;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTeste {
	
	@Test
    public void ehPalindromoTeste() {
        String frasePalindromo = "Socorram-me subi no onibus em Marrocos";
        
        boolean ehPalindromo = new Palindromo().ehPalindromo(frasePalindromo);
        
        Assert.assertEquals(true, ehPalindromo);
    }
	
	@Test
	public void naoEhPalindromoTeste() {
		String frasePalindromo = "Socorram-me nao subi em onibus em Marrocos";
		
		boolean ehPalindromo = new Palindromo().ehPalindromo(frasePalindromo);
		
		Assert.assertEquals(false, ehPalindromo);
	}
}
