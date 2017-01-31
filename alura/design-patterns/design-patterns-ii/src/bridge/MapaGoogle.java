package bridge;

import java.net.MalformedURLException;
import java.net.URL;

public class MapaGoogle implements MapaGeografico {

	@Override
	public String devolveMapa() throws MalformedURLException {
		URL google = new URL("https://www.google.com/maps");
		return google.toString();
	}

}
