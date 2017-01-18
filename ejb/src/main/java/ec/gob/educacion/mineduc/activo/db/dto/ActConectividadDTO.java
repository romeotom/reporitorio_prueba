package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActConectividadDTO implements Serializable {

	private static final long serialVersionUID = 2577859856950691261L;
	
	private Integer idAco;
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
	public Integer getIdAco() {
		return idAco;
	}
	public void setIdAco(Integer idAco) {
		this.idAco = idAco;
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
