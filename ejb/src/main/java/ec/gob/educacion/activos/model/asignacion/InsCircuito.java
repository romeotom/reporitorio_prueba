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
 * The persistent class for the INS_CIRCUITO database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_CIRCUITO")
public class InsCircuito implements Serializable {

	private static final long serialVersionUID = -2674872182389049635L;
	
	private long codigo;
	private InsDistrito insDistrito;
	private String descripcion;
	private String codigoSenplades;
	private Date fechaCreacion;
	private int estado;
	private String zona;
	private List<InsCirPar> insCirPars = new ArrayList<InsCirPar>(0);

	public InsCircuito() {
	}

	public InsCircuito(long codigo, InsDistrito insDistrito,
			String descripcion, String codigoSenplades, Date fechaCreacion,
			int estado) {
		this.codigo = codigo;
		this.insDistrito = insDistrito;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsCircuito(long codigo, InsDistrito insDistrito,
			String descripcion, String codigoSenplades, Date fechaCreacion,
			int estado, String zona, List<InsCirPar> insCirPars) {
		this.codigo = codigo;
		this.insDistrito = insDistrito;
		this.descripcion = descripcion;
		this.codigoSenplades = codigoSenplades;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.zona = zona;
		this.insCirPars = insCirPars;
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
	@JoinColumn(name = "COD_DISTRITO")
	public InsDistrito getInsDistrito() {
		return this.insDistrito;
	}

	public void setInsDistrito(InsDistrito insDistrito) {
		this.insDistrito = insDistrito;
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

	@Column(name = "ZONA")
	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insCircuito")
	public List<InsCirPar> getInsCirPars() {
		return this.insCirPars;
	}

	public void setInsCirPars(List<InsCirPar> insCirPars) {
		this.insCirPars = insCirPars;
	}

}
