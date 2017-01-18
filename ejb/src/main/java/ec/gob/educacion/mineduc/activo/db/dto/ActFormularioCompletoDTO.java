package ec.gob.educacion.mineduc.activo.db.dto;

import java.io.Serializable;
import java.util.List;

public class ActFormularioCompletoDTO implements Serializable {

	private static final long serialVersionUID = 302707728003277093L;
	
	private ActFormularioDTO actFormularioDTO;
	private List<ActNumeroEstudiantesDTO> actNumeroEstudiantesDTOs;
	private List<ActNumeroDocentesDTO> actNumeroDocentesDTOs;
	private List<ActNumeroParalelosDTO> actNumeroParalelosDTOs;
	private List<ActPromedioEstudiantesDTO> actPromedioEstudiantesDTOs;
	private List<ActTalentoHumanoDTO> actTalentoHumanoDTOs;
	private List<ActCuartoServidoresDTO> actCuartoServidoresDTOs;
	private List<ActLaboratorioTiDTO> actLaboratorioTiDTOs;
	private List<ActLaboratorioVariosDTO> actLaboratorioVariosDTOs;
	private List<ActSalaTiDTO> actSalaTiDTOs;
	private List<ActJornadaEducacionDTO> actJornadaEducacionDTOs;
	private List<ActJornadaEducacionTiDTO> actJornadaEducacionTiDTOs;
	private List<ActRecursoDigitalDTO> actRecursoDigitalDTOs;
	private List<ActAccesibilidadServiciosDTO> actAccesibilidadServiciosDTOs;
	private List<ActConectividadDTO> actConectividadDTOs;
	private List<ActDetalleLaboratorioTiDTO> actDetalleLaboratorioTiDTOs;
	
	public ActFormularioCompletoDTO() {
		super();
	}

	public ActFormularioCompletoDTO(ActFormularioDTO actFormularioDTO, List<ActNumeroEstudiantesDTO> actNumeroEstudiantesDTOs, List<ActNumeroDocentesDTO> actNumeroDocentesDTOs, List<ActNumeroParalelosDTO> actNumeroParalelosDTOs, List<ActPromedioEstudiantesDTO> actPromedioEstudiantesDTOs, List<ActTalentoHumanoDTO> actTalentoHumanoDTOs, List<ActCuartoServidoresDTO> actCuartoServidoresDTOs, List<ActLaboratorioTiDTO> actLaboratorioTiDTOs, List<ActLaboratorioVariosDTO> actLaboratorioVariosDTOs, List<ActSalaTiDTO> actSalaTiDTOs, List<ActJornadaEducacionDTO> actJornadaEducacionDTOs, List<ActJornadaEducacionTiDTO> actJornadaEducacionTiDTOs, List<ActRecursoDigitalDTO> actRecursoDigitalDTOs, List<ActAccesibilidadServiciosDTO> actAccesibilidadServiciosDTOs, List<ActConectividadDTO> actConectividadDTOs, List<ActDetalleLaboratorioTiDTO> actDetalleLaboratorioTiDTOs) {
		super();
		this.actFormularioDTO = actFormularioDTO;
		this.actNumeroEstudiantesDTOs = actNumeroEstudiantesDTOs;
		this.actNumeroDocentesDTOs = actNumeroDocentesDTOs;
		this.actNumeroParalelosDTOs = actNumeroParalelosDTOs;
		this.actPromedioEstudiantesDTOs = actPromedioEstudiantesDTOs;
		this.actTalentoHumanoDTOs = actTalentoHumanoDTOs;
		this.actCuartoServidoresDTOs = actCuartoServidoresDTOs;
		this.actLaboratorioTiDTOs = actLaboratorioTiDTOs;
		this.actLaboratorioVariosDTOs = actLaboratorioVariosDTOs;
		this.actSalaTiDTOs = actSalaTiDTOs;
		this.actJornadaEducacionDTOs = actJornadaEducacionDTOs;
		this.actJornadaEducacionTiDTOs = actJornadaEducacionTiDTOs;
		this.actRecursoDigitalDTOs = actRecursoDigitalDTOs;
		this.actAccesibilidadServiciosDTOs = actAccesibilidadServiciosDTOs;
		this.actConectividadDTOs = actConectividadDTOs;
		this.actDetalleLaboratorioTiDTOs = actDetalleLaboratorioTiDTOs;
	}
	
	public List<ActAccesibilidadServiciosDTO> getActAccesibilidadServiciosDTOs() {
		return actAccesibilidadServiciosDTOs;
	}
	public void setActAccesibilidadServiciosDTOs(
			List<ActAccesibilidadServiciosDTO> actAccesibilidadServiciosDTOs) {
		this.actAccesibilidadServiciosDTOs = actAccesibilidadServiciosDTOs;
	}
	public List<ActConectividadDTO> getActConectividadDTOs() {
		return actConectividadDTOs;
	}
	public void setActConectividadDTOs(List<ActConectividadDTO> actConectividadDTOs) {
		this.actConectividadDTOs = actConectividadDTOs;
	}
	public List<ActCuartoServidoresDTO> getActCuartoServidoresDTOs() {
		return actCuartoServidoresDTOs;
	}
	public void setActCuartoServidoresDTOs(
			List<ActCuartoServidoresDTO> actCuartoServidoresDTOs) {
		this.actCuartoServidoresDTOs = actCuartoServidoresDTOs;
	}
	public ActFormularioDTO getActFormularioDTO() {
		return actFormularioDTO;
	}
	public void setActFormularioDTO(ActFormularioDTO actFormularioDTO) {
		this.actFormularioDTO = actFormularioDTO;
	}
	public List<ActJornadaEducacionDTO> getActJornadaEducacionDTOs() {
		return actJornadaEducacionDTOs;
	}
	public void setActJornadaEducacionDTOs(
			List<ActJornadaEducacionDTO> actJornadaEducacionDTOs) {
		this.actJornadaEducacionDTOs = actJornadaEducacionDTOs;
	}
	public List<ActJornadaEducacionTiDTO> getActJornadaEducacionTiDTOs() {
		return actJornadaEducacionTiDTOs;
	}
	public void setActJornadaEducacionTiDTOs(
			List<ActJornadaEducacionTiDTO> actJornadaEducacionTiDTOs) {
		this.actJornadaEducacionTiDTOs = actJornadaEducacionTiDTOs;
	}
	public List<ActLaboratorioTiDTO> getActLaboratorioTiDTOs() {
		return actLaboratorioTiDTOs;
	}
	public void setActLaboratorioTiDTOs(
			List<ActLaboratorioTiDTO> actLaboratorioTiDTOs) {
		this.actLaboratorioTiDTOs = actLaboratorioTiDTOs;
	}
	public List<ActLaboratorioVariosDTO> getActLaboratorioVariosDTOs() {
		return actLaboratorioVariosDTOs;
	}
	public void setActLaboratorioVariosDTOs(
			List<ActLaboratorioVariosDTO> actLaboratorioVariosDTOs) {
		this.actLaboratorioVariosDTOs = actLaboratorioVariosDTOs;
	}
	public List<ActNumeroDocentesDTO> getActNumeroDocentesDTOs() {
		return actNumeroDocentesDTOs;
	}
	public void setActNumeroDocentesDTOs(
			List<ActNumeroDocentesDTO> actNumeroDocentesDTOs) {
		this.actNumeroDocentesDTOs = actNumeroDocentesDTOs;
	}
	public List<ActNumeroEstudiantesDTO> getActNumeroEstudiantesDTOs() {
		return actNumeroEstudiantesDTOs;
	}
	public void setActNumeroEstudiantesDTOs(
			List<ActNumeroEstudiantesDTO> actNumeroEstudiantesDTOs) {
		this.actNumeroEstudiantesDTOs = actNumeroEstudiantesDTOs;
	}
	public List<ActNumeroParalelosDTO> getActNumeroParalelosDTOs() {
		return actNumeroParalelosDTOs;
	}
	public void setActNumeroParalelosDTOs(
			List<ActNumeroParalelosDTO> actNumeroParalelosDTOs) {
		this.actNumeroParalelosDTOs = actNumeroParalelosDTOs;
	}
	public List<ActPromedioEstudiantesDTO> getActPromedioEstudiantesDTOs() {
		return actPromedioEstudiantesDTOs;
	}
	public void setActPromedioEstudiantesDTOs(
			List<ActPromedioEstudiantesDTO> actPromedioEstudiantesDTOs) {
		this.actPromedioEstudiantesDTOs = actPromedioEstudiantesDTOs;
	}
	public List<ActRecursoDigitalDTO> getActRecursoDigitalDTOs() {
		return actRecursoDigitalDTOs;
	}
	public void setActRecursoDigitalDTOs(
			List<ActRecursoDigitalDTO> actRecursoDigitalDTOs) {
		this.actRecursoDigitalDTOs = actRecursoDigitalDTOs;
	}
	public List<ActSalaTiDTO> getActSalaTiDTOs() {
		return actSalaTiDTOs;
	}
	public void setActSalaTiDTOs(List<ActSalaTiDTO> actSalaTiDTOs) {
		this.actSalaTiDTOs = actSalaTiDTOs;
	}
	public List<ActTalentoHumanoDTO> getActTalentoHumanoDTOs() {
		return actTalentoHumanoDTOs;
	}
	public void setActTalentoHumanoDTOs(
			List<ActTalentoHumanoDTO> actTalentoHumanoDTOs) {
		this.actTalentoHumanoDTOs = actTalentoHumanoDTOs;
	}

	public List<ActDetalleLaboratorioTiDTO> getActDetalleLaboratorioTiDTOs() {
		return actDetalleLaboratorioTiDTOs;
	}

	public void setActDetalleLaboratorioTiDTOs(
			List<ActDetalleLaboratorioTiDTO> actDetalleLaboratorioTiDTOs) {
		this.actDetalleLaboratorioTiDTOs = actDetalleLaboratorioTiDTOs;
	}
	

}
