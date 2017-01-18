package ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil;

public class ServicioWebRegistroCivilProxy implements ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil {
  private String _endpoint = null;
  private ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil servicioWebRegistroCivil = null;
  
  public ServicioWebRegistroCivilProxy() {
    _initServicioWebRegistroCivilProxy();
  }
  
  public ServicioWebRegistroCivilProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioWebRegistroCivilProxy();
  }
  
  private void _initServicioWebRegistroCivilProxy() {
    try {
      servicioWebRegistroCivil = (new ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceServiceLocator()).getServicioWebRegistroCivilPort();
      if (servicioWebRegistroCivil != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioWebRegistroCivil)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioWebRegistroCivil)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioWebRegistroCivil != null)
      ((javax.xml.rpc.Stub)servicioWebRegistroCivil)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil getServicioWebRegistroCivil() {
    if (servicioWebRegistroCivil == null)
      _initServicioWebRegistroCivilProxy();
    return servicioWebRegistroCivil;
  }
  
  public java.lang.String buscarPersona(java.lang.String cedula) throws java.rmi.RemoteException{
    if (servicioWebRegistroCivil == null)
      _initServicioWebRegistroCivilProxy();
    return servicioWebRegistroCivil.buscarPersona(cedula);
  }
  
  
}