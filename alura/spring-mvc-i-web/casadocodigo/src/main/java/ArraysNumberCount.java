import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysNumberCount {
	public static void main(String[] args) {
		List<Integer> data1 = new ArrayList<>(Arrays.asList(1, 4, 7));
		
		List<Integer> data2 = new ArrayList<>(Arrays.asList(123, -2, 477, 3, 14, 6551));

		ArraysNumberCount obj = new ArraysNumberCount();

		int result = obj.fold(data1);
		System.out.println(result);

		int yourAnswer = obj.fold(data2); // what is the answer for this one???
		System.out.println(yourAnswer);
	}

	private int fold(List<Integer> input) {
		if (input.size() > 1) {
			
			for (int i = 0; i < input.size() - 1; i++) {
				input.set(i + 1, input.get(0) + input.get(i + 1));
			}
			
			input.remove(0);
			fold(input);
		}

		return input.get(0);
	}

}
