package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;


/**
 * The persistent class for the ACT_DETALLE_GARANTIA database table.
 * 
 */
@Entity
@Table(name="ACT_DETALLE_GARANTIA")
@NamedQuery(name="ActDetalleGarantia.findAll", query="SELECT a FROM ActDetalleGarantia a")
@Audited
public class ActDetalleGarantia implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoTipoDuracion;
	private long duracion;
	private Date fecha;
	private ActDetalleActivo actDetalleActivo;

	public ActDetalleGarantia() {
	}


	@Id
	@SequenceGenerator(name="ACT_DETALLE_GARANTIA_CODIGO_GENERATOR", sequenceName="SEQ_ACT_DETALLE_GARANTIA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_DETALLE_GARANTIA_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_TIPO_DURACION")
	public long getCodigoTipoDuracion() {
		return this.codigoTipoDuracion;
	}

	public void setCodigoTipoDuracion(long codigoTipoDuracion) {
		this.codigoTipoDuracion = codigoTipoDuracion;
	}


	public long getDuracion() {
		return this.duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
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