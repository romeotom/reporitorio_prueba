package ec.gob.educacion.activos.model.asignacion;

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
 * The persistent class for the INS_CIR_PAR database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_CIR_PAR")
public class InsCirPar implements java.io.Serializable {

	private static final long serialVersionUID = -6346986647230564583L;
	
	private long codigo;
	private InsParroquia insParroquia;
	private InsCircuito insCircuito;
	private Date fechaCreacion;
	private int estado;
	private String parroquia;
	private List<InsInstitucion> insInstitucions = new ArrayList<InsInstitucion>(0);

	public InsCirPar() {
	}

	public InsCirPar(long codigo, InsParroquia insParroquia,
			InsCircuito insCircuito, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insParroquia = insParroquia;
		this.insCircuito = insCircuito;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsCirPar(long codigo, InsParroquia insParroquia,
			InsCircuito insCircuito, Date fechaCreacion, int estado,
			String parroquia, List<InsInstitucion> insInstitucions) {
		this.codigo = codigo;
		this.insParroquia = insParroquia;
		this.insCircuito = insCircuito;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.parroquia = parroquia;
		this.insInstitucions = insInstitucions;
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
	@JoinColumn(name = "COD_PARROQUIA")
	public InsParroquia getInsParroquia() {
		return this.insParroquia;
	}

	public void setInsParroquia(InsParroquia insParroquia) {
		this.insParroquia = insParroquia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CIRCUITO")
	public InsCircuito getInsCircuito() {
		return this.insCircuito;
	}

	public void setInsCircuito(InsCircuito insCircuito) {
		this.insCircuito = insCircuito;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insCirPar")
	public List<InsInstitucion> getInsInstitucions() {
		return this.insInstitucions;
	}

	public void setInsInstitucions(List<InsInstitucion> insInstitucions) {
		this.insInstitucions = insInstitucions;
	}

}
