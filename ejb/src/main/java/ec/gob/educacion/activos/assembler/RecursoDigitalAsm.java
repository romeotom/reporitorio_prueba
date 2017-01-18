package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActRecursoDigital;
import ec.gob.educacion.mineduc.activo.db.dto.ActRecursoDigitalDTO;

public class RecursoDigitalAsm {
	
	public static void fromDto(ActRecursoDigital obj, ActRecursoDigitalDTO dto) {
		obj.setCodigoTipoRecurso(dto.getCodigoTipoRecurso());
		obj.setBiologia(dto.getBiologia());
		obj.setCienciasNaturales(dto.getCienciasNaturales());
		obj.setFisica(dto.getFisica());
		obj.setLenguaExtranjera(dto.getLenguaExtranjera());
		obj.setLenguaLiteratura(dto.getLenguaLiteratura());
		obj.setMatematica(dto.getMatematica());
		obj.setQuimica(dto.getQuimica());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
