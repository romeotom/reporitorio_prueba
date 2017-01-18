package ec.gob.educacion.activos.enumerator;

public enum TipoCargaArchivoEnum {

	ORIGINAL(0, "Original"),
	SUSTITUTIVA(1, "Sustitutiva");

	private int codigo;
	private String descripcion;

	private TipoCargaArchivoEnum(int codigo, String descripcion) {
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
