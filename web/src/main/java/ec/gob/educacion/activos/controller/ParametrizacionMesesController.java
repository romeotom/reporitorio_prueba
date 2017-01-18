package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizado;
import ec.gob.educacion.activos.service.MesParametrizadoFormularioService;
import ec.gob.educacion.activos.service.MesParametrizadoService;
import ec.gob.educacion.activos.service.MesService;

@Named
@ViewScoped
public class ParametrizacionMesesController extends BaseController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MesService mesService;
	
	@EJB
	private MesParametrizadoService mesParametrizadoService;
	
	@EJB
	private MesParametrizadoFormularioService mesParametrizadoFormularioService;
	
	@Inject
	private SessionController sessionController;
	
	
	private List<ActMes> meses;
	private int anio;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "parametrizacionMeses.xhtml");
		anio = Calendar.getInstance().get(Calendar.YEAR);
		cargarListadoMeses();
	}
	
	private void setDeshabilitadoMesParametrizado(List<ActMes> meses){
		int ultimaPosicionDeshabilitada = -1;
		int contador = 1;
		//verificamos si para el mes parametrizado existen formularios cargados 
		for (ActMes actMes : meses) {
			if(actMes.getMesSeleccionado()){
				boolean disabled = mesParametrizadoFormularioService.existenFormulariosParaFechaParametrizadaMenorFechaActual(actMes);
				actMes.setDeshabilitado(disabled);
				if(disabled){
					ultimaPosicionDeshabilitada = contador;
				}
			}
			contador++;
		}
		//inhabilitamos todas las posiciones anteriores a la ultima fecha parametrizada que posee formularios
		if(ultimaPosicionDeshabilitada > -1){
			for (int i = 0; i < ultimaPosicionDeshabilitada; i++) {
				meses.get(i).setDeshabilitado(true);
			}
		}
	}
	
	public void actualizarMesParametrizado(int posicion){
		ActMes mesSeleccionado = meses.get(posicion);
		boolean seleccionado = !mesSeleccionado.getMesSeleccionado();
		try {
			if(seleccionado){
				ActMesParametrizado nuevoMes = new ActMesParametrizado();
				nuevoMes.setMes(mesSeleccionado);
				nuevoMes.setAnio(anio);
				mesParametrizadoService.guardar(nuevoMes);
			}else {
				ActMesParametrizado mesParametrizadoGuardado = mesParametrizadoService.buscarPorMesYAnio(mesSeleccionado, anio);
				if(mesParametrizadoGuardado != null){
					mesParametrizadoService.eliminar(mesParametrizadoGuardado);
				}
			}
			cargarListadoMeses();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void cargarListadoMeses(){
		meses = mesService.listaMeses();
		setDeshabilitadoMesParametrizado(meses);
	}
	
	public List<ActMes> getMeses() {
		return meses;
	}

	public void setMeses(List<ActMes> meses) {
		this.meses = meses;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
}