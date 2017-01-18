package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActJornadaEducacionDTO implements Serializable {

	private static final long serialVersionUID = -3167747509839449873L;
	
	private Integer idAje;
	private Integer codigoJornada;
	private Float inicial;
	private Float basica;
	private Float bachillerato;
	private Float total;
	private Integer idAfr;
	//	transient
	private String nombreJornada;
	
	public Float getBachillerato() {
		return bachillerato;
	}
	public void setBachillerato(Float bachillerato) {
		this.bachillerato = bachillerato;
	}
	public Float getBasica() {
		return basica;
	}
	public void setBasica(Float basica) {
		this.basica = basica;
	}
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
	public Integer getIdAje() {
		return idAje;
	}
	public void setIdAje(Integer idAje) {
		this.idAje = idAje;
	}
	public Float getInicial() {
		return inicial;
	}
	public void setInicial(Float inicial) {
		this.inicial = inicial;
	}
	public String getNombreJornada() {
		return nombreJornada;
	}
	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}

}
