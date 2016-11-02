package by.chvertock.web.site.service.email.exceptions;

import by.chvertock.web.site.service.exceptions.ServiceException;

public class MailException extends ServiceException {

    private static final long serialVersionUID = 9141708686166827497L;

    public MailException() {
	super();
    }

    public MailException(String message) {
	super(message);
    }

    public MailException(Throwable cause) {
	super(cause);
    }

    public MailException(String message, Throwable cause) {
	super(message, cause);
    }

    public MailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
