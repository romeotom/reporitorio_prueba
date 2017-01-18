package ec.gob.educacion.activos.enumerator;

public enum LaboratorioSalaEnum {

	LABORATORIO_TI(6, "TI", "TI", 1),
	LABORATORIO_INGLES(7, "Inglés", "INGLÉS", 2),
	LABORATORIO_CIENCIAS(8, "Ciencias", "CIENCIAS", 2),
	LABORATORIO_FISICA(9, "Física", "FÍSICA", 2),
	LABORATORIO_QUIMICA(10, "Química", "QUÍMICA", 2),
	SALA_INICIAL(11, "Inicial", "INICIAL", 3),
	SALA_PRIMERO(12, "1", "1RO DE EGB", 3),
	SALA_SEGUNDO(13, "2", "2DO DE EGB", 3),
	SALA_TERCERO(14, "3", "3RO DE EGB", 3),
	SALA_CUARTO(15, "4", "4TO DE EGB", 3),
	SALA_QUINTO(16, "5", "5TO DE EGB", 3),
	SALA_SEXTO(17, "6", "6TO DE EGB", 3),
	SALA_SEPTIMO(18, "7", "7MO DE EGB", 3),
	SALA_OCTAVO(19, "8", "8VO DE EGB", 3),
	SALA_NOVENO(20, "9", "9NO DE EGB", 3),
	SALA_DECIMO(21, "10", "10MO DE EGB", 3),
	SALA_PRIMERO_BCH(22, "1B", "1RO DE BACHILLERATO", 3),
	SALA_SEGUNDO_BCH(23, "2B", "2DO DE BACHILLERATO", 3),
	SALA_TERCERO_BCH(24, "3B", "3RO DE BACHILLERATO", 3),
	BIBLIOTECA(25, "Biblioteca", "BIBLIOTECA", 4),
	AREA_ADMINISTRATIVA(26, "Área Administrativa", "ÁREA ADMINISTRATIVA", 5);

	private long codigo;
	private String descripcion;
	private String otherDescripcion;
	private int opcionTipoLaboratorioSala;

	private LaboratorioSalaEnum(long codigo, String descripcion, String otherDescripcion, int opcionTipoLaboratorioSala) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.otherDescripcion = otherDescripcion;
		this.opcionTipoLaboratorioSala = opcionTipoLaboratorioSala;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getOtherDescripcion() {
		return otherDescripcion;
	}

	public int getOpcionTipoLaboratorioSala() {
		return opcionTipoLaboratorioSala;
	}

	public void setOpcionTipoLaboratorioSala(int opcionTipoLaboratorioSala) {
		this.opcionTipoLaboratorioSala = opcionTipoLaboratorioSala;
	}

}
