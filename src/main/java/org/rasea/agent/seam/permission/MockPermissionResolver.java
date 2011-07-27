package org.rasea.agent.seam.permission;

import java.util.Set;

public class MockPermissionResolver implements RaseaPermissionResolver {
	
	private static final long serialVersionUID = 1115471755637218645L;
	
	public void filterSetByAction(final Set<Object> targets, final String action) {
	}
	
	public boolean hasPermission(final Object target, final String action) {
		return true;
	}
	
	public void load() {
	}
}
