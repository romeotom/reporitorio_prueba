package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_ARCHIVO_ACTIVO database table.
 * 
 */
@Entity
@Table(name="ACT_ARCHIVO_ACTIVO")
@NamedQuery(name="ActArchivoActivo.findAll", query="SELECT a FROM ActArchivoActivo a")
@Audited
public class ActArchivoActivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String descripcion;
	private String idArchivo;
	private int tipo;
	private ActDetalleActivo actDetalleActivo;

	public ActArchivoActivo() {
	}


	@Id
	@SequenceGenerator(name="ACT_ARCHIVO_ACTIVO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_ARCHIVO_ACTIVO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_ARCHIVO_ACTIVO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="ID_ARCHIVO")
	public String getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(String idArchivo) {
		this.idArchivo = idArchivo;
	}


	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to ActDetalleActivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ADA")
	public ActDetalleActivo getActDetalleActivo() {
		return this.actDetalleActivo;
	}

	public void setActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		this.actDetalleActivo = actDetalleActivo;
	}

}