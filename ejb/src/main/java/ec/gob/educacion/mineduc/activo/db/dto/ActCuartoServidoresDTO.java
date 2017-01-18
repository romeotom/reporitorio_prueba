package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActCuartoServidoresDTO implements Serializable {

	private static final long serialVersionUID = 4690041196182222204L;
	
	private Integer idAcs;
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
	public Integer getIdAcs() {
		return idAcs;
	}
	public void setIdAcs(Integer idAcs) {
		this.idAcs = idAcs;
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
