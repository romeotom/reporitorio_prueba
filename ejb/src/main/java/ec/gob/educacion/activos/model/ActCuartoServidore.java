package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_CUARTO_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="ACT_CUARTO_SERVIDORES")
@NamedQuery(name="ActCuartoServidore.findAll", query="SELECT a FROM ActCuartoServidore a")
@Audited
public class ActCuartoServidore implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoItem;
	private int disponibilidad;
	private ActFormulario actFormulario;

	public ActCuartoServidore() {
	}


	@Id
	@SequenceGenerator(name="ACT_CUARTO_SERVIDORES_CODIGO_GENERATOR", sequenceName="SEQ_ACT_CUARTO_SERVIDORES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_CUARTO_SERVIDORES_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_ITEM")
	public long getCodigoItem() {
		return this.codigoItem;
	}

	public void setCodigoItem(long codigoItem) {
		this.codigoItem = codigoItem;
	}


	public int getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	//bi-directional many-to-one association to ActFormulario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AFR")
	public ActFormulario getActFormulario() {
		return this.actFormulario;
	}

	public void setActFormulario(ActFormulario actFormulario) {
		this.actFormulario = actFormulario;
	}

}