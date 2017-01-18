package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.facelets.FaceletException;
import javax.inject.Named;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import ec.gob.educacion.acceso.security.EducacionUserSecurity;
import ec.gob.educacion.activos.resources.ServiceLocator;
import ec.gob.educacion.activos.resources.Utils;
import ec.gob.educacion.seguridades.exception.RolAplicacionException;
import ec.gob.educacion.seguridades.model.Aplicacion;
import ec.gob.educacion.seguridades.model.Recurso;
import ec.gob.educacion.seguridades.model.RolAplicacion;
import ec.gob.educacion.seguridades.model.Usuario;
import ec.gob.educacion.seguridades.service.remote.AplicacionServiceRemote;
import ec.gob.educacion.seguridades.service.remote.RecursoServiceRemote;
import ec.gob.educacion.seguridades.service.remote.RolAplicacionServiceRemote;
import ec.gob.educacion.seguridades.service.remote.UsuarioServiceRemote;

@Named
@SessionScoped
public class SessionController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 3463016173694116536L;

	private EducacionUserSecurity userSecurity;
	
	private String roles;
	
	private List<Recurso> menu;
	
	private String nombreReporte;
	
	private String nombreCarpeta;
	
	@PostConstruct
    private void init() {
		nombreReporte="";
		nombreCarpeta="";
		roles = "";
        SecurityContext context = SecurityContextHolder.getContext();
        if(context.getAuthentication() != null) {
	        userSecurity = (EducacionUserSecurity) context.getAuthentication().getPrincipal();
	        if(userSecurity.getAuthorities() == null || userSecurity.getAuthorities().isEmpty()) {
	        	roles = "Invitado";
	        } else {
		        for (GrantedAuthority authority : userSecurity.getAuthorities()) {
					roles += authority.getAuthority() + ", ";
				}
		        roles = roles.substring(0, roles.length() - 2);
	        }
	        obtenerMenu();
        }
    }
	
	private void obtenerMenu() {
		try {
			AplicacionServiceRemote servicioAplicacion = ServiceLocator.buscarInstancia(ec.gob.educacion.activos.resources.Constantes.URL_SEGURIDADES, AplicacionServiceRemote.class, true);
			UsuarioServiceRemote servicioUsuario = ServiceLocator.buscarInstancia(ec.gob.educacion.activos.resources.Constantes.URL_SEGURIDADES, UsuarioServiceRemote.class, true); 
			RolAplicacionServiceRemote servicioRol = ServiceLocator.buscarInstancia(ec.gob.educacion.activos.resources.Constantes.URL_SEGURIDADES, RolAplicacionServiceRemote.class, true);
			RecursoServiceRemote servicioRecurso = ServiceLocator.buscarInstancia(ec.gob.educacion.activos.resources.Constantes.URL_SEGURIDADES, RecursoServiceRemote.class, true);
			Aplicacion aplicacion =  servicioAplicacion.obtenerPorPrefijo(Utils.obtenerPropiedad("app.code"));
			Usuario usuario = servicioUsuario.buscarPorIdentificacion(userSecurity.getUsername());
			List<RolAplicacion> roles = servicioRol.obtenerPorAplicacion(aplicacion, usuario);
			menu = servicioRecurso.generarMenu(aplicacion, roles);
		} catch (RolAplicacionException e) {
			throw new FaceletException(e);
		}
	}

	public EducacionUserSecurity getUserSecurity() {
		return userSecurity;
	}

	public void setUserSecurity(EducacionUserSecurity userSecurity) {
		this.userSecurity = userSecurity;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Recurso> getMenu() {
		return menu;
	}

	public void setMenu(List<Recurso> menu) {
		this.menu = menu;
	}

	public String getNombreReporte() {
		return nombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	public String getNombreCarpeta() {
		return nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}
	
}
