package org.rasea.agent.seam.locator;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.rasea.agent.seam.configuration.Configuration;
import org.rasea.agent.seam.configuration.Protocol;
import org.rasea.agent.seam.proxy.AccessControl;
import org.rasea.agent.seam.proxy.AccessControlService;
import org.rasea.agent.seam.proxy.Maintenance;
import org.rasea.agent.seam.proxy.MaintenanceService;
import org.rasea.agent.seam.proxy.Management;
import org.rasea.agent.seam.proxy.ManagementService;

/**
 * Factory utilizado para gerar um Proxy JAX-WS dos serviços Rasea. Este factory
 * é utilizado provendo apenas a interface (service port) para o client,
 * permitindo independência de implementação para o consumo dos serviços Rasea.
 * 
 * @author paulo
 * @since 08/01/2009
 */
public class ServicePortLocator {

	private static ServicePortLocator instance;

	public static ServicePortLocator instance() {
		if (instance == null) {
			instance = new ServicePortLocator();
		}

		return instance;
	}

	private ServicePortLocator() {
	}

	/**
	 * Retorna a interface do serviço (service port) AccessControl.
	 * 
	 * @return AccessControl
	 */
	public AccessControl getAccessControlServicePort() {
		return this.locateAccessControl();
	}

	/**
	 * Retorna a url do endpoint dos serviços.
	 * 
	 * @return String
	 */
	private String getEndpointAddress(final String endPoint) {
		return this.getProtocol().toString().toLowerCase() + "://"
				+ this.getHost() + ":" + this.getPort() + this.getWsdlBase()
				+ "/" + endPoint;
	}

	/**
	 * Retorna o host que provê os serviços.
	 * 
	 * @return String
	 */
	private String getHost() {
		return Configuration.instance().getHost();
	}

	/**
	 * Retorna a interface do serviço (service port) Maintenance.
	 * 
	 * @return Maintenance
	 */
	public Maintenance getMaintenanceServicePort() {
		return this.locateMaintenance();
	}

	/**
	 * Retorna a interface do serviço (service port) Management.
	 * 
	 * @return Management
	 */
	public Management getManagementServicePort() {
		return this.locateManagement();
	}

	/**
	 * Retorna o número da porta do servidor que contém os serviços Rasea nele
	 * publicados.
	 * 
	 * @return Integer
	 */
	private Integer getPort() {
		return Configuration.instance().getPort();
	}

	/**
	 * Retorna o protocolo de comunicação utilizado nos serviços.
	 * 
	 * @return Protocol
	 */
	private Protocol getProtocol() {
		return Configuration.instance().getProtocol();
	}

	private String getWsdlBase() {
		return Configuration.instance().getContext() + "/services";
	}

	/**
	 * Gera Proxy do serviço a partir de um wsdl local. Após recuperar o service
	 * port, usa a interface BindingProvider para configurar o endpoint a partir
	 * do arquivo de configuração do client.
	 * 
	 * @return AccessControl
	 */
	private AccessControl locateAccessControl() {
		final AccessControlService service = new AccessControlService();
		final AccessControl port = service.getAccessControlPort();
		final BindingProvider bindingProvider = (BindingProvider) port;

		final Map<String, Object> requestContext = bindingProvider
				.getRequestContext();

		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this
				.getEndpointAddress("AccessControl"));

		return port;
	}

	/**
	 * Gera Proxy do serviço a partir de um wsdl local. Após recuperar o service
	 * port, usa a interface BindingProvider para configurar o endpoint a partir
	 * do arquivo de configuração do client.
	 * 
	 * @return Maintenance
	 */
	private Maintenance locateMaintenance() {
		final MaintenanceService service = new MaintenanceService();
		final Maintenance port = service.getMaintenancePort();
		final BindingProvider bindingProvider = (BindingProvider) port;

		final Map<String, Object> requestContext = bindingProvider
				.getRequestContext();

		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this
				.getEndpointAddress("Maintenance"));

		return port;
	}

	/**
	 * Gera Proxy do serviço a partir de um wsdl local. Após recuperar o service
	 * port, usa a interface BindingProvider para configurar o endpoint a partir
	 * do arquivo de configuração do client.
	 * 
	 * @return Management
	 */
	private Management locateManagement() {
		final ManagementService service = new ManagementService();
		final Management port = service.getManagementPort();
		final BindingProvider bindingProvider = (BindingProvider) port;

		final Map<String, Object> requestContext = bindingProvider
				.getRequestContext();

		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this
				.getEndpointAddress("Management"));

		return port;
	}
}
