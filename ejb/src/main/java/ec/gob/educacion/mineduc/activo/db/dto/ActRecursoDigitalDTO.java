package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActRecursoDigitalDTO implements Serializable {

	private static final long serialVersionUID = -5104951176250119673L;
	
	private Integer idArd;
	private Integer codigoTipoRecurso;
	private Integer lenguaLiteratura;
	private Integer matematica;
	private Integer cienciasNaturales;
	private Integer lenguaExtranjera;
	private Integer fisica;
	private Integer quimica;
	private Integer biologia;
	private Integer idAfr;
	//	transient
	private String nombreTipoRecurso;
	
	public Integer getBiologia() {
		return biologia;
	}
	public void setBiologia(Integer biologia) {
		this.biologia = biologia;
	}
	public Integer getCienciasNaturales() {
		return cienciasNaturales;
	}
	public void setCienciasNaturales(Integer cienciasNaturales) {
		this.cienciasNaturales = cienciasNaturales;
	}
	public Integer getCodigoTipoRecurso() {
		return codigoTipoRecurso;
	}
	public void setCodigoTipoRecurso(Integer codigoTipoRecurso) {
		this.codigoTipoRecurso = codigoTipoRecurso;
	}
	public Integer getFisica() {
		return fisica;
	}
	public void setFisica(Integer fisica) {
		this.fisica = fisica;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdArd() {
		return idArd;
	}
	public void setIdArd(Integer idArd) {
		this.idArd = idArd;
	}
	public Integer getLenguaExtranjera() {
		return lenguaExtranjera;
	}
	public void setLenguaExtranjera(Integer lenguaExtranjera) {
		this.lenguaExtranjera = lenguaExtranjera;
	}
	public Integer getLenguaLiteratura() {
		return lenguaLiteratura;
	}
	public void setLenguaLiteratura(Integer lenguaLiteratura) {
		this.lenguaLiteratura = lenguaLiteratura;
	}
	public Integer getMatematica() {
		return matematica;
	}
	public void setMatematica(Integer matematica) {
		this.matematica = matematica;
	}
	public String getNombreTipoRecurso() {
		return nombreTipoRecurso;
	}
	public void setNombreTipoRecurso(String nombreTipoRecurso) {
		this.nombreTipoRecurso = nombreTipoRecurso;
	}
	public Integer getQuimica() {
		return quimica;
	}
	public void setQuimica(Integer quimica) {
		this.quimica = quimica;
	}

}
