package ec.gob.educacion.activos.model.asignacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the INS_INC_REGIMEN database table of ASIGNACIONES schema.
 * 
 */
@Entity
@Table(name = "INS_INC_REGIMEN")
public class InsIncRegimen implements Serializable {

	private static final long serialVersionUID = 7161808258215879451L;
	
	private long codigo;
	private String descripcion;
	private String estado;

	public InsIncRegimen() {
	}

	public InsIncRegimen(long codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public InsIncRegimen(long codigo, String descripcion, String estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
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

	@Column(name = "ESTADO")
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
