package bridge;

import java.net.MalformedURLException;
import java.net.URL;

public class MapaLink implements MapaGeografico {

	@Override
	public String devolveMapa() throws MalformedURLException {
		URL google = new URL("http://maplink.com.br/");
		return google.toString();
	}

}
