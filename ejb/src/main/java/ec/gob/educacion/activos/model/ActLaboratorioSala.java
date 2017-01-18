package ec.gob.educacion.activos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_LABORATORIO_SALA database table.
 * 
 */
@Entity
@Table(name="ACT_LABORATORIO_SALA")
@NamedQuery(name="ActLaboratorioSala.findAll", query="SELECT a FROM ActLaboratorioSala a")
@Audited
public class ActLaboratorioSala implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoTipo;
	private long computadoras;
	private Date fechaCreacion;
	private String implLaboratorios;
	private long impresoras;
	private String nombreTipo;
	private long pizarraInteractiva;
	private long proyectores;
	private long sistemaAudio;
	private int tipoCreacion;
	private List<ActDetalleActivo> actDetalleActivos;
	private ActFormulario actFormulario;
	
	private int tieneInternet;
	private int enUso;
	private String proveedorInternet;
	private Double velocidadNavegacion;

	public ActLaboratorioSala() {
	}


	@Id
	@SequenceGenerator(name="ACT_LABORATORIO_SALA_CODIGO_GENERATOR", sequenceName="SEQ_ACT_LABORATORIO_SALA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_LABORATORIO_SALA_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_TIPO")
	public long getCodigoTipo() {
		return this.codigoTipo;
	}

	public void setCodigoTipo(long codigoTipo) {
		this.codigoTipo = codigoTipo;
	}


	public long getComputadoras() {
		return this.computadoras;
	}

	public void setComputadoras(long computadoras) {
		this.computadoras = computadoras;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Column(name="IMPL_LABORATORIOS")
	public String getImplLaboratorios() {
		return this.implLaboratorios;
	}

	public void setImplLaboratorios(String implLaboratorios) {
		this.implLaboratorios = implLaboratorios;
	}


	public long getImpresoras() {
		return this.impresoras;
	}

	public void setImpresoras(long impresoras) {
		this.impresoras = impresoras;
	}


	@Column(name="NOMBRE_TIPO")
	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


	@Column(name="PIZARRA_INTERACTIVA")
	public long getPizarraInteractiva() {
		return this.pizarraInteractiva;
	}

	public void setPizarraInteractiva(long pizarraInteractiva) {
		this.pizarraInteractiva = pizarraInteractiva;
	}


	public long getProyectores() {
		return this.proyectores;
	}

	public void setProyectores(long proyectores) {
		this.proyectores = proyectores;
	}


	@Column(name="SISTEMA_AUDIO")
	public long getSistemaAudio() {
		return this.sistemaAudio;
	}

	public void setSistemaAudio(long sistemaAudio) {
		this.sistemaAudio = sistemaAudio;
	}


	@Column(name="TIPO_CREACION")
	public int getTipoCreacion() {
		return tipoCreacion;
	}


	public void setTipoCreacion(int tipoCreacion) {
		this.tipoCreacion = tipoCreacion;
	}


	//bi-directional many-to-one association to ActDetalleActivo
	@OneToMany(mappedBy="actLaboratorioSala", fetch=FetchType.EAGER)
	public List<ActDetalleActivo> getActDetalleActivos() {
		return this.actDetalleActivos;
	}

	public void setActDetalleActivos(List<ActDetalleActivo> actDetalleActivos) {
		this.actDetalleActivos = actDetalleActivos;
	}

	public ActDetalleActivo addActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().add(actDetalleActivo);
		actDetalleActivo.setActLaboratorioSala(this);

		return actDetalleActivo;
	}

	public ActDetalleActivo removeActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().remove(actDetalleActivo);
		actDetalleActivo.setActLaboratorioSala(null);

		return actDetalleActivo;
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


	@Column(name="TIENE_INTERNET")
	public int getTieneInternet() {
		return tieneInternet;
	}


	public void setTieneInternet(int tieneInternet) {
		this.tieneInternet = tieneInternet;
	}


	@Column(name="EN_USO")
	public int getEnUso() {
		return enUso;
	}


	public void setEnUso(int enUso) {
		this.enUso = enUso;
	}


	@Column(name="PROVEEDOR_INTERNET")
	public String getProveedorInternet() {
		return proveedorInternet;
	}


	public void setProveedorInternet(String proveedorInternet) {
		this.proveedorInternet = proveedorInternet;
	}


	@Column(name="VELOCIDAD_NAVEGACION")
	public Double getVelocidadNavegacion() {
		return velocidadNavegacion;
	}


	public void setVelocidadNavegacion(Double velocidadNavegacion) {
		this.velocidadNavegacion = velocidadNavegacion;
	}

}