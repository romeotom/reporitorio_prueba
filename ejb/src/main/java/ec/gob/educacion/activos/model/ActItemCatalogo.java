package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the ACT_ITEM_CATALOGO database table.
 * 
 */
@Entity
@Table(name="ACT_ITEM_CATALOGO")
@NamedQuery(name="ActItemCatalogo.findAll", query="SELECT a FROM ActItemCatalogo a")
@Audited
public class ActItemCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String descripcion;
	private ActCatalogo actCatalogo;

	public ActItemCatalogo() {
	}


	@Id
	@SequenceGenerator(name="ACT_ITEM_CATALOGO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_ITEM_CATALOGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_ITEM_CATALOGO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to ActCatalogo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ACA")
	public ActCatalogo getActCatalogo() {
		return this.actCatalogo;
	}

	public void setActCatalogo(ActCatalogo actCatalogo) {
		this.actCatalogo = actCatalogo;
	}

}