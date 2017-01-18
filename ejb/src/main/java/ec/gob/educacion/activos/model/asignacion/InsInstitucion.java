package ec.gob.educacion.activos.model.asignacion;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the INS_INSTITUCION database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_INSTITUCION")
public class InsInstitucion implements java.io.Serializable {

	private static final long serialVersionUID = 5805392398266971828L;
	
	private long codigo;
	private InsCirPar insCirPar;
	private String amie;
	private String descripcion;
	private String dpaParroquia;
	private String codigoPostal;
	private String estadoPres;
	private Integer urbano;
	private Date fechaCreacion;
	private int estado;
	private Long codComunidad;
	private Long codJurisdiccion;
	private Long codSostenimiento;
	private Long codTipoInstitucion;
	private Long codRegimen;
	private String actualizado;

	public InsInstitucion() {
	}

	public InsInstitucion(long codigo, String amie, String descripcion,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.amie = amie;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsInstitucion(long codigo, InsCirPar insCirPar, String amie,
			String descripcion, String dpaParroquia, String codigoPostal,
			String estadoPres, Integer urbano, Date fechaCreacion,
			int estado, Long codComunidad,
			Long codJurisdiccion, Long codSostenimiento,
			Long codTipoInstitucion, Long codRegimen,
			String actualizado) {
		this.codigo = codigo;
		this.insCirPar = insCirPar;
		this.amie = amie;
		this.descripcion = descripcion;
		this.dpaParroquia = dpaParroquia;
		this.codigoPostal = codigoPostal;
		this.estadoPres = estadoPres;
		this.urbano = urbano;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.codComunidad = codComunidad;
		this.codJurisdiccion = codJurisdiccion;
		this.codSostenimiento = codSostenimiento;
		this.codTipoInstitucion = codTipoInstitucion;
		this.codRegimen = codRegimen;
		this.actualizado = actualizado;
	}

	@Id
	@Column(name = "CODIGO")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CIR_PAR")
	public InsCirPar getInsCirPar() {
		return this.insCirPar;
	}

	public void setInsCirPar(InsCirPar insCirPar) {
		this.insCirPar = insCirPar;
	}

	@Column(name = "AMIE")
	public String getAmie() {
		return this.amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "DPA_PARROQUIA")
	public String getDpaParroquia() {
		return this.dpaParroquia;
	}

	public void setDpaParroquia(String dpaParroquia) {
		this.dpaParroquia = dpaParroquia;
	}

	@Column(name = "CODIGO_POSTAL")
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Column(name = "ESTADO_PRES")
	public String getEstadoPres() {
		return this.estadoPres;
	}

	public void setEstadoPres(String estadoPres) {
		this.estadoPres = estadoPres;
	}

	@Column(name = "URBANO")
	public Integer getUrbano() {
		return this.urbano;
	}

	public void setUrbano(Integer urbano) {
		this.urbano = urbano;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "ESTADO")
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "COD_COMUNIDAD")
	public Long getCodComunidad() {
		return this.codComunidad;
	}

	public void setCodComunidad(Long codComunidad) {
		this.codComunidad = codComunidad;
	}

	@Column(name = "COD_JURISDICCION")
	public Long getCodJurisdiccion() {
		return this.codJurisdiccion;
	}

	public void setCodJurisdiccion(Long codJurisdiccion) {
		this.codJurisdiccion = codJurisdiccion;
	}

	@Column(name = "COD_SOSTENIMIENTO")
	public Long getCodSostenimiento() {
		return this.codSostenimiento;
	}

	public void setCodSostenimiento(Long codSostenimiento) {
		this.codSostenimiento = codSostenimiento;
	}

	@Column(name = "COD_TIPO_INSTITUCION")
	public Long getCodTipoInstitucion() {
		return this.codTipoInstitucion;
	}

	public void setCodTipoInstitucion(Long codTipoInstitucion) {
		this.codTipoInstitucion = codTipoInstitucion;
	}

	@Column(name = "COD_REGIMEN")
	public Long getCodRegimen() {
		return this.codRegimen;
	}

	public void setCodRegimen(Long codRegimen) {
		this.codRegimen = codRegimen;
	}

	@Column(name = "ACTUALIZADO")
	public String getActualizado() {
		return this.actualizado;
	}

	public void setActualizado(String actualizado) {
		this.actualizado = actualizado;
	}

}
