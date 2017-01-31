import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListForEach {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("alura online");
		list.add("casa do código");
		list.add("caelum");
		
		list.forEach(consumer -> System.out.println(consumer.toString()));
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		list.sort((s1, s2) -> {
			System.out.println("Teste");
			return s1.compareTo(s2);
			}
		);
		
		list.sort((String s1, String s2) -> {return s1.compareTo(s2);});
		list.sort((String s1, String s2) -> s1.compareTo(s2));
		list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		System.out.println(list);
	}
}
