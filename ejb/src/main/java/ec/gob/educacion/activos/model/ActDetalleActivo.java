package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACT_DETALLE_ACTIVO database table.
 * 
 */
@Entity
@Table(name="ACT_DETALLE_ACTIVO")
@NamedQuery(name="ActDetalleActivo.findAll", query="SELECT a FROM ActDetalleActivo a")
@Audited
public class ActDetalleActivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoTipo;
	private int estado;
	private Date fechaCreacion;
	private Date fechaResponsable;
	private Long motivoBaja;
	private String observacionBaja;
	private String serial;
	private int tipoCreacion;
	private List<ActArchivoActivo> actArchivoActivos;
	private ActDetalleActivo actDetalleActivo;
	private List<ActDetalleActivo> actDetalleActivos;
	private ActLaboratorioSala actLaboratorioSala;
	private ActResponsable actResponsable;
	private List<ActDetalleGarantia> actDetalleGarantias;
	private List<ActDetalleMantenimiento> actDetalleMantenimientos;
	private String descripcionTipoActivo;

	private String serialActualizado;
	
	private Long codigoMarca;
	private String otraMarca;
	private Double velocidadProcesador;
	private Double memoriaRam;
	private String modelo;
	private Double capacidadDisco;
	private Integer tieneDobleBooteo;
	private Long codigoSOPrincipal;
	private Long codigoSOSecundario;
	private Long codigoProcedenciaActivo;
	private Long codigoEstadoActivo;

	public ActDetalleActivo() {
	}


	@Id
	@SequenceGenerator(name="ACT_DETALLE_ACTIVO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_DETALLE_ACTIVO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_DETALLE_ACTIVO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_TIPO")
	public long getCodigoTipo() {
		return this.codigoTipo;
	}

	public void setCodigoTipo(long codigoTipo) {
		this.codigoTipo = codigoTipo;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_RESPONSABLE")
	public Date getFechaResponsable() {
		return fechaResponsable;
	}


	public void setFechaResponsable(Date fechaResponsable) {
		this.fechaResponsable = fechaResponsable;
	}


	@Column(name="MOTIVO_BAJA")
	public Long getMotivoBaja() {
		return this.motivoBaja;
	}

	public void setMotivoBaja(Long motivoBaja) {
		this.motivoBaja = motivoBaja;
	}


	@Column(name="OBSERVACION_BAJA")
	public String getObservacionBaja() {
		return this.observacionBaja;
	}

	public void setObservacionBaja(String observacionBaja) {
		this.observacionBaja = observacionBaja;
	}


	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}


	@Column(name="TIPO_CREACION")
	public int getTipoCreacion() {
		return tipoCreacion;
	}


	public void setTipoCreacion(int tipoCreacion) {
		this.tipoCreacion = tipoCreacion;
	}


	//bi-directional many-to-one association to ActArchivoActivo
	@OneToMany(mappedBy="actDetalleActivo")
	public List<ActArchivoActivo> getActArchivoActivos() {
		return this.actArchivoActivos;
	}

	public void setActArchivoActivos(List<ActArchivoActivo> actArchivoActivos) {
		this.actArchivoActivos = actArchivoActivos;
	}

	public ActArchivoActivo addActArchivoActivo(ActArchivoActivo actArchivoActivo) {
		getActArchivoActivos().add(actArchivoActivo);
		actArchivoActivo.setActDetalleActivo(this);

		return actArchivoActivo;
	}

	public ActArchivoActivo removeActArchivoActivo(ActArchivoActivo actArchivoActivo) {
		getActArchivoActivos().remove(actArchivoActivo);
		actArchivoActivo.setActDetalleActivo(null);

		return actArchivoActivo;
	}


	//bi-directional many-to-one association to ActDetalleActivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_PADRE")
	public ActDetalleActivo getActDetalleActivo() {
		return this.actDetalleActivo;
	}

	public void setActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		this.actDetalleActivo = actDetalleActivo;
	}


	//bi-directional many-to-one association to ActDetalleActivo
	@OneToMany(mappedBy="actDetalleActivo")
	public List<ActDetalleActivo> getActDetalleActivos() {
		return this.actDetalleActivos;
	}

	public void setActDetalleActivos(List<ActDetalleActivo> actDetalleActivos) {
		this.actDetalleActivos = actDetalleActivos;
	}

	public ActDetalleActivo addActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().add(actDetalleActivo);
		actDetalleActivo.setActDetalleActivo(this);

		return actDetalleActivo;
	}

	public ActDetalleActivo removeActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().remove(actDetalleActivo);
		actDetalleActivo.setActDetalleActivo(null);

		return actDetalleActivo;
	}


	//bi-directional many-to-one association to ActLaboratorioSala
	@ManyToOne()
	@JoinColumn(name="ID_ALS")
	public ActLaboratorioSala getActLaboratorioSala() {
		return this.actLaboratorioSala;
	}

	public void setActLaboratorioSala(ActLaboratorioSala actLaboratorioSala) {
		this.actLaboratorioSala = actLaboratorioSala;
	}


	//bi-directional many-to-one association to ActResponsable
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ARS")
	public ActResponsable getActResponsable() {
		return this.actResponsable;
	}

	public void setActResponsable(ActResponsable actResponsable) {
		this.actResponsable = actResponsable;
	}


	//bi-directional many-to-one association to ActDetalleGarantia
	@OneToMany(mappedBy="actDetalleActivo")
	public List<ActDetalleGarantia> getActDetalleGarantias() {
		return this.actDetalleGarantias;
	}

	public void setActDetalleGarantias(List<ActDetalleGarantia> actDetalleGarantias) {
		this.actDetalleGarantias = actDetalleGarantias;
	}

	public ActDetalleGarantia addActDetalleGarantia(ActDetalleGarantia actDetalleGarantia) {
		getActDetalleGarantias().add(actDetalleGarantia);
		actDetalleGarantia.setActDetalleActivo(this);

		return actDetalleGarantia;
	}

	public ActDetalleGarantia removeActDetalleGarantia(ActDetalleGarantia actDetalleGarantia) {
		getActDetalleGarantias().remove(actDetalleGarantia);
		actDetalleGarantia.setActDetalleActivo(null);

		return actDetalleGarantia;
	}


	//bi-directional many-to-one association to ActDetalleMantenimiento
	@OneToMany(mappedBy="actDetalleActivo")
	public List<ActDetalleMantenimiento> getActDetalleMantenimientos() {
		return this.actDetalleMantenimientos;
	}

	public void setActDetalleMantenimientos(List<ActDetalleMantenimiento> actDetalleMantenimientos) {
		this.actDetalleMantenimientos = actDetalleMantenimientos;
	}

	public ActDetalleMantenimiento addActDetalleMantenimiento(ActDetalleMantenimiento actDetalleMantenimiento) {
		getActDetalleMantenimientos().add(actDetalleMantenimiento);
		actDetalleMantenimiento.setActDetalleActivo(this);

		return actDetalleMantenimiento;
	}

	public ActDetalleMantenimiento removeActDetalleMantenimiento(ActDetalleMantenimiento actDetalleMantenimiento) {
		getActDetalleMantenimientos().remove(actDetalleMantenimiento);
		actDetalleMantenimiento.setActDetalleActivo(null);

		return actDetalleMantenimiento;
	}

	@Transient
	public String getDescripcionTipoActivo() {
		return descripcionTipoActivo;
	}


	public void setDescripcionTipoActivo(String descripcionTipoActivo) {
		this.descripcionTipoActivo = descripcionTipoActivo;
	}


	@Transient
	public String getSerialActualizado() {
		return serialActualizado;
	}


	public void setSerialActualizado(String serialActualizado) {
		this.serialActualizado = serialActualizado;
	}


	@Column(name="CODIGO_MARCA")
	public Long getCodigoMarca() {
		return codigoMarca;
	}


	public void setCodigoMarca(Long codigoMarca) {
		this.codigoMarca = codigoMarca;
	}


	@Column(name="VELOCIDAD_PROCESADOR")
	public Double getVelocidadProcesador() {
		return velocidadProcesador;
	}


	public void setVelocidadProcesador(Double velocidadProcesador) {
		this.velocidadProcesador = velocidadProcesador;
	}


	@Column(name="MEMORIA_RAM")
	public Double getMemoriaRam() {
		return memoriaRam;
	}


	public void setMemoriaRam(Double memoriaRam) {
		this.memoriaRam = memoriaRam;
	}


	@Column(name="MODELO")
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Column(name="CAPACIDAD_DISCO")
	public Double getCapacidadDisco() {
		return capacidadDisco;
	}


	public void setCapacidadDisco(Double capacidadDisco) {
		this.capacidadDisco = capacidadDisco;
	}


	@Column(name="TIENE_DOBLE_BOOTEO")
	public Integer getTieneDobleBooteo() {
		return tieneDobleBooteo;
	}


	public void setTieneDobleBooteo(Integer tieneDobleBooteo) {
		this.tieneDobleBooteo = tieneDobleBooteo;
	}


	@Column(name="CODIGO_SO_PRINCIPAL")
	public Long getCodigoSOPrincipal() {
		return codigoSOPrincipal;
	}


	public void setCodigoSOPrincipal(Long codigoSOPrincipal) {
		this.codigoSOPrincipal = codigoSOPrincipal;
	}


	@Column(name="CODIGO_SO_SECUNDARIO")
	public Long getCodigoSOSecundario() {
		return codigoSOSecundario;
	}


	public void setCodigoSOSecundario(Long codigoSOSecundario) {
		this.codigoSOSecundario = codigoSOSecundario;
	}

	@Column(name="CODIGO_PROCEDENCIA_ACTIVO")
	public Long getCodigoProcedenciaActivo() {
		return codigoProcedenciaActivo;
	}


	public void setCodigoProcedenciaActivo(Long codigoProcedenciaActivo) {
		this.codigoProcedenciaActivo = codigoProcedenciaActivo;
	}

	@Column(name="OTRA_MARCA")
	public String getOtraMarca() {
		return otraMarca;
	}


	public void setOtraMarca(String otraMarca) {
		this.otraMarca = otraMarca;
	}

	@Column(name="CODIGO_ESTADO_ACTIVO")
	public Long getCodigoEstadoActivo() {
		return codigoEstadoActivo;
	}


	public void setCodigoEstadoActivo(Long codigoEstadoActivo) {
		this.codigoEstadoActivo = codigoEstadoActivo;
	}

}