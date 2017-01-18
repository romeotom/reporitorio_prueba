package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActAccesibilidadServiciosDTO implements Serializable {

	private static final long serialVersionUID = 2522341022788900621L;
	
	private Integer idAas;
	private Integer codigoItem;
	private Integer disponibilidad;
	private Integer idAfr;
	//	transient
	private String nombreItem;
	
	public Integer getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Integer getIdAas() {
		return idAas;
	}
	public void setIdAas(Integer idAas) {
		this.idAas = idAas;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

}
