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
 * The persistent class for the ACT_NUMERO_ESTUDIANTES database table.
 * 
 */
@Entity
@Table(name="ACT_NUMERO_ESTUDIANTES")
@NamedQuery(name="ActNumeroEstudiante.findAll", query="SELECT a FROM ActNumeroEstudiante a")
@Audited
public class ActNumeroEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoJornada;
	private long numeroHombres;
	private long numeroMujeres;
	private long total;
	private ActFormulario actFormulario;

	public ActNumeroEstudiante() {
	}


	@Id
	@SequenceGenerator(name="ACT_NUMERO_ESTUDIANTES_CODIGO_GENERATOR", sequenceName="SEQ_ACT_NUMERO_ESTUDIANTES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_NUMERO_ESTUDIANTES_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_JORNADA")
	public long getCodigoJornada() {
		return this.codigoJornada;
	}

	public void setCodigoJornada(long codigoJornada) {
		this.codigoJornada = codigoJornada;
	}


	@Column(name="NUMERO_HOMBRES")
	public long getNumeroHombres() {
		return this.numeroHombres;
	}

	public void setNumeroHombres(long numeroHombres) {
		this.numeroHombres = numeroHombres;
	}


	@Column(name="NUMERO_MUJERES")
	public long getNumeroMujeres() {
		return this.numeroMujeres;
	}

	public void setNumeroMujeres(long numeroMujeres) {
		this.numeroMujeres = numeroMujeres;
	}


	public long getTotal() {
		return this.total;
	}

	public void setTotal(long total) {
		this.total = total;
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