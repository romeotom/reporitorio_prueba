package ec.gob.educacion.activos.resources;

public class Constantes {
	
	public static final String UNCHECKED = "unchecked";
	
	//Constantes carga de archivos
	public static final int TAMANIO_MEGA = 1048576;
	public static final int CANTIDAD_MEGA = 2;
	
	//Para acceder remotamente si estan en un mismo servidor
	public static final String URL_SEGURIDADES = "seguridades-educacion-ear/seguridades-educacion-ejb";
	
	// Codigo de Jornada cuando es un total
	public static final long JORNADA_TOTAL = -1l;

	// nemonico de tipo sala laboratorio
	public static final String TIPO_SALA_LAB = "TLS";

	// nemonico de tipo activo
	public static final String TIPO_ACTIVO = "TDA";

	// nemonico de tipo activo
	public static final String TIPO_DURACION = "DRN";

	// nemonico de tipo activo
	public static final String MOTIVO_BAJA = "MDB";

	// nemonico de ubicación de archivo
	public static final String CARPETA_ARCHIVOS = "CAR";

	// codigo de sala laboratorio
	public static final int VALOR_DOS = 2;
	
	//Constantes para documentos
	public static final String PATH_IMG_BACKGROUND="/images/background.jpg";
	public static final String STYLE_FONT_FAMILY_DOCUMENTS="font-family: Arial, Helvetica, sans-serif;";
	public static final String STYLE_FONT_SIZE_DOCUMENTS="font-size: 12px;";
	public static final String STYLE_FONT_SIZE_TITLE="font-size: 14px;";
	public static final String BACKGROUND_COLOR_TABLE = "background-color:#e7eaec;";
	public static final String FONT_WEIGHT_BOLD = "font-weight:bold;";
	public static final String PADDING_CELL = "padding:5px;";
	public static final String STYLE_FONT_SIZE_CELL="font-size: 11px;";
	
	//limites de catalogos
	public static final long CODIGO_ITEM_CATALOGO_LABORATORIOS_TI = 6L;
	public static final long[] CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES = new long[] {7L,10L};
	public static final long[] CODIGO_LIMITES_ITEM_CATALOGO_SALAS_CLASES = new long[] {11L,24L};
	public static final long CODIGO_ITEM_CATALOGO_BIBLIOTECA = 25L;
	public static final long CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA = 26L;
	public static final long CODIGO_ITEM_CATALOGO_COMPUTADOR = 1L;
	public static final long CODIGO_ITEM_CATALOGO_IMPRESORA = 2L;
	
	public static final String NOMBRE_HOJA_CALCULO_REPORTE = "BASE LABORATORIOS NACIONAL";
	public static final String NOMBRE_ARCHIVO_REPORTE = "Matriz-Laboratorios-Nacional-";
	
	public static final int INSTITUCIONES_SIN_INICIO_DE_CARGA_FORMULARIO = 3;
	public static final int INSTITUCIONES_HAN_CARGADO_FORMULARIO = 1;
	public static final int INSTITUCIONES_NO_HAN_CARGADO_FORMULARIO = 2;
	
	public static final long REGIMEN_SIERRA = 1;
	public static final long REGIMEN_COSTA = 2;

	public static final long CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC = 29L;
	public static final long CODIGO_ITEM_CATALOGO_RESPONSABLE_IE = 30L;
	public static final long CODIGO_ITEM_CATALOGO_DOCENTE_IE = 31L;
}
