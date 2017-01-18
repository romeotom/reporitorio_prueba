package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;


/**
 * The persistent class for the ACT_DETALLE_MANTENIMIENTO database table.
 * 
 */
@Entity
@Table(name="ACT_DETALLE_MANTENIMIENTO")
@NamedQuery(name="ActDetalleMantenimiento.findAll", query="SELECT a FROM ActDetalleMantenimiento a")
@Audited
public class ActDetalleMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String descripcion;
	private Date fecha;
	private ActDetalleActivo actDetalleActivo;

	public ActDetalleMantenimiento() {
	}


	@Id
	@SequenceGenerator(name="ACT_DETALLE_MANTENIMIENTO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_DETALLE_MANTENIMIENTO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_DETALLE_MANTENIMIENTO_CODIGO_GENERATOR")
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


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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