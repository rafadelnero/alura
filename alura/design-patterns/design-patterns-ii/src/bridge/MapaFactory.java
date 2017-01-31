package bridge;

public class MapaFactory {
	
	public static MapaGeografico retornaMapaPor(String nomeDoMapa) {
		if ("google".equals(nomeDoMapa)) {
			return new MapaGoogle();
		} else if ("mapLink".equals(nomeDoMapa)) {
			return new MapaLink();
		} else {
			throw new IllegalArgumentException("nome do mapa não localizado.");
		}
	}
}
