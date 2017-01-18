package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActLaboratorioTiDTO implements Serializable {

	private static final long serialVersionUID = 5881719523016182562L;
	
	private Integer idAlt;
	private String numeroLaboratorio;
	private Integer computadoras;
	private Integer proyectores;
	private Integer pizarraInteractiva;
	private Integer sistemaAudio;
	private Integer impresoras;
	private String implLaboratorios;
	private Integer idAfr;
	
	private Integer tieneInternet;
	private Integer enUso;
	private String proveedorInternet;
	private Float velocidadNavegacion;
	
	public Integer getComputadoras() {
		return computadoras;
	}
	public void setComputadoras(Integer computadoras) {
		this.computadoras = computadoras;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdAlt() {
		return idAlt;
	}
	public void setIdAlt(Integer idAlt) {
		this.idAlt = idAlt;
	}
	public String getImplLaboratorios() {
		return implLaboratorios;
	}
	public void setImplLaboratorios(String implLaboratorios) {
		this.implLaboratorios = implLaboratorios;
	}
	public Integer getImpresoras() {
		return impresoras;
	}
	public void setImpresoras(Integer impresoras) {
		this.impresoras = impresoras;
	}
	public String getNumeroLaboratorio() {
		return numeroLaboratorio;
	}
	public void setNumeroLaboratorio(String numeroLaboratorio) {
		this.numeroLaboratorio = numeroLaboratorio;
	}
	public Integer getPizarraInteractiva() {
		return pizarraInteractiva;
	}
	public void setPizarraInteractiva(Integer pizarraInteractiva) {
		this.pizarraInteractiva = pizarraInteractiva;
	}
	public Integer getProyectores() {
		return proyectores;
	}
	public void setProyectores(Integer proyectores) {
		this.proyectores = proyectores;
	}
	public Integer getSistemaAudio() {
		return sistemaAudio;
	}
	public void setSistemaAudio(Integer sistemaAudio) {
		this.sistemaAudio = sistemaAudio;
	}
	public Integer getTieneInternet() {
		return tieneInternet;
	}
	public void setTieneInternet(Integer tieneInternet) {
		this.tieneInternet = tieneInternet;
	}
	public Integer getEnUso() {
		return enUso;
	}
	public void setEnUso(Integer enUso) {
		this.enUso = enUso;
	}
	public String getProveedorInternet() {
		return proveedorInternet;
	}
	public void setProveedorInternet(String proveedorInternet) {
		this.proveedorInternet = proveedorInternet;
	}
	public Float getVelocidadNavegacion() {
		return velocidadNavegacion;
	}
	public void setVelocidadNavegacion(Float velocidadNavegacion) {
		this.velocidadNavegacion = velocidadNavegacion;
	}

}
