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
 * The persistent class for the ACT_JORNADA_EDUCACION_TI database table.
 * 
 */
@Entity
@Table(name="ACT_JORNADA_EDUCACION_TI")
@NamedQuery(name="ActJornadaEducacionTi.findAll", query="SELECT a FROM ActJornadaEducacionTi a")
@Audited
public class ActJornadaEducacionTi implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private double biologia;
	private double cienciasNaturales;
	private long codigoJornada;
	private long codigoTipoNivel;
	private double fisica;
	private double lenguaExtranjera;
	private double lenguaLiteratura;
	private double matematica;
	private double quimica;
	private ActFormulario actFormulario;

	public ActJornadaEducacionTi() {
	}


	@Id
	@SequenceGenerator(name="ACT_JORNADA_EDUCACION_TI_CODIGO_GENERATOR", sequenceName="SEQ_ACT_JORNADA_EDUCACION_TI", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_JORNADA_EDUCACION_TI_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public double getBiologia() {
		return this.biologia;
	}

	public void setBiologia(double biologia) {
		this.biologia = biologia;
	}


	@Column(name="CIENCIAS_NATURALES")
	public double getCienciasNaturales() {
		return this.cienciasNaturales;
	}

	public void setCienciasNaturales(double cienciasNaturales) {
		this.cienciasNaturales = cienciasNaturales;
	}


	@Column(name="CODIGO_JORNADA")
	public long getCodigoJornada() {
		return this.codigoJornada;
	}

	public void setCodigoJornada(long codigoJornada) {
		this.codigoJornada = codigoJornada;
	}


	@Column(name="CODIGO_TIPO_NIVEL")
	public long getCodigoTipoNivel() {
		return this.codigoTipoNivel;
	}

	public void setCodigoTipoNivel(long codigoTipoNivel) {
		this.codigoTipoNivel = codigoTipoNivel;
	}


	public double getFisica() {
		return this.fisica;
	}

	public void setFisica(double fisica) {
		this.fisica = fisica;
	}


	@Column(name="LENGUA_EXTRANJERA")
	public double getLenguaExtranjera() {
		return this.lenguaExtranjera;
	}

	public void setLenguaExtranjera(double lenguaExtranjera) {
		this.lenguaExtranjera = lenguaExtranjera;
	}


	@Column(name="LENGUA_LITERATURA")
	public double getLenguaLiteratura() {
		return this.lenguaLiteratura;
	}

	public void setLenguaLiteratura(double lenguaLiteratura) {
		this.lenguaLiteratura = lenguaLiteratura;
	}


	public double getMatematica() {
		return this.matematica;
	}

	public void setMatematica(double matematica) {
		this.matematica = matematica;
	}


	public double getQuimica() {
		return this.quimica;
	}

	public void setQuimica(double quimica) {
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