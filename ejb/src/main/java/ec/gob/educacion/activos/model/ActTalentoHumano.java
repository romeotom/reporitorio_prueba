package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_TALENTO_HUMANO database table.
 * 
 */
@Entity
@Table(name="ACT_TALENTO_HUMANO")
@NamedQuery(name="ActTalentoHumano.findAll", query="SELECT a FROM ActTalentoHumano a")
@Audited
public class ActTalentoHumano implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String apellido;
	private long codigoCargo;
	private String contactoDos;
	private String contactoUno;
	private String email;
	private String nombre;
	private String nombreCargo;
	private ActFormulario actFormulario;

	public ActTalentoHumano() {
	}


	@Id
	@SequenceGenerator(name="ACT_TALENTO_HUMANO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_TALENTO_HUMANO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_TALENTO_HUMANO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Column(name="CODIGO_CARGO")
	public long getCodigoCargo() {
		return this.codigoCargo;
	}

	public void setCodigoCargo(long codigoCargo) {
		this.codigoCargo = codigoCargo;
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


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="NOMBRE_CARGO")
	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}


	//bi-directional many-to-one association to ActFormulario
	@ManyToOne()
	@JoinColumn(name="ID_AFR")
	public ActFormulario getActFormulario() {
		return this.actFormulario;
	}

	public void setActFormulario(ActFormulario actFormulario) {
		this.actFormulario = actFormulario;
	}

}