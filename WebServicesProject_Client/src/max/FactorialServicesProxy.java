package max;

public class FactorialServicesProxy implements max.FactorialServices {
  private String _endpoint = null;
  private max.FactorialServices factorialServices = null;
  
  public FactorialServicesProxy() {
    _initFactorialServicesProxy();
  }
  
  public FactorialServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initFactorialServicesProxy();
  }
  
  private void _initFactorialServicesProxy() {
    try {
      factorialServices = (new max.FactorialServicesServiceLocator()).getFactorialServices();
      if (factorialServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)factorialServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)factorialServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (factorialServices != null)
      ((javax.xml.rpc.Stub)factorialServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.FactorialServices getFactorialServices() {
    if (factorialServices == null)
      _initFactorialServicesProxy();
    return factorialServices;
  }
  
  public java.lang.String otp(java.lang.String mob) throws java.rmi.RemoteException{
    if (factorialServices == null)
      _initFactorialServicesProxy();
    return factorialServices.otp(mob);
  }
  
  public java.lang.String getFacto(java.lang.String n) throws java.rmi.RemoteException{
    if (factorialServices == null)
      _initFactorialServicesProxy();
    return factorialServices.getFacto(n);
  }
  
  
}