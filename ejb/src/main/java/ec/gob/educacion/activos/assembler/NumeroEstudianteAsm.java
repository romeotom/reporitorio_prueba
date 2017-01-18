package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActNumeroEstudiante;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.mineduc.activo.db.dto.ActNumeroEstudiantesDTO;

public class NumeroEstudianteAsm {
	
	public static void fromDto(ActNumeroEstudiante obj, ActNumeroEstudiantesDTO dto) {
		obj.setCodigoJornada(dto.getCodigoJornada() == null ? Constantes.JORNADA_TOTAL : dto.getCodigoJornada());
		obj.setNumeroHombres(dto.getNumeroHombres());
		obj.setNumeroMujeres(dto.getNumeroMujeres());
		obj.setTotal(dto.getTotal());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
