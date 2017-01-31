import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
	public static void main(String[] args) {
		LocalDate futureDate = LocalDate.of(2099, 1, 25);
		
		Period period = LocalDate.now().until(futureDate);
		
		System.out.println(futureDate);
		System.out.println(LocalDate.now());
		
		System.out.println(futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
	}
}
