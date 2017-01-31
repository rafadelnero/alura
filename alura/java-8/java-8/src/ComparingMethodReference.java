import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparingMethodReference {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("alura online");
		list.add("casa do código");
		list.add("caelum");
		
		
		list.sort(Comparator.comparing(s -> s.length()));
		
		// Method Reference
		list.sort(Comparator.comparing(String::length));
		System.out.println(list);
		
		list.sort(Comparator.comparing(String::toString));
		
		System.out.println(list);
		
		list.forEach(System.out::println);
	}
}
