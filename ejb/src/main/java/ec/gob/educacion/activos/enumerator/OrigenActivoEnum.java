package ec.gob.educacion.activos.enumerator;

public enum OrigenActivoEnum {

	ARCHIVO_CARGADO(0, "Archivo cargado"),
	ONLINE(1, "Online");

	private int codigo;
	private String descripcion;

	private OrigenActivoEnum(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
