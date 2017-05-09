package dateprovision;

import java.util.Calendar;

import greeter.DateProvider;

public class DateProviderMock implements DateProvider {
	Calendar customDate;

	public DateProviderMock(Calendar customDate) {
		this.customDate = customDate;
	}

	@Override
	public Calendar getDateToday() {
		return customDate;
	}
}
