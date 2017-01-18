package ec.gob.educacion.activos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.assembler.AccesibilidadServicioAsm;
import ec.gob.educacion.activos.assembler.ConectividadAsm;
import ec.gob.educacion.activos.assembler.CuartoServidoreAsm;
import ec.gob.educacion.activos.assembler.FormularioAsm;
import ec.gob.educacion.activos.assembler.JornadaEducacionAsm;
import ec.gob.educacion.activos.assembler.JornadaEducacionTiAsm;
import ec.gob.educacion.activos.assembler.NumeroDocenteAsm;
import ec.gob.educacion.activos.assembler.NumeroEstudianteAsm;
import ec.gob.educacion.activos.assembler.NumeroParaleloAsm;
import ec.gob.educacion.activos.assembler.PromedioEstudianteAsm;
import ec.gob.educacion.activos.assembler.RecursoDigitalAsm;
import ec.gob.educacion.activos.assembler.TalentoHumanoAsm;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.enumerator.OrigenActivoEnum;
import ec.gob.educacion.activos.exception.AccesibilidadServicioException;
import ec.gob.educacion.activos.exception.ConectividadException;
import ec.gob.educacion.activos.exception.CuartoServidoreException;
import ec.gob.educacion.activos.exception.FormularioException;
import ec.gob.educacion.activos.exception.JornadaEducacionException;
import ec.gob.educacion.activos.exception.JornadaEducacionTiException;
import ec.gob.educacion.activos.exception.NumeroDocenteException;
import ec.gob.educacion.activos.exception.NumeroEstudianteException;
import ec.gob.educacion.activos.exception.NumeroParaleloException;
import ec.gob.educacion.activos.exception.PromedioEstudianteException;
import ec.gob.educacion.activos.exception.RecursoDigitalException;
import ec.gob.educacion.activos.exception.SalaLaboratorioException;
import ec.gob.educacion.activos.exception.TalentoHumanoException;
import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActJornadaEducacion;
import ec.gob.educacion.activos.model.ActJornadaEducacionTi;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.model.ActMesParametrizado;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;
import ec.gob.educacion.activos.model.ActNumeroDocente;
import ec.gob.educacion.activos.model.ActNumeroEstudiante;
import ec.gob.educacion.activos.model.ActNumeroParalelo;
import ec.gob.educacion.activos.model.ActPromedioEstudiante;
import ec.gob.educacion.activos.model.ActRecursoDigital;
import ec.gob.educacion.activos.model.ActTalentoHumano;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.resources.FileUtils;
import ec.gob.educacion.activos.resources.Utils;
import ec.gob.educacion.activos.service.AccesibilidadServicioService;
import ec.gob.educacion.activos.service.ConectividadService;
import ec.gob.educacion.activos.service.CuartoServidoreService;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.FormularioService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.JornadaEducacionService;
import ec.gob.educacion.activos.service.JornadaEducacionTiService;
import ec.gob.educacion.activos.service.MesParametrizadoFormularioService;
import ec.gob.educacion.activos.service.MesParametrizadoService;
import ec.gob.educacion.activos.service.NumeroDocenteService;
import ec.gob.educacion.activos.service.NumeroEstudianteService;
import ec.gob.educacion.activos.service.NumeroParaleloService;
import ec.gob.educacion.activos.service.PromedioEstudianteService;
import ec.gob.educacion.activos.service.RecursoDigitalService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;
import ec.gob.educacion.activos.service.TalentoHumanoService;
import ec.gob.educacion.mineduc.activo.db.dto.ActAccesibilidadServiciosDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActConectividadDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActCuartoServidoresDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActDetalleLaboratorioTiDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActFormularioCompletoDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActFormularioDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActJornadaEducacionDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActJornadaEducacionTiDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActLaboratorioTiDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActLaboratorioVariosDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActNumeroDocentesDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActNumeroEstudiantesDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActNumeroParalelosDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActPromedioEstudiantesDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActRecursoDigitalDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActSalaTiDTO;
import ec.gob.educacion.mineduc.activo.db.dto.ActTalentoHumanoDTO;
import ec.gob.educacion.mineduc.principal.db.dto.InstitucionEducativaDTO;

@Named
@ViewScoped
public class CargaArchivoController extends BaseController implements Serializable {

	private static final long serialVersionUID = 1667827067919651262L;
	
	@EJB
	private InstitucionService institucionService;
	@EJB
	private FormularioService formularioService;
	@EJB
	private NumeroEstudianteService numeroEstudianteService;
	@EJB
	private NumeroDocenteService numeroDocenteService;
	@EJB
	private NumeroParaleloService numeroParaleloService;
	@EJB
	private PromedioEstudianteService promedioEstudianteService;
	@EJB
	private TalentoHumanoService talentoHumanoService;
	@EJB
	private CuartoServidoreService cuartoServidoreService;
	@EJB
	private JornadaEducacionService jornadaEducacionService;
	@EJB
	private JornadaEducacionTiService jornadaEducacionTiService;
	@EJB
	private RecursoDigitalService recursoDigitalService;
	@EJB
	private AccesibilidadServicioService accesibilidadServicioService;
	@EJB
	private ConectividadService conectividadService;
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	@EJB
	private DetalleActivoService detalleActivoService;
	@EJB
	private ItemCatalogoService itemCatalogoService;
	@EJB
	private MesParametrizadoService mesParametrizadoService;
	@EJB
	private MesParametrizadoFormularioService mesParametrizadoFormularioService;

	
	@Inject
	private SessionController sessionController;
	
	private InstitucionEducativaDTO institucionEducativaDTO;
	private ActFormularioCompletoDTO actFormularioCompletoDTO;
	
	private InsInstitucion insInstitucion;
	private ActFormulario actFormulario;
	private ActNumeroEstudiante actNumeroEstudiante;
	private ActNumeroDocente actNumeroDocente;
	private ActNumeroParalelo actNumeroParalelo;
	private ActPromedioEstudiante actPromedioEstudiante;
	private ActTalentoHumano actTalentoHumano;
	private ActCuartoServidore actCuartoServidore;
	private ActJornadaEducacion actJornadaEducacion;
	private ActJornadaEducacionTi actJornadaEducacionTi;
	private ActRecursoDigital actRecursoDigital;
	private ActAccesibilidadServicio actAccesibilidadServicio;
	private ActConectividad actConectividad;
	private ActLaboratorioSala actLaboratorioSala;
	
	private String username;
	private int anio;
	private String nombreArchivoCargado;
	private InputStream archivoCargado;
	private boolean esSustitutiva;
	private boolean deshabilitarGuardar;
	private boolean deshabilitarCargar;
	private String mensaje;
	private String mensajeError = "";
	private boolean verFormulario;
	private String mensajeInstitucionError;
	private String ubicacionArchivos;
	
	
	private List<ActMesParametrizado> mesesParametrizados = new ArrayList<ActMesParametrizado>();
	private List<ActMesParametrizado> mesesNoCargados = new ArrayList<ActMesParametrizado>();
	private List<ActMesParametrizadoFormulario> formulariosCargadosParametrizados = new ArrayList<ActMesParametrizadoFormulario>();
	private boolean cargaActualizada;
	private ActMesParametrizado mesPorCargar;
	

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "cargaFormulario.xhtml");
		username = sessionController.getUserSecurity().getUsername();
		anio = Calendar.getInstance().get(Calendar.YEAR);
		mesesParametrizados = mesParametrizadoService.ListadoPorAnio(anio);
		insInstitucion = institucionService.obtenerPorAmie(username);
		verFormulario = Boolean.TRUE;
		mensajeInstitucionError = "";
		if (insInstitucion == null) {
			verFormulario = Boolean.FALSE;
			mensajeInstitucionError = "El usuario que ha iniciado sesión no es una institución educativa.";
		} else {
			//VALIDAR EL OBTENER LA DIRECCIÓN DONDE SE PROCEDERÁ A GUARDAR LOS ZIPS CARGADOS
			List<ActItemCatalogo> actItemCatalogos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.CARPETA_ARCHIVOS);
			if (actItemCatalogos == null || actItemCatalogos.isEmpty()) {
				verFormulario = Boolean.FALSE;
				mensajeInstitucionError = "Error al obtener la ubicación de los archivos. Por favor comuníquese con el administrador del sistema.";
			} else if (actItemCatalogos.get(0).getDescripcion() == null || "".equals(actItemCatalogos.get(0).getDescripcion().trim())) {
				verFormulario = Boolean.FALSE;
				mensajeInstitucionError = "Ubicación de los archivos inválida. Por favor comuníquese con el administrador del sistema.";
			} else {
				//VALIDACION PARA COMPROBAR SI EXISTEN FORMULARIOS CARGADOS
				deshabilitarGuardar = true;
				deshabilitarCargar = false;
				listarFormulariosCargadosPorInstitucion(insInstitucion.getAmie());
				mesPorCargar = Utils.mesPorCargar(mesesParametrizados);
				//ubicacionArchivos = actItemCatalogos.get(0).getDescripcion().trim();
				ubicacionArchivos = "C:/arhivosActivos/";
			}
		}
	}
	
	/**
	 * Método que permite la carga de un archivo generado desde el cliente
	 * pesado que contiene el formulario de activos
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void cargarFormulario(FileUploadEvent event) throws Exception {
		mensajeError = "";
		institucionEducativaDTO = null;
		actFormularioCompletoDTO = null;
		
		UploadedFile item = event.getUploadedFile();
		
		if (item.getSize() <= (Constantes.TAMANIO_MEGA * Constantes.CANTIDAD_MEGA)) {
			try {
				nombreArchivoCargado = event.getUploadedFile().getName();
				archivoCargado = event.getUploadedFile().getInputStream();
				ZipInputStream zis = new ZipInputStream(item.getInputStream());
				ZipEntry ze = zis.getNextEntry();
				
				while (ze != null) {
					try {
						String nombreArchivo = ze.getName();
						String clase = nombreArchivo.substring(0, nombreArchivo.indexOf("_"));
						File archivo = FileUtils.crearArchivo(clase, zis, Boolean.TRUE, ".bin", Boolean.FALSE);
		
						FileInputStream otherZe = new FileInputStream(archivo);
						ObjectInputStream oin = new ObjectInputStream(otherZe);
						if ("InstitucionEducativaDTO".equals(clase)) {
							institucionEducativaDTO = (InstitucionEducativaDTO) oin.readObject();
						} else if ("ActFormularioCompletoDTO".equals(clase)) {
							actFormularioCompletoDTO = (ActFormularioCompletoDTO) oin.readObject();
						}
						oin.close();
						otherZe.close();
						archivo.delete();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					ze = zis.getNextEntry();
				}
		
				zis.closeEntry();
				zis.close();
				
				deshabilitarGuardar = !validarArchivo();
				deshabilitarCargar = Boolean.FALSE;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			agregarMensajeError(
					"El archivo seleccionado ha sobrepasado el tamaño máximo de " + Constantes.CANTIDAD_MEGA + " M.",
					"El archivo seleccionado ha sobrepasado el tamaño máximo de " + Constantes.CANTIDAD_MEGA + " M.");
		}
	}
	
	/**
	 * Método que permite guardar la información cargada desde el formulario
	 * generado desde el cliente pesado
	 */
	public void guardarFormulario() {
		try {
			cargarActFormulario(actFormularioCompletoDTO.getActFormularioDTO(), esSustitutiva);
			cargarActNumeroEstudiantes(actFormularioCompletoDTO.getActNumeroEstudiantesDTOs());
			cargarActNumeroDocentes(actFormularioCompletoDTO.getActNumeroDocentesDTOs());
			cargarActNumeroParalelos(actFormularioCompletoDTO.getActNumeroParalelosDTOs());
			cargarActPromedioEstudiantes(actFormularioCompletoDTO.getActPromedioEstudiantesDTOs());
			cargarActTalentoHumano(actFormularioCompletoDTO.getActTalentoHumanoDTOs());
			cargarActCuartoServidores(actFormularioCompletoDTO.getActCuartoServidoresDTOs());
			cargarActJornadaEducacion(actFormularioCompletoDTO.getActJornadaEducacionDTOs());
			cargarActJornadaEducacionTi(actFormularioCompletoDTO.getActJornadaEducacionTiDTOs());
			cargarActRecursoDigital(actFormularioCompletoDTO.getActRecursoDigitalDTOs());
			cargarActAccesibilidadServicios(actFormularioCompletoDTO.getActAccesibilidadServiciosDTOs());
			cargarActConectividad(actFormularioCompletoDTO.getActConectividadDTOs());
			cargarActLaboratorioTi(actFormularioCompletoDTO.getActLaboratorioTiDTOs(), actFormularioCompletoDTO.getActDetalleLaboratorioTiDTOs());
			cargarActLaboratorioVarios(actFormularioCompletoDTO.getActLaboratorioVariosDTOs(), actFormularioCompletoDTO.getActDetalleLaboratorioTiDTOs());
			cargarActSalaTi(actFormularioCompletoDTO.getActSalaTiDTOs(), actFormularioCompletoDTO.getActDetalleLaboratorioTiDTOs());
			cargarActBiblioteca(actFormularioCompletoDTO.getActFormularioDTO().getIdAfr(), actFormularioCompletoDTO.getActDetalleLaboratorioTiDTOs());
			cargarActAreaAdministrativa(actFormularioCompletoDTO.getActFormularioDTO().getIdAfr(), actFormularioCompletoDTO.getActDetalleLaboratorioTiDTOs());
			
			//Se controla la carga del formulario en base a los mese de carga parametrizados
			controlCargaFormulario(actFormulario);
			//Se salva el formulario fisicamente
			FileUtils.crearDirectorio(ubicacionArchivos + "/" + username);
			FileUtils.crearArchivo(ubicacionArchivos + "/" + username + "/" + nombreArchivoCargado, archivoCargado, Boolean.FALSE, null, Boolean.TRUE);
			
			agregarMensajeInformacion("Formulario procesado exitosamente.", "Formulario procesado exitosamente.");
			
			listarFormulariosCargadosPorInstitucion(actFormulario.getAmie());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			agregarMensajeError(
					"El formulario que intentó cargar ya se encuentra registrado. Por favor verifique.",
					"El formulario que intentó cargar ya se encuentra registrado. Por favor verifique.");
			e.printStackTrace();
		}
		deshabilitarGuardar = Boolean.TRUE;
		deshabilitarCargar = false;
	}
	
	/**
	 * Método que permite almacenar la información del formulario
	 * 
	 * @param dto
	 * @param esSustitutiva
	 */
	private void cargarActFormulario(ActFormularioDTO dto, boolean esSustitutiva) {
		try {
			actFormulario = new ActFormulario();
			FormularioAsm.fromDto(actFormulario, dto);
			actFormulario.setCodigoInstitucion(insInstitucion.getCodigo());
			actFormulario.setFechaCarga(new Date());
			actFormulario.setIdArchivo(nombreArchivoCargado);
			actFormulario.setTipo(0);
			actFormulario.setAmie(institucionEducativaDTO.getAmie());
			formularioService.guardar(actFormulario);
		} catch (FormularioException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que permite almacenar la información de número de estudiantes
	 * 
	 * @param dtos
	 */
	private void cargarActNumeroEstudiantes(List<ActNumeroEstudiantesDTO> dtos) {
		for (ActNumeroEstudiantesDTO dto : dtos) {
			try {
				actNumeroEstudiante = new ActNumeroEstudiante();
				NumeroEstudianteAsm.fromDto(actNumeroEstudiante, dto);
				actNumeroEstudiante.setActFormulario(actFormulario);
				numeroEstudianteService.guardar(actNumeroEstudiante);
			} catch (NumeroEstudianteException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de número de docentes
	 * 
	 * @param dtos
	 */
	private void cargarActNumeroDocentes(List<ActNumeroDocentesDTO> dtos) {
		for (ActNumeroDocentesDTO dto : dtos) {
			try {
				actNumeroDocente = new ActNumeroDocente();
				NumeroDocenteAsm.fromDto(actNumeroDocente, dto);
				actNumeroDocente.setActFormulario(actFormulario);
				numeroDocenteService.guardar(actNumeroDocente);
			} catch (NumeroDocenteException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de número de paralelos
	 * 
	 * @param dtos
	 */
	private void cargarActNumeroParalelos(List<ActNumeroParalelosDTO> dtos) {
		for (ActNumeroParalelosDTO dto : dtos) {
			try {
				actNumeroParalelo = new ActNumeroParalelo();
				NumeroParaleloAsm.fromDto(actNumeroParalelo, dto);
				actNumeroParalelo.setActFormulario(actFormulario);
				numeroParaleloService.guardar(actNumeroParalelo);
			} catch (NumeroParaleloException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de promedio de estudiantes
	 * 
	 * @param dtos
	 */
	private void cargarActPromedioEstudiantes(List<ActPromedioEstudiantesDTO> dtos) {
		for (ActPromedioEstudiantesDTO dto : dtos) {
			try {
				actPromedioEstudiante = new ActPromedioEstudiante();
				PromedioEstudianteAsm.fromDto(actPromedioEstudiante, dto);
				actPromedioEstudiante.setActFormulario(actFormulario);
				promedioEstudianteService.guardar(actPromedioEstudiante);
			} catch (PromedioEstudianteException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de talento humano
	 * 
	 * @param dtos
	 */
	private void cargarActTalentoHumano(List<ActTalentoHumanoDTO> dtos) {
		for (ActTalentoHumanoDTO dto : dtos) {
			try {
				actTalentoHumano = new ActTalentoHumano();
				TalentoHumanoAsm.fromDto(actTalentoHumano, dto);
				actTalentoHumano.setActFormulario(actFormulario);
				talentoHumanoService.guardar(actTalentoHumano);
			} catch (TalentoHumanoException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de cuarto de servidores
	 * 
	 * @param dtos
	 */
	private void cargarActCuartoServidores(List<ActCuartoServidoresDTO> dtos) {
		for (ActCuartoServidoresDTO dto : dtos) {
			try {
				actCuartoServidore = new ActCuartoServidore();
				CuartoServidoreAsm.fromDto(actCuartoServidore, dto);
				actCuartoServidore.setActFormulario(actFormulario);
				cuartoServidoreService.guardar(actCuartoServidore);
			} catch (CuartoServidoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de jornadas educativas
	 * 
	 * @param dtos
	 */
	private void cargarActJornadaEducacion(List<ActJornadaEducacionDTO> dtos) {
		for (ActJornadaEducacionDTO dto : dtos) {
			try {
				actJornadaEducacion = new ActJornadaEducacion();
				JornadaEducacionAsm.fromDto(actJornadaEducacion, dto);
				actJornadaEducacion.setActFormulario(actFormulario);
				jornadaEducacionService.guardar(actJornadaEducacion);
			} catch (JornadaEducacionException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de jornadas educativas
	 * 
	 * @param dtos
	 */
	private void cargarActJornadaEducacionTi(List<ActJornadaEducacionTiDTO> dtos) {
		for (ActJornadaEducacionTiDTO dto : dtos) {
			try {
				actJornadaEducacionTi = new ActJornadaEducacionTi();
				JornadaEducacionTiAsm.fromDto(actJornadaEducacionTi, dto);
				actJornadaEducacionTi.setActFormulario(actFormulario);
				jornadaEducacionTiService.guardar(actJornadaEducacionTi);
			} catch (JornadaEducacionTiException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de recursos digitales
	 * 
	 * @param dtos
	 */
	private void cargarActRecursoDigital(List<ActRecursoDigitalDTO> dtos) {
		for (ActRecursoDigitalDTO dto : dtos) {
			try {
				actRecursoDigital = new ActRecursoDigital();
				RecursoDigitalAsm.fromDto(actRecursoDigital, dto);
				actRecursoDigital.setActFormulario(actFormulario);
				recursoDigitalService.guardar(actRecursoDigital);
			} catch (RecursoDigitalException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de accesibilidad a servicios
	 * 
	 * @param dtos
	 */
	private void cargarActAccesibilidadServicios(List<ActAccesibilidadServiciosDTO> dtos) {
		for (ActAccesibilidadServiciosDTO dto : dtos) {
			try {
				actAccesibilidadServicio = new ActAccesibilidadServicio();
				AccesibilidadServicioAsm.fromDto(actAccesibilidadServicio, dto);
				actAccesibilidadServicio.setActFormulario(actFormulario);
				accesibilidadServicioService.guardar(actAccesibilidadServicio);
			} catch (AccesibilidadServicioException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de conectividad
	 * 
	 * @param dtos
	 */
	private void cargarActConectividad(List<ActConectividadDTO> dtos) {
		for (ActConectividadDTO dto : dtos) {
			try {
				actConectividad = new ActConectividad();
				ConectividadAsm.fromDto(actConectividad, dto);
				actConectividad.setActFormulario(actFormulario);
				conectividadService.guardar(actConectividad);
			} catch (ConectividadException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de laboratorios TI
	 * 
	 * @param dtos
	 */
	private void cargarActLaboratorioTi(List<ActLaboratorioTiDTO> dtos, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		for (ActLaboratorioTiDTO dto : dtos) {
			//cargamos los valores
			long computadores = (dto.getComputadoras()!=null)?dto.getComputadoras().longValue():0;
			long impresoras = (dto.getImpresoras()!=null)?dto.getImpresoras().longValue():0;
			long pizarrasInteractivas = (dto.getPizarraInteractiva()!=null)?dto.getPizarraInteractiva().longValue():0;
			long proyectores = (dto.getProyectores()!=null)?dto.getProyectores().longValue():0;
			long sistemasAudio = (dto.getSistemaAudio()!=null)?dto.getSistemaAudio().longValue():0;
			Double velocidadNavegacion = (dto.getVelocidadNavegacion()!=null)?dto.getVelocidadNavegacion().doubleValue():null;
			
			if(!Utils.esLaboratorioVacioDto(dto, 1)){
				crearActLaboratorioSalaNuevaVersion(actFormulario, computadores, impresoras, pizarrasInteractivas,
						proyectores, sistemasAudio, dto.getNumeroLaboratorio(), LaboratorioSalaEnum.LABORATORIO_TI.getCodigo(), dto.getTieneInternet(),
						dto.getEnUso(), dto.getProveedorInternet(), velocidadNavegacion, dto.getIdAlt(), detalleActivosDtos);
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de laboratorios varios
	 * 
	 * @param dtos
	 */
	private void cargarActLaboratorioVarios(List<ActLaboratorioVariosDTO> dtos, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		for (ActLaboratorioVariosDTO dto : dtos) {
			//cargamos los valores
			long computadores = (dto.getComputadoras()!=null)?dto.getComputadoras().longValue():0;
			long impresoras = (dto.getImpresoras()!=null)?dto.getImpresoras().longValue():0;
			long pizarrasInteractivas = (dto.getPizarraInteractiva()!=null)?dto.getPizarraInteractiva().longValue():0;
			long proyectores = (dto.getProyectores()!=null)?dto.getProyectores().longValue():0;
			long sistemasAudio = (dto.getSistemaAudio()!=null)?dto.getSistemaAudio().longValue():0;
			Double velocidadNavegacion = (dto.getVelocidadNavegacion()!=null)?dto.getVelocidadNavegacion().doubleValue():null;
			
			if(!Utils.esLaboratorioVacioDto(dto, 2)){
				crearActLaboratorioSalaNuevaVersion(actFormulario, computadores, impresoras, pizarrasInteractivas,
						proyectores, sistemasAudio, dto.getNombreLaboratorio(), dto.getCodigoLaboratorio(), dto.getTieneInternet(),
						dto.getEnUso(), dto.getProveedorInternet(), velocidadNavegacion, dto.getIdAlv(), detalleActivosDtos);
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de salas de clase
	 * 
	 * @param dtos
	 */
	private void cargarActSalaTi(List<ActSalaTiDTO> dtos, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		for (ActSalaTiDTO dto : dtos) {
			//cargamos los valores
			long computadores = (dto.getComputadoras()!=null)?dto.getComputadoras().longValue():0;
			long impresoras = (dto.getImpresoras()!=null)?dto.getImpresoras().longValue():0;
			long pizarrasInteractivas = (dto.getPizarraInteractiva()!=null)?dto.getPizarraInteractiva().longValue():0;
			long proyectores = (dto.getProyectores()!=null)?dto.getProyectores().longValue():0;
			long sistemasAudio = (dto.getSistemaAudio()!=null)?dto.getSistemaAudio().longValue():0;
			Double velocidadNavegacion = (dto.getVelocidadNavegacion()!=null)?dto.getVelocidadNavegacion().doubleValue():null;
			
			if(!Utils.esLaboratorioVacioDto(dto, 3)){
				crearActLaboratorioSalaNuevaVersion(actFormulario, computadores, impresoras, pizarrasInteractivas,
						proyectores, sistemasAudio, dto.getNombreNivel(), dto.getCodigoNivel(), dto.getTieneInternet(),
						dto.getEnUso(), dto.getProveedorInternet(), velocidadNavegacion, dto.getIdAst(), detalleActivosDtos);
			}
		}
	}
	
	/**
	 * Método que permite almacenar la información de biblioteca
	 */
	private void cargarActBiblioteca(Integer codigoFormularioDtoCarga, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		if (actFormulario.getNumeroTiBiblioteca() != null) {
			//cargamos los valores
			long computadores = (actFormulario.getNumeroTiBiblioteca()!=null)?actFormulario.getNumeroTiBiblioteca().longValue():0;
			long impresoras = (actFormulario.getNumeroImpresorasBiblioteca()!=null)?actFormulario.getNumeroImpresorasBiblioteca().longValue():0;
			long pizarrasInteractivas = 0;
			long proyectores = 0;
			long sistemasAudio = 0;
			Double velocidadNavegacion = null;
			
			crearActLaboratorioSalaNuevaVersion(actFormulario, computadores, impresoras, pizarrasInteractivas,
					proyectores, sistemasAudio, LaboratorioSalaEnum.BIBLIOTECA.getDescripcion(), LaboratorioSalaEnum.BIBLIOTECA.getCodigo(), actFormulario.getTieneInternetBiblioteca(),
					1, null, velocidadNavegacion, codigoFormularioDtoCarga, detalleActivosDtos);
		}
	}
	
	/**
	 * Método que permite almacenar la información de área administrativa
	 */
	private void cargarActAreaAdministrativa(Integer codigoFormularioDtoCarga, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		if (actFormulario.getNumeroTiAdministrativo() != null) {
			//cargamos los valores
			long computadores = (actFormulario.getNumeroTiAdministrativo()!=null)?actFormulario.getNumeroTiAdministrativo().longValue():0;
			long impresoras = (actFormulario.getNumeroImpresorasAdministrativo()!=null)?actFormulario.getNumeroImpresorasAdministrativo().longValue():0;
			long pizarrasInteractivas = 0;
			long proyectores = 0;
			long sistemasAudio = 0;
			Double velocidadNavegacion = null;
			
			crearActLaboratorioSalaNuevaVersion(actFormulario, computadores, impresoras, pizarrasInteractivas,
					proyectores, sistemasAudio, LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getDescripcion(), LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo(), actFormulario.getTieneInternetAdministrativo(),
					1, null, velocidadNavegacion, codigoFormularioDtoCarga, detalleActivosDtos);
		}
	}
	
	
	/**
	 * Método que permite crear un nuevo laboratorio, sala de clases, biblioteca y area administrativa 
	 * @param actFormulario
	 * @param computadoras
	 * @param impresoras
	 * @param pizarraInteractiva
	 * @param proyectores
	 * @param sistemaAudio
	 * @param nombreLabSala
	 * @param codigoTipoLabSala
	 * @param tieneInternet
	 * @param enUso
	 * @param proveedor
	 * @param velocidadNavegacion
	 * @param codigoLabSalaDto
	 * @param detalleActivosDtos
	 */
	private void crearActLaboratorioSalaNuevaVersion(ActFormulario actFormulario, long computadoras, long impresoras, long pizarraInteractiva, long proyectores, 
			long sistemaAudio, String nombreLabSala, long codigoTipoLabSala, Integer tieneInternet, Integer enUso, String proveedor, Double velocidadNavegacion, 
			Integer codigoLabSalaDto, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos) {
		
		actLaboratorioSala = new ActLaboratorioSala();
		actLaboratorioSala.setCodigoTipo(codigoTipoLabSala);
		actLaboratorioSala.setActFormulario(actFormulario);
		actLaboratorioSala.setFechaCreacion(actFormulario.getFechaCarga());
		actLaboratorioSala.setTipoCreacion(OrigenActivoEnum.ARCHIVO_CARGADO.getCodigo());
		
		actLaboratorioSala.setComputadoras(computadoras);
		actLaboratorioSala.setImpresoras(impresoras);
		actLaboratorioSala.setNombreTipo(nombreLabSala);
		actLaboratorioSala.setPizarraInteractiva(pizarraInteractiva);
		actLaboratorioSala.setProyectores(proyectores);
		actLaboratorioSala.setSistemaAudio(sistemaAudio);
		actLaboratorioSala.setTieneInternet((tieneInternet!=null)?tieneInternet.intValue():0);
		actLaboratorioSala.setEnUso((enUso!=null)?enUso.intValue():0);
		actLaboratorioSala.setProveedorInternet(proveedor);
		actLaboratorioSala.setVelocidadNavegacion(velocidadNavegacion);
		
		try {
			salaLaboratorioService.guardar(actLaboratorioSala);			
			crearDetalleActivosNuevaVersion(codigoLabSalaDto, actLaboratorioSala, detalleActivosDtos, codigoTipoLabSala);
		} catch (SalaLaboratorioException e) {
			e.printStackTrace();
		}
	}
	 
	/**
	 * Método que permite crear el detalle de todos los activos de los laboratorios, salas de clases, bilbioteca y area administrativa
	 * @param codigoLabSalaDto
	 * @param actLaboratorioSala
	 * @param detalleActivosDtos
	 */
	private void crearDetalleActivosNuevaVersion(Integer codigoLabSalaDto, ActLaboratorioSala actLaboratorioSala, List<ActDetalleLaboratorioTiDTO> detalleActivosDtos, long codigoTipoLabSala){
		for (ActDetalleLaboratorioTiDTO actDetalleLaboratorioTiDTO : detalleActivosDtos) {
			if(getOpcionCrearDetalleActivo(actDetalleLaboratorioTiDTO, codigoLabSalaDto, codigoTipoLabSala)){
				try {
					ActDetalleActivo actDetalleActivo = new ActDetalleActivo();	
					actDetalleActivo.setCodigoTipo((actDetalleLaboratorioTiDTO.getCodigoItem()!=null)?actDetalleLaboratorioTiDTO.getCodigoItem().longValue():0);
					actDetalleActivo.setEstado((actDetalleLaboratorioTiDTO.getEstado()!=null)?actDetalleLaboratorioTiDTO.getEstado().intValue():0);
					actDetalleActivo.setFechaCreacion(actFormulario.getFechaCarga());
					actDetalleActivo.setTipoCreacion(OrigenActivoEnum.ARCHIVO_CARGADO.getCodigo());
					actDetalleActivo.setActLaboratorioSala(actLaboratorioSala);
					
					actDetalleActivo.setSerial(actDetalleLaboratorioTiDTO.getSerial());
					actDetalleActivo.setCapacidadDisco((actDetalleLaboratorioTiDTO.getCapacidadDisco() != null)?actDetalleLaboratorioTiDTO.getCapacidadDisco().doubleValue():null);
					actDetalleActivo.setCodigoMarca((actDetalleLaboratorioTiDTO.getCodigoMarca() != null)?actDetalleLaboratorioTiDTO.getCodigoMarca().longValue():null);
					actDetalleActivo.setOtraMarca(((actDetalleLaboratorioTiDTO.getOtraMarca()!=null)?actDetalleLaboratorioTiDTO.getOtraMarca():null));
					actDetalleActivo.setCodigoSOPrincipal((actDetalleLaboratorioTiDTO.getCodigoSOPrincipal() != null)?actDetalleLaboratorioTiDTO.getCodigoSOPrincipal().longValue():null);
					actDetalleActivo.setCodigoSOSecundario((actDetalleLaboratorioTiDTO.getCodigoSOSecundario() != null)?actDetalleLaboratorioTiDTO.getCodigoSOSecundario().longValue():null);
					actDetalleActivo.setCodigoEstadoActivo((actDetalleLaboratorioTiDTO.getCodigoEstadoActivo() != null)?actDetalleLaboratorioTiDTO.getCodigoEstadoActivo().longValue():null);
					actDetalleActivo.setCodigoProcedenciaActivo((actDetalleLaboratorioTiDTO.getCodigoProcedenciaActivo() != null)?actDetalleLaboratorioTiDTO.getCodigoProcedenciaActivo().longValue():null);
					actDetalleActivo.setModelo(actDetalleLaboratorioTiDTO.getModelo());
					actDetalleActivo.setMemoriaRam((actDetalleLaboratorioTiDTO.getMemoriaRam() != null)?actDetalleLaboratorioTiDTO.getMemoriaRam().doubleValue():null);
					actDetalleActivo.setVelocidadProcesador((actDetalleLaboratorioTiDTO.getVelocidadProcesador() != null)?actDetalleLaboratorioTiDTO.getVelocidadProcesador().doubleValue():null);
					actDetalleActivo.setTieneDobleBooteo(actDetalleLaboratorioTiDTO.getTieneDobleBooteo());
					detalleActivoService.guardar(actDetalleActivo);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método que permite determinar si el detalle del activo actual se guarda o no
	 * @param actDetalleLaboratorioTiDTO
	 * @param codigoLabSalaDto
	 * @return true or false
	 */
	private boolean getOpcionCrearDetalleActivo(ActDetalleLaboratorioTiDTO actDetalleLaboratorioTiDTO, Integer codigoLabSalaDto, long codigoTipoLabSala){
		boolean crearActivo = false;
		if(actDetalleLaboratorioTiDTO.getCodigoAlt() != null && actDetalleLaboratorioTiDTO.getCodigoAfr() == null && actDetalleLaboratorioTiDTO.getCodigoAlv() == null && actDetalleLaboratorioTiDTO.getCodigoAst() == null && actDetalleLaboratorioTiDTO.getCodigoAlt().equals(codigoLabSalaDto) && getOpcionTipoLaboratorioSala(codigoTipoLabSala) == 1){
			crearActivo = true;
		}else if (actDetalleLaboratorioTiDTO.getCodigoAlt() == null && actDetalleLaboratorioTiDTO.getCodigoAfr() == null && actDetalleLaboratorioTiDTO.getCodigoAlv() != null && actDetalleLaboratorioTiDTO.getCodigoAst() == null && actDetalleLaboratorioTiDTO.getCodigoAlv().equals(codigoLabSalaDto) && getOpcionTipoLaboratorioSala(codigoTipoLabSala) == 2) {
			crearActivo = true;
		}else if (actDetalleLaboratorioTiDTO.getCodigoAlt() == null && actDetalleLaboratorioTiDTO.getCodigoAfr() == null && actDetalleLaboratorioTiDTO.getCodigoAlv() == null && actDetalleLaboratorioTiDTO.getCodigoAst() != null && actDetalleLaboratorioTiDTO.getCodigoAst().equals(codigoLabSalaDto) && getOpcionTipoLaboratorioSala(codigoTipoLabSala) == 3) {
			crearActivo = true;
		}else if (actDetalleLaboratorioTiDTO.getCodigoAlt() == null && actDetalleLaboratorioTiDTO.getCodigoAfr() != null && actDetalleLaboratorioTiDTO.getCodigoAlv() == null && actDetalleLaboratorioTiDTO.getCodigoAst() == null && actDetalleLaboratorioTiDTO.getCodigoAfr().equals(codigoLabSalaDto)) {
			if(getOpcionTipoLaboratorioSala(codigoTipoLabSala) == 4 && actDetalleLaboratorioTiDTO.getEsBiblioteca()!=null && actDetalleLaboratorioTiDTO.getEsBiblioteca().intValue()==1){
				crearActivo = true;
			}else if (getOpcionTipoLaboratorioSala(codigoTipoLabSala) == 5 && actDetalleLaboratorioTiDTO.getEsBiblioteca()!=null && actDetalleLaboratorioTiDTO.getEsBiblioteca().intValue()==0) {
				crearActivo = true;
			}
		}
		return crearActivo;
	}
	
	private int getOpcionTipoLaboratorioSala(long codigoTipoLabSala){
		int opcion= 0;
		LaboratorioSalaEnum[] codigos = LaboratorioSalaEnum.values();
		for (LaboratorioSalaEnum laboratorioSalaEnum : codigos) {
			if(codigoTipoLabSala == laboratorioSalaEnum.getCodigo()){
				opcion = laboratorioSalaEnum.getOpcionTipoLaboratorioSala();
				break;
			}
		}
		return opcion;
	}
	
	
	/**
	 * Método que permite la validación básica del archivo cargado
	 * 
	 * @return Verdadero o falso según la condición establecida
	 */
	private boolean validarArchivo() {
		boolean correcto = true;
		mensajeError = "";
		if (institucionEducativaDTO == null || actFormularioCompletoDTO == null) {
			mensajeError = "La información del archivo es incorrecta.";
			correcto = false;
		} else {
			if (!insInstitucion.getAmie().equals(institucionEducativaDTO.getAmie())) {
				mensajeError = "No puede cargar la información de otra institución educativa.";
				correcto = false;
			}
			if (anio != actFormularioCompletoDTO.getActFormularioDTO().getAnio().intValue()) {
				mensajeError = "No puede cargar la información de años diferentes al actual.";
				correcto = false;
			}
		}
		return correcto;
	}
	
	/**
	 * Método que permite controlar la carga del formulario actual:
	 * - Si existieran meses sin carga el formulario actual se atará a los mismos
	 * - Si existiera un formulario para el mes de carga se inactiva el mismo y se ata el formulario actual al mes de carga
	 * @param formularioCargado
	 */
	private void controlCargaFormulario(ActFormulario formularioCargado){
		ActMesParametrizadoFormulario formularioFechaParametrizadaAEliminar = null;
		//si existen meses que no se han cargado se craga el formulario actual en todos estos meses
		for (ActMesParametrizado mesNocargado : mesesNoCargados) {
			salvarFormulariosParaFechasParametrizadas(formularioCargado, mesNocargado);
		}
		
		//comprobamos si ya se encuentra cargado un formulario para reemplazarlo
		for (ActMesParametrizadoFormulario formulario : formulariosCargadosParametrizados) {
			if(formulario.getMesParametrizado().getCodigo() == mesPorCargar.getCodigo()){
				formularioFechaParametrizadaAEliminar = formulario;
				break;
			}
		}
		//si existe eliminamos el formulario en la fecha parametrizada
		if(formularioFechaParametrizadaAEliminar != null){
			try {
				ActFormulario formularioInactivar = formularioService.obtenerPorCodigo(formularioFechaParametrizadaAEliminar.getFormulario().getCodigo());
				formularioInactivar.setEstado(0);
				formularioService.actualizar(formularioInactivar);
				mesParametrizadoFormularioService.eliminar(formularioFechaParametrizadaAEliminar);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//guardamos el nuevo formulario para el mes de carga
		salvarFormulariosParaFechasParametrizadas(formularioCargado, mesPorCargar);
		
	}
	
	private void salvarFormulariosParaFechasParametrizadas(ActFormulario formularioCargado, ActMesParametrizado mesParametrizado){
		ActMesParametrizadoFormulario mesFormulario = new ActMesParametrizadoFormulario();
		mesFormulario.setFormulario(formularioCargado);
		mesFormulario.setMesParametrizado(mesParametrizado);
		try {
			mesParametrizadoFormularioService.guardar(mesFormulario);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	private void listarFormulariosCargadosPorInstitucion(String amie){
		formulariosCargadosParametrizados = mesParametrizadoFormularioService.listaMesParametrizadoFormulariosPorAmieAnio(amie, anio);
		 for (ActMesParametrizado mesParametrizado : mesesParametrizados) {
			 mesParametrizado.setExisteFormulario(false);
			 mesParametrizado.setArchivoFisico(null);
			 mesParametrizado.setFechaCargaOnLine(null);
			 mesParametrizado.setFechaLevantamiento(null);
			 for (ActMesParametrizadoFormulario actMesParametrizadoFormulario : formulariosCargadosParametrizados) {
					if(mesParametrizado.getCodigo() == actMesParametrizadoFormulario.getMesParametrizado().getCodigo()){
						mesParametrizado.setExisteFormulario(true);
						mesParametrizado.setArchivoFisico(actMesParametrizadoFormulario.getFormulario().getIdArchivo());
						 mesParametrizado.setFechaCargaOnLine(actMesParametrizadoFormulario.getFormulario().getFechaCarga());
						 mesParametrizado.setFechaLevantamiento(actMesParametrizadoFormulario.getFormulario().getFechaLevantamiento());
						break;
					}
				}
		}
		 mesesNoCargados.clear();
		 mesesNoCargados = Utils.listaMesesNoCargados(formulariosCargadosParametrizados, mesesParametrizados);
	}

	public boolean isEsSustitutiva() {
		return esSustitutiva;
	}

	public void setEsSustitutiva(boolean esSustitutiva) {
		this.esSustitutiva = esSustitutiva;
	}

	public boolean isDeshabilitarGuardar() {
		return deshabilitarGuardar;
	}

	public void setDeshabilitarGuardar(boolean deshabilitarGuardar) {
		this.deshabilitarGuardar = deshabilitarGuardar;
	}

	public boolean isDeshabilitarCargar() {
		return deshabilitarCargar;
	}

	public void setDeshabilitarCargar(boolean deshabilitarCargar) {
		this.deshabilitarCargar = deshabilitarCargar;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public boolean isVerFormulario() {
		return verFormulario;
	}

	public void setVerFormulario(boolean verFormulario) {
		this.verFormulario = verFormulario;
	}

	public String getMensajeInstitucionError() {
		return mensajeInstitucionError;
	}

	public void setMensajeInstitucionError(String mensajeInstitucionError) {
		this.mensajeInstitucionError = mensajeInstitucionError;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<ActMesParametrizado> getMesesParametrizados() {
		return mesesParametrizados;
	}

	public void setMesesParametrizados(List<ActMesParametrizado> mesesParametrizados) {
		this.mesesParametrizados = mesesParametrizados;
	}

	public List<ActMesParametrizadoFormulario> getFormulariosCargadosParametrizados() {
		return formulariosCargadosParametrizados;
	}

	public void setFormulariosCargadosParametrizados(
			List<ActMesParametrizadoFormulario> formulariosCargadosParametrizados) {
		this.formulariosCargadosParametrizados = formulariosCargadosParametrizados;
	}

	public boolean getCargaActualizada() {
		return cargaActualizada;
	}

	public void setCargaActualizada(boolean cargaActualizada) {
		this.cargaActualizada = cargaActualizada;
	}

	public List<ActMesParametrizado> getMesesNoCargados() {
		return mesesNoCargados;
	}

	public void setMesesNoCargados(List<ActMesParametrizado> mesesNoCargados) {
		this.mesesNoCargados = mesesNoCargados;
	}

	public ActMesParametrizado getMesPorCargar() {
		return mesPorCargar;
	}

	public void setMesPorCargar(ActMesParametrizado mesPorCargar) {
		this.mesPorCargar = mesPorCargar;
	}

	public InsInstitucion getInsInstitucion() {
		return insInstitucion;
	}

	public void setInsInstitucion(InsInstitucion insInstitucion) {
		this.insInstitucion = insInstitucion;
	}

	
}
