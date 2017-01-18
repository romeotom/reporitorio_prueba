package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.mineduc.activo.db.dto.ActAccesibilidadServiciosDTO;

public class AccesibilidadServicioAsm {
	
	public static void fromDto(ActAccesibilidadServicio obj, ActAccesibilidadServiciosDTO dto) {
		obj.setCodigoItem(dto.getCodigoItem());
		obj.setDisponibilidad(dto.getDisponibilidad());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
