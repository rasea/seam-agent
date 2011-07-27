package org.rasea.agent.seam.configuration;

import java.io.FileNotFoundException;
import java.net.URL;

import org.rasea.agent.seam.exception.ConfigurationException;

public abstract class AbstractConfigurationLoader {
	
	protected URL getResourceAsURL(final String resource) throws FileNotFoundException {
		final String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
		
		URL url = null;
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null) {
			url = classLoader.getResource(stripped);
		}
		
		if (url == null) {
			url = PropertyConfigurationLoader.class.getResource(stripped);
		}
		if (url == null) {
			url = PropertyConfigurationLoader.class.getClassLoader().getResource(stripped);
		}
		
		if (url == null) {
			throw new FileNotFoundException(resource + " not found.");
		}
		
		return url;
	}
	
	public abstract Configuration load() throws ConfigurationException;
}
