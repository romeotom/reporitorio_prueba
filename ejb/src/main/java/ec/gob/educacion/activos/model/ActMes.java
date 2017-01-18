package ec.gob.educacion.activos.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the ACT_MESES database table.
 * 
 */
@Entity
@Table(name="ACT_MESES")
@NamedQuery(name="ActMes.findAll", query="SELECT a FROM ActMes a")
@Audited
public class ActMes implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String valor;
	private List<ActMesParametrizado> mesesParametrizados;
	private EnumMonth enumMonth;
	private Integer ordenMes;
	
	private boolean mesSeleccionado;
	private boolean deshabilitado;

	public ActMes() {
	}


	@Id
	@SequenceGenerator(name="ACT_MESES_CODIGO_GENERATOR", sequenceName="SEQ_ACT_MESES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACT_MESES_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	@Column(name="VALOR")
	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	@Enumerated(EnumType.STRING)
	@Column(name = "ENUM_MES")
	public EnumMonth getEnumMonth() {
		return enumMonth;
	}


	public void setEnumMonth(EnumMonth enumMonth) {
		this.enumMonth = enumMonth;
	}
	

	@OneToMany(mappedBy="mes", fetch=FetchType.EAGER)
	public List<ActMesParametrizado> getMesesParametrizados() {
		return mesesParametrizados;
	}


	public void setMesesParametrizados(List<ActMesParametrizado> mesesParametrizados) {
		this.mesesParametrizados = mesesParametrizados;
	}
	
	@Transient
	public boolean getMesSeleccionado() {
		mesSeleccionado = false;
		if(this.mesesParametrizados != null && !this.mesesParametrizados.isEmpty() ){
			int anio = Calendar.getInstance().get(Calendar.YEAR);
			for (ActMesParametrizado actMesParametrizado : mesesParametrizados) {
				if(actMesParametrizado.getMes().getCodigo() == this.codigo && actMesParametrizado.getAnio() == anio){
					mesSeleccionado = true;
					break;
				}
			}
		}
		return mesSeleccionado;
	}


	public void setMesSeleccionado(boolean mesSeleccionado) {
		this.mesSeleccionado = mesSeleccionado;
	}

	@Transient
	public boolean getDeshabilitado() {
		return deshabilitado;
	}


	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	@Column(name="ORDEN_MES")
	public Integer getOrdenMes() {
		return ordenMes;
	}


	public void setOrdenMes(Integer ordenMes) {
		this.ordenMes = ordenMes;
	}

	public static enum EnumMonth{
		ENERO,
		FEBRERO,
		MARZO,
		ABRIL,
		MAYO,
		JUNIO,
		JULIO,
		AGOSTO,
		SEPTIEMBRE,
		OCTUBRE,
		NOVIEMBRE,
		DICIEMBRE
	}

}