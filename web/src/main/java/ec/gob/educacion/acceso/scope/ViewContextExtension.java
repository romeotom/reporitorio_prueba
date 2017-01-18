package ec.gob.educacion.acceso.scope;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
public class ViewContextExtension implements Extension {

	public void afterBeanDiscovery(@Observes AfterBeanDiscovery event,
			BeanManager manager) {
		event.addContext(new ViewContext());
	}
}
