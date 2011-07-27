package org.rasea.agent.seam.configuration;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.rasea.agent.seam.exception.ConfigurationException;

@Startup
@Name("org.rasea.agent.seam.configuration.factory")
@Scope(ScopeType.APPLICATION)
public class ConfigurationFactory {
	
	@Factory(value = "org.rasea.agent.seam.configuration")
	public Configuration loadConfiguration() throws ConfigurationException {
		Configuration configuration = null;
		
		try {
			configuration = new PropertyConfigurationLoader().load();
			
			if (configuration == null) {
				throw new ConfigurationException("Tipo de arquivo não reconhecido!");
			}
			
			ConfigurationValidator.validate(configuration);
			
		} catch (final ConfigurationException cause) {
			throw cause;
			
		} catch (final Throwable cause) {
			throw new ConfigurationException(cause);
		}
		
		return configuration;
	}
}
