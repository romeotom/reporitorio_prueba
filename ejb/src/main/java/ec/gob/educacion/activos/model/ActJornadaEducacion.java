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
 * The persistent class for the ACT_JORNADA_EDUCACION database table.
 * 
 */
@Entity
@Table(name="ACT_JORNADA_EDUCACION")
@NamedQuery(name="ActJornadaEducacion.findAll", query="SELECT a FROM ActJornadaEducacion a")
@Audited
public class ActJornadaEducacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private double bachillerato;
	private double basica;
	private long codigoJornada;
	private double inicial;
	private double total;
	private ActFormulario actFormulario;

	public ActJornadaEducacion() {
	}


	@Id
	@SequenceGenerator(name="ACT_JORNADA_EDUCACION_CODIGO_GENERATOR", sequenceName="SEQ_ACT_JORNADA_EDUCACION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_JORNADA_EDUCACION_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public double getBachillerato() {
		return this.bachillerato;
	}

	public void setBachillerato(double bachillerato) {
		this.bachillerato = bachillerato;
	}


	public double getBasica() {
		return this.basica;
	}

	public void setBasica(double basica) {
		this.basica = basica;
	}


	@Column(name="CODIGO_JORNADA")
	public long getCodigoJornada() {
		return this.codigoJornada;
	}

	public void setCodigoJornada(long codigoJornada) {
		this.codigoJornada = codigoJornada;
	}


	public double getInicial() {
		return this.inicial;
	}

	public void setInicial(double inicial) {
		this.inicial = inicial;
	}


	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
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