package ec.gob.educacion.activos.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActArchivoActivo;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.resources.FileUtils;
import ec.gob.educacion.activos.service.ArchivoActivoService;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;

@Named
@ViewScoped
public class CargaDocumentoController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DetalleActivoService detalleActivoService;
	
	@EJB
	private ArchivoActivoService archivoActivoService;
	
	@EJB
	private ItemCatalogoService itemCatalogoService;

	@EJB
	private InstitucionService institucionService;
	
	@Inject
	private SessionController sessionController;
	
	private ActArchivoActivo arhivoActivo;
	private List<ActArchivoActivo> listaArhivoActivo;
	private ActDetalleActivo detalleActivo;
	
	//variables para carga de archivo
	private byte[] adjuntoDocumento;
	private Integer exitoCarga;
	private String mensajeCarga;
	private InputStream arch;
	private String serial;
	private boolean existeSerial;
	private int verificacion;
	private boolean verFormulario;
	private String mensajeInstitucionError;
	private String ubicacionArchivos;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "cargaDocumento.xhtml");
		InsInstitucion insInstitucion = new InsInstitucion();// = institucionService.obtenerPorAmie(sessionController.getUserSecurity().getUsername());
		insInstitucion.setAmie("18H00137");
		insInstitucion.setCodigo(53687);
		
		verFormulario = Boolean.TRUE;
		mensajeInstitucionError = "";
		if (insInstitucion == null) {
			verFormulario = Boolean.FALSE;
			mensajeInstitucionError = "El usuario que ha iniciado sesión no es una institución educativa.";
		} else {
			List<ActItemCatalogo> actItemCatalogos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.CARPETA_ARCHIVOS);
			if (actItemCatalogos == null || actItemCatalogos.isEmpty()) {
				verFormulario = Boolean.FALSE;
				mensajeInstitucionError = "Error al obtener la ubicación de los archivos.";
			} else if (actItemCatalogos.get(0).getDescripcion() == null || "".equals(actItemCatalogos.get(0).getDescripcion().trim())) {
				verFormulario = Boolean.FALSE;
				mensajeInstitucionError = "Ubicación de los archivos inválida.";
			} else {
				listaArhivoActivo = new ArrayList<ActArchivoActivo>();
				detalleActivo = new ActDetalleActivo();
				arhivoActivo = new ActArchivoActivo();
				adjuntoDocumento = new byte[0];
				exitoCarga = null;
				mensajeCarga = "";
				setVerificacion(0);
				ubicacionArchivos = actItemCatalogos.get(0).getDescripcion().trim();
			}
		}
	}
	
	public void buscarActivo() {
		detalleActivo = detalleActivoService.buscarPorSerial(serial,
				sessionController.getUserSecurity().getUsername(), EstadoEnum.ACTIVO.getCodigo(), Calendar.getInstance().get(Calendar.YEAR));
		existeSerial = detalleActivo != null;
		listaArhivoActivo = null;
		if (existeSerial) {
			detalleActivo.setDescripcionTipoActivo(itemCatalogoService
					.buscarPorCodigo(detalleActivo.getCodigoTipo()).getDescripcion());
			listaArhivoActivo = archivoActivoService.listarArchivosActivo(detalleActivo.getCodigo());
		} else {
			agregarMensajeError(
					"El activo no se encuentra ingresado o está dado de baja.",
					"El activo no se encuentra ingresado o está dado de baja.");
		}
	}
	
	private File archivo;
	
	/**
	 * Método que permite la carga de un archivo
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void cargarArchivo(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();
		if (item.getSize() <= (Constantes.TAMANIO_MEGA * Constantes.CANTIDAD_MEGA)) {
			try {
				archivo = FileUtils.crearArchivo(item.getName(), item.getInputStream(), Boolean.TRUE, ".pdf", Boolean.FALSE);
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
	 * Método que permite crear un nuevo archivo para un determinado activo
	 */
	public void crearArchivo () {
		arhivoActivo = new ActArchivoActivo();
	}
	
	/**
	 * Método que permite asignar el archivo que va a editarse
	 * 
	 * @param archivo
	 */
	public void actualizarArchivo(ActArchivoActivo archivo) {
		arhivoActivo = archivoActivoService.buscarPorCodigo(archivo.getCodigo());
	}
	
	/**
	 * Método que permite realizar la edición del archivo
	 * 
	 * @param tipo
	 */
	public void guardarEdicionArchivo(int tipo) {
		try {
			if (EstadoEnum.ACTIVO.getCodigo() == tipo) {
				String nombreArchivo = ubicacionArchivos
						+ sessionController.getUserSecurity().getUsername() + "/" + arhivoActivo.getIdArchivo();
				FileUtils.reemplazarArchivo(nombreArchivo, archivo);
				arhivoActivo.setTipo(EstadoEnum.ACTIVO.getCodigo());
			}
			archivoActivoService.actualizar(arhivoActivo);
			listaArhivoActivo = archivoActivoService
					.listarArchivosActivo(arhivoActivo.getActDetalleActivo().getCodigo());
			agregarMensajeInformacion("Operación realizada exitosamente.", "Operación realizada exitosamente.");
		} catch (DetalleActivoException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarArchivo() {
		if (exitoCarga != null && exitoCarga != 0) {
			arhivoActivo.setActDetalleActivo(detalleActivo);
			try {
				archivoActivoService.guardar(arhivoActivo);
				guardarDatosDocumento();
				listaArhivoActivo = archivoActivoService
						.listarArchivosActivo(detalleActivo.getCodigo());
				arhivoActivo = new ActArchivoActivo();
				adjuntoDocumento = new byte[0];
				exitoCarga = null;
				mensajeCarga = "";
			} catch (DetalleActivoException e) {
				e.printStackTrace();
			}
		} else {
			agregarMensajeError("Por favor necesita cargar un documento", "");
		}
	}
	
//	public void editarArchivo() {
//		try {
//			if (arhivoActivo.getTipo() == 1 && exitoCarga != null) {
//				guardarDatosDocumento();
//				listaArhivoActivo = archivoActivoService
//						.listarArchivosActivo(detalleActivo.getCodigo());
//				arhivoActivo.setTipo(EstadoEnum.ACTIVO.getCodigo());
//			}
//			archivoActivoService.actualizar(arhivoActivo);
//			arhivoActivo = new ActArchivoActivo();
//			adjuntoDocumento = new byte[0];
//			exitoCarga = null;
//			mensajeCarga = "";
//		} catch (DetalleActivoException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void editarArchivo(ActArchivoActivo archivo){
//		arhivoActivo = new ActArchivoActivo();
//		arhivoActivo=archivo;
//	}
//	
//	//MÉTODO DE EDITAR DE ARCHIVOS
//	public void editarDocumento(FileUploadEvent event1) throws Exception {
//		UploadedFile item = event1.getUploadedFile();
//		if (item.getSize() <= (Constantes.TAMANIO_MEGA)*(Constantes.CANTIDAD_MEGA)) {
//			exitoCarga = 1;
//			verificarCarga();
//			adjuntoDocumento = item.getData();
//			arch=new ByteArrayInputStream(adjuntoDocumento);			
//			mensajeCarga = "El archivo se adjunto correctamente";	
//		} else {
//			exitoCarga = 0;	
//			mensajeCarga = "El archivo seleccionado a sobrepasado el tamaño máximo de "+ Constantes.CANTIDAD_MEGA + " M";
//		}
//	}
	
	public void verificarCarga(){
		getExitoCarga();
		if(exitoCarga==1){
			setVerificacion(1);
		}else{
			setVerificacion(0);
		}
	}
	
	public void volverVerificacion(){
		setVerificacion(0);
	}
	
	//MÉTODO DE CARGA DE ARCHIVOS
	 public void cargarDocumento(FileUploadEvent event1) throws Exception {
		UploadedFile item = event1.getUploadedFile();
		String arcNombre = "";
		if (item.getSize() <= (Constantes.TAMANIO_MEGA)*(Constantes.CANTIDAD_MEGA)) {
			adjuntoDocumento = item.getData();
			arcNombre = archivoActivoService.buscarNombreArchivo(sessionController.getUserSecurity().getUsername()+"_"+serial+"_"+item.getName().replace(" ", "_"));
			if(arcNombre == "vacio"){
				exitoCarga = 1;
				arhivoActivo.setIdArchivo(sessionController.getUserSecurity().getUsername()+"_"+serial+"_"+item.getName().replace(" ", "_"));
				arch=new ByteArrayInputStream(adjuntoDocumento);
				mensajeCarga = "El archivo se adjunto correctamente";
			}else{
				exitoCarga = 0;
				mensajeCarga = "Ya se encuentra ingresado un archivo con el mismo nombre";
			}
		} else {
			exitoCarga = 0;
			mensajeCarga = "El archivo seleccionado a sobrepasado el tamaño máximo de "+ Constantes.CANTIDAD_MEGA + " M";
		}
	}
	 
	public void verArchivo(String idArchivo){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);		
		File file = new File(ubicacionArchivos + sessionController.getUserSecurity().getUsername() + "/" + idArchivo);
		int read = 0;
		try {
			InputStream fis = new FileInputStream(file);
			OutputStream os = null;
			byte[] bytes1 = new byte[1024];
			os = response.getOutputStream();
			while ((read = fis.read(bytes1)) != -1) {
				os.write(bytes1, 0, read);
			}
			os.flush();
			os.close();
			fis.close();
		} catch (Exception e) {
		}
		FacesContext.getCurrentInstance().responseComplete();
	}	 
	 
	private void guardarDatosDocumento() {
		String dir = ubicacionArchivos
				+ sessionController.getUserSecurity().getUsername() + "/";
		String nombre = arhivoActivo.getIdArchivo();
		BufferedInputStream bufferedInput = new BufferedInputStream(arch);
		try {
			FileOutputStream fileOutput = new FileOutputStream(dir + "/" + nombre);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			// Bucle para leer de un fichero y escribir en el otro.
			byte[] array = new byte[1000];
			int leidos = bufferedInput.read(array);
			while (leidos > 0) {
				bufferedOutput.write(array, 0, leidos);
				leidos = bufferedInput.read(array);
			}

			// Cierre de los ficheros
			bufferedOutput.close();
			bufferedInput.close();
			arch.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   
	public void verDocumento() {
		if (exitoCarga!=null&&exitoCarga != 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			int read = 0;
			try {
				InputStream fis = new ByteArrayInputStream(adjuntoDocumento);
				OutputStream os = null;
				byte[] bytes1 = new byte[1024];
				os = response.getOutputStream();
				while ((read = fis.read(bytes1)) != -1) {
					os.write(bytes1, 0, read);
				}
				os.flush();
				os.close();
				fis.close();
			} catch (Exception e) {
			}
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	   
	public void verDocumentoLista(long codigo) {	
	   byte[] adjuntoDocumentoWeb=new byte[0];
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
	   response.setContentType("application/pdf");
	   response.setHeader("Cache-Control", "no-cache");
	   response.setHeader("Pragma", "no-cache");
	   response.setDateHeader("Expires", 0);
	   int read = 0;
	   try {
			InputStream fis = new ByteArrayInputStream(adjuntoDocumentoWeb);
			OutputStream os = null;
			byte[] bytes1 = new byte[1024];
			os = response.getOutputStream();
			while ((read = fis.read(bytes1)) != -1) {
				os.write(bytes1, 0, read);
			}
			os.flush();
			os.close();
			fis.close();
		} catch (Exception e) {
		}
		FacesContext.getCurrentInstance().responseComplete();		
	}

	public void quitarDocumento() {
	/*	if(mensajeCarga!=" "){
			File file = new File(Constantes.URL_ARCHIVOS+arhivoActivo.getIdArchivo());
			file.delete();
		}*/
		adjuntoDocumento = new byte[0];
		exitoCarga = null;
		mensajeCarga = "";
		//arhivoActivo.setTipo(0);
	}
	
	public void eliminarArchivo() {
		arhivoActivo=new ActArchivoActivo();
		quitarDocumento();
		verificacion = 0;
	}
	
	/**
	 * Método que corta la cadena a un máximo de 20 caracteres en caso de que
	 * sobrepase dicha longitud
	 * 
	 * @param cadena
	 * @param limite
	 * @return Objeto de tipo String
	 */
	public String obtenerCadenaCortada(String cadena, int limite) {
		String cadenaCortada = "";
		if (cadena.trim().contains(" ")) {
			cadenaCortada = cadena;
		} else {
			cadenaCortada = cortarCadena(cadena, limite);
		}
		return cadenaCortada;
	}

	public byte[] getAdjuntoDocumento() {
		return adjuntoDocumento;
	}

	public void setAdjuntoDocumento(byte[] adjuntoDocumento) {
		this.adjuntoDocumento = adjuntoDocumento;
	}

	public Integer getExitoCarga() {
		return exitoCarga;
	}

	public void setExitoCarga(Integer exitoCarga) {
		this.exitoCarga = exitoCarga;
	}

	public String getMensajeCarga() {
		return mensajeCarga;
	}

	public void setMensajeCarga(String mensajeCarga) {
		this.mensajeCarga = mensajeCarga;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public ActArchivoActivo getArhivoActivo() {
		return arhivoActivo;
	}

	public void setArhivoActivo(ActArchivoActivo arhivoActivo) {
		this.arhivoActivo = arhivoActivo;
	}

	public InputStream getArch() {
		return arch;
	}

	public void setArch(InputStream arch) {
		this.arch = arch;
	}

	public ActDetalleActivo getDetalleActivo() {
		return detalleActivo;
	}

	public void setDetalleActivo(ActDetalleActivo detalleActivo) {
		this.detalleActivo = detalleActivo;
	}

	public boolean isExisteSerial() {
		return existeSerial;
	}

	public void setExisteSerial(boolean existeSerial) {
		this.existeSerial = existeSerial;
	}

	public List<ActArchivoActivo> getListaArhivoActivo() {
		return listaArhivoActivo;
	}

	public void setListaArhivoActivo(List<ActArchivoActivo> listaArhivoActivo) {
		this.listaArhivoActivo = listaArhivoActivo;
	}

	public Integer getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(Integer verificacion) {
		this.verificacion = verificacion;
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
	
}