package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActJornadaEducacion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.mineduc.activo.db.dto.ActJornadaEducacionDTO;

public class JornadaEducacionAsm {
	
	public static void fromDto(ActJornadaEducacion obj, ActJornadaEducacionDTO dto) {
		obj.setCodigoJornada(dto.getCodigoJornada() == null ? Constantes.JORNADA_TOTAL : dto.getCodigoJornada());
		obj.setInicial(dto.getInicial());
		obj.setBasica(dto.getBasica());
		obj.setBachillerato(dto.getBachillerato());
		obj.setTotal(dto.getTotal());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
