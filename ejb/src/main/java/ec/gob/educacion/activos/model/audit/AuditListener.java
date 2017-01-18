package ec.gob.educacion.activos.model.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditListener implements RevisionListener {
	
	@Override
	public void newRevision(Object revisionEntity) {
		RevEntity revEntity = (RevEntity) revisionEntity;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null
				&& context.getAuthentication().getName()!=null) {
			revEntity.setUsuario(context.getAuthentication().getName());
		} else {
			revEntity.setUsuario("WS");
		}
	}

}
