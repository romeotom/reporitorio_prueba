package ec.gob.educacion.activos.service;

import java.util.LinkedHashSet;
import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.acceso.dto.ReporteGeneralDTO;
import ec.gob.educacion.activos.model.ActItemCatalogo;


@Local
public interface ReporteGeneralService {

	/**
	 * Método que extrae la información de activos tecnológicos en base a filtro establecidos, devuelve una lista con detalle de los activos por laboratorio o sala
	 * @param amie
	 * @param codigoZona
	 * @param codigoDistrito
	 * @param codigoProvincia
	 * @param codigoCanton
	 * @param estadoIE
	 * @param estadoFormulario
	 * @param enUsoLaboratorio
	 * @param tieneInternetLab
	 * @param fechaCarga
	 * @param comparacionFecha
	 * @param urbanoRural
	 * @param codigoTipoLaboratorio
	 * @param codigoEstadoActivo
	 * @param itemsCatalogo
	 * @return listado de objetos ReporteGeneralDTO
	 */
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionReporte(String amie, String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE, Integer estadoFormulario,
			Integer enUsoLaboratorio, Integer tieneInternetLab, String fechaCarga, String comparacionFecha, Integer urbanoRural, Long codigoTipoLaboratorio, Integer codigoEstadoActivo, List<ActItemCatalogo> itemsCatalogo);
	
	/**
	 *  Método que extrae la información de activos tecnológicos en base a filtro establecidos, devuelve una lista con los totales de laboratorios o salas y cantidad de computadores e impresoras
	 * @param amie
	 * @param codigoZona
	 * @param codigoDistrito
	 * @param codigoProvincia
	 * @param codigoCanton
	 * @param estadoIE
	 * @param estadoFormulario
	 * @param enUsoLaboratorio
	 * @param tieneInternetLab
	 * @param fechaCarga
	 * @param comparacionFecha
	 * @param urbanoRural
	 * @param codigoTipoLaboratorio
	 * @param codigoEstadoActivo
	 * @param itemsCatalogo
	 * @return listado de objetos ReporteGeneralDTO
	 */
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionTotalesReporte(String amie, String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE, Integer estadoFormulario,
			Integer enUsoLaboratorio, Integer tieneInternetLab, String fechaCarga, String comparacionFecha, Integer urbanoRural, Long codigoTipoLaboratorio, Integer codigoEstadoActivo, List<ActItemCatalogo> itemsCatalogo);
	
	
	/**
	 * Método que lista la información de las cargas de los formularios para las instituciones educativas
	 * @param codigoZona
	 * @param codigoDistrito
	 * @param codigoProvincia
	 * @param codigoCanton
	 * @param estadoIE
	 * @param fechaCarga
	 * @param comparacionFecha
	 * @param urbanoRural
	 * @param opcionCargaFormulario
	 * @return listado de objetos ReporteGeneralDTO
	 */
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionInstitucionesCarga(String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE,
			Integer mes, Integer urbanoRural, Integer opcionCargaFormulario);
}
