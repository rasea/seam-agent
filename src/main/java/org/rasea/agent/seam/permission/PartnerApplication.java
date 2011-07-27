package org.rasea.agent.seam.permission;

import static org.jboss.seam.ScopeType.APPLICATION;
import static org.jboss.seam.annotations.Install.FRAMEWORK;

import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

@Name("org.rasea.agent.seam.permission.partnerApplication")
@Scope(APPLICATION)
@Install(precedence = FRAMEWORK)
@BypassInterceptors
public class PartnerApplication {
	
	private String appName;
	
	public String getAppName() {
		return this.appName;
	}
	
	public void setAppName(final String appName) {
		this.appName = appName;
	}
	
}
