package ec.gob.educacion.activos.resources;

import java.util.List;

import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.model.ActTalentoHumano;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;

public class FormReportGenerator {
	
	
	
	public static String generarReporte(ActFormulario formulario, List<ActItemCatalogo> itemsCatalogo, List<ActTalentoHumano>  talentoHumano, List<ActCuartoServidore> cuartoServidores, List<ActLaboratorioSala> laboratoriosTI, List<ActLaboratorioSala> laboratoriosEspeciales, List<ActLaboratorioSala> salasClases, List<ActLaboratorioSala> biblioteca, List<ActLaboratorioSala> areaAdministrativa, List<ActAccesibilidadServicio> accesibilidad, List<ActConectividad> conectividad, InsInstitucion insInstitucion){
		String texto = "<div style=\"width:100%;\" align=\"center\"><p style=\"text-align:center;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">FORMULARIO DE ACTIVOS TECNOLÓGICOS</span></b></p><p>&nbsp;</p>";
		texto = texto + seccionGeneralidades(formulario, insInstitucion);
		texto = texto + seccionTalentoHumano(formulario, talentoHumano);
		texto = texto + seccionCapacidadesTecnologicas(formulario, itemsCatalogo, cuartoServidores, laboratoriosTI, laboratoriosEspeciales, salasClases, biblioteca, areaAdministrativa);
		texto = texto + seccionAccesibilidad(itemsCatalogo, accesibilidad, conectividad);
		texto = texto + firmaResponsabilidad(talentoHumano);
		texto=texto+"</div>";
		return texto;
	}
	
	public static String seccionGeneralidades(ActFormulario formulario, InsInstitucion insInstitucion){
		String texto="";
		texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;padding:5px;\">";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Año:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+ Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+formulario.getAnio()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Fecha de carga:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+Utils.dateToString(formulario.getFechaCarga(), "dd-MM-yyyy HH:mm:ss")+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Fecha de levantamiento:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+Utils.dateToString(formulario.getFechaLevantamiento(), "dd-MM-yyyy")+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Coordinación zonal:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getInsZona().getNombre()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Código de distrito:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigoSenplades()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Distrito:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getDescripcion()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Código circuito:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getInsCirPar().getInsCircuito().getCodigoSenplades()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Circuito:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getInsCirPar().getInsCircuito().getDescripcion()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Régimen:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+((insInstitucion.getCodRegimen()!=null)?((insInstitucion.getCodRegimen().longValue()==Constantes.REGIMEN_SIERRA)?"SIERRA":"COSTA"):"No definido")+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Código AMIE:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+formulario.getAmie()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Institución educativa:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+insInstitucion.getDescripcion()+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Oferta educativa:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+ofertaEducativa(formulario)+"</td></tr>";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: right; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Responsable de distrito:</td><td style=\"width:10%;border-left: 1px solid #ccc;"+Constantes.PADDING_CELL+Constantes.STYLE_FONT_SIZE_CELL +"border-top: 1px solid #ccc\">"+formulario.getResponsableDistrito()+"</td></tr>";
		texto=texto+"</table><p>&nbsp;</p>";
		return texto;
	}
	
	public static String seccionTalentoHumano(ActFormulario formulario, List<ActTalentoHumano>  talentoHumano){
		String texto = "<div style=\"width:100%;padding:10px;background-color:#D7DFF4;\" align=\"center\"><p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">I. INFORMACIÓN DE TALENTO HUMANO</span></b></p></div><p>&nbsp;</p>";
		texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;padding:5px;\">";
		texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Cargo</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Nombres y apellidos</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; border-right: 1px solid #ccc; text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Correo electrónico</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Teléfonos de contacto</td></tr>";
		for (ActTalentoHumano actTalentoHumano : talentoHumano) {
			texto=texto+"<tr style=\"text-align:justify;"+Constantes.STYLE_FONT_SIZE_CELL +"\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;  border-right: 1px solid #ccc;text-align: left;\">"+actTalentoHumano.getNombreCargo().toUpperCase()+"</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;  border-right: 1px solid #ccc; text-align: left;\">"+actTalentoHumano.getNombre()+" "+actTalentoHumano.getApellido()+"</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; border-right: 1px solid #ccc;text-align: center;\">"+actTalentoHumano.getEmail()+"</td><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: center;\">"+actTalentoHumano.getContactoUno()+((actTalentoHumano.getContactoDos()!=null)?" - "+actTalentoHumano.getContactoDos():"")+"</td></tr>";
		}
		texto=texto+"</table><p>&nbsp;</p>";
		return texto;
	}
	
	public static String seccionCapacidadesTecnologicas(ActFormulario formulario, List<ActItemCatalogo> itemsCatalogo, List<ActCuartoServidore> cuartoServidores, List<ActLaboratorioSala> laboratoriosTI, List<ActLaboratorioSala> laboratoriosEspeciales, List<ActLaboratorioSala> salasClases, List<ActLaboratorioSala> biblioteca, List<ActLaboratorioSala> areaAdministrativa){
		String texto = "<div style=\"width:100%;padding:10px;background-color:#D7DFF4;\" align=\"center\"><p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">II. INFORMACIÓN DE CAPACIDADES TECNOLÓGICAS</span></b></p></div><p>&nbsp;</p>";
		texto=texto+parrafoServidores(itemsCatalogo, cuartoServidores);
		texto=texto+parrafoLaboratorios(itemsCatalogo, laboratoriosTI, "- Laboratorio(s) de informática", "Laboratorio de informática");
		texto=texto+parrafoLaboratorios(itemsCatalogo, laboratoriosEspeciales, "- Laboratorio(s) especial(es)", "Laboratorio de");
		texto=texto+parrafoLaboratorios(itemsCatalogo, salasClases, "- Sala(s) de clase(s)", "Sala de clase");
		texto=texto+parrafoBibliotecaAreaAdministrativa(itemsCatalogo, biblioteca, "- Biblioteca", "La biblioteca");
		texto=texto+parrafoBibliotecaAreaAdministrativa(itemsCatalogo, areaAdministrativa, "- Área administrativa", "El área administrativa");
		return texto;
	}
	
	public static String seccionAccesibilidad(List<ActItemCatalogo> itemsCatalogo, List<ActAccesibilidadServicio> accesibilidad, List<ActConectividad> conectividad){
		String texto = "";
		if(!accesibilidad.isEmpty() || !conectividad.isEmpty()){
			texto = texto+"<div style=\"width:100%;padding:10px;background-color:#D7DFF4;\" align=\"center\"><p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">III. INFORMACIÓN DE ACCESIBILIDAD A SERVICIOS</span></b></p></div><p>&nbsp;</p>";
			if(!accesibilidad.isEmpty()){
				texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;padding:5px;\">";
				texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Accesibilidad a los servicios</td></tr>";
				for (ActAccesibilidadServicio item : accesibilidad) {
					texto=texto+"<tr style=\"text-align:justify;"+Constantes.STYLE_FONT_SIZE_CELL +"\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: left;\">"+Utils.getNombreItemCatalogo(itemsCatalogo, item.getCodigoItem())+"</td></tr>";
				}
				texto=texto+"</table><p>&nbsp;</p>";
			}
			if(!conectividad.isEmpty()){
				texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;padding:5px;\">";
				texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Tecnología implementada de conectividad de la IE</td></tr>";
				for (ActConectividad item : conectividad) {
					texto=texto+"<tr style=\"text-align:justify;"+Constantes.STYLE_FONT_SIZE_CELL +"\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: left;\">"+Utils.getNombreItemCatalogo(itemsCatalogo, item.getCodigoItem())+"</td></tr>";
				}
				texto=texto+"</table><p>&nbsp;</p>";
			}
			
		}
		return texto;
	}
	
	public static String firmaResponsabilidad(List<ActTalentoHumano>  talentoHumano){
		 String texto = "";
		 if(!talentoHumano.isEmpty() && talentoHumano.size()==3){
			 texto="<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>"
			 			+ "<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+"width:100%;border: 0px;font-size: 11px;\"><tbody>"
						+ "<tr>"
						+ "<td style=\"text-align:center;border-bottom:1px solid;width:15%;\"></td>"
						+ "<td style=\"width:3%;\"></td>"
						+ "<td style=\"text-align:center;border-bottom:1px solid;width:15%;\"></td>"
						+ "<td style=\"width:3%;\"></td>"
						+ "<td style=\"text-align:center;border-bottom:1px solid;width:15%;\"></td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><p style=\"text-align:center;\">"+ ((talentoHumano.get(0).getNombre()!=null)?talentoHumano.get(0).getNombre():"") + " " + ((talentoHumano.get(0).getApellido()!=null)?talentoHumano.get(0).getApellido():"")
						+ "<br/><strong>"+((talentoHumano.get(0).getNombreCargo()!=null)?talentoHumano.get(0).getNombreCargo():"")+"</strong></p></td>"
						+ "<td style=\"width:3%;\"></td>"
						+ "<td><p style=\"text-align:center;\">"+ ((talentoHumano.get(1).getNombre()!=null)?talentoHumano.get(1).getNombre():"") + " " + ((talentoHumano.get(1).getApellido()!=null)?talentoHumano.get(1).getApellido():"")
						+ "<br/><strong>"+((talentoHumano.get(1).getNombreCargo()!=null)?talentoHumano.get(1).getNombreCargo():"")+"</strong></p></td>"
						+ "<td style=\"width:3%;\"></td>"
						+ "<td><p style=\"text-align:center;\">"+ ((talentoHumano.get(2).getNombre()!=null)?talentoHumano.get(2).getNombre():"") + " " + ((talentoHumano.get(2).getApellido()!=null)?talentoHumano.get(2).getApellido():"")
						+ "<br/><strong>"+((talentoHumano.get(2).getNombreCargo()!=null)?talentoHumano.get(2).getNombreCargo():"")+"</strong></p></td>"
						+ "</tr>"
						+ "</tbody></table>";
		 }
		return texto;
	}
	
	
	
	
	
	public static String parrafoServidores(List<ActItemCatalogo> itemsCatalogo, List<ActCuartoServidore> cuartoServidores){
		String texto = "";
		if(!cuartoServidores.isEmpty()){
			texto = texto+"<p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">- Cuarto de servidores</span></b></p><br/>";
			texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;padding:5px;\">";
			texto=texto+"<tr style=\"text-align:justify;\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Infraestructura física y tecnológica</td></tr>";
			for (ActCuartoServidore cuartoServidor : cuartoServidores) {
				texto=texto+"<tr style=\"text-align:justify;"+Constantes.STYLE_FONT_SIZE_CELL +"\"><td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc; text-align: left;\">"+Utils.getNombreItemCatalogo(itemsCatalogo, cuartoServidor.getCodigoItem())+"</td></tr>";
			}
			texto=texto+"</table><p>&nbsp;</p>";
		}
		return texto;
	}
	
	public static String parrafoLaboratorios(List<ActItemCatalogo> itemsCatalogo, List<ActLaboratorioSala> laboratorios, String nombreLabel, String nombreTipo){
		String texto = "";
		if(!laboratorios.isEmpty()){
			texto = texto+"<p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">"+nombreLabel+"</span></b></p><br/>";
			texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: none;padding:5px;\">";
			for (ActLaboratorioSala laboratorio : laboratorios) {
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%;padding:15px; border-top: 1px solid #ccc;border-left: 1px solid #ccc;border-right: 1px solid #ccc; text-align: left; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">"+nombreTipo+" "+laboratorio.getNombreTipo()+"</td></tr>";
				texto = texto + generarColumnasTablaLaboratorios(laboratorio);
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%; text-align: left; " + Constantes.FONT_WEIGHT_BOLD+"\">";
				texto = texto + generarComputadoresImpresorasLaboratorios(laboratorio, itemsCatalogo);
				texto = texto + "</td></tr>";
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%;padding:5px; text-align: left;"+ Constantes.FONT_WEIGHT_BOLD+"\">&nbsp;</td></tr>";
			}
			texto=texto+"</table><p>&nbsp;</p>";
		}
		return texto;
	}
	
	public static String parrafoBibliotecaAreaAdministrativa(List<ActItemCatalogo> itemsCatalogo, List<ActLaboratorioSala> laboratorios, String nombreLabel, String nombreTipo){
		String texto = "";
		if(!laboratorios.isEmpty()){
			texto = texto+"<p style=\"text-align:left;\"><b><span style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_TITLE+"\">"+nombreLabel+"</span></b></p><br/>";
			texto=texto+"<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: none;padding:5px;\">";
			for (ActLaboratorioSala laboratorio : laboratorios) {
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%;padding:15px; border-top: 1px solid #ccc;border-left: 1px solid #ccc;border-right: 1px solid #ccc; text-align: left; " + Constantes.STYLE_FONT_SIZE_CELL+"\"><b>Conectividad: </b>"+nombreTipo+((laboratorio.getTieneInternet()==1)?" presenta Internet":" no presenta Internet")+"</td></tr>";
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%; text-align: left; " + Constantes.FONT_WEIGHT_BOLD+"\">";
				texto = texto + generarComputadoresImpresorasLaboratorios(laboratorio, itemsCatalogo);
				texto = texto + "</td></tr>";
				texto=texto+"<tr style=\"text-align:justify;\"><td colspan=\"5\" style=\"width:10%;padding:5px; text-align: left;"+ Constantes.FONT_WEIGHT_BOLD+"\">&nbsp;</td></tr>";
			}
			texto=texto+"</table><p>&nbsp;</p>";
		}
		return texto;
	}
	
	public static String generarColumnasTablaLaboratorios(ActLaboratorioSala laboratorio){
		String texto="<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;border-left: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Estado</td>"
				+ "<td style=\"width:15%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Conectividad</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">No. proyectores</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">No. pizarras interactivas</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">No. sistemas de audio</td>"
				+ "</tr>";
		texto=texto+"<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:5%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;border-left: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+((laboratorio.getEnUso() == 1 )?"En uso":"Sin uso")+"</td>"
				+ "<td style=\"width:15%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: left; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+((laboratorio.getTieneInternet() == 1)?"Presenta internet <br/> <b>Proveedor:</b> "+laboratorio.getProveedorInternet()+"<br/><b>Velocidad:</b> "+laboratorio.getVelocidadNavegacion()+ " mbips":"No presenta internet")+"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+ laboratorio.getProyectores() +"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+ laboratorio.getPizarraInteractiva() +"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+ laboratorio.getSistemaAudio() +"</td>"
				+ "</tr>";
		return texto;
	}
	
	public static String generarComputadoresImpresorasLaboratorios(ActLaboratorioSala laboratorio, List<ActItemCatalogo> itemsCatalogo){
		boolean esComputador = true;
		String texto = "<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;\">";
		texto=texto+"<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Computador(es)</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Impresora(s)</td>"
				+ "</tr>"
				+ "<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:10%;border-right: 1px solid #ccc;text-align: center; vertical-align: top !important;" + Constantes.FONT_WEIGHT_BOLD+"\">";
		
		if(laboratorio.getComputadoras() > 0){
			texto = texto + generarColumnasActivos(laboratorio, itemsCatalogo, esComputador);
		}else{
			texto = texto + "<span style=\"font-weight:normal;"+Constantes.STYLE_FONT_SIZE_CELL+"\"><br/>No se han registrado computadores<br/></span>";
		}
				
		texto = texto + "</td>";
		texto = texto + "<td valign=\"top\" style=\"width:10%;text-align: center;" + Constantes.FONT_WEIGHT_BOLD+"\">";
		
		if(laboratorio.getImpresoras() > 0){
			texto = texto + generarColumnasActivos(laboratorio, itemsCatalogo, !esComputador);
		}else{
			texto = texto + "<span style=\"font-weight:normal;"+Constantes.STYLE_FONT_SIZE_CELL+"\"><br/>No se han registrado impresoras<br/></span>";
		}
		texto = texto + "</td></tr></table>";
		return texto;
	}
	
	public static String generarColumnasActivos(ActLaboratorioSala laboratorio, List<ActItemCatalogo> itemsCatalogo, boolean esComputador){
		String texto="<table style=\""+Constantes.STYLE_FONT_FAMILY_DOCUMENTS+Constantes.STYLE_FONT_SIZE_DOCUMENTS+"width:100%;border: 1px solid #ccc;\">"
				+"<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:3%;"+Constantes.PADDING_CELL+"border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">No.</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Marca</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-right: 1px solid #ccc;text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Serial</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"text-align: center; " +Constantes.BACKGROUND_COLOR_TABLE+ Constantes.FONT_WEIGHT_BOLD+"\">Estado</td>"
				+ "</tr>";
		int count = 1;
		for (ActDetalleActivo activo : laboratorio.getActDetalleActivos()) {
			if(esComputador && activo.getCodigoTipo() == Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR){
				texto = texto + diferenciarActivo(activo, itemsCatalogo, count);
				count++;
			}else if (!esComputador && activo.getCodigoTipo() == Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA) {
				texto = texto + diferenciarActivo(activo, itemsCatalogo, count);
				count++;
			}
		}
		texto = texto + "</table>";
		return texto;
	}
	
	public static String diferenciarActivo(ActDetalleActivo activo, List<ActItemCatalogo> itemsCatalogo, int contador){
		String texto="<tr style=\"text-align:justify;\">"
				+ "<td style=\"width:3%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+contador+"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+Utils.getNombreItemCatalogo(itemsCatalogo, activo.getCodigoMarca())+"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;border-right: 1px solid #ccc;text-align: left; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+activo.getSerial()+"</td>"
				+ "<td style=\"width:10%;"+Constantes.PADDING_CELL+"border-top: 1px solid #ccc;text-align: center; " +Constantes.STYLE_FONT_SIZE_CELL+"\">"+ Utils.getNombreItemCatalogo(itemsCatalogo, activo.getCodigoEstadoActivo()) +"</td>"
				+ "</tr>";
		return texto;
	}

	public static String ofertaEducativa(ActFormulario formulario){
		String oferta="";
		if(formulario.getTieneInicial() == 1 && formulario.getTieneBasica() == 1 && formulario.getTieneBachillerato() == 1){
			oferta="EDUCACIÓN INICIAL, EDUCACIÓN GENERAL BÁSICA, BACHILLERATO";
		}else if (formulario.getTieneInicial() == 1 && formulario.getTieneBasica() == 1 && formulario.getTieneBachillerato() == 0) {
			oferta="EDUCACIÓN INICIAL, EDUCACIÓN GENERAL BÁSICA";
		}else if (formulario.getTieneInicial() == 1 && formulario.getTieneBasica() == 0 && formulario.getTieneBachillerato() == 0) {
			oferta="EDUCACIÓN INICIAL";
		}else {
			oferta="No presenta oferta educativa";
		}
		return oferta;
	}
}
