package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActNumeroDocentesDTO implements Serializable {

	private static final long serialVersionUID = -6240001702304765390L;
	
	private Integer idAnd;
	private Integer codigoJornada;
	private Integer numeroHombres;
	private Integer numeroMujeres;
	private Integer total;
	private Integer idAfr;
	//	transient
	private String nombreJornada;

	public Integer getCodigoJornada() {
		return codigoJornada;
	}
	public void setCodigoJornada(Integer codigoJornada) {
		this.codigoJornada = codigoJornada;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdAnd() {
		return idAnd;
	}
	public void setIdAnd(Integer idAnd) {
		this.idAnd = idAnd;
	}
	public Integer getNumeroHombres() {
		return numeroHombres;
	}
	public void setNumeroHombres(Integer numeroHombres) {
		this.numeroHombres = numeroHombres;
	}
	public Integer getNumeroMujeres() {
		return numeroMujeres;
	}
	public void setNumeroMujeres(Integer numeroMujeres) {
		this.numeroMujeres = numeroMujeres;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getNombreJornada() {
		return nombreJornada;
	}
	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

}
