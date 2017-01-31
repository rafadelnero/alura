package br.com.alura.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapaDeClasses {

	private Map<Class<?>, Class<?>> mapaComClasses = new HashMap<>();

	public MapaDeClasses() throws Exception {
		carregaMapaComClasses();
	}

	private void carregaMapaComClasses() throws Exception {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/classes.properties");
		props.load(file);

		for (Object chave : props.keySet()) {
			Class<?> algumaClasse = Class.forName(chave.toString());
			Class<?> algumaImplementacao = Class.forName(props.getProperty(chave.toString()));

			if (!algumaClasse.isAssignableFrom(algumaImplementacao)) {
				throw new RuntimeException("A classe: " + algumaImplementacao.getName() + " não implementa a classe: "
						+ algumaClasse.getName());
			}

			mapaComClasses.put(algumaClasse, algumaImplementacao);
		}
	}

	private Class<?> carregaClassePor(String algumaClasse) throws Exception {
		return Class.forName(algumaClasse);
	}

	public Class<?> getClass(String chaveDaClasse) throws Exception {
		Class<?> algumaClasse = carregaClassePor(chaveDaClasse);

		return mapaComClasses.get(algumaClasse);
	}

	public Object getObject(String chaveDoObjeto, Object... params) throws Exception {
		Class<?> algumaClasse = mapaComClasses.get(carregaClassePor(chaveDoObjeto));

		Class<?>[] tiposDosParametros = new Class<?>[params.length];

		for (int i = 0; i < tiposDosParametros.length; i++) {
			tiposDosParametros[i] = params[i].getClass();
		}

		Constructor<?> constructor = algumaClasse.getConstructor(tiposDosParametros);

		return constructor.newInstance(params);
	}
}
