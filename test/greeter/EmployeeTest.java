package greeter;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import dateprovision.DateProviderMock;

public class EmployeeTest {
	private static final String ANY_MAIL = "anymail";
	private static final String ANY_SURNAME = "Rossi";
	private static final String ANY_NAME = "Paolo";
	private static final int ANY_DAY = 1;
	private static final int ANY_MONTH = 0;
	private static final int ANY_YEAR = 1970;

	@Test
	public void employeeDataIsStored() {
		Employee employee = new Employee(ANY_NAME, ANY_SURNAME, new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY),
				ANY_MAIL, null);
		assertEquals(ANY_NAME, employee.getName());
		assertEquals(ANY_SURNAME, employee.getSurname());
		assertEquals(new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY), employee.getBirthday());
		assertEquals(ANY_MAIL, employee.getEmail());
	}

	@Test
	public void hasBirthdayTodayIfBornExactlyToday() {
		Employee employee = new Employee(null, null, new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY), null,
				new DateProviderMock(new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY)));
		assertTrue(employee.hasBirthdayToday());
	}

	@Test
	public void hasBirthdayTodayIfHasBirthdayToday() {
		Employee employee = new Employee(null, null, new GregorianCalendar(ANY_YEAR - 1, ANY_MONTH, ANY_DAY), null,
				new DateProviderMock(new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY)));
		assertTrue(employee.hasBirthdayToday());
	}

	@Test
	public void hasBirthdayTodayIfDoesntHaveBirthdayToday() {
		Employee employee = new Employee(null, null, new GregorianCalendar(ANY_YEAR - 1, ANY_MONTH, ANY_DAY + 1), null,
				new DateProviderMock(new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY)));
		assertFalse(employee.hasBirthdayToday());
		employee = new Employee(null, null, new GregorianCalendar(ANY_YEAR - 1, ANY_MONTH + 1, ANY_DAY), null,
				new DateProviderMock(new GregorianCalendar(ANY_YEAR, ANY_MONTH, ANY_DAY)));
		assertFalse(employee.hasBirthdayToday());
	}
}
