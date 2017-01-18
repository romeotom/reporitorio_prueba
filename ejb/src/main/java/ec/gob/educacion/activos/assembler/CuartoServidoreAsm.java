package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.mineduc.activo.db.dto.ActCuartoServidoresDTO;

public class CuartoServidoreAsm {
	
	public static void fromDto(ActCuartoServidore obj, ActCuartoServidoresDTO dto) {
		obj.setCodigoItem(dto.getCodigoItem());
		obj.setDisponibilidad(dto.getDisponibilidad());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
