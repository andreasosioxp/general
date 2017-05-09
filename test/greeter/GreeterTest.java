package greeter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import dateprovision.DateProviderMock;
import filemanager.EmployeeListProviderMock;
import mailmanager.MailSenderMock;

public class GreeterTest {
	@Test
	public void noMailIsSentIfListIsEmpty() {
		Greeter greeter = new Greeter(null, new MailSenderMock(), new EmployeeListProviderMock(new ArrayList<Employee>()));
		greeter.greet();
		assertFalse(new MailSenderMock().mailSent());
	}

	@Test
	public void singleMailSentIfListContainsOneEmployeeWhoHasBirthday() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Calendar date = new GregorianCalendar(1970,0,1);
		employeeList.add(new Employee("a", "a", date, "a", new DateProviderMock(date)));
		Greeter greeter = new Greeter(null, new MailSenderMock(), new EmployeeListProviderMock(employeeList));
		greeter.greet();
		assertTrue(new MailSenderMock().mailSent());
	}
}
