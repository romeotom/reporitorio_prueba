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
 * The persistent class for the ACT_RECURSO_DIGITAL database table.
 * 
 */
@Entity
@Table(name="ACT_RECURSO_DIGITAL")
@NamedQuery(name="ActRecursoDigital.findAll", query="SELECT a FROM ActRecursoDigital a")
@Audited
public class ActRecursoDigital implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long biologia;
	private long cienciasNaturales;
	private long codigoTipoRecurso;
	private long fisica;
	private long lenguaExtranjera;
	private long lenguaLiteratura;
	private long matematica;
	private long quimica;
	private ActFormulario actFormulario;

	public ActRecursoDigital() {
	}


	@Id
	@SequenceGenerator(name="ACT_RECURSO_DIGITAL_CODIGO_GENERATOR", sequenceName="SEQ_ACT_RECURSO_DIGITAL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_RECURSO_DIGITAL_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public long getBiologia() {
		return this.biologia;
	}

	public void setBiologia(long biologia) {
		this.biologia = biologia;
	}


	@Column(name="CIENCIAS_NATURALES")
	public long getCienciasNaturales() {
		return this.cienciasNaturales;
	}

	public void setCienciasNaturales(long cienciasNaturales) {
		this.cienciasNaturales = cienciasNaturales;
	}


	@Column(name="CODIGO_TIPO_RECURSO")
	public long getCodigoTipoRecurso() {
		return this.codigoTipoRecurso;
	}

	public void setCodigoTipoRecurso(long codigoTipoRecurso) {
		this.codigoTipoRecurso = codigoTipoRecurso;
	}


	public long getFisica() {
		return this.fisica;
	}

	public void setFisica(long fisica) {
		this.fisica = fisica;
	}


	@Column(name="LENGUA_EXTRANJERA")
	public long getLenguaExtranjera() {
		return this.lenguaExtranjera;
	}

	public void setLenguaExtranjera(long lenguaExtranjera) {
		this.lenguaExtranjera = lenguaExtranjera;
	}


	@Column(name="LENGUA_LITERATURA")
	public long getLenguaLiteratura() {
		return this.lenguaLiteratura;
	}

	public void setLenguaLiteratura(long lenguaLiteratura) {
		this.lenguaLiteratura = lenguaLiteratura;
	}


	public long getMatematica() {
		return this.matematica;
	}

	public void setMatematica(long matematica) {
		this.matematica = matematica;
	}


	public long getQuimica() {
		return this.quimica;
	}

	public void setQuimica(long quimica) {
		this.quimica = quimica;
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