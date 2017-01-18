package ec.gob.educacion.activos.enumerator;

public enum DetalleActivoEnum {

	COMPUTADORA(1, "Computadora"),
	IMPRESORA(2, "Impresora"),
	PIZARRA_INTERACTIVA(3, "Pizarra Interactiva"),
	PROYECTOR(4, "Proyector"),
	SISTEMA_AUDIO(5, "Sistema Audio");

	private long codigo;
	private String descripcion;

	private DetalleActivoEnum(long codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
