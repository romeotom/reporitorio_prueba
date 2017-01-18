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
 * The persistent class for the INS_PARROQUIA database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_PARROQUIA")
public class InsParroquia implements Serializable {

	private static final long serialVersionUID = -8634115193440670735L;
	
	private String codigo;
	private InsCanton insCanton;
	private String descripcion;
	private String zona;
	private Date fechaCreacion;
	private int estado;
	private String parroquia;
	private List<InsCirPar> insCirPars = new ArrayList<InsCirPar>(0);

	public InsParroquia() {
	}

	public InsParroquia(String codigo, InsCanton insCanton, String descripcion,
			String zona, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insCanton = insCanton;
		this.descripcion = descripcion;
		this.zona = zona;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsParroquia(String codigo, InsCanton insCanton, String descripcion,
			String zona, Date fechaCreacion, int estado, String parroquia,
			List<InsCirPar> insCirPars) {
		this.codigo = codigo;
		this.insCanton = insCanton;
		this.descripcion = descripcion;
		this.zona = zona;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.parroquia = parroquia;
		this.insCirPars = insCirPars;
	}

	@Id
	@Column(name = "CODIGO")
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CANTON")
	public InsCanton getInsCanton() {
		return this.insCanton;
	}

	public void setInsCanton(InsCanton insCanton) {
		this.insCanton = insCanton;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ZONA")
	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
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

	@Column(name = "PARROQUIA")
	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insParroquia")
	public List<InsCirPar> getInsCirPars() {
		return this.insCirPars;
	}

	public void setInsCirPars(List<InsCirPar> insCirPars) {
		this.insCirPars = insCirPars;
	}

}
