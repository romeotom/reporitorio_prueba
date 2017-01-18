package ec.gob.educacion.activos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.gob.educacion.activos.model.ActResponsable;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;

@Named
@SessionScoped
public class SessionResponsableController extends BaseController implements Serializable {

	private static final long serialVersionUID = 2518219911735764074L;
	
	private String username = "";
	private ActResponsable responsable;
	private InsInstitucion institucion;

	@PostConstruct
	public void init() {
		username = "";
		responsable = new ActResponsable();
		institucion = new InsInstitucion();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ActResponsable getResponsable() {
		return responsable;
	}

	public void setResponsable(ActResponsable responsable) {
		this.responsable = responsable;
	}

	public InsInstitucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InsInstitucion institucion) {
		this.institucion = institucion;
	}

}
