package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActJornadaEducacionTi;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.mineduc.activo.db.dto.ActJornadaEducacionTiDTO;

public class JornadaEducacionTiAsm {
	
	public static void fromDto(ActJornadaEducacionTi obj, ActJornadaEducacionTiDTO dto) {
		obj.setCodigoJornada(dto.getCodigoJornada() == null ? Constantes.JORNADA_TOTAL : dto.getCodigoJornada());
		obj.setCodigoTipoNivel(dto.getCodigoTipoNivel());
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
