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
 * The persistent class for the INS_PROVINCIA database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_PROVINCIA")
public class InsProvincia implements Serializable {

	private static final long serialVersionUID = -6435700023400737527L;
	
	private String codigo;
	private String descripcion;
	private String capital;
	private Date fechaCreacion;
	private int estado;
	private List<InsCanton> insCantons = new ArrayList<InsCanton>(0);

	public InsProvincia() {
	}

	public InsProvincia(String codigo, String descripcion, String capital,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.capital = capital;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsProvincia(String codigo, String descripcion, String capital,
			Date fechaCreacion, int estado, List<InsCanton> insCantons) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.capital = capital;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insCantons = insCantons;
	}

	@Id
	@Column(name = "CODIGO")
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "CAPITAL")
	public String getCapital() {
		return this.capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insProvincia")
	public List<InsCanton> getInsCantons() {
		return this.insCantons;
	}

	public void setInsCantons(List<InsCanton> insCantons) {
		this.insCantons = insCantons;
	}

}
