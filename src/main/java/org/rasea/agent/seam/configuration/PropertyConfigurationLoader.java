package org.rasea.agent.seam.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.rasea.agent.seam.exception.ConfigurationException;

public class PropertyConfigurationLoader extends AbstractConfigurationLoader {
	
	@Override
	public Configuration load() throws ConfigurationException {
		Configuration configuration = null;
		
		try {
			final URL url = this.getResourceAsURL("rasea-agent.properties");
			
			if (url != null) {
				final Properties properties = new Properties();
				properties.load(url.openStream());
				
				configuration = this.parse(properties);
			}
			
		} catch (final FileNotFoundException e) {
			configuration = null;
			
		} catch (final IOException e) {
			configuration = null;
		}
		
		return configuration;
	}
	
	private Configuration parse(final Properties properties) throws ConfigurationException {
		try {
			final Protocol protocol = Protocol.valueOf(properties.getProperty("protocol",
					Protocol.HTTP.toString()).toUpperCase());
			final String host = properties.getProperty("host");
			final int port = Integer.valueOf(properties.getProperty("port", Protocol.HTTP
					.equals(protocol) ? "80" : "443"));
			final String context = properties.getProperty("context", "/rasea");
			final Mode mode = Mode.valueOf(properties.getProperty("mode", Mode.DEFAULT.toString())
					.toUpperCase());
			
			return new Configuration(protocol, host, port, context, mode);
			
		} catch (final Throwable cause) {
			throw new ConfigurationException(cause);
		}
	}
}
