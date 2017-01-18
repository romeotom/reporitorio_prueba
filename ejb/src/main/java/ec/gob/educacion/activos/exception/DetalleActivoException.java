package ec.gob.educacion.activos.exception;

public class DetalleActivoException extends Exception {
	private static final long serialVersionUID = -7280120866853321637L;

	public DetalleActivoException() {
		super();
	}

	public DetalleActivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DetalleActivoException(String message) {
		super(message);
	}

	public DetalleActivoException(Throwable cause) {
		super(cause);
	}
}
