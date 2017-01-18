package ec.gob.educacion.acceso.dto;

public class TipoSedeDTO {
	private String canton;
	private String sede;
	private Integer stsEstado;
	
	public Integer getStsEstado() {
		return stsEstado;
	}

	public void setStsEstado(Integer stsEstado) {
		this.stsEstado = stsEstado;
	}

	public TipoSedeDTO() {
			}
	
	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}


}
