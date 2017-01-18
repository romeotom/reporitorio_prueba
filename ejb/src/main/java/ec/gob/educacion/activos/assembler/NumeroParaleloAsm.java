package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActNumeroParalelo;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.mineduc.activo.db.dto.ActNumeroParalelosDTO;

public class NumeroParaleloAsm {
	
	public static void fromDto(ActNumeroParalelo obj, ActNumeroParalelosDTO dto) {
		obj.setCodigoJornada(dto.getCodigoJornada() == null ? Constantes.JORNADA_TOTAL : dto.getCodigoJornada());
		obj.setInicial(dto.getInicial() == null ? null : Long.valueOf(dto.getInicial()));
		obj.setPrimero(dto.getPrimero() == null ? null : Long.valueOf(dto.getPrimero()));
		obj.setSegundo(dto.getSegundo() == null ? null : Long.valueOf(dto.getSegundo()));
		obj.setTercero(dto.getTercero() == null ? null : Long.valueOf(dto.getTercero()));
		obj.setCuarto(dto.getCuarto() == null ? null : Long.valueOf(dto.getCuarto()));
		obj.setQuinto(dto.getQuinto() == null ? null : Long.valueOf(dto.getQuinto()));
		obj.setSexto(dto.getSexto() == null ? null : Long.valueOf(dto.getSexto()));
		obj.setSeptimo(dto.getSeptimo() == null ? null : Long.valueOf(dto.getSeptimo()));
		obj.setOctavo(dto.getOctavo() == null ? null : Long.valueOf(dto.getOctavo()));
		obj.setNoveno(dto.getNoveno() == null ? null : Long.valueOf(dto.getNoveno()));
		obj.setDecimo(dto.getDecimo() == null ? null : Long.valueOf(dto.getDecimo()));
		obj.setPrimeroBch(dto.getPrimeroBch() == null ? null : Long.valueOf(dto.getPrimeroBch()));
		obj.setSegundoBch(dto.getSegundoBch() == null ? null : Long.valueOf(dto.getSegundoBch()));
		obj.setTerceroBch(dto.getTerceroBch() == null ? null : Long.valueOf(dto.getTerceroBch()));
	}
	
	public static void toDto() {
		//TODO
	}
	
}
