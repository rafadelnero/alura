package bridge;

import java.net.MalformedURLException;

public class Programa {
	public static void main(String[] args) throws MalformedURLException {
		MapaGeografico mapaGeografico = MapaFactory.retornaMapaPor("google");
		System.out.println(mapaGeografico.devolveMapa());
	}
}
