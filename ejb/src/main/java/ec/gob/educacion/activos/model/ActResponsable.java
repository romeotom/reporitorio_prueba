package ec.gob.educacion.activos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_RESPONSABLE database table.
 * 
 */
@Entity
@Table(name="ACT_RESPONSABLE")
@NamedQuery(name="ActResponsable.findAll", query="SELECT a FROM ActResponsable a")
@Audited
public class ActResponsable implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private long codigoInstitucion;
	private String contactoDos;
	private String contactoUno;
	private String email;
	private int estado;
	private String identificacion;
	private String nombre;
	private List<ActDetalleActivo> actDetalleActivos;

	public ActResponsable() {
	}


	@Id
	@SequenceGenerator(name="ACT_RESPONSABLE_CODIGO_GENERATOR", sequenceName="SEQ_ACT_RESPONSABLE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_RESPONSABLE_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="CODIGO_INSTITUCION")
	public long getCodigoInstitucion() {
		return this.codigoInstitucion;
	}

	public void setCodigoInstitucion(long codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}


	@Column(name="CONTACTO_DOS")
	public String getContactoDos() {
		return this.contactoDos;
	}

	public void setContactoDos(String contactoDos) {
		this.contactoDos = contactoDos;
	}


	@Column(name="CONTACTO_UNO")
	public String getContactoUno() {
		return this.contactoUno;
	}

	public void setContactoUno(String contactoUno) {
		this.contactoUno = contactoUno;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to ActDetalleActivo
	@OneToMany(mappedBy="actResponsable")
	public List<ActDetalleActivo> getActDetalleActivos() {
		return this.actDetalleActivos;
	}

	public void setActDetalleActivos(List<ActDetalleActivo> actDetalleActivos) {
		this.actDetalleActivos = actDetalleActivos;
	}

	public ActDetalleActivo addActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().add(actDetalleActivo);
		actDetalleActivo.setActResponsable(this);

		return actDetalleActivo;
	}

	public ActDetalleActivo removeActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		getActDetalleActivos().remove(actDetalleActivo);
		actDetalleActivo.setActResponsable(null);

		return actDetalleActivo;
	}

}