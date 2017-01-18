package ec.gob.educacion.activos.model.asignacion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the INS_MODALIDAD database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_MODALIDAD")
public class InsModalidad implements Serializable {

	private static final long serialVersionUID = -4375328147527624051L;
	
	private long codigo;
	private String descripcion;
	private String nemonico;
	private Date fechaCreacion;
	private int estado;

	public InsModalidad() {
	}

	public InsModalidad(long codigo, String descripcion,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsModalidad(long codigo, String descripcion, String nemonico,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nemonico = nemonico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	@Id
	@Column(name = "CODIGO")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "NEMONICO")
	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
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

}
