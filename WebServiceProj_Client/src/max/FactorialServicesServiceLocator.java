/**
 * FactorialServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package max;

public class FactorialServicesServiceLocator extends org.apache.axis.client.Service implements max.FactorialServicesService {

    public FactorialServicesServiceLocator() {
    }


    public FactorialServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FactorialServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FactorialServices
    private java.lang.String FactorialServices_address = "http://localhost:8080/ZFactorialServer/services/FactorialServices";

    public java.lang.String getFactorialServicesAddress() {
        return FactorialServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FactorialServicesWSDDServiceName = "FactorialServices";

    public java.lang.String getFactorialServicesWSDDServiceName() {
        return FactorialServicesWSDDServiceName;
    }

    public void setFactorialServicesWSDDServiceName(java.lang.String name) {
        FactorialServicesWSDDServiceName = name;
    }

    public max.FactorialServices getFactorialServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FactorialServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFactorialServices(endpoint);
    }

    public max.FactorialServices getFactorialServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            max.FactorialServicesSoapBindingStub _stub = new max.FactorialServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getFactorialServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFactorialServicesEndpointAddress(java.lang.String address) {
        FactorialServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (max.FactorialServices.class.isAssignableFrom(serviceEndpointInterface)) {
                max.FactorialServicesSoapBindingStub _stub = new max.FactorialServicesSoapBindingStub(new java.net.URL(FactorialServices_address), this);
                _stub.setPortName(getFactorialServicesWSDDServiceName());
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
        if ("FactorialServices".equals(inputPortName)) {
            return getFactorialServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://max", "FactorialServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://max", "FactorialServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FactorialServices".equals(portName)) {
            setFactorialServicesEndpointAddress(address);
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
