package ec.gob.educacion.activos.model.asignacion;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the INS_ZONA database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_ZONA")
public class InsZona implements Serializable {

	private static final long serialVersionUID = -8691113325533673465L;
	
	private long codigo;
	private String nombre;
	private String descripcion;
	private String codigoSenplades;
	private Date fechaCreacion;
	private int estado;
	private List<InsDistrito> insDistritos = new ArrayList<InsDistrito>(0);

	public InsZona() {
	}

	public InsZona(long codigo, String nombre, String descripcion,
			String codigoSenplades, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsZona(long codigo, String nombre, String descripcion,
			String codigoSenplades, Date fechaCreacion, int estado,
			List<InsDistrito> insDistritos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insDistritos = insDistritos;
	}

	@Id
	@Column(name = "CODIGO")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insZona")
	public List<InsDistrito> getInsDistritos() {
		return this.insDistritos;
	}

	public void setInsDistritos(List<InsDistrito> insDistritos) {
		this.insDistritos = insDistritos;
	}

}
