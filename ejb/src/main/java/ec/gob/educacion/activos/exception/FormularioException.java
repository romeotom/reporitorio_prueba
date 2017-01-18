package ec.gob.educacion.activos.exception;

public class FormularioException extends Exception {
	
	private static final long serialVersionUID = 7390423866782335568L;

	public FormularioException() {
		super();
	}

	public FormularioException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormularioException(String message) {
		super(message);
	}

	public FormularioException(Throwable cause) {
		super(cause);
	}
}
