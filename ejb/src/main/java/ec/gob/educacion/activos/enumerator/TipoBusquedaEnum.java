package ec.gob.educacion.activos.enumerator;

public enum TipoBusquedaEnum {
	
	IDENTIFICACION(0, "Identificación del Responsable"), 	 
	RESPONSABLE_NOMBRE(1, "Nombres del Responsable"),
	SERIAL_ACTIVO(2, "Serial del Activo");

	private int codigo;
	private String descripcion;

	private TipoBusquedaEnum(int codigo, String descripcion) {
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
