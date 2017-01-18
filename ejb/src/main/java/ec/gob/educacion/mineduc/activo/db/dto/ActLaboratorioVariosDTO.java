package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActLaboratorioVariosDTO implements Serializable {

	private static final long serialVersionUID = -8011599443579493708L;
	
	private Integer idAlv;
	private Integer codigoLaboratorio;
	private String nombreLaboratorio;
	private Integer computadoras;
	private Integer proyectores;
	private Integer pizarraInteractiva;
	private Integer sistemaAudio;
	private Integer impresoras;
	private Integer idAfr;
	
	private Integer tieneInternet;
	private Integer enUso;
	private String proveedorInternet;
	private Float velocidadNavegacion;
	
	public Integer getCodigoLaboratorio() {
		return codigoLaboratorio;
	}
	public void setCodigoLaboratorio(Integer codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}
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
	public Integer getIdAlv() {
		return idAlv;
	}
	public void setIdAlv(Integer idAlv) {
		this.idAlv = idAlv;
	}
	public Integer getImpresoras() {
		return impresoras;
	}
	public void setImpresoras(Integer impresoras) {
		this.impresoras = impresoras;
	}
	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}
	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
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
