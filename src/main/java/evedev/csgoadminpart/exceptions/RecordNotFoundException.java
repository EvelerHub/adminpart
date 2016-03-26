package evedev.csgoadminpart.exceptions;

/**
 * Exception for data base. <br/>
 * Throw it when record not found in database.
 *
 * @author Alexander Eveler
 */
public class RecordNotFoundException extends Exception {

    private static final String MESSAGE = "Record not found";
    private static final long serialVersionUID = -7824753122148131L;

    public RecordNotFoundException() {
        super(MESSAGE);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }


}
