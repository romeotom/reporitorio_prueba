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
 * The persistent class for the INS_CANTON database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_CANTON")
public class InsCanton implements Serializable {

	private static final long serialVersionUID = 3747627184064330830L;
	
	private String codigo;
	private InsProvincia insProvincia;
	private String descripcion;
	private Date fechaCreacion;
	private int estado;
	private List<InsParroquia> insParroquias = new ArrayList<InsParroquia>(0);

	public InsCanton() {
	}

	public InsCanton(String codigo, InsProvincia insProvincia,
			String descripcion, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insProvincia = insProvincia;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsCanton(String codigo, InsProvincia insProvincia,
			String descripcion, Date fechaCreacion, int estado,
			List<InsParroquia> insParroquias) {
		this.codigo = codigo;
		this.insProvincia = insProvincia;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insParroquias = insParroquias;
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
	@JoinColumn(name = "COD_PROVINCIA")
	public InsProvincia getInsProvincia() {
		return this.insProvincia;
	}

	public void setInsProvincia(InsProvincia insProvincia) {
		this.insProvincia = insProvincia;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insCanton")
	public List<InsParroquia> getInsParroquias() {
		return this.insParroquias;
	}

	public void setInsParroquias(List<InsParroquia> insParroquias) {
		this.insParroquias = insParroquias;
	}

}
