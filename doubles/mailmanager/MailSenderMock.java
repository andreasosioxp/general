package mailmanager;

import greeter.MailSender;

public class MailSenderMock implements MailSender {

	public boolean mailSent() {
		return false;
	}
}
