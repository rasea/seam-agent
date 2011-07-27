package org.rasea.agent.seam.configuration;

import org.rasea.agent.seam.exception.ConfigurationException;

public final class ConfigurationValidator {

	public static void validate(final Configuration configuration)
			throws ConfigurationException {

		if (configuration == null) {
			throw new ConfigurationException("server element can not be null");

		} else if (configuration.getHost() == null) {
			throw new ConfigurationException("host attribute can not be null");
		}

		// } else if (configuration.getProtocol() == null) {
		// throw new ConfigurationException(
		// "protocol attribute can not be null");
		//		
		// } else if (configuration.getContext() == null) {
		// throw new ConfigurationException(
		// "context attribute can not be null");
		//
		// } else if (configuration.getMode() == null) {
		// throw new ConfigurationException("mode attribute can not be null");
		// }
	}
}
