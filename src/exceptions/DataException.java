package exceptions;

@SuppressWarnings("serial")
public class DataException extends RuntimeException {

	public DataException() {
	}

	public DataException(String message) {
		super(message);
	}
}