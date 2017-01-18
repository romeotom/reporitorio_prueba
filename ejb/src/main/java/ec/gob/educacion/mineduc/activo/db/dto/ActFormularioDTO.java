package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;
import java.util.Date;

public class ActFormularioDTO implements Serializable {

	private static final long serialVersionUID = -6161746160969216052L;
	
	private Integer idAfr;
	private Date fechaLevantamiento;
	private Integer anio;
	private Integer estado;
	private Integer tieneInicial;
	private Integer tieneBasica;
	private Integer tieneBachillerato;
	private Integer tieneInicialOriginal;
	private Integer tieneBasicaOriginal;
	private Integer tieneBachilleratoOriginal;
	private Integer idIe;
	
	private Integer tieneCrtServidores;
	private Integer tieneLabInformatico;
	private Integer numeroLabInformatico;
	private Integer tieneLabVarios;
	private Integer tieneTiSalas;
	private Integer tieneTiBiblioteca;
	private Integer numeroTiBiblioteca;
	private Integer tieneTiAdministrativo;
	private Integer numeroTiAdministrativo;
	
	private Integer hombresTic;
	private Integer mujeresTic;
	private Integer totalTic;
	private String proveedorInternet;
	private Integer conectividad;
	private Float velocidadNavegacion;
	private Integer medidaVelocidadNavegacion;
	private String encargadoPagoInternet;
	private Float valorPagoInternet;
	private String responsableDistrito;
	
	private Integer editado;
	private Integer abrioEdicion;
	
	private Long levantamientoMilisegundos;
	private Integer tieneInternetAdministrativo;
	private Integer tieneInternetBiblioteca;
	private Integer numeroImpresorasBiblioteca;
	private Integer numeroImpresorasAdministrativo;
	private Integer numeroProyectoresAdministrativo;
	private Integer numeroPizarrasAdministrativo;
	private Integer numeroAudioAdministrativo;
	private Integer numeroTelevisoresAdministrativo;
	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Date getFechaLevantamiento() {
		return fechaLevantamiento;
	}
	public void setFechaLevantamiento(Date fechaLevantamiento) {
		this.fechaLevantamiento = fechaLevantamiento;
	}
	public Integer getIdAfr() {
		return idAfr;
	}
	public void setIdAfr(Integer idAfr) {
		this.idAfr = idAfr;
	}
	public Integer getIdIe() {
		return idIe;
	}
	public void setIdIe(Integer idIe) {
		this.idIe = idIe;
	}
	public Integer getTieneBachillerato() {
		return tieneBachillerato;
	}
	public void setTieneBachillerato(Integer tieneBachillerato) {
		this.tieneBachillerato = tieneBachillerato;
	}
	public Integer getTieneBasica() {
		return tieneBasica;
	}
	public void setTieneBasica(Integer tieneBasica) {
		this.tieneBasica = tieneBasica;
	}
	public Integer getTieneInicial() {
		return tieneInicial;
	}
	public void setTieneInicial(Integer tieneInicial) {
		this.tieneInicial = tieneInicial;
	}
	public Integer getTieneInicialOriginal() {
		return tieneInicialOriginal;
	}
	public void setTieneInicialOriginal(Integer tieneInicialOriginal) {
		this.tieneInicialOriginal = tieneInicialOriginal;
	}
	public Integer getTieneBasicaOriginal() {
		return tieneBasicaOriginal;
	}
	public void setTieneBasicaOriginal(Integer tieneBasicaOriginal) {
		this.tieneBasicaOriginal = tieneBasicaOriginal;
	}
	public Integer getTieneBachilleratoOriginal() {
		return tieneBachilleratoOriginal;
	}
	public void setTieneBachilleratoOriginal(Integer tieneBachilleratoOriginal) {
		this.tieneBachilleratoOriginal = tieneBachilleratoOriginal;
	}
	public Integer getNumeroLabInformatico() {
		return numeroLabInformatico;
	}
	public void setNumeroLabInformatico(Integer numeroLabInformatico) {
		this.numeroLabInformatico = numeroLabInformatico;
	}
	public Integer getNumeroTiAdministrativo() {
		return numeroTiAdministrativo;
	}
	public void setNumeroTiAdministrativo(Integer numeroTiAdministrativo) {
		this.numeroTiAdministrativo = numeroTiAdministrativo;
	}
	public Integer getNumeroTiBiblioteca() {
		return numeroTiBiblioteca;
	}
	public void setNumeroTiBiblioteca(Integer numeroTiBiblioteca) {
		this.numeroTiBiblioteca = numeroTiBiblioteca;
	}
	public Integer getTieneCrtServidores() {
		return tieneCrtServidores;
	}
	public void setTieneCrtServidores(Integer tieneCrtServidores) {
		this.tieneCrtServidores = tieneCrtServidores;
	}
	public Integer getTieneLabInformatico() {
		return tieneLabInformatico;
	}
	public void setTieneLabInformatico(Integer tieneLabInformatico) {
		this.tieneLabInformatico = tieneLabInformatico;
	}
	public Integer getTieneLabVarios() {
		return tieneLabVarios;
	}
	public void setTieneLabVarios(Integer tieneLabVarios) {
		this.tieneLabVarios = tieneLabVarios;
	}
	public Integer getTieneTiAdministrativo() {
		return tieneTiAdministrativo;
	}
	public void setTieneTiAdministrativo(Integer tieneTiAdministrativo) {
		this.tieneTiAdministrativo = tieneTiAdministrativo;
	}
	public Integer getTieneTiBiblioteca() {
		return tieneTiBiblioteca;
	}
	public void setTieneTiBiblioteca(Integer tieneTiBiblioteca) {
		this.tieneTiBiblioteca = tieneTiBiblioteca;
	}
	public Integer getTieneTiSalas() {
		return tieneTiSalas;
	}
	public void setTieneTiSalas(Integer tieneTiSalas) {
		this.tieneTiSalas = tieneTiSalas;
	}
	public Integer getConectividad() {
		return conectividad;
	}
	public void setConectividad(Integer conectividad) {
		this.conectividad = conectividad;
	}
	public String getEncargadoPagoInternet() {
		return encargadoPagoInternet;
	}
	public void setEncargadoPagoInternet(String encargadoPagoInternet) {
		this.encargadoPagoInternet = encargadoPagoInternet;
	}
	public Integer getHombresTic() {
		return hombresTic;
	}
	public void setHombresTic(Integer hombresTic) {
		this.hombresTic = hombresTic;
	}
	public Integer getMedidaVelocidadNavegacion() {
		return medidaVelocidadNavegacion;
	}
	public void setMedidaVelocidadNavegacion(Integer medidaVelocidadNavegacion) {
		this.medidaVelocidadNavegacion = medidaVelocidadNavegacion;
	}
	public Integer getMujeresTic() {
		return mujeresTic;
	}
	public void setMujeresTic(Integer mujeresTic) {
		this.mujeresTic = mujeresTic;
	}
	public String getProveedorInternet() {
		return proveedorInternet;
	}
	public void setProveedorInternet(String proveedorInternet) {
		this.proveedorInternet = proveedorInternet;
	}
	public String getResponsableDistrito() {
		return responsableDistrito;
	}
	public void setResponsableDistrito(String responsableDistrito) {
		this.responsableDistrito = responsableDistrito;
	}
	public Integer getTotalTic() {
		return totalTic;
	}
	public void setTotalTic(Integer totalTic) {
		this.totalTic = totalTic;
	}
	public Float getValorPagoInternet() {
		return valorPagoInternet;
	}
	public void setValorPagoInternet(Float valorPagoInternet) {
		this.valorPagoInternet = valorPagoInternet;
	}
	public Float getVelocidadNavegacion() {
		return velocidadNavegacion;
	}
	public void setVelocidadNavegacion(Float velocidadNavegacion) {
		this.velocidadNavegacion = velocidadNavegacion;
	}
	public Integer getEditado() {
		return editado;
	}
	public void setEditado(Integer editado) {
		this.editado = editado;
	}
	public Integer getAbrioEdicion() {
		return abrioEdicion;
	}
	public void setAbrioEdicion(Integer abrioEdicion) {
		this.abrioEdicion = abrioEdicion;
	}
	public Long getLevantamientoMilisegundos() {
		return levantamientoMilisegundos;
	}
	public void setLevantamientoMilisegundos(Long levantamientoMilisegundos) {
		this.levantamientoMilisegundos = levantamientoMilisegundos;
	}
	public Integer getTieneInternetAdministrativo() {
		return tieneInternetAdministrativo;
	}
	public void setTieneInternetAdministrativo(Integer tieneInternetAdministrativo) {
		this.tieneInternetAdministrativo = tieneInternetAdministrativo;
	}
	public Integer getTieneInternetBiblioteca() {
		return tieneInternetBiblioteca;
	}
	public void setTieneInternetBiblioteca(Integer tieneInternetBiblioteca) {
		this.tieneInternetBiblioteca = tieneInternetBiblioteca;
	}
	public Integer getNumeroImpresorasBiblioteca() {
		return numeroImpresorasBiblioteca;
	}
	public void setNumeroImpresorasBiblioteca(Integer numeroImpresorasBiblioteca) {
		this.numeroImpresorasBiblioteca = numeroImpresorasBiblioteca;
	}
	public Integer getNumeroImpresorasAdministrativo() {
		return numeroImpresorasAdministrativo;
	}
	public void setNumeroImpresorasAdministrativo(
			Integer numeroImpresorasAdministrativo) {
		this.numeroImpresorasAdministrativo = numeroImpresorasAdministrativo;
	}
	public Integer getNumeroProyectoresAdministrativo() {
		return numeroProyectoresAdministrativo;
	}
	public void setNumeroProyectoresAdministrativo(
			Integer numeroProyectoresAdministrativo) {
		this.numeroProyectoresAdministrativo = numeroProyectoresAdministrativo;
	}
	public Integer getNumeroPizarrasAdministrativo() {
		return numeroPizarrasAdministrativo;
	}
	public void setNumeroPizarrasAdministrativo(Integer numeroPizarrasAdministrativo) {
		this.numeroPizarrasAdministrativo = numeroPizarrasAdministrativo;
	}
	public Integer getNumeroAudioAdministrativo() {
		return numeroAudioAdministrativo;
	}
	public void setNumeroAudioAdministrativo(Integer numeroAudioAdministrativo) {
		this.numeroAudioAdministrativo = numeroAudioAdministrativo;
	}
	public Integer getNumeroTelevisoresAdministrativo() {
		return numeroTelevisoresAdministrativo;
	}
	public void setNumeroTelevisoresAdministrativo(
			Integer numeroTelevisoresAdministrativo) {
		this.numeroTelevisoresAdministrativo = numeroTelevisoresAdministrativo;
	}

}
