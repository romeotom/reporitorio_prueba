package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;

public class ActDetalleDTO implements Serializable {

	private static final long serialVersionUID = -1698032364000835199L;
	
	private String serial;
	private Integer codigoItem;
	private Integer codigoMarca;
	private Integer estado;
	private Float velocidadProcesador;
	private Float memoriaRam;
	private String modelo;
	private Float capacidadDisco;
	private Integer tieneDobleBooteo;
	private Integer codigoSOPrincipal;
	private Integer esBiblioteca;
	private Integer codigoSOSecundario;
	private Integer codigoProcedenciaActivo;
	private String otraMarca;
	private Integer codigoEstadoActivo;
	
	//Campos de conversion
	private String nombreMarca;
	private String nombreEstado;
	private String nombreSistemaOperativo;
	private String nombreTieneDobleBooteo;
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Integer getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}
	public Integer getCodigoMarca() {
		return codigoMarca;
	}
	public void setCodigoMarca(Integer codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Float getVelocidadProcesador() {
		return velocidadProcesador;
	}
	public void setVelocidadProcesador(Float velocidadProcesador) {
		this.velocidadProcesador = velocidadProcesador;
	}
	public Float getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(Float memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Float getCapacidadDisco() {
		return capacidadDisco;
	}
	public void setCapacidadDisco(Float capacidadDisco) {
		this.capacidadDisco = capacidadDisco;
	}
	public Integer getTieneDobleBooteo() {
		return tieneDobleBooteo;
	}
	public void setTieneDobleBooteo(Integer tieneDobleBooteo) {
		this.tieneDobleBooteo = tieneDobleBooteo;
	}
	public Integer getCodigoSOPrincipal() {
		return codigoSOPrincipal;
	}
	public void setCodigoSOPrincipal(Integer codigoSOPrincipal) {
		this.codigoSOPrincipal = codigoSOPrincipal;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	
	public String getNombreSistemaOperativo() {
		return nombreSistemaOperativo;
	}
	public String getNombreTieneDobleBooteo() {
		nombreTieneDobleBooteo = (this.tieneDobleBooteo!=null&&this.tieneDobleBooteo.intValue()==1)?"Si":"No";
		return nombreTieneDobleBooteo;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public void setNombreSistemaOperativo(String nombreSistemaOperativo) {
		this.nombreSistemaOperativo = nombreSistemaOperativo;
	}
	public Integer getEsBiblioteca() {
		return esBiblioteca;
	}
	public void setEsBiblioteca(Integer esBiblioteca) {
		this.esBiblioteca = esBiblioteca;
	}
	public Integer getCodigoSOSecundario() {
		return codigoSOSecundario;
	}
	public void setCodigoSOSecundario(Integer codigoSOSecundario) {
		this.codigoSOSecundario = codigoSOSecundario;
	}
	public Integer getCodigoProcedenciaActivo() {
		return codigoProcedenciaActivo;
	}
	public void setCodigoProcedenciaActivo(Integer codigoProcedenciaActivo) {
		this.codigoProcedenciaActivo = codigoProcedenciaActivo;
	}
	public String getOtraMarca() {
		return otraMarca;
	}
	public void setOtraMarca(String otraMarca) {
		this.otraMarca = otraMarca;
	}
	public Integer getCodigoEstadoActivo() {
		return codigoEstadoActivo;
	}
	public void setCodigoEstadoActivo(Integer codigoEstadoActivo) {
		this.codigoEstadoActivo = codigoEstadoActivo;
	}
	
}
