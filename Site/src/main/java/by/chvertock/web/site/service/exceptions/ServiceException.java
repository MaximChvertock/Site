package by.chvertock.web.site.service.exceptions;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -7879906225721392258L;

    public ServiceException() {
	super();
    }

    public ServiceException(String message) {
	super(message);
    }

    public ServiceException(Throwable cause) {
	super(cause);
    }

    public ServiceException(String message, Throwable cause) {
	super(message, cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
