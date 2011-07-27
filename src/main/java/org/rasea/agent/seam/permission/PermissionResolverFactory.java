package org.rasea.agent.seam.permission;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.core.Init;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.rasea.agent.seam.configuration.Configuration;
import org.rasea.agent.seam.proxy.RaseaServiceException;
import org.rasea.agent.seam.proxy.RaseaServiceHeader;

@Startup
@Scope(ScopeType.APPLICATION)
@Name("org.rasea.agent.seam.permission.factory")
public class PermissionResolverFactory {
	
	private static final String PERMISSION_RESOLVER_NAME = "org.rasea.agent.seam.permission.raseaPermissionResolver";
	
	@Logger
	private Log log;
	
	@In(create = true)
	private PartnerApplication partnerApplication;
	
	@Factory(value = PERMISSION_RESOLVER_NAME, scope = ScopeType.SESSION)
	public RaseaPermissionResolver buildPermissionResolver() throws RaseaServiceException {
		RaseaPermissionResolver raseaPermissionResolver = null;
		final Credentials credentials = (Credentials) Component.getInstance(Credentials.class);
		
		final RaseaServiceHeader header = (RaseaServiceHeader) Component
				.getInstance("raseaServiceHeader");
		
		switch (Configuration.instance().getMode()) {
			case DEFAULT:
				raseaPermissionResolver = new DefaultPermissionResolver(this.partnerApplication,
						credentials, header, this.log);
				break;
			
			case LOAD:
				if (!"Rasea".equalsIgnoreCase(this.partnerApplication.getAppName())) {
					raseaPermissionResolver = new LoadPermissionResolver(this.partnerApplication,
							credentials, header, this.log);
					
				} else {
					raseaPermissionResolver = new DefaultPermissionResolver(this.partnerApplication,
							credentials, header, this.log);
				}
				break;
			
			case MOCK:
				raseaPermissionResolver = new MockPermissionResolver();
		}
		
		return raseaPermissionResolver;
	}
	
	@Observer("org.jboss.seam.security.loginSuccessful")
	public void initPermissionResolver() {
		final RaseaPermissionResolver resolver = (RaseaPermissionResolver) Component.getInstance(
				PERMISSION_RESOLVER_NAME, true);
		resolver.load();
	}
	
	@Create
	public void registerPermissionResolver() {
		Init.instance().addPermissionResolver(PERMISSION_RESOLVER_NAME);
	}
}
