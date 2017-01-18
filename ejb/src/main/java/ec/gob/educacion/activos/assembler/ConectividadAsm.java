package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.mineduc.activo.db.dto.ActConectividadDTO;

public class ConectividadAsm {
	
	public static void fromDto(ActConectividad obj, ActConectividadDTO dto) {
		obj.setCodigoItem(dto.getCodigoItem());
		obj.setDisponibilidad(dto.getDisponibilidad());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
