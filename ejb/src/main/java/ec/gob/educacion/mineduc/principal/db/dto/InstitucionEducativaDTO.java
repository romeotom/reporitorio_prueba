package ec.gob.educacion.mineduc.principal.db.dto;

import java.io.Serializable;

public class InstitucionEducativaDTO implements Serializable {

	private static final long serialVersionUID = -4155899965334944077L;

	private Integer idIe;
	private String amie;
	private String descripcion;
	private Integer codTipoInstitucion;
	private Integer codZona;
	private Integer codDistrito;
	private Integer codCircuito;
	private Integer codRegimen;
	private Integer estado;
	
	public String getAmie() {
		return amie;
	}
	public void setAmie(String amie) {
		this.amie = amie;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCodCircuito() {
		return codCircuito;
	}
	public void setCodCircuito(Integer codCircuito) {
		this.codCircuito = codCircuito;
	}
	public Integer getCodDistrito() {
		return codDistrito;
	}
	public void setCodDistrito(Integer codDistrito) {
		this.codDistrito = codDistrito;
	}
	public Integer getCodRegimen() {
		return codRegimen;
	}
	public void setCodRegimen(Integer codRegimen) {
		this.codRegimen = codRegimen;
	}
	public Integer getCodTipoInstitucion() {
		return codTipoInstitucion;
	}
	public void setCodTipoInstitucion(Integer codTipoInstitucion) {
		this.codTipoInstitucion = codTipoInstitucion;
	}
	public Integer getCodZona() {
		return codZona;
	}
	public void setCodZona(Integer codZona) {
		this.codZona = codZona;
	}
	public Integer getIdIe() {
		return idIe;
	}
	public void setIdIe(Integer idIe) {
		this.idIe = idIe;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
