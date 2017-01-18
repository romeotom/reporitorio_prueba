package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActDetalleLaboratorioTiDTO extends ActDetalleDTO implements Serializable{
	
	private static final long serialVersionUID = -8514093031493528696L;
	
	private Integer codigoAltDet;
	private Integer codigoAlt;
	private Integer codigoAlv;
	private Integer codigoAst;
	private Integer codigoAfr;
	
	
	public Integer getCodigoAltDet() {
		return codigoAltDet;
	}
	public void setCodigoAltDet(Integer codigoAltDet) {
		this.codigoAltDet = codigoAltDet;
	}
	public Integer getCodigoAlt() {
		return codigoAlt;
	}
	public void setCodigoAlt(Integer codigoAlt) {
		this.codigoAlt = codigoAlt;
	}
	public Integer getCodigoAst() {
		return codigoAst;
	}
	public void setCodigoAst(Integer codigoAst) {
		this.codigoAst = codigoAst;
	}
	public Integer getCodigoAlv() {
		return codigoAlv;
	}
	public void setCodigoAlv(Integer codigoAlv) {
		this.codigoAlv = codigoAlv;
	}
	public Integer getCodigoAfr() {
		return codigoAfr;
	}
	public void setCodigoAfr(Integer codigoAfr) {
		this.codigoAfr = codigoAfr;
	}
}
