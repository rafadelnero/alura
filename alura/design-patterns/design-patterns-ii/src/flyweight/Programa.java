package flyweight;

import java.util.Arrays;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		NotasMusicaisExemploReflection notasMusicais = new NotasMusicaisExemploReflection();

		List<Nota> musica = Arrays.asList(notasMusicais.pega("do"), notasMusicais.pega("re"), notasMusicais.pega("mi"),
				notasMusicais.pega("fa"), notasMusicais.pega("fa"), notasMusicais.pega("fa"), notasMusicais.pega("do"),
				notasMusicais.pega("re"), notasMusicais.pega("do"), notasMusicais.pega("re"), notasMusicais.pega("re"),
				notasMusicais.pega("re"), notasMusicais.pega("do"), notasMusicais.pega("sol"), notasMusicais.pega("fa"),
				notasMusicais.pega("mi"), notasMusicais.pega("mi"), notasMusicais.pega("mi"), notasMusicais.pega("do"),
				notasMusicais.pega("re"), notasMusicais.pega("mi"), notasMusicais.pega("fa"), notasMusicais.pega("fa"),
				notasMusicais.pega("fa"), notasMusicais.pega("do#"), notasMusicais.pega("re#"));

		new Piano().toca(musica);
	}
}
