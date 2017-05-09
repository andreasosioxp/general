package greeter;

import java.util.Calendar;

public class Employee {

	private String name, surname;
	private Calendar birthday;
	private String email;
	DateProvider dateProvider;
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Calendar getBirthday() {
		return birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Employee(String name, String surname, Calendar birthday, String email,
			DateProvider dateProvider) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.email = email;
		this.dateProvider = dateProvider;
	}
	public boolean hasBirthdayToday() {
		Calendar calendarToday = dateProvider.getDateToday();
		return calendarToday.get(Calendar.DAY_OF_MONTH)==birthday.get(Calendar.DAY_OF_MONTH) &&
				calendarToday.get(Calendar.MONTH)==birthday.get(Calendar.MONTH);
	}
}
