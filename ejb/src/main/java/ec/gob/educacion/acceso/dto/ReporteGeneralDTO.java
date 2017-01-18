package ec.gob.educacion.acceso.dto;

import java.util.Date;

public class ReporteGeneralDTO {
	
	private String amie;
	private Date fechaCarga;
	private String nombreInstitucion;
	private String zona;
	private String distrito;
	private String provincia;
	private String canton;
	private String parroquia;
	private String direccion;
	private String responsableNombres;
	private String responsableCorreo;
	private String responsableContactos;
	private String tecnicoNombres;
	private String tecnicoCorreo;
	private String tecnicoContactos;
	private String docenteNombres;
	private String docenteCorreo;
	private String docenteContactos;
	private String estadoIE;
	private String estadoLabTI;
	private String tieneInternetLabTI;
	private Double velocidadInternetLabTI;
	private String marcaModelo;
	private String serial;
	private Double velocidadProcesador;
	private Double memoria;
	private Double discoDuro;
	private String dobleBooteo;
	private String soPrincipal;
	private String soSecundario;
	private String urbano;
	private Long codigoFormulario;
	private Long codigoLaboratorio;
	private Long codigoActivo;
	private String estadoFormulario;
	private String nombreLaboratorio;
	private String nombreActivo;
	private String procedenciaActivo;
	private String tipoLabSala;
	private String estadoActivo;
	
	private int totalLaboratoriosTi;
	private int totalComputadoresTi;
	private int totalComputadoresEnUsoTi;
	private int totalComputadoresObsoletasTi;
	private int totalImpresorasTi;
	private int totalImpresorasEnUsoTi;
	private int totalImpresorasObsoletasTi;
	
	private int totalLaboratoriosAdmin;
	private int totalComputadoresAdmin;
	private int totalComputadoresEnUsoAdmin;
	private int totalComputadoresObsoletasAdmin;
	private int totalImpresorasAdmin;
	private int totalImpresorasEnUsoAdmin;
	private int totalImpresorasObsoletasAdmin;
	
	private int totalVarios;
	private int totalComputadoresVarios;
	private int totalComputadoresEnUsoVarios;
	private int totalComputadoresObsoletasVarios;
	private int totalImpresorasVarios;
	private int totalImpresorasEnUsoVarios;
	private int totalImpresorasObsoletasVarios;
	
	private int ordenMes;
	private String nombreMes;
	
	//talento humano
	private String nombresTecnicoMinEduc;
	private String mailTecnicoMinEduc;
	private String contactosTecnicoMinEduc;
	private String nombresResponsableIe;
	private String mailResponsableIe;
	private String contactosResponsableIe;
	private String nombresDocenteIe;
	private String mailDocenteIe;
	private String contactosDocenteIe;
	
	public String getAmie() {
		return amie;
	}
	public void setAmie(String amie) {
		this.amie = amie;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public String getNombreInstitucion() {
		return nombreInstitucion;
	}
	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
	public String getParroquia() {
		return parroquia;
	}
	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getResponsableNombres() {
		return responsableNombres;
	}
	public void setResponsableNombres(String responsableNombres) {
		this.responsableNombres = responsableNombres;
	}
	public String getResponsableCorreo() {
		return responsableCorreo;
	}
	public void setResponsableCorreo(String responsableCorreo) {
		this.responsableCorreo = responsableCorreo;
	}
	public String getResponsableContactos() {
		return responsableContactos;
	}
	public void setResponsableContactos(String responsableContactos) {
		this.responsableContactos = responsableContactos;
	}
	public String getTecnicoNombres() {
		return tecnicoNombres;
	}
	public void setTecnicoNombres(String tecnicoNombres) {
		this.tecnicoNombres = tecnicoNombres;
	}
	public String getTecnicoCorreo() {
		return tecnicoCorreo;
	}
	public void setTecnicoCorreo(String tecnicoCorreo) {
		this.tecnicoCorreo = tecnicoCorreo;
	}
	public String getTecnicoContactos() {
		return tecnicoContactos;
	}
	public void setTecnicoContactos(String tecnicoContactos) {
		this.tecnicoContactos = tecnicoContactos;
	}
	public String getDocenteNombres() {
		return docenteNombres;
	}
	public void setDocenteNombres(String docenteNombres) {
		this.docenteNombres = docenteNombres;
	}
	public String getDocenteCorreo() {
		return docenteCorreo;
	}
	public void setDocenteCorreo(String docenteCorreo) {
		this.docenteCorreo = docenteCorreo;
	}
	public String getDocenteContactos() {
		return docenteContactos;
	}
	public void setDocenteContactos(String docenteContactos) {
		this.docenteContactos = docenteContactos;
	}
	public String getEstadoIE() {
		return estadoIE;
	}
	public void setEstadoIE(String estadoIE) {
		this.estadoIE = estadoIE;
	}
	public String getEstadoLabTI() {
		return estadoLabTI;
	}
	public void setEstadoLabTI(String estadoLabTI) {
		this.estadoLabTI = estadoLabTI;
	}
	public String getTieneInternetLabTI() {
		return tieneInternetLabTI;
	}
	public void setTieneInternetLabTI(String tieneInternetLabTI) {
		this.tieneInternetLabTI = tieneInternetLabTI;
	}
	public Double getVelocidadInternetLabTI() {
		return velocidadInternetLabTI;
	}
	public void setVelocidadInternetLabTI(Double velocidadInternetLabTI) {
		this.velocidadInternetLabTI = velocidadInternetLabTI;
	}
	public String getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Double getVelocidadProcesador() {
		return velocidadProcesador;
	}
	public void setVelocidadProcesador(Double velocidadProcesador) {
		this.velocidadProcesador = velocidadProcesador;
	}
	public Double getMemoria() {
		return memoria;
	}
	public void setMemoria(Double memoria) {
		this.memoria = memoria;
	}
	public Double getDiscoDuro() {
		return discoDuro;
	}
	public void setDiscoDuro(Double discoDuro) {
		this.discoDuro = discoDuro;
	}
	public String getDobleBooteo() {
		return dobleBooteo;
	}
	public void setDobleBooteo(String dobleBooteo) {
		this.dobleBooteo = dobleBooteo;
	}
	public String getSoPrincipal() {
		return soPrincipal;
	}
	public void setSoPrincipal(String soPrincipal) {
		this.soPrincipal = soPrincipal;
	}
	public String getSoSecundario() {
		return soSecundario;
	}
	public void setSoSecundario(String soSecundario) {
		this.soSecundario = soSecundario;
	}
	public String getUrbano() {
		return urbano;
	}
	public void setUrbano(String urbano) {
		this.urbano = urbano;
	}
	public Long getCodigoFormulario() {
		return codigoFormulario;
	}
	public void setCodigoFormulario(Long codigoFormulario) {
		this.codigoFormulario = codigoFormulario;
	}
	public Long getCodigoLaboratorio() {
		return codigoLaboratorio;
	}
	public void setCodigoLaboratorio(Long codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}
	public Long getCodigoActivo() {
		return codigoActivo;
	}
	public void setCodigoActivo(Long codigoActivo) {
		this.codigoActivo = codigoActivo;
	}
	public String getEstadoFormulario() {
		return estadoFormulario;
	}
	public void setEstadoFormulario(String estadoFormulario) {
		this.estadoFormulario = estadoFormulario;
	}
	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}
	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}
	public String getNombreActivo() {
		return nombreActivo;
	}
	public void setNombreActivo(String nombreActivo) {
		this.nombreActivo = nombreActivo;
	}
	public String getProcedenciaActivo() {
		return procedenciaActivo;
	}
	public void setProcedenciaActivo(String procedenciaActivo) {
		this.procedenciaActivo = procedenciaActivo;
	}
	public String getTipoLabSala() {
		return tipoLabSala;
	}
	public void setTipoLabSala(String tipoLabSala) {
		this.tipoLabSala = tipoLabSala;
	}
	public String getEstadoActivo() {
		return estadoActivo;
	}
	public void setEstadoActivo(String estadoActivo) {
		this.estadoActivo = estadoActivo;
	}
	public int getTotalLaboratoriosTi() {
		return totalLaboratoriosTi;
	}
	public void setTotalLaboratoriosTi(int totalLaboratoriosTi) {
		this.totalLaboratoriosTi = totalLaboratoriosTi;
	}
	public int getTotalComputadoresTi() {
		return totalComputadoresTi;
	}
	public void setTotalComputadoresTi(int totalComputadoresTi) {
		this.totalComputadoresTi = totalComputadoresTi;
	}
	public int getTotalComputadoresEnUsoTi() {
		return totalComputadoresEnUsoTi;
	}
	public void setTotalComputadoresEnUsoTi(int totalComputadoresEnUsoTi) {
		this.totalComputadoresEnUsoTi = totalComputadoresEnUsoTi;
	}
	public int getTotalComputadoresObsoletasTi() {
		return totalComputadoresObsoletasTi;
	}
	public void setTotalComputadoresObsoletasTi(int totalComputadoresObsoletasTi) {
		this.totalComputadoresObsoletasTi = totalComputadoresObsoletasTi;
	}
	public int getTotalImpresorasTi() {
		return totalImpresorasTi;
	}
	public void setTotalImpresorasTi(int totalImpresorasTi) {
		this.totalImpresorasTi = totalImpresorasTi;
	}
	public int getTotalImpresorasEnUsoTi() {
		return totalImpresorasEnUsoTi;
	}
	public void setTotalImpresorasEnUsoTi(int totalImpresorasEnUsoTi) {
		this.totalImpresorasEnUsoTi = totalImpresorasEnUsoTi;
	}
	public int getTotalImpresorasObsoletasTi() {
		return totalImpresorasObsoletasTi;
	}
	public void setTotalImpresorasObsoletasTi(int totalImpresorasObsoletasTi) {
		this.totalImpresorasObsoletasTi = totalImpresorasObsoletasTi;
	}
	public int getTotalLaboratoriosAdmin() {
		return totalLaboratoriosAdmin;
	}
	public void setTotalLaboratoriosAdmin(int totalLaboratoriosAdmin) {
		this.totalLaboratoriosAdmin = totalLaboratoriosAdmin;
	}
	public int getTotalComputadoresAdmin() {
		return totalComputadoresAdmin;
	}
	public void setTotalComputadoresAdmin(int totalComputadoresAdmin) {
		this.totalComputadoresAdmin = totalComputadoresAdmin;
	}
	public int getTotalComputadoresEnUsoAdmin() {
		return totalComputadoresEnUsoAdmin;
	}
	public void setTotalComputadoresEnUsoAdmin(int totalComputadoresEnUsoAdmin) {
		this.totalComputadoresEnUsoAdmin = totalComputadoresEnUsoAdmin;
	}
	public int getTotalComputadoresObsoletasAdmin() {
		return totalComputadoresObsoletasAdmin;
	}
	public void setTotalComputadoresObsoletasAdmin(
			int totalComputadoresObsoletasAdmin) {
		this.totalComputadoresObsoletasAdmin = totalComputadoresObsoletasAdmin;
	}
	public int getTotalImpresorasAdmin() {
		return totalImpresorasAdmin;
	}
	public void setTotalImpresorasAdmin(int totalImpresorasAdmin) {
		this.totalImpresorasAdmin = totalImpresorasAdmin;
	}
	public int getTotalImpresorasEnUsoAdmin() {
		return totalImpresorasEnUsoAdmin;
	}
	public void setTotalImpresorasEnUsoAdmin(int totalImpresorasEnUsoAdmin) {
		this.totalImpresorasEnUsoAdmin = totalImpresorasEnUsoAdmin;
	}
	public int getTotalImpresorasObsoletasAdmin() {
		return totalImpresorasObsoletasAdmin;
	}
	public void setTotalImpresorasObsoletasAdmin(int totalImpresorasObsoletasAdmin) {
		this.totalImpresorasObsoletasAdmin = totalImpresorasObsoletasAdmin;
	}
	public int getTotalVarios() {
		return totalVarios;
	}
	public void setTotalVarios(int totalVarios) {
		this.totalVarios = totalVarios;
	}
	public int getTotalComputadoresVarios() {
		return totalComputadoresVarios;
	}
	public void setTotalComputadoresVarios(int totalComputadoresVarios) {
		this.totalComputadoresVarios = totalComputadoresVarios;
	}
	public int getTotalComputadoresEnUsoVarios() {
		return totalComputadoresEnUsoVarios;
	}
	public void setTotalComputadoresEnUsoVarios(int totalComputadoresEnUsoVarios) {
		this.totalComputadoresEnUsoVarios = totalComputadoresEnUsoVarios;
	}
	public int getTotalComputadoresObsoletasVarios() {
		return totalComputadoresObsoletasVarios;
	}
	public void setTotalComputadoresObsoletasVarios(
			int totalComputadoresObsoletasVarios) {
		this.totalComputadoresObsoletasVarios = totalComputadoresObsoletasVarios;
	}
	public int getTotalImpresorasVarios() {
		return totalImpresorasVarios;
	}
	public void setTotalImpresorasVarios(int totalImpresorasVarios) {
		this.totalImpresorasVarios = totalImpresorasVarios;
	}
	public int getTotalImpresorasEnUsoVarios() {
		return totalImpresorasEnUsoVarios;
	}
	public void setTotalImpresorasEnUsoVarios(int totalImpresorasEnUsoVarios) {
		this.totalImpresorasEnUsoVarios = totalImpresorasEnUsoVarios;
	}
	public int getTotalImpresorasObsoletasVarios() {
		return totalImpresorasObsoletasVarios;
	}
	public void setTotalImpresorasObsoletasVarios(int totalImpresorasObsoletasVarios) {
		this.totalImpresorasObsoletasVarios = totalImpresorasObsoletasVarios;
	}
	public int getOrdenMes() {
		return ordenMes;
	}
	public void setOrdenMes(int ordenMes) {
		this.ordenMes = ordenMes;
	}
	public String getNombreMes() {
		return nombreMes;
	}
	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}
	public String getNombresTecnicoMinEduc() {
		return nombresTecnicoMinEduc;
	}
	public void setNombresTecnicoMinEduc(String nombresTecnicoMinEduc) {
		this.nombresTecnicoMinEduc = nombresTecnicoMinEduc;
	}
	public String getMailTecnicoMinEduc() {
		return mailTecnicoMinEduc;
	}
	public void setMailTecnicoMinEduc(String mailTecnicoMinEduc) {
		this.mailTecnicoMinEduc = mailTecnicoMinEduc;
	}
	public String getContactosTecnicoMinEduc() {
		return contactosTecnicoMinEduc;
	}
	public void setContactosTecnicoMinEduc(String contactosTecnicoMinEduc) {
		this.contactosTecnicoMinEduc = contactosTecnicoMinEduc;
	}
	public String getNombresResponsableIe() {
		return nombresResponsableIe;
	}
	public void setNombresResponsableIe(String nombresResponsableIe) {
		this.nombresResponsableIe = nombresResponsableIe;
	}
	public String getMailResponsableIe() {
		return mailResponsableIe;
	}
	public void setMailResponsableIe(String mailResponsableIe) {
		this.mailResponsableIe = mailResponsableIe;
	}
	public String getContactosResponsableIe() {
		return contactosResponsableIe;
	}
	public void setContactosResponsableIe(String contactosResponsableIe) {
		this.contactosResponsableIe = contactosResponsableIe;
	}
	public String getNombresDocenteIe() {
		return nombresDocenteIe;
	}
	public void setNombresDocenteIe(String nombresDocenteIe) {
		this.nombresDocenteIe = nombresDocenteIe;
	}
	public String getMailDocenteIe() {
		return mailDocenteIe;
	}
	public void setMailDocenteIe(String mailDocenteIe) {
		this.mailDocenteIe = mailDocenteIe;
	}
	public String getContactosDocenteIe() {
		return contactosDocenteIe;
	}
	public void setContactosDocenteIe(String contactosDocenteIe) {
		this.contactosDocenteIe = contactosDocenteIe;
	}

}