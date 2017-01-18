package ec.gob.educacion.activos.exception;

import javax.ejb.ApplicationException;


/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@ApplicationException(rollback = false)
public class EducacionNonUniqueResultException extends Exception {

	private static final long serialVersionUID = 971044079612567355L;

	public EducacionNonUniqueResultException() {
		super();
	}

	public EducacionNonUniqueResultException(String message, Throwable cause) {
		super(message, cause);
	}

	public EducacionNonUniqueResultException(String message) {
		super(message);
	}

	public EducacionNonUniqueResultException(Throwable cause) {
		super(cause);
	}
}
