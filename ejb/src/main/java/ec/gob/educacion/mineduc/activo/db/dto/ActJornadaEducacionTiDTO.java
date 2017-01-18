package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActJornadaEducacionTiDTO implements Serializable {

	private static final long serialVersionUID = 1981797080898499666L;
	
	private Integer idAjt;
	private Integer codigoJornada;
	private Integer codigoTipoNivel;
	private Float lenguaLiteratura;
	private Float matematica;
	private Float cienciasNaturales;
	private Float lenguaExtranjera;
	private Float fisica;
	private Float quimica;
	private Float biologia;
	private Integer idAfr;
	//	transient
	private String nombreJornada;
	private String nombreTipoNivel;
	private boolean visualizarRegistro;
	
	public Float getBiologia() {
		return biologia;
	}
	public void setBiologia(Float biologia) {
		this.biologia = biologia;
	}
	public Float getCienciasNaturales() {
		return cienciasNaturales;
	}
	public void setCienciasNaturales(Float cienciasNaturales) {
		this.cienciasNaturales = cienciasNaturales;
	}
	public Integer getCodigoJornada() {
		return codigoJornada;
	}
	public void setCodigoJornada(Integer codigoJornada) {
		this.codigoJornada = codigoJornada;
	}
	public Integer getCodigoTipoNivel() {
		return codigoTipoNivel;
	}
	public void setCodigoTipoNivel(Integer codigoTipoNivel) {
		this.codigoTipoNivel = codigoTipoNivel;
	}
	public Float getFisica() {
		return fisica;
	}
	public void setFisica(Float fisica) {
		this.fisica = fisica;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdAjt() {
		return idAjt;
	}
	public void setIdAjt(Integer idAjt) {
		this.idAjt = idAjt;
	}
	public Float getLenguaExtranjera() {
		return lenguaExtranjera;
	}
	public void setLenguaExtranjera(Float lenguaExtranjera) {
		this.lenguaExtranjera = lenguaExtranjera;
	}
	public Float getLenguaLiteratura() {
		return lenguaLiteratura;
	}
	public void setLenguaLiteratura(Float lenguaLiteratura) {
		this.lenguaLiteratura = lenguaLiteratura;
	}
	public Float getMatematica() {
		return matematica;
	}
	public void setMatematica(Float matematica) {
		this.matematica = matematica;
	}
	public String getNombreJornada() {
		return nombreJornada;
	}
	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}
	public String getNombreTipoNivel() {
		return nombreTipoNivel;
	}
	public void setNombreTipoNivel(String nombreTipoNivel) {
		this.nombreTipoNivel = nombreTipoNivel;
	}
	public Float getQuimica() {
		return quimica;
	}
	public void setQuimica(Float quimica) {
		this.quimica = quimica;
	}
	public boolean isVisualizarRegistro() {
		return visualizarRegistro;
	}
	public void setVisualizarRegistro(boolean visualizarRegistro) {
		this.visualizarRegistro = visualizarRegistro;
	}

}
