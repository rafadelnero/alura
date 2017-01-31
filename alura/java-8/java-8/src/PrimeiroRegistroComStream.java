import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrimeiroRegistroComStream {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		Optional<Curso> curso = cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();
		
		System.out.println(curso.get().getNome());
	}
}
