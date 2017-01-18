package ec.gob.educacion.activos.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.gob.educacion.acceso.dto.ReporteGeneralDTO;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.resources.FileUtils;
import ec.gob.educacion.activos.service.MesParametrizadoFormularioService;
import ec.gob.educacion.activos.service.ReporteGeneralService;

@Stateless
public class ReporteGeneralServiceImpl implements ReporteGeneralService {

	@PersistenceContext
	protected EntityManager em;
	
	@EJB
	private MesParametrizadoFormularioService mesParametrizadoFormularioService;
	
	
	@SuppressWarnings("unchecked")
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionReporte(String amie, String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE, Integer estadoFormulario,
			Integer enUsoLaboratorio, Integer tieneInternetLab, String fechaCarga, String comparacionFecha, Integer urbanoRural, Long codigoTipoLaboratorio, Integer codigoEstadoActivo, List<ActItemCatalogo> itemsCatalogo){
		LinkedHashSet<ReporteGeneralDTO> reporte = new LinkedHashSet<ReporteGeneralDTO>();
		String select="SELECT  DISTINCT "
				+ "i.AMIE, "
				+ "f.FECHA_CARGA, "
				+ "i.DESCRIPCION AS NOMBRE_INSTITUCION, "
				+ "ZON.CODIGO_SENPLADES AS ZONA, "
				+ "DIS.CODIGO_SENPLADES AS DISTRITO, "
				+ "PRO.DESCRIPCION AS PROVINCIA, "
				+ "CAN.DESCRIPCION AS CANTON, "
				+ "PAR.DESCRIPCION AS PARROQUIA, "
				+ "i.URBANO AS URBANO, "
				+ "i.ESTADO AS ESTADO_INSTITUCION, "
				+ "f.CODIGO AS CODIGO_FORMULARIO, "
				+ "f.ESTADO AS ESTADO_FORMULARIO, "
				+ "l.CODIGO AS CODIGO_LABORATORIO, "
				+ "l.NOMBRE_TIPO AS NOMBRE_LABORATORIO, "
				+ "l.EN_USO, "
				+ "l.TIENE_INTERNET, "
				+ "l.VELOCIDAD_NAVEGACION,"
				+ "d.CODIGO AS CODIGO_ACTIVO, "
				+ "d.SERIAL, "
				+ "d.CODIGO_MARCA, "
				+ "d.MODELO, "
				+ "d.CODIGO_TIPO AS COMPUTADOROIMPRESORA, "
				+ "d.VELOCIDAD_PROCESADOR, "
				+ "d.MEMORIA_RAM, "
				+ "d.CAPACIDAD_DISCO, "
				+ "d.TIENE_DOBLE_BOOTEO, "
				+ "d.CODIGO_SO_PRINCIPAL, "
				+ "d.CODIGO_SO_SECUNDARIO, "
				+ "d.CODIGO_PROCEDENCIA_ACTIVO, "
				+ "l.CODIGO_TIPO AS TIPO_LABORATORIO_SALA, "
				+ "d.CODIGO_ESTADO_ACTIVO, "
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS NOMBRES_TECNICO,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS MAIL_TECNICO,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS CONTACTOS_TECNICO,"
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS NOMBRES_RESPONSABLE,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS MAIL_RESPONSABLE,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS CONTACTOS_RESPONSABLE,"
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS NOMBRES_DOCENTE,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS MAIL_DOCENTE,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS CONTACTOS_DOCENTE "
				+ "FROM "
				+ "ACTIVOS.ACT_FORMULARIO f,  "
				+ "ACTIVOS.ACT_LABORATORIO_SALA l, "
				+ "ACTIVOS.ACT_DETALLE_ACTIVO d, "
				+ "ASIGNACIONES.INS_INSTITUCION i, "
				+ "ASIGNACIONES.INS_CIR_PAR icp, "
				+ "ASIGNACIONES.INS_CIRCUITO cir, "
				+ "ASIGNACIONES.INS_DISTRITO dis, "
				+ "ASIGNACIONES.INS_PARROQUIA par, "
				+ "ASIGNACIONES.INS_CANTON can, "
				+ "ASIGNACIONES.INS_PROVINCIA pro, "
				+ "ASIGNACIONES.INS_ZONA zon "
				+ "WHERE ";
		
		//FILTROS
				if(amie != null){
					select = select + " f.AMIE = '"+amie+"' AND ";
				}
				if(codigoZona != null){
					select = select + " ZON.CODIGO_SENPLADES = '"+codigoZona+"' AND ";
				}
				if(codigoDistrito != null){
					select = select + " DIS.CODIGO_SENPLADES = '"+codigoDistrito+"' AND ";
				}
				if(codigoProvincia != null){
					select = select + " PRO.CODIGO = '"+codigoProvincia+"' AND ";
				}
				if(codigoCanton != null){
					select = select + " CAN.CODIGO = '"+codigoCanton+"' AND ";
				}
				if(estadoIE != null){
					select = select + " i.ESTADO = "+estadoIE+" AND ";
				}
				if(estadoFormulario != null){
					select = select + " f.ESTADO = "+estadoFormulario+" AND ";
				}
				if(fechaCarga != null && !fechaCarga.isEmpty()){
					select = select + " TRUNC(f.FECHA_CARGA) "+comparacionFecha+" TO_DATE('"+fechaCarga+"', 'dd-MM-yyyy') AND ";
				}
				if(tieneInternetLab != null){
					select = select + " l.TIENE_INTERNET = "+tieneInternetLab+" AND ";
				}
				if(urbanoRural != null){
					select = select + " i.URBANO = "+urbanoRural+" AND ";
				}
				if(codigoTipoLaboratorio != null){
					select = select + " l.CODIGO_TIPO = "+codigoTipoLaboratorio+" AND ";
				}
				if(codigoEstadoActivo != null){
					select = select + " d.ESTADO = "+codigoEstadoActivo+" AND ";
				}
				if(enUsoLaboratorio != null){
					select = select + " l.EN_USO = "+enUsoLaboratorio+" AND ";
				}


				select = select + " i.AMIE = f.AMIE "
						+ "and i.COD_CIR_PAR = ICP.CODIGO "
						+ "and ICP.COD_CIRCUITO = CIR.CODIGO "
						+ "and CIR.COD_DISTRITO = DIS.CODIGO "
						+ "AND DIS.COD_ZONA = ZON.CODIGO "
						+ "AND ICP.COD_PARROQUIA = PAR.CODIGO "
						+ "AND PAR.COD_CANTON = CAN.CODIGO "
						+ "AND CAN.COD_PROVINCIA = PRO.CODIGO "
						+ "and f.CODIGO = l.ID_AFR "
						+ " AND l.CODIGO = d.ID_ALS "
						+ " AND d.CODIGO_TIPO in ( "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+", "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" )"
						+ " ORDER BY ZON.CODIGO_SENPLADES, f.FECHA_CARGA DESC";
				
		Query query = em.createNativeQuery(select);
		
		List<Object[]> listaAux = query.getResultList();
		for (Object objects[] : listaAux) {
			try {
				
			ReporteGeneralDTO objetoReporte = new ReporteGeneralDTO();
			String acronimo = "";
			if(objects[0]==null){
				objetoReporte.setAmie("No presenta");
			} else {
				objetoReporte.setAmie(String.valueOf(objects[0]));
			}
			if(objects[1]==null){
				objetoReporte.setFechaCarga(null);
			} else {
				objetoReporte.setFechaCarga((Date)(objects[1]));
			}
			if(objects[2]==null){
				objetoReporte.setNombreInstitucion("No presenta");
			} else {
				objetoReporte.setNombreInstitucion(String.valueOf(objects[2]));
			}
			if(objects[3]==null){
				objetoReporte.setZona("No presenta");
			} else {
				objetoReporte.setZona(String.valueOf(objects[3]));
			}
			if(objects[4]==null){
				objetoReporte.setDistrito("No presenta");
			} else {
				objetoReporte.setDistrito(String.valueOf(objects[4]));
			}
			if(objects[5]==null){
				objetoReporte.setProvincia("No presenta");
			} else {
				objetoReporte.setProvincia(String.valueOf(objects[5]));
			}
			if(objects[6]==null){
				objetoReporte.setCanton("No presenta");
			} else {
				objetoReporte.setCanton(String.valueOf(objects[6]));
			}
			if(objects[7]==null){
				objetoReporte.setParroquia("No presenta");
			} else {
				objetoReporte.setParroquia(String.valueOf(objects[7]));
			}
			if(objects[8]==null){
				objetoReporte.setUrbano("No presenta");
			} else {
				String urbano = String.valueOf(objects[8]);
				objetoReporte.setUrbano((urbano.equals("1"))?"Urbano":"Rural");
			}
			if(objects[9]==null){
				objetoReporte.setEstadoIE(null);
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[9]));	
				objetoReporte.setEstadoIE((estado.intValue()==1)?"Activa":"Inactiva");
			}
			if(objects[10]==null){
				objetoReporte.setCodigoFormulario(null);
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[10]));
				objetoReporte.setCodigoFormulario(codigo);
			}
			if(objects[11]==null){
				objetoReporte.setEstadoFormulario("No presenta");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[11]));	
				objetoReporte.setEstadoFormulario((estado.intValue()==1)?"Activo":"Inactivo");
			}
			if(objects[12]==null){
				objetoReporte.setCodigoLaboratorio(null);
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[12]));
				objetoReporte.setCodigoLaboratorio(codigo);
			}
			if(objects[29]==null){
				objetoReporte.setTipoLabSala("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[29]));
				acronimo = FileUtils.acronimoLaboratorioSala(codigo);
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigo);
				objetoReporte.setTipoLabSala(cadena);
			}
			if(objects[13]==null){
				objetoReporte.setNombreLaboratorio("No presenta");
			} else {
				objetoReporte.setNombreLaboratorio(acronimo+String.valueOf(objects[13]));
			}
			if(objects[14]==null){
				objetoReporte.setEstadoLabTI("No presenta");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[14]));		
				objetoReporte.setEstadoLabTI((estado.intValue()==1)?"En uso":"Sin uso");
			}
			if(objects[15]==null){
				objetoReporte.setTieneInternetLabTI("No presenta");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[15]));		
				objetoReporte.setTieneInternetLabTI((estado.intValue()==1)?"Si":"No");
			}
			if(objects[16]==null){
				objetoReporte.setVelocidadInternetLabTI(0D);
			} else {
				Double valor = Double.valueOf(String.valueOf(objects[16]));
				objetoReporte.setVelocidadInternetLabTI(valor);
			}
			if(objects[17]==null){
				objetoReporte.setCodigoActivo(null);
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[17]));
				objetoReporte.setCodigoActivo(codigo);
			}
			if(objects[18]==null){
				objetoReporte.setSerial("No presenta");
			} else {
				objetoReporte.setSerial(String.valueOf(objects[18]));
			}
			if(objects[19]==null){
				objetoReporte.setMarcaModelo("No presenta");
			} else {
				Long codigoMarca = Long.valueOf(String.valueOf(objects[19]));
				String modelo = (objects[20] != null)?String.valueOf(objects[20]):null;
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigoMarca) + ((modelo!=null)?" - "+ modelo:"");
				objetoReporte.setMarcaModelo(cadena);
			}
			if(objects[21]==null){
				objetoReporte.setNombreActivo("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[21]));
				objetoReporte.setNombreActivo(((codigo.longValue() == Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR)?"Computador":"Impresora"));
			}
			if(objects[22]==null){
				objetoReporte.setVelocidadProcesador(0D);
			} else {
				Double valor = Double.valueOf(String.valueOf(objects[22]));
				objetoReporte.setVelocidadProcesador(valor);
			}
			if(objects[23]==null){
				objetoReporte.setMemoria(0D);
			} else {
				Double valor = Double.valueOf(String.valueOf(objects[23]));
				objetoReporte.setMemoria(valor);
			}
			if(objects[24]==null){
				objetoReporte.setDiscoDuro(0D);
			} else {
				Double valor = Double.valueOf(String.valueOf(objects[24]));
				objetoReporte.setDiscoDuro(valor);
			}
			if(objects[25]==null){
				objetoReporte.setDobleBooteo("Sin valor");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[25]));
				objetoReporte.setDobleBooteo((estado.intValue()==1)?"Si":"No");
			}
			if(objects[26]==null){
				objetoReporte.setSoPrincipal("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[26]));
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigo);
				objetoReporte.setSoPrincipal(cadena);
			}
			if(objects[27]==null){
				objetoReporte.setSoSecundario("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[27]));
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigo);
				objetoReporte.setSoSecundario(cadena);
			}
			if(objects[28]==null){
				objetoReporte.setProcedenciaActivo("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[28]));
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigo);
				objetoReporte.setProcedenciaActivo(cadena);
			}
			if(objects[30]==null){
				objetoReporte.setEstadoActivo("No presenta");
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[30]));
				String cadena = FileUtils.getNombreItemCatalogo(itemsCatalogo, codigo);
				objetoReporte.setEstadoActivo(cadena);
			}
			if(objects[31]==null){
				objetoReporte.setNombresTecnicoMinEduc("No presenta");
			} else {
				objetoReporte.setNombresTecnicoMinEduc(String.valueOf(objects[31]));
			}
			if(objects[32]==null){
				objetoReporte.setMailTecnicoMinEduc("No presenta");
			} else {
				objetoReporte.setMailTecnicoMinEduc(String.valueOf(objects[32]));
			}
			if(objects[33]==null){
				objetoReporte.setContactosTecnicoMinEduc("No presenta");
			} else {
				objetoReporte.setContactosTecnicoMinEduc(String.valueOf(objects[33]));
			}
			if(objects[34]==null){
				objetoReporte.setNombresResponsableIe("No presenta");
			} else {
				objetoReporte.setNombresResponsableIe(String.valueOf(objects[34]));
			}
			if(objects[35]==null){
				objetoReporte.setMailResponsableIe("No presenta");
			} else {
				objetoReporte.setMailResponsableIe(String.valueOf(objects[35]));
			}
			if(objects[36]==null){
				objetoReporte.setContactosResponsableIe("No presenta");
			} else {
				objetoReporte.setContactosResponsableIe(String.valueOf(objects[36]));
			}
			if(objects[37]==null){
				objetoReporte.setNombresDocenteIe("No presenta");
			} else {
				objetoReporte.setNombresDocenteIe(String.valueOf(objects[37]));
			}
			if(objects[38]==null){
				objetoReporte.setMailDocenteIe("No presenta");
			} else {
				objetoReporte.setMailDocenteIe(String.valueOf(objects[38]));
			}
			if(objects[39]==null){
				objetoReporte.setContactosDocenteIe("No presenta");
			} else {
				objetoReporte.setContactosDocenteIe(String.valueOf(objects[39]));
			}

			reporte.add(objetoReporte);
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reporte;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionTotalesReporte(String amie, String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE, Integer estadoFormulario,
			Integer enUsoLaboratorio, Integer tieneInternetLab, String fechaCarga, String comparacionFecha, Integer urbanoRural, Long codigoTipoLaboratorio, Integer codigoEstadoActivo, List<ActItemCatalogo> itemsCatalogo){
		LinkedHashSet<ReporteGeneralDTO> reporte = new LinkedHashSet<ReporteGeneralDTO>();
		String select="SELECT  DISTINCT "
				+ "i.AMIE, "
				+ "f.FECHA_CARGA, "
				+ "i.DESCRIPCION AS NOMBRE_INSTITUCION, "
				+ "ZON.CODIGO_SENPLADES AS ZONA, "
				+ "DIS.CODIGO_SENPLADES AS DISTRITO, "
				+ "PRO.DESCRIPCION AS PROVINCIA, "
				+ "CAN.DESCRIPCION AS CANTON, "
				+ "PAR.DESCRIPCION AS PARROQUIA, "
				+ "i.URBANO AS URBANO, "
				+ "i.ESTADO AS ESTADO_INSTITUCION, "
				+ "f.CODIGO AS CODIGO_FORMULARIO, "
				+ "f.ESTADO AS ESTADO_FORMULARIO, "
				+ "(SELECT COUNT(DISTINCT LAB.CODIGO) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_LABORATORIOS_TI,"
				+ "(SELECT SUM(LAB.COMPUTADORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_COMPUTADORES_TI, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_COMPU_ACTIVOS_TI, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_COMPU_OBSOLETOS_TI, "
				+ "(SELECT SUM(LAB.IMPRESORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_IMPRESORAS_TI, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_IMPRE_ACTIVAS_TI, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI+") AS TOTAL_IMPRE_OBSOLETAS_TI, "
				+ "(SELECT SUM(LAB.COMPUTADORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_COMPUTADORES_ADMIN, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_COMPU_ACTIVOS_ADMIN, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_COMPU_OBSOLETOS_ADMIN, "
				+ "(SELECT SUM(LAB.IMPRESORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_IMPRESORAS_ADMIN, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_IMPRE_ACTIVAS_ADMIN, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA+") AS TOTAL_IMPRE_OBSOLETAS_ADMIN, "
				+ "(SELECT SUM(LAB.COMPUTADORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_COMPU_VARIOS, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_COMPU_ACTIVOS_VAR, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+" AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_COMPU_OBSOLETOS_VAR, "
				+ "(SELECT SUM(LAB.IMPRESORAS) FROM ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_IMPRESORAS_VAR, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 1 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_IMPRE_ACTIVAS_VAR, "
				+ "(SELECT COUNT(ACT.CODIGO) FROM ACT_DETALLE_ACTIVO ACT, ACT_LABORATORIO_SALA LAB WHERE LAB.ID_AFR = F.CODIGO AND ACT.ID_ALS = LAB.CODIGO AND ACT.ESTADO = 0 AND ACT.CODIGO_TIPO = "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" AND LAB.CODIGO_TIPO >= "+Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0]+" AND LAB.CODIGO_TIPO <= "+Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA+") AS TOTAL_IMPRE_OBSOLETAS_VAR "
				+ " FROM "
				+ "ACTIVOS.ACT_FORMULARIO f,  "
				+ "ACTIVOS.ACT_LABORATORIO_SALA l, "
				+ "ACTIVOS.ACT_DETALLE_ACTIVO d, "
				+ "ASIGNACIONES.INS_INSTITUCION i, "
				+ "ASIGNACIONES.INS_CIR_PAR icp, "
				+ "ASIGNACIONES.INS_CIRCUITO cir, "
				+ "ASIGNACIONES.INS_DISTRITO dis, "
				+ "ASIGNACIONES.INS_PARROQUIA par, "
				+ "ASIGNACIONES.INS_CANTON can, "
				+ "ASIGNACIONES.INS_PROVINCIA pro, "
				+ "ASIGNACIONES.INS_ZONA zon "
				+ "WHERE ";
		
		//FILTROS
				if(amie != null){
					select = select + " f.AMIE = '"+amie+"' AND ";
				}
				if(codigoZona != null){
					select = select + " ZON.CODIGO_SENPLADES = '"+codigoZona+"' AND ";
				}
				if(codigoDistrito != null){
					select = select + " DIS.CODIGO_SENPLADES = '"+codigoDistrito+"' AND ";
				}
				if(codigoProvincia != null){
					select = select + " PRO.CODIGO = '"+codigoProvincia+"' AND ";
				}
				if(codigoCanton != null){
					select = select + " CAN.CODIGO = '"+codigoCanton+"' AND ";
				}
				if(estadoIE != null){
					select = select + " i.ESTADO = "+estadoIE+" AND ";
				}
				if(estadoFormulario != null){
					select = select + " f.ESTADO = "+estadoFormulario+" AND ";
				}
				if(fechaCarga != null && !fechaCarga.isEmpty()){
					select = select + " TRUNC(f.FECHA_CARGA) "+comparacionFecha+" TO_DATE('"+fechaCarga+"', 'dd-MM-yyyy') AND ";
				}
				if(tieneInternetLab != null){
					select = select + " l.TIENE_INTERNET = "+tieneInternetLab+" AND ";
				}
				if(urbanoRural != null){
					select = select + " i.URBANO = "+urbanoRural+" AND ";
				}
				if(codigoTipoLaboratorio != null){
					select = select + " l.CODIGO_TIPO = "+codigoTipoLaboratorio+" AND ";
				}
				if(codigoEstadoActivo != null){
					select = select + " d.ESTADO = "+codigoEstadoActivo+" AND ";
				}
				if(enUsoLaboratorio != null){
					select = select + " l.EN_USO = "+enUsoLaboratorio+" AND ";
				}


				select = select + " i.AMIE = f.AMIE "
						+ "and i.COD_CIR_PAR = ICP.CODIGO "
						+ "and ICP.COD_CIRCUITO = CIR.CODIGO "
						+ "and CIR.COD_DISTRITO = DIS.CODIGO "
						+ "AND DIS.COD_ZONA = ZON.CODIGO "
						+ "AND ICP.COD_PARROQUIA = PAR.CODIGO "
						+ "AND PAR.COD_CANTON = CAN.CODIGO "
						+ "AND CAN.COD_PROVINCIA = PRO.CODIGO "
						+ "and f.CODIGO = l.ID_AFR "
						+ " AND l.CODIGO = d.ID_ALS "
						+ " AND d.CODIGO_TIPO in ( "+Constantes.CODIGO_ITEM_CATALOGO_COMPUTADOR+", "+Constantes.CODIGO_ITEM_CATALOGO_IMPRESORA+" )"
						+ " ORDER BY ZON.CODIGO_SENPLADES, f.FECHA_CARGA DESC";
		
		Query query = em.createNativeQuery(select);
		
		List<Object[]> listaAux = query.getResultList();
		for (Object objects[] : listaAux) {
			try {
				
			ReporteGeneralDTO objetoReporte= new ReporteGeneralDTO();
			if(objects[0]==null){
				objetoReporte.setAmie("No presenta");
			} else {
				objetoReporte.setAmie(String.valueOf(objects[0]));
			}
			if(objects[1]==null){
				objetoReporte.setFechaCarga(null);
			} else {
				objetoReporte.setFechaCarga((Date)(objects[1]));
			}
			if(objects[2]==null){
				objetoReporte.setNombreInstitucion("No presenta");
			} else {
				objetoReporte.setNombreInstitucion(String.valueOf(objects[2]));
			}
			if(objects[3]==null){
				objetoReporte.setZona("No presenta");
			} else {
				objetoReporte.setZona(String.valueOf(objects[3]));
			}
			if(objects[4]==null){
				objetoReporte.setDistrito("No presenta");
			} else {
				objetoReporte.setDistrito(String.valueOf(objects[4]));
			}
			if(objects[5]==null){
				objetoReporte.setProvincia("No presenta");
			} else {
				objetoReporte.setProvincia(String.valueOf(objects[5]));
			}
			if(objects[6]==null){
				objetoReporte.setCanton("No presenta");
			} else {
				objetoReporte.setCanton(String.valueOf(objects[6]));
			}
			if(objects[7]==null){
				objetoReporte.setParroquia("");
			} else {
				objetoReporte.setParroquia(String.valueOf(objects[7]));
			}
			if(objects[8]==null){
				objetoReporte.setUrbano("sin dato");
			} else {
				String urbano = String.valueOf(objects[8]);
				objetoReporte.setUrbano((urbano.equals("1"))?"Urbano":"Rural");
			}
			if(objects[9]==null){
				objetoReporte.setEstadoIE("No presenta");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[9]));	
				objetoReporte.setEstadoIE((estado.intValue()==1)?"Activa":"Inactiva");
			}
			if(objects[10]==null){
				objetoReporte.setCodigoFormulario(null);
			} else {
				Long codigo = Long.valueOf(String.valueOf(objects[10]));
				objetoReporte.setCodigoFormulario(codigo);
			}
			if(objects[11]==null){
				objetoReporte.setEstadoFormulario("No presenta");
			} else {
				Integer estado = Integer.valueOf(String.valueOf(objects[11]));	
				objetoReporte.setEstadoFormulario((estado.intValue()==1)?"Activo":"Inactivo");
			}
			if(objects[12]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[12]));
				objetoReporte.setTotalLaboratoriosTi(valor);
			}
			if(objects[13]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[13]));
				objetoReporte.setTotalComputadoresTi(valor);
			}
			if(objects[14]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[14]));
				objetoReporte.setTotalComputadoresEnUsoTi(valor);
			}
			if(objects[15]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[15]));
				objetoReporte.setTotalComputadoresObsoletasTi(valor);
			}
			if(objects[16]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[16]));
				objetoReporte.setTotalImpresorasTi(valor);
			}
			if(objects[17]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[17]));
				objetoReporte.setTotalImpresorasEnUsoTi(valor);
			}
			if(objects[18]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[18]));
				objetoReporte.setTotalImpresorasObsoletasTi(valor);
			}
			if(objects[19]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[19]));
				objetoReporte.setTotalComputadoresAdmin(valor);
			}
			if(objects[20]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[20]));
				objetoReporte.setTotalComputadoresEnUsoAdmin(valor);
			}
			if(objects[21]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[21]));
				objetoReporte.setTotalComputadoresObsoletasAdmin(valor);
			}
			if(objects[22]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[22]));
				objetoReporte.setTotalImpresorasAdmin(valor);
			}
			if(objects[23]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[23]));
				objetoReporte.setTotalImpresorasEnUsoAdmin(valor);
			}
			if(objects[24]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[24]));
				objetoReporte.setTotalImpresorasObsoletasAdmin(valor);
			}
			if(objects[25]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[25]));
				objetoReporte.setTotalComputadoresVarios(valor);
			}
			if(objects[26]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[26]));
				objetoReporte.setTotalComputadoresEnUsoVarios(valor);
			}
			if(objects[27]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[27]));
				objetoReporte.setTotalComputadoresObsoletasVarios(valor);
			}
			if(objects[28]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[28]));
				objetoReporte.setTotalImpresorasVarios(valor);
			}
			if(objects[29]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[29]));
				objetoReporte.setTotalImpresorasEnUsoVarios(valor);
			}
			if(objects[30]!=null){
				Integer valor = Integer.valueOf(String.valueOf(objects[30]));
				objetoReporte.setTotalImpresorasObsoletasVarios(valor);
			}
			
			reporte.add(objetoReporte);
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reporte;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedHashSet<ReporteGeneralDTO> listaInformacionInstitucionesCarga(String codigoZona, String codigoDistrito, String codigoProvincia, String codigoCanton, Integer estadoIE,
			Integer mes, Integer urbanoRural, Integer opcionCargaFormulario){
		LinkedHashSet<ReporteGeneralDTO> reporte = new LinkedHashSet<ReporteGeneralDTO>();
		List<ActMesParametrizadoFormulario> institucionesConcargaFormulario = new ArrayList<ActMesParametrizadoFormulario>();
		boolean validarAmie = false;
		if(opcionCargaFormulario!=null && opcionCargaFormulario.intValue() == Constantes.INSTITUCIONES_NO_HAN_CARGADO_FORMULARIO){
			int anioActual = Calendar.getInstance().get(Calendar.YEAR);
			institucionesConcargaFormulario = mesParametrizadoFormularioService.listaMesParametrizadoFormulariosPorMesAnio(mes, anioActual);
		}
		
		String select="SELECT  DISTINCT "
				+ "i.AMIE, "
				+ "f.FECHA_CARGA, "
				+ "i.DESCRIPCION AS NOMBRE_INSTITUCION, "
				+ "ZON.CODIGO_SENPLADES AS ZONA, "
				+ "DIS.CODIGO_SENPLADES AS DISTRITO, "
				+ "PRO.DESCRIPCION AS PROVINCIA, "
				+ "CAN.DESCRIPCION AS CANTON, "
				+ "PAR.DESCRIPCION AS PARROQUIA, "
				+ "i.URBANO AS URBANO, "
				+ "i.ESTADO AS ESTADO_INSTITUCION, "
				+ "MES.VALOR AS MES_CARGADO, "
				+ " MES.ORDEN_MES AS MES_ORDEN, "
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS NOMBRES_TECNICO,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS MAIL_TECNICO,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_TECNICO_MINEDUC+") AS CONTACTOS_TECNICO,"
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS NOMBRES_RESPONSABLE,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS MAIL_RESPONSABLE,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_RESPONSABLE_IE+") AS CONTACTOS_RESPONSABLE,"
				+ "(SELECT (TA.NOMBRE || ' ' || TA.APELLIDO) FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS NOMBRES_DOCENTE,"
				+ "(SELECT TA.EMAIL FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS MAIL_DOCENTE,"
				+ "(SELECT TA.CONTACTO_UNO FROM ACT_TALENTO_HUMANO ta WHERE TA.ID_AFR = f.CODIGO AND TA.CODIGO_CARGO = "+Constantes.CODIGO_ITEM_CATALOGO_DOCENTE_IE+") AS CONTACTOS_DOCENTE "
				+ " FROM "
				+ "ASIGNACIONES.INS_CIR_PAR icp, "
				+ "ASIGNACIONES.INS_CIRCUITO cir, "
				+ "ASIGNACIONES.INS_DISTRITO dis, "
				+ "ASIGNACIONES.INS_PARROQUIA par, "
				+ "ASIGNACIONES.INS_CANTON can, "
				+ "ASIGNACIONES.INS_PROVINCIA pro, "
				+ "ASIGNACIONES.INS_ZONA zon, "
				+ "ASIGNACIONES.INS_INSTITUCION i "
				+ "LEFT OUTER JOIN ACTIVOS.ACT_FORMULARIO f "
				+ "ON f.AMIE = i.AMIE "
				+ "LEFT OUTER JOIN ACTIVOS.ACT_MESES_PARAM_FORMULARIO mf "
				+ "ON f.CODIGO = MF.CODIGO_FORMULARIO "
				+ "LEFT OUTER JOIN ACTIVOS.ACT_MESES_PARAMETRIZADOS mp "
				+ "ON MP.CODIGO = MF.CODIGO_MES_PARAMETRIZADO "
				+ "LEFT OUTER JOIN ACTIVOS.ACT_MESES mes "
				+ "ON MP.CODIGO_MES = MES.CODIGO "
				+ " WHERE ";
		
		//FILTROS
				if(codigoZona != null){
					select = select + " ZON.CODIGO_SENPLADES = '"+codigoZona+"' AND ";
				}
				if(codigoDistrito != null){
					select = select + " DIS.CODIGO_SENPLADES = '"+codigoDistrito+"' AND ";
				}
				if(codigoProvincia != null){
					select = select + " PRO.CODIGO = '"+codigoProvincia+"' AND ";
				}
				if(codigoCanton != null){
					select = select + " CAN.CODIGO = '"+codigoCanton+"' AND ";
				}
				if(estadoIE != null){
					select = select + " i.ESTADO = "+estadoIE+" AND ";
				}
				if(mes != null && opcionCargaFormulario!=null && opcionCargaFormulario.intValue() == Constantes.INSTITUCIONES_HAN_CARGADO_FORMULARIO){
					select = select + " mes.ORDEN_MES = "+mes.intValue()+" AND f.FECHA_CARGA is not NULL AND";
				}else if (opcionCargaFormulario!=null && opcionCargaFormulario.intValue() == Constantes.INSTITUCIONES_SIN_INICIO_DE_CARGA_FORMULARIO) {
					select = select + " f.FECHA_CARGA is NULL AND";
				}else if (opcionCargaFormulario!=null && opcionCargaFormulario.intValue() == Constantes.INSTITUCIONES_NO_HAN_CARGADO_FORMULARIO) {
					select = select + " f.FECHA_CARGA is not NULL AND";
					validarAmie = true;
				}
				
				if(urbanoRural != null){
					select = select + " i.URBANO = "+urbanoRural+" AND ";
				}


				select = select + " i.COD_CIR_PAR = ICP.CODIGO "
						+ "and ICP.COD_CIRCUITO = CIR.CODIGO "
						+ "and CIR.COD_DISTRITO = DIS.CODIGO "
						+ "AND DIS.COD_ZONA = ZON.CODIGO "
						+ "AND ICP.COD_PARROQUIA = PAR.CODIGO "
						+ "AND PAR.COD_CANTON = CAN.CODIGO "
						+ "AND CAN.COD_PROVINCIA = PRO.CODIGO "
						+ " ORDER BY I.AMIE, MES.ORDEN_MES ASC";
		
		Query query = em.createNativeQuery(select);
		
		List<Object[]> listaAux = query.getResultList();
		for (Object objects[] : listaAux) {
			try {
				
			ReporteGeneralDTO objetoReporte= new ReporteGeneralDTO();
			boolean insertObject = false;
			
			if(objects[0]==null){
				objetoReporte.setAmie("No presenta");
			} else {
				objetoReporte.setAmie(String.valueOf(objects[0]));
			}
			if(validarAmie){
				insertObject = validarAmieCargaFormulario(institucionesConcargaFormulario, objetoReporte.getAmie());
			}
			
			if((!validarAmie && !insertObject) || (validarAmie && insertObject)){
				if(objects[1]==null){
					objetoReporte.setFechaCarga(null);
				} else {
					objetoReporte.setFechaCarga((Date)(objects[1]));
				}
				
				if(objects[2]==null){
					objetoReporte.setNombreInstitucion("No presenta");
				} else {
					objetoReporte.setNombreInstitucion(String.valueOf(objects[2]));
				}
				if(objects[3]==null){
					objetoReporte.setZona("No presenta");
				} else {
					objetoReporte.setZona(String.valueOf(objects[3]));
				}
				if(objects[4]==null){
					objetoReporte.setDistrito("No presenta");
				} else {
					objetoReporte.setDistrito(String.valueOf(objects[4]));
				}
				if(objects[5]==null){
					objetoReporte.setProvincia("No presenta");
				} else {
					objetoReporte.setProvincia(String.valueOf(objects[5]));
				}
				if(objects[6]==null){
					objetoReporte.setCanton("No presenta");
				} else {
					objetoReporte.setCanton(String.valueOf(objects[6]));
				}
				if(objects[7]==null){
					objetoReporte.setParroquia("No presenta");
				} else {
					objetoReporte.setParroquia(String.valueOf(objects[7]));
				}
				if(objects[8]==null){
					objetoReporte.setUrbano("sin dato");
				} else {
					String urbano = String.valueOf(objects[8]);
					objetoReporte.setUrbano((urbano.equals("1"))?"Urbano":"Rural");
				}
				if(objects[9]==null){
					objetoReporte.setEstadoIE("No presenta");
				} else {
					Integer estado = Integer.valueOf(String.valueOf(objects[9]));	
					objetoReporte.setEstadoIE((estado.intValue()==1)?"Activa":"Inactiva");
				}
				if(objects[10]==null){
					objetoReporte.setNombreMes("No presenta");
				} else {
					objetoReporte.setNombreMes(String.valueOf(objects[10]));
				}
				if(objects[11]==null){
					objetoReporte.setOrdenMes(0);
				} else {
					objetoReporte.setOrdenMes(Integer.valueOf(String.valueOf(objects[11])));
				}
				if(objects[12]==null){
					objetoReporte.setNombresTecnicoMinEduc("No presenta");
				} else {
					objetoReporte.setNombresTecnicoMinEduc(String.valueOf(objects[12]));
				}
				if(objects[13]==null){
					objetoReporte.setMailTecnicoMinEduc("No presenta");
				} else {
					objetoReporte.setMailTecnicoMinEduc(String.valueOf(objects[13]));
				}
				if(objects[14]==null){
					objetoReporte.setContactosTecnicoMinEduc("No presenta");
				} else {
					objetoReporte.setContactosTecnicoMinEduc(String.valueOf(objects[14]));
				}
				if(objects[15]==null){
					objetoReporte.setNombresResponsableIe("No presenta");
				} else {
					objetoReporte.setNombresResponsableIe(String.valueOf(objects[15]));
				}
				if(objects[16]==null){
					objetoReporte.setMailResponsableIe("No presenta");
				} else {
					objetoReporte.setMailResponsableIe(String.valueOf(objects[16]));
				}
				if(objects[17]==null){
					objetoReporte.setContactosResponsableIe("No presenta");
				} else {
					objetoReporte.setContactosResponsableIe(String.valueOf(objects[17]));
				}
				if(objects[18]==null){
					objetoReporte.setNombresDocenteIe("No presenta");
				} else {
					objetoReporte.setNombresDocenteIe(String.valueOf(objects[18]));
				}
				if(objects[19]==null){
					objetoReporte.setMailDocenteIe("No presenta");
				} else {
					objetoReporte.setMailDocenteIe(String.valueOf(objects[19]));
				}
				if(objects[20]==null){
					objetoReporte.setContactosDocenteIe("No presenta");
				} else {
					objetoReporte.setContactosDocenteIe(String.valueOf(objects[20]));
				}
				reporte.add(objetoReporte);
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reporte;
	}
	
	private boolean validarAmieCargaFormulario(List<ActMesParametrizadoFormulario> institucionesConcargaFormulario, String amie){
		boolean insertarIEnoCargo = true;
		for (ActMesParametrizadoFormulario actMesParametrizadoFormulario : institucionesConcargaFormulario) {
			if(actMesParametrizadoFormulario.getFormulario().getAmie().equals(amie)){
				insertarIEnoCargo = false;
				break;
			}
		}
		
		return insertarIEnoCargo;
	}
	
}
