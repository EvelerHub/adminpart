package evedev.csgoadminpart.exceptions;

/**
 * @author Alexander Eveler
 */
public class UnexpectedSituation extends Exception{

    private static final long serialVersionUID = 2058488153590446654L;

    public UnexpectedSituation() {
        super();
    }

    public UnexpectedSituation(String message) {
        super(message);
    }
}
