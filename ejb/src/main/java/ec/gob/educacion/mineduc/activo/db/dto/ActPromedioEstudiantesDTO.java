package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActPromedioEstudiantesDTO implements Serializable {

	private static final long serialVersionUID = -5646659703311282498L;
	
	private Integer idApe;
	private Integer codigoJornada;
	private Integer inicial;
	private Integer primero;
	private Integer segundo;
	private Integer tercero;
	private Integer cuarto;
	private Integer quinto;
	private Integer sexto;
	private Integer septimo;
	private Integer octavo;
	private Integer noveno;
	private Integer decimo;
	private Integer primeroBch;
	private Integer segundoBch;
	private Integer terceroBch;
	private Integer idAfr;
	//	transient
	private String nombreJornada;
	
	public Integer getIdApe() {
		return idApe;
	}
	public void setIdApe(Integer idApe) {
		this.idApe = idApe;
	}
	public Integer getCodigoJornada() {
		return codigoJornada;
	}
	public void setCodigoJornada(Integer codigoJornada) {
		this.codigoJornada = codigoJornada;
	}
	public Integer getInicial() {
		return inicial;
	}
	public void setInicial(Integer inicial) {
		this.inicial = inicial;
	}
	public Integer getPrimero() {
		return primero;
	}
	public void setPrimero(Integer primero) {
		this.primero = primero;
	}
	public Integer getSegundo() {
		return segundo;
	}
	public void setSegundo(Integer segundo) {
		this.segundo = segundo;
	}
	public Integer getTercero() {
		return tercero;
	}
	public void setTercero(Integer tercero) {
		this.tercero = tercero;
	}
	public Integer getCuarto() {
		return cuarto;
	}
	public void setCuarto(Integer cuarto) {
		this.cuarto = cuarto;
	}
	public Integer getQuinto() {
		return quinto;
	}
	public void setQuinto(Integer quinto) {
		this.quinto = quinto;
	}
	public Integer getSexto() {
		return sexto;
	}
	public void setSexto(Integer sexto) {
		this.sexto = sexto;
	}
	public Integer getSeptimo() {
		return septimo;
	}
	public void setSeptimo(Integer septimo) {
		this.septimo = septimo;
	}
	public Integer getOctavo() {
		return octavo;
	}
	public void setOctavo(Integer octavo) {
		this.octavo = octavo;
	}
	public Integer getNoveno() {
		return noveno;
	}
	public void setNoveno(Integer noveno) {
		this.noveno = noveno;
	}
	public Integer getDecimo() {
		return decimo;
	}
	public void setDecimo(Integer decimo) {
		this.decimo = decimo;
	}
	public Integer getPrimeroBch() {
		return primeroBch;
	}
	public void setPrimeroBch(Integer primeroBch) {
		this.primeroBch = primeroBch;
	}
	public Integer getSegundoBch() {
		return segundoBch;
	}
	public void setSegundoBch(Integer segundoBch) {
		this.segundoBch = segundoBch;
	}
	public Integer getTerceroBch() {
		return terceroBch;
	}
	public void setTerceroBch(Integer terceroBch) {
		this.terceroBch = terceroBch;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public String getNombreJornada() {
		return nombreJornada;
	}
	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

}
