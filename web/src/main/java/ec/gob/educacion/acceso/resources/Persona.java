package ec.gob.educacion.acceso.resources;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ROW")
public class Persona {
	
	@XStreamAlias("CEDULA")
	private String cedula;
	
	@XStreamAlias("NOMBRE")
	private String nombre;
	
	@XStreamAlias("GENERO")
	private String genero;
	
	@XStreamAlias("CONDICION_CEDULADO")
	private String condicionCedulado;
	
	@XStreamAlias("FECHA_NACIMIENTO")
	private String fechaNacimiento;
	
	@XStreamAlias("CODIGO_LUGAR_NACIMIENTO")
	private String codigoLugarNacimiento;
	
	@XStreamAlias("LUGAR_NACIMIENTO")
	private String lugarNacimiento;
	
	@XStreamAlias("NACIONALIDAD")
	private String nacionalidad;
	
	@XStreamAlias("ESTADO_CIVIL")
	private String estadoCivil;
	
	@XStreamAlias("CONYUGE")
	private String conyuge;
	
	@XStreamAlias("INSTRUCCION")
	private String instruccion;
	
	@XStreamAlias("PROFESION")
	private String profesion;
	
	@XStreamAlias("FECHA_CEDULACION")
	private String fechaCedulacion;
	
	@XStreamAlias("FECHA_MATRIMONIO")
	private String fechaMatrimonio;
	
	@XStreamAlias("LUGAR_MATRIMONIO")
	private String lugarMatrimonio;
	
	@XStreamAlias("CODIGO_GENERO")
	private String codigoGenero;
	
	@XStreamAlias("CODIGO_CONDICION_CEDULADO")
	private String codigoCondicionCedulado;
	
	@XStreamAlias("CODIGO_NACIONALIDAD")
	private String codigoNacionalidad;
	
	@XStreamAlias("CODIGO_ESTADO_CIVIL")
	private String codigoEstadoCivil;
	
	@XStreamAlias("CODIGO_INSTRUCCION")
	private String codigoInstruccion;
	
	@XStreamAlias("CODIGO_PROFESION")
	private String codigoProfesion;
	
	@XStreamAlias("CODIGO_LUGAR_MATRIMONIO")
	private String codigoLugarMatrimonio;
	
	@XStreamAlias("FECHA_DEFUNCION")
	private String fechaDefuncion;
	
	@XStreamAlias("LUGAR_DOMICILIO")
	private String lugarDomicilio;
	
	@XStreamAlias("CODIGO_LUGAR_DOMICILIO")
	private String codigoLugarDomicilio;
	
	@XStreamAlias("CALLES_DOMICILIO")
	private String callesDomicilio;
	
	@XStreamAlias("NUMERO_CASA")
	private String numeroCasa;
	
	@XStreamAlias("NOMBRE_PADRE")
	private String nombrePadre;
	
	@XStreamAlias("NOMBRE_MADRE")
	private String nombreMadre;

	public String getCedula() {
		if(cedula.contentEquals("null"))
			return "";
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		if(nombre.contentEquals("null"))
			return "";
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		if(genero.contentEquals("null"))
			return "";
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCondicionCedulado() {
		if(condicionCedulado.contentEquals("null"))
			return "";
		return condicionCedulado;
	}

	public void setCondicionCedulado(String condicionCedulado) {
		this.condicionCedulado = condicionCedulado;
	}

	public String getFechaNacimiento() {
		if(fechaNacimiento.contentEquals("null"))
			return "";
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCodigoLugarNacimiento() {
		if(codigoLugarNacimiento.contentEquals("null"))
			return "";
		return codigoLugarNacimiento;
	}

	public void setCodigoLugarNacimiento(String codigoLugarNacimiento) {
		this.codigoLugarNacimiento = codigoLugarNacimiento;
	}

	public String getLugarNacimiento() {
		if(lugarNacimiento.contentEquals("null"))
			return "";
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getNacionalidad() {
		if(nacionalidad.contentEquals("null"))
			return "";
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstadoCivil() {
		if(estadoCivil.contentEquals("null"))
			return "";
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConyuge() {
		if(conyuge.contentEquals("null"))
			return "";
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	public String getInstruccion() {
		if(instruccion.contentEquals("null"))
			return "";
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	public String getProfesion() {
		if(profesion.contentEquals("null"))
			return "";
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getFechaCedulacion() {
		if(fechaCedulacion.contentEquals("null"))
			return "";
		return fechaCedulacion;
	}

	public void setFechaCedulacion(String fechaCedulacion) {
		this.fechaCedulacion = fechaCedulacion;
	}

	public String getFechaMatrimonio() {
		if(fechaMatrimonio.contentEquals("null"))
			return "";
		return fechaMatrimonio;
	}

	public void setFechaMatrimonio(String fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
	}

	public String getLugarMatrimonio() {
		if(lugarMatrimonio.contentEquals("null"))
			return "";
		return lugarMatrimonio;
	}

	public void setLugarMatrimonio(String lugarMatrimonio) {
		this.lugarMatrimonio = lugarMatrimonio;
	}

	public String getCodigoGenero() {
		if(codigoGenero.contentEquals("null"))
			return "";
		return codigoGenero;
	}

	public void setCodigoGenero(String codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public String getCodigoCondicionCedulado() {
		if(codigoCondicionCedulado.contentEquals("null"))
			return "";
		return codigoCondicionCedulado;
	}

	public void setCodigoCondicionCedulado(String codigoCondicionCedulado) {
		this.codigoCondicionCedulado = codigoCondicionCedulado;
	}

	public String getCodigoNacionalidad() {
		if(codigoNacionalidad.contentEquals("null"))
			return "";
		return codigoNacionalidad;
	}

	public void setCodigoNacionalidad(String codigoNacionalidad) {
		this.codigoNacionalidad = codigoNacionalidad;
	}

	public String getCodigoEstadoCivil() {
		if(codigoEstadoCivil.contentEquals("null"))
			return "";
		return codigoEstadoCivil;
	}

	public void setCodigoEstadoCivil(String codigoEstadoCivil) {
		this.codigoEstadoCivil = codigoEstadoCivil;
	}

	public String getCodigoInstruccion() {
		if(codigoInstruccion.contentEquals("null"))
			return "";
		return codigoInstruccion;
	}

	public void setCodigoInstruccion(String codigoInstruccion) {
		this.codigoInstruccion = codigoInstruccion;
	}

	public String getCodigoProfesion() {
		if(codigoProfesion.contentEquals("null"))
			return "";
		return codigoProfesion;
	}

	public void setCodigoProfesion(String codigoProfesion) {
		this.codigoProfesion = codigoProfesion;
	}

	public String getCodigoLugarMatrimonio() {
		if(codigoLugarMatrimonio.contentEquals("null"))
			return "";
		return codigoLugarMatrimonio;
	}

	public void setCodigoLugarMatrimonio(String codigoLugarMatrimonio) {
		this.codigoLugarMatrimonio = codigoLugarMatrimonio;
	}

	public String getFechaDefuncion() {
		if(fechaDefuncion.contentEquals("null"))
			return "";
		return fechaDefuncion;
	}

	public void setFechaDefuncion(String fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public String getLugarDomicilio() {
		if(lugarDomicilio.contentEquals("null"))
			return "";
		return lugarDomicilio;
	}

	public void setLugarDomicilio(String lugarDomicilio) {
		this.lugarDomicilio = lugarDomicilio;
	}

	public String getCodigoLugarDomicilio() {
		if(codigoLugarDomicilio.contentEquals("null"))
			return "";
		return codigoLugarDomicilio;
	}

	public void setCodigoLugarDomicilio(String codigoLugarDomicilio) {
		this.codigoLugarDomicilio = codigoLugarDomicilio;
	}

	public String getCallesDomicilio() {
		if(callesDomicilio.contentEquals("null"))
			return "";
		return callesDomicilio;
	}

	public void setCallesDomicilio(String callesDomicilio) {
		this.callesDomicilio = callesDomicilio;
	}

	public String getNumeroCasa() {
		if(numeroCasa.contentEquals("null"))
			return "";
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getNombrePadre() {
		if(nombrePadre.contentEquals("null"))
			return "";
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		if(nombreMadre.contentEquals("null"))
			return "";
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}
		
}
