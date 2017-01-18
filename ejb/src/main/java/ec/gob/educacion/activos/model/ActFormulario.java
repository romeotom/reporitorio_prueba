package ec.gob.educacion.activos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_FORMULARIO database table.
 * 
 */
@Entity
@Table(name="ACT_FORMULARIO")
@NamedQuery(name="ActFormulario.findAll", query="SELECT a FROM ActFormulario a")
@Audited
public class ActFormulario implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private int anio;
	private long codigoInstitucion;
	private int conectividad;
	private String encargadoPagoInternet;
	private int estado;
	private Date fechaCarga;
	private Date fechaLevantamiento;
	private Integer hombresTic;
	private String idArchivo;
	private Long medidaVelocidadNavegacion;
	private Integer mujeresTic;
	private Long numeroLabInformatico;
	private Long numeroTiAdministrativo;
	private Long numeroTiBiblioteca;
	private String proveedorInternet;
	private String responsableDistrito;
	private int tieneBachillerato;
	private int tieneBasica;
	private int tieneCrtServidores;
	private int tieneInicial;
	private int tieneLabInformatico;
	private int tieneLabVarios;
	private int tieneTiAdministrativo;
	private int tieneTiBiblioteca;
	private int tieneTiSalas;
	private int tipo;
	private Integer totalTic;
	private Double valorPagoInternet;
	private Double velocidadNavegacion;
	private String amie;
	private List<ActAccesibilidadServicio> actAccesibilidadServicios;
	private List<ActConectividad> actConectividads;
	private List<ActCuartoServidore> actCuartoServidores;
	private List<ActJornadaEducacion> actJornadaEducacions;
	private List<ActJornadaEducacionTi> actJornadaEducacionTis;
	private List<ActLaboratorioSala> actLaboratorioSalas;
	private List<ActNumeroDocente> actNumeroDocentes;
	private List<ActNumeroEstudiante> actNumeroEstudiantes;
	private List<ActNumeroParalelo> actNumeroParalelos;
	private List<ActPromedioEstudiante> actPromedioEstudiantes;
	private List<ActRecursoDigital> actRecursoDigitals;
	private List<ActTalentoHumano> actTalentoHumanos;
	
	private List<ActMesParametrizadoFormulario> actMesesParametrizadosFormularios;
	
	//nuevos campos para subida de activos
	private Long levantamientoMilisegundos;
	private Integer tieneInternetAdministrativo;
	private Integer tieneInternetBiblioteca;
	private Integer numeroImpresorasBiblioteca;
	private Integer numeroImpresorasAdministrativo;
	private Integer numeroProyectoresAdministrativo;
	private Integer numeroPizarrasAdministrativo;
	private Integer numeroAudioAdministrativo;
	private Integer numeroTelevisoresAdministrativo;
	
	

	public ActFormulario() {
	}


	@Id
	@SequenceGenerator(name="ACT_FORMULARIO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_FORMULARIO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_FORMULARIO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name="AMIE")
	public String getAmie() {
		return this.amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}


	@Column(name="CODIGO_INSTITUCION")
	public long getCodigoInstitucion() {
		return this.codigoInstitucion;
	}

	public void setCodigoInstitucion(long codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}


	public int getConectividad() {
		return this.conectividad;
	}

	public void setConectividad(int conectividad) {
		this.conectividad = conectividad;
	}


	@Column(name="ENCARGADO_PAGO_INTERNET")
	public String getEncargadoPagoInternet() {
		return this.encargadoPagoInternet;
	}

	public void setEncargadoPagoInternet(String encargadoPagoInternet) {
		this.encargadoPagoInternet = encargadoPagoInternet;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CARGA")
	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_LEVANTAMIENTO")
	public Date getFechaLevantamiento() {
		return this.fechaLevantamiento;
	}

	public void setFechaLevantamiento(Date fechaLevantamiento) {
		this.fechaLevantamiento = fechaLevantamiento;
	}


	@Column(name="HOMBRES_TIC")
	public Integer getHombresTic() {
		return this.hombresTic;
	}

	public void setHombresTic(Integer hombresTic) {
		this.hombresTic = hombresTic;
	}


	@Column(name="ID_ARCHIVO")
	public String getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(String idArchivo) {
		this.idArchivo = idArchivo;
	}


	@Column(name="MEDIDA_VELOCIDAD_NAVEGACION")
	public Long getMedidaVelocidadNavegacion() {
		return this.medidaVelocidadNavegacion;
	}

	public void setMedidaVelocidadNavegacion(Long medidaVelocidadNavegacion) {
		this.medidaVelocidadNavegacion = medidaVelocidadNavegacion;
	}


	@Column(name="MUJERES_TIC")
	public Integer getMujeresTic() {
		return this.mujeresTic;
	}

	public void setMujeresTic(Integer mujeresTic) {
		this.mujeresTic = mujeresTic;
	}


	@Column(name="NUMERO_LAB_INFORMATICO")
	public Long getNumeroLabInformatico() {
		return this.numeroLabInformatico;
	}

	public void setNumeroLabInformatico(Long numeroLabInformatico) {
		this.numeroLabInformatico = numeroLabInformatico;
	}


	@Column(name="NUMERO_TI_ADMINISTRATIVO")
	public Long getNumeroTiAdministrativo() {
		return this.numeroTiAdministrativo;
	}

	public void setNumeroTiAdministrativo(Long numeroTiAdministrativo) {
		this.numeroTiAdministrativo = numeroTiAdministrativo;
	}


	@Column(name="NUMERO_TI_BIBLIOTECA")
	public Long getNumeroTiBiblioteca() {
		return this.numeroTiBiblioteca;
	}

	public void setNumeroTiBiblioteca(Long numeroTiBiblioteca) {
		this.numeroTiBiblioteca = numeroTiBiblioteca;
	}


	@Column(name="PROVEEDOR_INTERNET")
	public String getProveedorInternet() {
		return this.proveedorInternet;
	}

	public void setProveedorInternet(String proveedorInternet) {
		this.proveedorInternet = proveedorInternet;
	}


	@Column(name="RESPONSABLE_DISTRITO")
	public String getResponsableDistrito() {
		return this.responsableDistrito;
	}

	public void setResponsableDistrito(String responsableDistrito) {
		this.responsableDistrito = responsableDistrito;
	}


	@Column(name="TIENE_BACHILLERATO")
	public int getTieneBachillerato() {
		return this.tieneBachillerato;
	}

	public void setTieneBachillerato(int tieneBachillerato) {
		this.tieneBachillerato = tieneBachillerato;
	}


	@Column(name="TIENE_BASICA")
	public int getTieneBasica() {
		return this.tieneBasica;
	}

	public void setTieneBasica(int tieneBasica) {
		this.tieneBasica = tieneBasica;
	}


	@Column(name="TIENE_CRT_SERVIDORES")
	public int getTieneCrtServidores() {
		return this.tieneCrtServidores;
	}

	public void setTieneCrtServidores(int tieneCrtServidores) {
		this.tieneCrtServidores = tieneCrtServidores;
	}


	@Column(name="TIENE_INICIAL")
	public int getTieneInicial() {
		return this.tieneInicial;
	}

	public void setTieneInicial(int tieneInicial) {
		this.tieneInicial = tieneInicial;
	}


	@Column(name="TIENE_LAB_INFORMATICO")
	public int getTieneLabInformatico() {
		return this.tieneLabInformatico;
	}

	public void setTieneLabInformatico(int tieneLabInformatico) {
		this.tieneLabInformatico = tieneLabInformatico;
	}


	@Column(name="TIENE_LAB_VARIOS")
	public int getTieneLabVarios() {
		return this.tieneLabVarios;
	}

	public void setTieneLabVarios(int tieneLabVarios) {
		this.tieneLabVarios = tieneLabVarios;
	}


	@Column(name="TIENE_TI_ADMINISTRATIVO")
	public int getTieneTiAdministrativo() {
		return this.tieneTiAdministrativo;
	}

	public void setTieneTiAdministrativo(int tieneTiAdministrativo) {
		this.tieneTiAdministrativo = tieneTiAdministrativo;
	}


	@Column(name="TIENE_TI_BIBLIOTECA")
	public int getTieneTiBiblioteca() {
		return this.tieneTiBiblioteca;
	}

	public void setTieneTiBiblioteca(int tieneTiBiblioteca) {
		this.tieneTiBiblioteca = tieneTiBiblioteca;
	}


	@Column(name="TIENE_TI_SALAS")
	public int getTieneTiSalas() {
		return this.tieneTiSalas;
	}

	public void setTieneTiSalas(int tieneTiSalas) {
		this.tieneTiSalas = tieneTiSalas;
	}


	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	@Column(name="TOTAL_TIC")
	public Integer getTotalTic() {
		return this.totalTic;
	}

	public void setTotalTic(Integer totalTic) {
		this.totalTic = totalTic;
	}


	@Column(name="VALOR_PAGO_INTERNET")
	public Double getValorPagoInternet() {
		return this.valorPagoInternet;
	}

	public void setValorPagoInternet(Double valorPagoInternet) {
		this.valorPagoInternet = valorPagoInternet;
	}


	@Column(name="VELOCIDAD_NAVEGACION")
	public Double getVelocidadNavegacion() {
		return this.velocidadNavegacion;
	}

	public void setVelocidadNavegacion(Double velocidadNavegacion) {
		this.velocidadNavegacion = velocidadNavegacion;
	}

	//bi-directional many-to-one association to ActAccesibilidadServicio
	@OneToMany(mappedBy="actFormulario")
	public List<ActAccesibilidadServicio> getActAccesibilidadServicios() {
		return this.actAccesibilidadServicios;
	}

	public void setActAccesibilidadServicios(List<ActAccesibilidadServicio> actAccesibilidadServicios) {
		this.actAccesibilidadServicios = actAccesibilidadServicios;
	}

	public ActAccesibilidadServicio addActAccesibilidadServicio(ActAccesibilidadServicio actAccesibilidadServicio) {
		getActAccesibilidadServicios().add(actAccesibilidadServicio);
		actAccesibilidadServicio.setActFormulario(this);

		return actAccesibilidadServicio;
	}

	public ActAccesibilidadServicio removeActAccesibilidadServicio(ActAccesibilidadServicio actAccesibilidadServicio) {
		getActAccesibilidadServicios().remove(actAccesibilidadServicio);
		actAccesibilidadServicio.setActFormulario(null);

		return actAccesibilidadServicio;
	}


	//bi-directional many-to-one association to ActConectividad
	@OneToMany(mappedBy="actFormulario")
	public List<ActConectividad> getActConectividads() {
		return this.actConectividads;
	}

	public void setActConectividads(List<ActConectividad> actConectividads) {
		this.actConectividads = actConectividads;
	}

	public ActConectividad addActConectividad(ActConectividad actConectividad) {
		getActConectividads().add(actConectividad);
		actConectividad.setActFormulario(this);

		return actConectividad;
	}

	public ActConectividad removeActConectividad(ActConectividad actConectividad) {
		getActConectividads().remove(actConectividad);
		actConectividad.setActFormulario(null);

		return actConectividad;
	}


	//bi-directional many-to-one association to ActCuartoServidore
	@OneToMany(mappedBy="actFormulario")
	public List<ActCuartoServidore> getActCuartoServidores() {
		return this.actCuartoServidores;
	}

	public void setActCuartoServidores(List<ActCuartoServidore> actCuartoServidores) {
		this.actCuartoServidores = actCuartoServidores;
	}

	public ActCuartoServidore addActCuartoServidore(ActCuartoServidore actCuartoServidore) {
		getActCuartoServidores().add(actCuartoServidore);
		actCuartoServidore.setActFormulario(this);

		return actCuartoServidore;
	}

	public ActCuartoServidore removeActCuartoServidore(ActCuartoServidore actCuartoServidore) {
		getActCuartoServidores().remove(actCuartoServidore);
		actCuartoServidore.setActFormulario(null);

		return actCuartoServidore;
	}


	//bi-directional many-to-one association to ActJornadaEducacion
	@OneToMany(mappedBy="actFormulario")
	public List<ActJornadaEducacion> getActJornadaEducacions() {
		return this.actJornadaEducacions;
	}

	public void setActJornadaEducacions(List<ActJornadaEducacion> actJornadaEducacions) {
		this.actJornadaEducacions = actJornadaEducacions;
	}

	public ActJornadaEducacion addActJornadaEducacion(ActJornadaEducacion actJornadaEducacion) {
		getActJornadaEducacions().add(actJornadaEducacion);
		actJornadaEducacion.setActFormulario(this);

		return actJornadaEducacion;
	}

	public ActJornadaEducacion removeActJornadaEducacion(ActJornadaEducacion actJornadaEducacion) {
		getActJornadaEducacions().remove(actJornadaEducacion);
		actJornadaEducacion.setActFormulario(null);

		return actJornadaEducacion;
	}


	//bi-directional many-to-one association to ActJornadaEducacionTi
	@OneToMany(mappedBy="actFormulario")
	public List<ActJornadaEducacionTi> getActJornadaEducacionTis() {
		return this.actJornadaEducacionTis;
	}

	public void setActJornadaEducacionTis(List<ActJornadaEducacionTi> actJornadaEducacionTis) {
		this.actJornadaEducacionTis = actJornadaEducacionTis;
	}

	public ActJornadaEducacionTi addActJornadaEducacionTi(ActJornadaEducacionTi actJornadaEducacionTi) {
		getActJornadaEducacionTis().add(actJornadaEducacionTi);
		actJornadaEducacionTi.setActFormulario(this);

		return actJornadaEducacionTi;
	}

	public ActJornadaEducacionTi removeActJornadaEducacionTi(ActJornadaEducacionTi actJornadaEducacionTi) {
		getActJornadaEducacionTis().remove(actJornadaEducacionTi);
		actJornadaEducacionTi.setActFormulario(null);

		return actJornadaEducacionTi;
	}


	//bi-directional many-to-one association to ActLaboratorioSala
	@OneToMany(mappedBy="actFormulario", fetch=FetchType.LAZY)
	public List<ActLaboratorioSala> getActLaboratorioSalas() {
		return this.actLaboratorioSalas;
	}

	public void setActLaboratorioSalas(List<ActLaboratorioSala> actLaboratorioSalas) {
		this.actLaboratorioSalas = actLaboratorioSalas;
	}

	public ActLaboratorioSala addActLaboratorioSala(ActLaboratorioSala actLaboratorioSala) {
		getActLaboratorioSalas().add(actLaboratorioSala);
		actLaboratorioSala.setActFormulario(this);

		return actLaboratorioSala;
	}

	public ActLaboratorioSala removeActLaboratorioSala(ActLaboratorioSala actLaboratorioSala) {
		getActLaboratorioSalas().remove(actLaboratorioSala);
		actLaboratorioSala.setActFormulario(null);

		return actLaboratorioSala;
	}


	//bi-directional many-to-one association to ActNumeroDocente
	@OneToMany(mappedBy="actFormulario")
	public List<ActNumeroDocente> getActNumeroDocentes() {
		return this.actNumeroDocentes;
	}

	public void setActNumeroDocentes(List<ActNumeroDocente> actNumeroDocentes) {
		this.actNumeroDocentes = actNumeroDocentes;
	}

	public ActNumeroDocente addActNumeroDocente(ActNumeroDocente actNumeroDocente) {
		getActNumeroDocentes().add(actNumeroDocente);
		actNumeroDocente.setActFormulario(this);

		return actNumeroDocente;
	}

	public ActNumeroDocente removeActNumeroDocente(ActNumeroDocente actNumeroDocente) {
		getActNumeroDocentes().remove(actNumeroDocente);
		actNumeroDocente.setActFormulario(null);

		return actNumeroDocente;
	}


	//bi-directional many-to-one association to ActNumeroEstudiante
	@OneToMany(mappedBy="actFormulario")
	public List<ActNumeroEstudiante> getActNumeroEstudiantes() {
		return this.actNumeroEstudiantes;
	}

	public void setActNumeroEstudiantes(List<ActNumeroEstudiante> actNumeroEstudiantes) {
		this.actNumeroEstudiantes = actNumeroEstudiantes;
	}

	public ActNumeroEstudiante addActNumeroEstudiante(ActNumeroEstudiante actNumeroEstudiante) {
		getActNumeroEstudiantes().add(actNumeroEstudiante);
		actNumeroEstudiante.setActFormulario(this);

		return actNumeroEstudiante;
	}

	public ActNumeroEstudiante removeActNumeroEstudiante(ActNumeroEstudiante actNumeroEstudiante) {
		getActNumeroEstudiantes().remove(actNumeroEstudiante);
		actNumeroEstudiante.setActFormulario(null);

		return actNumeroEstudiante;
	}


	//bi-directional many-to-one association to ActNumeroParalelo
	@OneToMany(mappedBy="actFormulario")
	public List<ActNumeroParalelo> getActNumeroParalelos() {
		return this.actNumeroParalelos;
	}

	public void setActNumeroParalelos(List<ActNumeroParalelo> actNumeroParalelos) {
		this.actNumeroParalelos = actNumeroParalelos;
	}

	public ActNumeroParalelo addActNumeroParalelo(ActNumeroParalelo actNumeroParalelo) {
		getActNumeroParalelos().add(actNumeroParalelo);
		actNumeroParalelo.setActFormulario(this);

		return actNumeroParalelo;
	}

	public ActNumeroParalelo removeActNumeroParalelo(ActNumeroParalelo actNumeroParalelo) {
		getActNumeroParalelos().remove(actNumeroParalelo);
		actNumeroParalelo.setActFormulario(null);

		return actNumeroParalelo;
	}


	//bi-directional many-to-one association to ActPromedioEstudiante
	@OneToMany(mappedBy="actFormulario")
	public List<ActPromedioEstudiante> getActPromedioEstudiantes() {
		return this.actPromedioEstudiantes;
	}

	public void setActPromedioEstudiantes(List<ActPromedioEstudiante> actPromedioEstudiantes) {
		this.actPromedioEstudiantes = actPromedioEstudiantes;
	}

	public ActPromedioEstudiante addActPromedioEstudiante(ActPromedioEstudiante actPromedioEstudiante) {
		getActPromedioEstudiantes().add(actPromedioEstudiante);
		actPromedioEstudiante.setActFormulario(this);

		return actPromedioEstudiante;
	}

	public ActPromedioEstudiante removeActPromedioEstudiante(ActPromedioEstudiante actPromedioEstudiante) {
		getActPromedioEstudiantes().remove(actPromedioEstudiante);
		actPromedioEstudiante.setActFormulario(null);

		return actPromedioEstudiante;
	}


	//bi-directional many-to-one association to ActRecursoDigital
	@OneToMany(mappedBy="actFormulario")
	public List<ActRecursoDigital> getActRecursoDigitals() {
		return this.actRecursoDigitals;
	}

	public void setActRecursoDigitals(List<ActRecursoDigital> actRecursoDigitals) {
		this.actRecursoDigitals = actRecursoDigitals;
	}

	public ActRecursoDigital addActRecursoDigital(ActRecursoDigital actRecursoDigital) {
		getActRecursoDigitals().add(actRecursoDigital);
		actRecursoDigital.setActFormulario(this);

		return actRecursoDigital;
	}

	public ActRecursoDigital removeActRecursoDigital(ActRecursoDigital actRecursoDigital) {
		getActRecursoDigitals().remove(actRecursoDigital);
		actRecursoDigital.setActFormulario(null);

		return actRecursoDigital;
	}


	//bi-directional many-to-one association to ActTalentoHumano
	@OneToMany(mappedBy="actFormulario", fetch=FetchType.EAGER)
	public List<ActTalentoHumano> getActTalentoHumanos() {
		return this.actTalentoHumanos;
	}

	public void setActTalentoHumanos(List<ActTalentoHumano> actTalentoHumanos) {
		this.actTalentoHumanos = actTalentoHumanos;
	}

	public ActTalentoHumano addActTalentoHumano(ActTalentoHumano actTalentoHumano) {
		getActTalentoHumanos().add(actTalentoHumano);
		actTalentoHumano.setActFormulario(this);

		return actTalentoHumano;
	}

	public ActTalentoHumano removeActTalentoHumano(ActTalentoHumano actTalentoHumano) {
		getActTalentoHumanos().remove(actTalentoHumano);
		actTalentoHumano.setActFormulario(null);

		return actTalentoHumano;
	}

	@Column(name="FECHA_LEVANTAMIENTO_MILL")
	public Long getLevantamientoMilisegundos() {
		return levantamientoMilisegundos;
	}


	public void setLevantamientoMilisegundos(Long levantamientoMilisegundos) {
		this.levantamientoMilisegundos = levantamientoMilisegundos;
	}

	@Column(name="TIENE_INTERNET_ADMIN")
	public Integer getTieneInternetAdministrativo() {
		return tieneInternetAdministrativo;
	}


	public void setTieneInternetAdministrativo(Integer tieneInternetAdministrativo) {
		this.tieneInternetAdministrativo = tieneInternetAdministrativo;
	}

	
	@Column(name="TIENE_INTERNET_BIBLIOTECA")
	public Integer getTieneInternetBiblioteca() {
		return tieneInternetBiblioteca;
	}


	public void setTieneInternetBiblioteca(Integer tieneInternetBiblioteca) {
		this.tieneInternetBiblioteca = tieneInternetBiblioteca;
	}

	@Column(name="NUMERO_IMPRE_BIBLIOTECA")
	public Integer getNumeroImpresorasBiblioteca() {
		return numeroImpresorasBiblioteca;
	}


	public void setNumeroImpresorasBiblioteca(Integer numeroImpresorasBiblioteca) {
		this.numeroImpresorasBiblioteca = numeroImpresorasBiblioteca;
	}

	
	@Column(name="NUMERO_IMPRE_ADMINISTRATIVO")
	public Integer getNumeroImpresorasAdministrativo() {
		return numeroImpresorasAdministrativo;
	}


	public void setNumeroImpresorasAdministrativo(Integer numeroImpresorasAdministrativo) {
		this.numeroImpresorasAdministrativo = numeroImpresorasAdministrativo;
	}

	@OneToMany(mappedBy="formulario")
	public List<ActMesParametrizadoFormulario> getActMesesParametrizadosFormularios() {
		return actMesesParametrizadosFormularios;
	}


	public void setActMesesParametrizadosFormularios(
			List<ActMesParametrizadoFormulario> actMesesParametrizadosFormularios) {
		this.actMesesParametrizadosFormularios = actMesesParametrizadosFormularios;
	}


	@Column(name="NUMERO_PROYECTORES_ADMIN")
	public Integer getNumeroProyectoresAdministrativo() {
		return numeroProyectoresAdministrativo;
	}


	public void setNumeroProyectoresAdministrativo(
			Integer numeroProyectoresAdministrativo) {
		this.numeroProyectoresAdministrativo = numeroProyectoresAdministrativo;
	}


	@Column(name="NUMERO_PIZARRAS_ADMIN")
	public Integer getNumeroPizarrasAdministrativo() {
		return numeroPizarrasAdministrativo;
	}


	public void setNumeroPizarrasAdministrativo(Integer numeroPizarrasAdministrativo) {
		this.numeroPizarrasAdministrativo = numeroPizarrasAdministrativo;
	}


	@Column(name="NUMERO_AUDIO_ADMIN")
	public Integer getNumeroAudioAdministrativo() {
		return numeroAudioAdministrativo;
	}


	public void setNumeroAudioAdministrativo(Integer numeroAudioAdministrativo) {
		this.numeroAudioAdministrativo = numeroAudioAdministrativo;
	}


	@Column(name="NUMERO_TELEVISORES_ADMIN")
	public Integer getNumeroTelevisoresAdministrativo() {
		return numeroTelevisoresAdministrativo;
	}


	public void setNumeroTelevisoresAdministrativo(
			Integer numeroTelevisoresAdministrativo) {
		this.numeroTelevisoresAdministrativo = numeroTelevisoresAdministrativo;
	}

}