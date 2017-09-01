
package com.subservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "subcalcWebService", targetNamespace = "http://src.com/", wsdlLocation = "http://localhost:8080/subcalcWebService/subcalcWebService?wsdl")
public class SubcalcWebService_Service
    extends Service
{

    private final static URL SUBCALCWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException SUBCALCWEBSERVICE_EXCEPTION;
    private final static QName SUBCALCWEBSERVICE_QNAME = new QName("http://src.com/", "subcalcWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/subcalcWebService/subcalcWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SUBCALCWEBSERVICE_WSDL_LOCATION = url;
        SUBCALCWEBSERVICE_EXCEPTION = e;
    }

    public SubcalcWebService_Service() {
        super(__getWsdlLocation(), SUBCALCWEBSERVICE_QNAME);
    }

    public SubcalcWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SUBCALCWEBSERVICE_QNAME, features);
    }

    public SubcalcWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, SUBCALCWEBSERVICE_QNAME);
    }

    public SubcalcWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SUBCALCWEBSERVICE_QNAME, features);
    }

    public SubcalcWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SubcalcWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SubcalcWebService
     */
    @WebEndpoint(name = "subcalcWebServicePort")
    public SubcalcWebService getSubcalcWebServicePort() {
        return super.getPort(new QName("http://src.com/", "subcalcWebServicePort"), SubcalcWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SubcalcWebService
     */
    @WebEndpoint(name = "subcalcWebServicePort")
    public SubcalcWebService getSubcalcWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://src.com/", "subcalcWebServicePort"), SubcalcWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SUBCALCWEBSERVICE_EXCEPTION!= null) {
            throw SUBCALCWEBSERVICE_EXCEPTION;
        }
        return SUBCALCWEBSERVICE_WSDL_LOCATION;
    }

}