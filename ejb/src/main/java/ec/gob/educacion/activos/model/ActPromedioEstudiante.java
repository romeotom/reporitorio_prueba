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
 * The persistent class for the ACT_PROMEDIO_ESTUDIANTES database table.
 * 
 */
@Entity
@Table(name="ACT_PROMEDIO_ESTUDIANTES")
@NamedQuery(name="ActPromedioEstudiante.findAll", query="SELECT a FROM ActPromedioEstudiante a")
@Audited
public class ActPromedioEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoJornada;
	private long cuarto;
	private long decimo;
	private long inicial;
	private long noveno;
	private long octavo;
	private long primero;
	private long primeroBch;
	private long quinto;
	private long segundo;
	private long segundoBch;
	private long septimo;
	private long sexto;
	private long tercero;
	private long terceroBch;
	private ActFormulario actFormulario;

	public ActPromedioEstudiante() {
	}


	@Id
	@SequenceGenerator(name="ACT_PROMEDIO_ESTUDIANTES_CODIGO_GENERATOR", sequenceName="SEQ_ACT_PROMEDIO_ESTUDIANTES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_PROMEDIO_ESTUDIANTES_CODIGO_GENERATOR")
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


	public long getCuarto() {
		return this.cuarto;
	}

	public void setCuarto(long cuarto) {
		this.cuarto = cuarto;
	}


	public long getDecimo() {
		return this.decimo;
	}

	public void setDecimo(long decimo) {
		this.decimo = decimo;
	}


	public long getInicial() {
		return this.inicial;
	}

	public void setInicial(long inicial) {
		this.inicial = inicial;
	}


	public long getNoveno() {
		return this.noveno;
	}

	public void setNoveno(long noveno) {
		this.noveno = noveno;
	}


	public long getOctavo() {
		return this.octavo;
	}

	public void setOctavo(long octavo) {
		this.octavo = octavo;
	}


	public long getPrimero() {
		return this.primero;
	}

	public void setPrimero(long primero) {
		this.primero = primero;
	}


	@Column(name="PRIMERO_BCH")
	public long getPrimeroBch() {
		return this.primeroBch;
	}

	public void setPrimeroBch(long primeroBch) {
		this.primeroBch = primeroBch;
	}


	public long getQuinto() {
		return this.quinto;
	}

	public void setQuinto(long quinto) {
		this.quinto = quinto;
	}


	public long getSegundo() {
		return this.segundo;
	}

	public void setSegundo(long segundo) {
		this.segundo = segundo;
	}


	@Column(name="SEGUNDO_BCH")
	public long getSegundoBch() {
		return this.segundoBch;
	}

	public void setSegundoBch(long segundoBch) {
		this.segundoBch = segundoBch;
	}


	public long getSeptimo() {
		return this.septimo;
	}

	public void setSeptimo(long septimo) {
		this.septimo = septimo;
	}


	public long getSexto() {
		return this.sexto;
	}

	public void setSexto(long sexto) {
		this.sexto = sexto;
	}


	public long getTercero() {
		return this.tercero;
	}

	public void setTercero(long tercero) {
		this.tercero = tercero;
	}


	@Column(name="TERCERO_BCH")
	public long getTerceroBch() {
		return this.terceroBch;
	}

	public void setTerceroBch(long terceroBch) {
		this.terceroBch = terceroBch;
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