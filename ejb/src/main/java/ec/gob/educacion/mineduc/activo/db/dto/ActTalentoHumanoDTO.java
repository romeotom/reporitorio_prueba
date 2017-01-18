package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActTalentoHumanoDTO implements Serializable {

	private static final long serialVersionUID = -4620548674871303342L;
	
	private Integer idAth;
	private Integer codigoCargo;
	private String nombreCargo;
	private String nombre;
	private String apellido;
	private String email;
	private String contactoUno;
	private String contactoDos;
	private Integer idAfr;
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(Integer codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public String getContactoDos() {
		return contactoDos;
	}
	public void setContactoDos(String contactoDos) {
		this.contactoDos = contactoDos;
	}
	public String getContactoUno() {
		return contactoUno;
	}
	public void setContactoUno(String contactoUno) {
		this.contactoUno = contactoUno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdAth() {
		return idAth;
	}
	public void setIdAth(Integer idAth) {
		this.idAth = idAth;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

}
