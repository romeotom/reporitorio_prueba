package ec.gob.educacion.activos.model.asignacion;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the INS_DISTRITO database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_DISTRITO")
public class InsDistrito implements Serializable {

	private static final long serialVersionUID = -3256161506249988235L;
	
	private long codigo;
	private InsZona insZona;
	private String nombre;
	private String descripcion;
	private String codigoSenplades;
	private Date fechaCreacion;
	private int estado;
	private List<InsCircuito> insCircuitos = new ArrayList<InsCircuito>(0);

	public InsDistrito() {
	}

	public InsDistrito(long codigo, InsZona insZona, String nombre,
			String descripcion, String codigoSenplades, Date fechaCreacion,
			int estado) {
		this.codigo = codigo;
		this.insZona = insZona;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsDistrito(long codigo, InsZona insZona, String nombre,
			String descripcion, String codigoSenplades, Date fechaCreacion,
			int estado, List<InsCircuito> insCircuitos) {
		this.codigo = codigo;
		this.insZona = insZona;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insCircuitos = insCircuitos;
	}

	@Id
	@Column(name = "CODIGO")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_ZONA", nullable = false)
	public InsZona getInsZona() {
		return this.insZona;
	}

	public void setInsZona(InsZona insZona) {
		this.insZona = insZona;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "CODIGO_SENPLADES")
	public String getCodigoSenplades() {
		return this.codigoSenplades;
	}

	public void setCodigoSenplades(String codigoSenplades) {
		this.codigoSenplades = codigoSenplades;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insDistrito")
	public List<InsCircuito> getInsCircuitos() {
		return this.insCircuitos;
	}

	public void setInsCircuitos(List<InsCircuito> insCircuitos) {
		this.insCircuitos = insCircuitos;
	}

}
