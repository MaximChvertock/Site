package by.chvertock.web.site.service.user.exceptions;

import by.chvertock.web.site.dao.exceptions.DaoException;

public class UserDuplicateException extends DaoException {

    private static final long serialVersionUID = -1195418063181783096L;

    public UserDuplicateException() {
	super();
    }

    public UserDuplicateException(String message) {
	super(message);
    }

    public UserDuplicateException(String message, Throwable cause) {
	super(message, cause);
    }

    public UserDuplicateException(Throwable cause) {
	super(cause);
    }

    public UserDuplicateException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
