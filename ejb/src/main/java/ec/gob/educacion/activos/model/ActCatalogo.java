package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.List;


/**
 * The persistent class for the ACT_CATALOGO database table.
 * 
 */
@Entity
@Table(name="ACT_CATALOGO")
@NamedQuery(name="ActCatalogo.findAll", query="SELECT a FROM ActCatalogo a")
@Audited
public class ActCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String descripcion;
	private String nemonico;
	private List<ActItemCatalogo> actItemCatalogos;

	public ActCatalogo() {
	}


	@Id
	@SequenceGenerator(name="ACT_CATALOGO_CODIGO_GENERATOR", sequenceName="SEQ_ACT_CATALOGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_CATALOGO_CODIGO_GENERATOR")
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


	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}


	//bi-directional many-to-one association to ActItemCatalogo
	@OneToMany(mappedBy="actCatalogo")
	public List<ActItemCatalogo> getActItemCatalogos() {
		return this.actItemCatalogos;
	}

	public void setActItemCatalogos(List<ActItemCatalogo> actItemCatalogos) {
		this.actItemCatalogos = actItemCatalogos;
	}

	public ActItemCatalogo addActItemCatalogo(ActItemCatalogo actItemCatalogo) {
		getActItemCatalogos().add(actItemCatalogo);
		actItemCatalogo.setActCatalogo(this);

		return actItemCatalogo;
	}

	public ActItemCatalogo removeActItemCatalogo(ActItemCatalogo actItemCatalogo) {
		getActItemCatalogos().remove(actItemCatalogo);
		actItemCatalogo.setActCatalogo(null);

		return actItemCatalogo;
	}

}