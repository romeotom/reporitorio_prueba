package ec.gob.educacion.activos.resources;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.model.ActMesParametrizado;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;
import ec.gob.educacion.mineduc.activo.db.dto.ActLaboratorioTiDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActLaboratorioVariosDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActSalaTiDTO;

public class Utils {

	public static Properties properties;

	public static String obtenerPropiedad(String key) {
		if (properties == null) {
			InputStream inputStream = new Utils().getClass().getClassLoader().getResourceAsStream("application.properties");
			try {
				properties = new Properties();
				properties.load(inputStream);
				inputStream.close();
			} catch (IOException e) {
				return null;
			}
		}
		return properties.getProperty(key);
	}
	
	public static List<ActMesParametrizado> listaMesesNoCargados(List<ActMesParametrizadoFormulario> formulariosCargadosParametrizados, List<ActMesParametrizado> mesesParametrizados){
		int currentMonth = getMonthFromDate(new Date());
		List<ActMesParametrizado> mesesParametrizadosOperacion = new ArrayList<ActMesParametrizado>();
		for (ActMesParametrizado actMesParametrizado : mesesParametrizados) {
			boolean exists = false;
			for (ActMesParametrizadoFormulario formularioCargado : formulariosCargadosParametrizados) {
				if(formularioCargado.getMesParametrizado().getCodigo() == actMesParametrizado.getCodigo()){
					exists = true;
					break;
				}
			}
			if(!exists && actMesParametrizado.getMes().getOrdenMes().intValue() <= currentMonth){
				mesesParametrizadosOperacion.add(actMesParametrizado);
			}
		}
		
		
		return mesesParametrizadosOperacion;
	}
	
	public static boolean cargaActualizada(List<ActMesParametrizadoFormulario> formulariosCargadosParametrizados, List<ActMesParametrizado> mesesParametrizados){
		List<ActMesParametrizado> mesesNoCargados = listaMesesNoCargados(formulariosCargadosParametrizados, mesesParametrizados);
		return mesesNoCargados.isEmpty();
	}
	
	public static int getMonthFromDate(Date date){
		int month = 0;
		if(date != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			month = cal.get(Calendar.MONTH);
		}
		return month;
	}
	
	public static ActMesParametrizado mesPorCargar(List<ActMesParametrizado> mesesParametrizados){
		int currentMonth = getMonthFromDate(new Date());
		ActMesParametrizado mesPorCargar = null;
		for (ActMesParametrizado actMesParametrizado : mesesParametrizados) {
			if(actMesParametrizado.getMes().getOrdenMes().intValue() >= currentMonth){
				mesPorCargar = actMesParametrizado;
				break;
			}
		}
		return mesPorCargar;
	}
	
	public static String dateToString(Date date, String format){
		String dateString = "";
		if(date != null){
			DateFormat df = new SimpleDateFormat(format);
			dateString = df.format(date);
		}
		return dateString;
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
	
	public static boolean esLaboratorioVacio(ActLaboratorioSala laboratorio){
		boolean esVacio = false;
		if(laboratorio.getComputadoras()==0 && laboratorio.getImpresoras()==0 && laboratorio.getPizarraInteractiva()==0 
				&& laboratorio.getProyectores()==0 && laboratorio.getSistemaAudio()==0 && laboratorio.getTieneInternet()==0 && laboratorio.getEnUso()==0){
			esVacio = true;
		}
		return esVacio;
	}
	
	public static boolean esLaboratorioVacioDto(Object laboratorioParametro, int opcion){
		boolean esVacio = false;
		switch (opcion) {
		case 1:
			ActLaboratorioTiDTO laboratorio = (ActLaboratorioTiDTO) laboratorioParametro;
			if(laboratorio != null && laboratorio.getComputadoras()==0 && laboratorio.getImpresoras()==0 && laboratorio.getPizarraInteractiva()==0 
					&& laboratorio.getProyectores()==0 && laboratorio.getSistemaAudio()==0 && laboratorio.getTieneInternet()!= null && laboratorio.getTieneInternet()==0 && laboratorio.getEnUso()!=null && laboratorio.getEnUso()==0){
				esVacio = true;
			}
			break;
		case 2:
			ActLaboratorioVariosDTO laboratorioVarios = (ActLaboratorioVariosDTO) laboratorioParametro;
			if(laboratorioVarios != null && laboratorioVarios.getComputadoras()==0 && laboratorioVarios.getImpresoras()==0 && laboratorioVarios.getPizarraInteractiva()==0 
					&& laboratorioVarios.getProyectores()==0 && laboratorioVarios.getSistemaAudio()==0 && laboratorioVarios.getTieneInternet()!= null && laboratorioVarios.getTieneInternet()==0 && laboratorioVarios.getEnUso()!=null && laboratorioVarios.getEnUso()==0){
				esVacio = true;
			}
			break;
		case 3:
			ActSalaTiDTO sala = (ActSalaTiDTO) laboratorioParametro;
			if(sala != null && sala.getComputadoras()==0 && sala.getImpresoras()==0 && sala.getPizarraInteractiva()==0 
					&& sala.getProyectores()==0 && sala.getSistemaAudio()==0 && sala.getTieneInternet()!= null && sala.getTieneInternet()==0 && sala.getEnUso() != null && sala.getEnUso()==0){
				esVacio = true;
			}
			break;

		}
		
		return esVacio;
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
