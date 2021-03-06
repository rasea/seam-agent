
package org.rasea.agent.seam.proxy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "MaintenanceService", targetNamespace = "http://rasea.org/ws/Maintenance", wsdlLocation = "http://localhost:8080/rasea/services/Maintenance?wsdl")
public class MaintenanceService
    extends Service
{

    private final static URL MAINTENANCESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.rasea.agent.seam.proxy.MaintenanceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.rasea.agent.seam.proxy.MaintenanceService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/rasea/services/Maintenance?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/rasea/services/Maintenance?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MAINTENANCESERVICE_WSDL_LOCATION = url;
    }

    public MaintenanceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MaintenanceService() {
        super(MAINTENANCESERVICE_WSDL_LOCATION, new QName("http://rasea.org/ws/Maintenance", "MaintenanceService"));
    }

    /**
     * 
     * @return
     *     returns Maintenance
     */
    @WebEndpoint(name = "MaintenancePort")
    public Maintenance getMaintenancePort() {
        return super.getPort(new QName("http://rasea.org/ws/Maintenance", "MaintenancePort"), Maintenance.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Maintenance
     */
    @WebEndpoint(name = "MaintenancePort")
    public Maintenance getMaintenancePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://rasea.org/ws/Maintenance", "MaintenancePort"), Maintenance.class, features);
    }

}
