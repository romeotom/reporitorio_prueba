package ec.gob.educacion.activos.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import ec.gob.educacion.activos.model.ActItemCatalogo;

public class FileUtils {
	
	/**
	 * Método que crea un directorio donde se almacenarán los archivos
	 * pertenecientes a una institución determinada
	 * 
	 * @param nombreDirectorio
	 * @throws IOException
	 */
	public static void crearDirectorio(String nombreDirectorio) throws IOException {
		File directorio = new File(nombreDirectorio);
		if (!directorio.exists()) {
			directorio.mkdir();
		}
	}
	
	/**
	 * Método que permite almacenar físicamente el archivo cargado. Si el
	 * archivo no es temporal, el parámetro nombreArchivo debe llevar el
	 * nombreCompleto incluyendo la extensión del archivo, y el parámetro
	 * extension debe ir con valor null; si por el contrario, es temporal, el
	 * atributo nombreArchivo no debe incluir la ubicación ni la extensión y
	 * esta debe especificarse en el parámetro extension.
	 * 
	 * @param nombreArchivo
	 * @param archivoOriginal
	 * @param esTemporal
	 * @param extension
	 * @param cerrarArchivoOriginal
	 * @return Objeto de tipo File
	 * @throws IOException
	 */
	public static File crearArchivo(String nombreArchivo, InputStream archivoOriginal, boolean esTemporal, String extension, boolean cerrarArchivoOriginal) throws IOException {
		File archivoObjetivo = esTemporal ? File.createTempFile(nombreArchivo, extension) : new File(nombreArchivo);
		FileOutputStream fos = new FileOutputStream(archivoObjetivo);

		int bytesRead;
		byte[] buffer = new byte[8 * 1024];
		while ((bytesRead = archivoOriginal.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);
		}
		if (cerrarArchivoOriginal) {
			IOUtils.closeQuietly(archivoOriginal);
		}
		IOUtils.closeQuietly(fos);
		
		return archivoObjetivo;
	}
	
	public static void reemplazarArchivo(String nombreArchivo, File original) throws IOException {
		File otherArchivoOriginal = new File(nombreArchivo);
		if (otherArchivoOriginal.exists() && !otherArchivoOriginal.isDirectory()) {
			otherArchivoOriginal.delete();
		}
		
		InputStream archivoOriginal = org.apache.commons.io.FileUtils.openInputStream(original);
		
		File archivoObjetivo = new File(nombreArchivo);
		FileOutputStream fos = new FileOutputStream(archivoObjetivo);
		int bytesRead;
		byte[] buffer = new byte[8 * 1024];
		while ((bytesRead = archivoOriginal.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);
		}
		IOUtils.closeQuietly(archivoOriginal);
		IOUtils.closeQuietly(fos);
		original.delete();
	}
	
	public static String getNombreItemCatalogo(List<ActItemCatalogo> itemsCatalogo, Long codigoItemCatalogo){
		String nombre = "";
		for (ActItemCatalogo actItemCatalogo : itemsCatalogo) {
			if(codigoItemCatalogo != null && actItemCatalogo.getCodigo() == codigoItemCatalogo.longValue()){
				nombre = actItemCatalogo.getDescripcion();
				break;
			}
		}
		return nombre;
	}
	
	public static String acronimoLaboratorioSala(Long codigoTipo){
		String acronimo = "";
		if(codigoTipo!=null){
			if(codigoTipo == Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI){
				acronimo = "Laboratorio de informática ";
			}else if (codigoTipo >= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0] && codigoTipo <= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[1]) {
				acronimo = "Laboratorio de ";
			}else if (codigoTipo >= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_SALAS_CLASES[0] && codigoTipo <= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_SALAS_CLASES[1]) {
				acronimo = "Sala de clases ";
			}
		}
		return acronimo;
	}
	
}
