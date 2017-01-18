package ec.gob.educacion.activos.assembler;

import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.mineduc.activo.db.dto.ActFormularioDTO;

public class FormularioAsm {
	
	public static void fromDto(ActFormulario obj, ActFormularioDTO dto) {
		obj.setAnio(dto.getAnio());
		obj.setConectividad(dto.getConectividad() == null ? 0 : dto.getConectividad());
		obj.setEncargadoPagoInternet(dto.getEncargadoPagoInternet());
		obj.setEstado(dto.getEstado());
		obj.setFechaLevantamiento(dto.getFechaLevantamiento());
		obj.setHombresTic(dto.getHombresTic());
		obj.setMedidaVelocidadNavegacion(dto.getMedidaVelocidadNavegacion() == null ? null : dto.getMedidaVelocidadNavegacion().longValue());
		obj.setMujeresTic(dto.getMujeresTic());
		obj.setNumeroLabInformatico(dto.getNumeroLabInformatico() == null ? null : dto.getNumeroLabInformatico().longValue());
		obj.setNumeroTiAdministrativo(dto.getNumeroTiAdministrativo() == null ? null : dto.getNumeroTiAdministrativo().longValue());
		obj.setNumeroTiBiblioteca(dto.getNumeroTiBiblioteca() == null ? null : dto.getNumeroTiBiblioteca().longValue());
		obj.setProveedorInternet(dto.getProveedorInternet());
		obj.setResponsableDistrito(dto.getResponsableDistrito());
		obj.setTieneBachillerato(dto.getTieneBachillerato() == null ? 0 : dto.getTieneBachillerato());
		obj.setTieneBasica(dto.getTieneBasica() == null ? 0 : dto.getTieneBasica());
		obj.setTieneCrtServidores(dto.getTieneCrtServidores() == null ? 0 : dto.getTieneCrtServidores());
		obj.setTieneInicial(dto.getTieneInicial() == null ? 0 : dto.getTieneInicial());
		obj.setTieneLabInformatico(dto.getTieneLabInformatico() == null ? 0 : dto.getTieneLabInformatico());
		obj.setTieneLabVarios(dto.getTieneLabVarios() == null ? 0 : dto.getTieneLabVarios());
		obj.setTieneTiAdministrativo(dto.getTieneTiAdministrativo() == null ? 0 : dto.getTieneTiAdministrativo());
		obj.setTieneTiBiblioteca(dto.getTieneTiBiblioteca() == null ? 0 : dto.getTieneTiBiblioteca());
		obj.setTieneTiSalas(dto.getTieneTiSalas() == null ? 0 : dto.getTieneTiSalas());
		obj.setTotalTic(dto.getTotalTic());
		obj.setValorPagoInternet(dto.getValorPagoInternet() == null ? null :dto.getValorPagoInternet().doubleValue());
		obj.setVelocidadNavegacion(dto.getVelocidadNavegacion() == null ? null : dto.getVelocidadNavegacion().doubleValue());
		
		obj.setLevantamientoMilisegundos(dto.getLevantamientoMilisegundos());
		obj.setTieneInternetBiblioteca((dto.getTieneInternetBiblioteca() == null)? 0: dto.getTieneInternetBiblioteca().intValue());
		obj.setTieneInternetAdministrativo((dto.getTieneInternetAdministrativo() == null)? 0: dto.getTieneInternetAdministrativo().intValue());
		obj.setNumeroImpresorasBiblioteca((dto.getNumeroImpresorasBiblioteca() == null)? 0: dto.getNumeroImpresorasBiblioteca().intValue());
		obj.setNumeroImpresorasAdministrativo((dto.getNumeroImpresorasAdministrativo() == null)? 0: dto.getNumeroImpresorasAdministrativo().intValue());
		obj.setNumeroProyectoresAdministrativo((dto.getNumeroProyectoresAdministrativo() == null)? 0: dto.getNumeroProyectoresAdministrativo().intValue());
		obj.setNumeroPizarrasAdministrativo((dto.getNumeroPizarrasAdministrativo() == null)? 0: dto.getNumeroPizarrasAdministrativo().intValue());
		obj.setNumeroAudioAdministrativo((dto.getNumeroAudioAdministrativo() == null)? 0: dto.getNumeroAudioAdministrativo().intValue());
		obj.setNumeroTelevisoresAdministrativo((dto.getNumeroTelevisoresAdministrativo() == null)? 0: dto.getNumeroTelevisoresAdministrativo().intValue());
	}
	
	public static void toDto() {
		//TODO
	}
	
}
