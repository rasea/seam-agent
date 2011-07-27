package org.rasea.agent.seam.permission;

import java.io.Serializable;

public interface RaseaPermissionResolver extends org.jboss.seam.security.permission.PermissionResolver,
		Serializable {
	
	void load();
}
