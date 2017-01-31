package flyweight;

import java.util.HashMap;
import java.util.Map;

public class NotasMusicais {
	static Map<String, Nota> notas = new HashMap<>();
	
	static {
		notas.put("do", notas.get("do") == null ? new Do() : notas.get("do"));
		notas.put("re", notas.get("re") == null ? new Do() : notas.get("re"));
		notas.put("mi", notas.get("mi") == null ? new Do() : notas.get("mi"));
		notas.put("fa", notas.get("fa") == null ? new Do() : notas.get("fa"));
		notas.put("sol", notas.get("sol") == null ? new Do() : notas.get("sol"));
		notas.put("la", notas.get("la") == null ? new Do() : notas.get("la"));
		notas.put("si", notas.get("si") == null ? new Do() : notas.get("si"));
	}
	
	public Nota pega(String nome) {
		return notas.get(nome);
	}
}
