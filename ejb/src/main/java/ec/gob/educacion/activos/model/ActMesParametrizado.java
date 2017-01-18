package ec.gob.educacion.activos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_MESES_PARAMETRIZADOS database table.
 * 
 */
@Entity
@Table(name="ACT_MESES_PARAMETRIZADOS")
@NamedQuery(name="ActMesParametrizado.findAll", query="SELECT a FROM ActMesParametrizado a")
@Audited
public class ActMesParametrizado implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private int anio;
	private ActMes mes;
	
	private String archivoFisico;
	private Date fechaCargaOnLine;
	private Date fechaLevantamiento;
	private boolean existeFormulario;

	public ActMesParametrizado() {
	}


	@Id
	@SequenceGenerator(name="ACT_MESES_PARAMETRIZADOS_CODIGO_GENERATOR", sequenceName="SEQ_ACT_MESES_PARAMETRIZADOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_MESES_PARAMETRIZADOS_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name="ANIO")
	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}

	
	@ManyToOne()
	@JoinColumn(name="CODIGO_MES")
	public ActMes getMes() {
		return mes;
	}


	public void setMes(ActMes mes) {
		this.mes = mes;
	}


	@Transient
	public boolean getExisteFormulario() {
		return existeFormulario;
	}


	public void setExisteFormulario(boolean existeFormulario) {
		this.existeFormulario = existeFormulario;
	}

	@Transient
	public String getArchivoFisico() {
		return archivoFisico;
	}


	public void setArchivoFisico(String archivoFisico) {
		this.archivoFisico = archivoFisico;
	}

	@Transient
	public Date getFechaCargaOnLine() {
		return fechaCargaOnLine;
	}


	public void setFechaCargaOnLine(Date fechaCargaOnLine) {
		this.fechaCargaOnLine = fechaCargaOnLine;
	}

	@Transient
	public Date getFechaLevantamiento() {
		return fechaLevantamiento;
	}


	public void setFechaLevantamiento(Date fechaLevantamiento) {
		this.fechaLevantamiento = fechaLevantamiento;
	}

}