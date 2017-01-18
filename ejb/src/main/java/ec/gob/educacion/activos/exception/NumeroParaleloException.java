package ec.gob.educacion.activos.exception;

public class NumeroParaleloException extends Exception {
	
	private static final long serialVersionUID = 7390423866782335568L;

	public NumeroParaleloException() {
		super();
	}

	public NumeroParaleloException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumeroParaleloException(String message) {
		super(message);
	}

	public NumeroParaleloException(Throwable cause) {
		super(cause);
	}
}
