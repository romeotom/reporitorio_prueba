package ec.gob.educacion.activos.model;

import java.io.Serializable;

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
 * The persistent class for the ACT_MESES_PARAM_FORMULARIO database table.
 * 
 */
@Entity
@Table(name="ACT_MESES_PARAM_FORMULARIO")
@NamedQuery(name="ActMesParametrizadoFormulario.findAll", query="SELECT a FROM ActMesParametrizadoFormulario a")
@Audited
public class ActMesParametrizadoFormulario implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private ActMesParametrizado mesParametrizado;
	private ActFormulario formulario;
	
	

	public ActMesParametrizadoFormulario() {
	}


	@Id
	@SequenceGenerator(name="ACT_MESES_PARAM_FORMULARIO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_MESES_PARAM_FORMULARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_MESES_PARAM_FORMULARIO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_MES_PARAMETRIZADO")
	public ActMesParametrizado getMesParametrizado() {
		return mesParametrizado;
	}


	public void setMesParametrizado(ActMesParametrizado mesParametrizado) {
		this.mesParametrizado = mesParametrizado;
	}


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CODIGO_FORMULARIO")
	public ActFormulario getFormulario() {
		return formulario;
	}


	public void setFormulario(ActFormulario formulario) {
		this.formulario = formulario;
	}

}