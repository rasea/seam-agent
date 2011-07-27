package org.rasea.agent.seam.configuration;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.contexts.Contexts;

@Scope(ScopeType.APPLICATION)
@Name("org.rasea.agent.seam.configuration")
public class Configuration {
	
	public static Configuration instance() {
		if (!Contexts.isApplicationContextActive()) {
			throw new IllegalStateException("No active application context");
		}
		
		final Configuration instance = (Configuration) Component.getInstance(Configuration.class,
				ScopeType.APPLICATION);
		
		if (instance == null) {
			throw new IllegalStateException("No Configuration could be created");
		}
		
		return instance;
	}
	
	private final String context;
	
	private final String host;
	
	private final Mode mode;
	
	private final int port;
	
	private final Protocol protocol;
	
	Configuration(final Protocol protocol, final String host, final int port, final String context,
			final Mode mode) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.context = context;
		this.mode = mode;
	}
	
	public String getContext() {
		return this.context;
	}
	
	public String getHost() {
		return this.host;
	}
	
	public Mode getMode() {
		return this.mode;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public Protocol getProtocol() {
		return this.protocol;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		
		sb.append("[protocol = " + this.getProtocol() + "] ");
		sb.append("[host = " + this.getHost() + "] ");
		sb.append("[port = " + this.getPort() + "]");
		sb.append("[context = " + this.getContext() + "]");
		sb.append("[mode = " + this.getMode() + "]");
		
		return sb.toString();
	}
}
