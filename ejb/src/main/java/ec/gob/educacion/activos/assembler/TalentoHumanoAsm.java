package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActTalentoHumano;
import ec.gob.educacion.mineduc.activo.db.dto.ActTalentoHumanoDTO;

public class TalentoHumanoAsm {
	
	public static void fromDto(ActTalentoHumano obj, ActTalentoHumanoDTO dto) {
		obj.setCodigoCargo(dto.getCodigoCargo());
		obj.setNombreCargo(dto.getNombreCargo());
		obj.setNombre(dto.getNombre());
		obj.setApellido(dto.getApellido());
		obj.setEmail(dto.getEmail());
		obj.setContactoUno(dto.getContactoUno());
		obj.setContactoDos(dto.getContactoDos());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
