/**
 * RegistroCivilWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil;

public class RegistroCivilWebServiceServiceLocator extends org.apache.axis.client.Service implements ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceService {

    public RegistroCivilWebServiceServiceLocator() {
    }


    public RegistroCivilWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RegistroCivilWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioWebRegistroCivilPort
    private java.lang.String ServicioWebRegistroCivilPort_address = "http://servicios.educacion.gob.ec:80/registro-civil-sw/ServicioWebRegistroCivil";

    public java.lang.String getServicioWebRegistroCivilPortAddress() {
        return ServicioWebRegistroCivilPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioWebRegistroCivilPortWSDDServiceName = "ServicioWebRegistroCivilPort";

    public java.lang.String getServicioWebRegistroCivilPortWSDDServiceName() {
        return ServicioWebRegistroCivilPortWSDDServiceName;
    }

    public void setServicioWebRegistroCivilPortWSDDServiceName(java.lang.String name) {
        ServicioWebRegistroCivilPortWSDDServiceName = name;
    }

    public ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil getServicioWebRegistroCivilPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioWebRegistroCivilPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioWebRegistroCivilPort(endpoint);
    }

    public ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil getServicioWebRegistroCivilPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceServiceSoapBindingStub _stub = new ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioWebRegistroCivilPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioWebRegistroCivilPortEndpointAddress(java.lang.String address) {
        ServicioWebRegistroCivilPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil.class.isAssignableFrom(serviceEndpointInterface)) {
                ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceServiceSoapBindingStub _stub = new ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.RegistroCivilWebServiceServiceSoapBindingStub(new java.net.URL(ServicioWebRegistroCivilPort_address), this);
                _stub.setPortName(getServicioWebRegistroCivilPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioWebRegistroCivilPort".equals(inputPortName)) {
            return getServicioWebRegistroCivilPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.educacion.gob.ec/registro-civil-sw/ServicioWebRegistroCivil", "RegistroCivilWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.educacion.gob.ec/registro-civil-sw/ServicioWebRegistroCivil", "ServicioWebRegistroCivilPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioWebRegistroCivilPort".equals(portName)) {
            setServicioWebRegistroCivilPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
