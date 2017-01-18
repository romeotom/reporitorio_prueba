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
 * The persistent class for the ACT_NUMERO_PARALELOS database table.
 * 
 */
@Entity
@Table(name="ACT_NUMERO_PARALELOS")
@NamedQuery(name="ActNumeroParalelo.findAll", query="SELECT a FROM ActNumeroParalelo a")
@Audited
public class ActNumeroParalelo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoJornada;
	private Long cuarto;
	private Long decimo;
	private Long inicial;
	private Long noveno;
	private Long octavo;
	private Long primero;
	private Long primeroBch;
	private Long quinto;
	private Long segundo;
	private Long segundoBch;
	private Long septimo;
	private Long sexto;
	private Long tercero;
	private Long terceroBch;
	private ActFormulario actFormulario;

	public ActNumeroParalelo() {
	}


	@Id
	@SequenceGenerator(name="ACT_NUMERO_PARALELOS_CODIGO_GENERATOR", sequenceName="SEQ_ACT_NUMERO_PARALELOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_NUMERO_PARALELOS_CODIGO_GENERATOR")
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


	public Long getCuarto() {
		return this.cuarto;
	}

	public void setCuarto(Long cuarto) {
		this.cuarto = cuarto;
	}


	public Long getDecimo() {
		return this.decimo;
	}

	public void setDecimo(Long decimo) {
		this.decimo = decimo;
	}


	public Long getInicial() {
		return this.inicial;
	}

	public void setInicial(Long inicial) {
		this.inicial = inicial;
	}


	public Long getNoveno() {
		return this.noveno;
	}

	public void setNoveno(Long noveno) {
		this.noveno = noveno;
	}


	public Long getOctavo() {
		return this.octavo;
	}

	public void setOctavo(Long octavo) {
		this.octavo = octavo;
	}


	public Long getPrimero() {
		return this.primero;
	}

	public void setPrimero(Long primero) {
		this.primero = primero;
	}


	@Column(name="PRIMERO_BCH")
	public Long getPrimeroBch() {
		return this.primeroBch;
	}

	public void setPrimeroBch(Long primeroBch) {
		this.primeroBch = primeroBch;
	}


	public Long getQuinto() {
		return this.quinto;
	}

	public void setQuinto(Long quinto) {
		this.quinto = quinto;
	}


	public Long getSegundo() {
		return this.segundo;
	}

	public void setSegundo(Long segundo) {
		this.segundo = segundo;
	}


	@Column(name="SEGUNDO_BCH")
	public Long getSegundoBch() {
		return this.segundoBch;
	}

	public void setSegundoBch(Long segundoBch) {
		this.segundoBch = segundoBch;
	}


	public Long getSeptimo() {
		return this.septimo;
	}

	public void setSeptimo(Long septimo) {
		this.septimo = septimo;
	}


	public Long getSexto() {
		return this.sexto;
	}

	public void setSexto(Long sexto) {
		this.sexto = sexto;
	}


	public Long getTercero() {
		return this.tercero;
	}

	public void setTercero(Long tercero) {
		this.tercero = tercero;
	}


	@Column(name="TERCERO_BCH")
	public Long getTerceroBch() {
		return this.terceroBch;
	}

	public void setTerceroBch(Long terceroBch) {
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