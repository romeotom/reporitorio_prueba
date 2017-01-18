package ec.gob.educacion.activos.exception;

public class ConectividadException extends Exception {
	
	private static final long serialVersionUID = 7390423866782335568L;

	public ConectividadException() {
		super();
	}

	public ConectividadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConectividadException(String message) {
		super(message);
	}

	public ConectividadException(Throwable cause) {
		super(cause);
	}
}
