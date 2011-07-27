package org.rasea.agent.seam.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.management.IdentityManager;
import org.rasea.agent.seam.exception.AgentException;
import org.rasea.agent.seam.locator.ServicePortLocator;
import org.rasea.agent.seam.proxy.Permission;
import org.rasea.agent.seam.proxy.RaseaServiceException;
import org.rasea.agent.seam.proxy.RaseaServiceHeader;
import org.rasea.agent.seam.proxy.UserPermissions;

public class DefaultPermissionResolver implements RaseaPermissionResolver {
	
	private static final long serialVersionUID = 1L;
	
	private final Credentials credentials;
	
	private final RaseaServiceHeader header;
	
	private final Log log;
	
	private final PartnerApplication partnerApplication;
	
	private Map<String, Map<String, String>> permissions;
	
	public DefaultPermissionResolver(final PartnerApplication partnerApplication,
			final Credentials credentials, final RaseaServiceHeader header, final Log log) {
		this.partnerApplication = partnerApplication;
		this.log = log;
		this.credentials = credentials;
		this.header = header;
	}
	
	private void addPermission(final String name, final String action) {
		if (this.permissions.containsKey(name)) {
			final Map<String, String> actions = this.permissions.get(name);
			
			if (!actions.containsKey(action)) {
				actions.put(action, action);
			}
		} else {
			final Map<String, String> actions = new HashMap<String, String>();
			actions.put(action, action);
			
			this.permissions.put(name, actions);
		}
	}
	
	public void filterSetByAction(final Set<Object> targets, final String action) {
		// TODO Auto-generated method stub
	}
	
	public boolean hasPermission(final Object target, final String action) {
		return this.permissions.containsKey(target)
				&& this.permissions.get(target).containsKey(action);
	}
	
	public void load() {
		this.permissions = new HashMap<String, Map<String, String>>();
		this.loadPermissions();
	}
	
	private void loadDefaultPermissions() {
		this.addPermission(IdentityManager.USER_PERMISSION_NAME, IdentityManager.PERMISSION_CREATE);
		this.addPermission(IdentityManager.USER_PERMISSION_NAME, IdentityManager.PERMISSION_READ);
		this.addPermission(IdentityManager.USER_PERMISSION_NAME, IdentityManager.PERMISSION_DELETE);
		this.addPermission(IdentityManager.USER_PERMISSION_NAME, IdentityManager.PERMISSION_UPDATE);
		
		this.addPermission(IdentityManager.ROLE_PERMISSION_NAME, IdentityManager.PERMISSION_CREATE);
		this.addPermission(IdentityManager.ROLE_PERMISSION_NAME, IdentityManager.PERMISSION_READ);
		this.addPermission(IdentityManager.ROLE_PERMISSION_NAME, IdentityManager.PERMISSION_DELETE);
		this.addPermission(IdentityManager.ROLE_PERMISSION_NAME, IdentityManager.PERMISSION_UPDATE);
	}
	
	public void loadPermissions() {
		List<Permission> perm = null;
		
		try {
			final UserPermissions request = new UserPermissions();
			request.setApplication(this.partnerApplication.getAppName());
			request.setUsername(this.credentials.getUsername());
			
			perm = ServicePortLocator.instance().getAccessControlServicePort().userPermissions(
					request, this.header).getPermissions();
			
			if (perm != null) {
				for (final Permission permission : perm) {
					this.log.info("application #0: allow operation #1 on #2 to #3",
							this.partnerApplication.getAppName(), permission.getOperation(),
							permission.getResource(), this.credentials.getUsername());
					
					this.addPermission(permission.getResource(), permission.getOperation());
				}
			}
			
			this.loadDefaultPermissions();
			
		} catch (final RaseaServiceException cause) {
			throw new AgentException(cause);
		}
	}
}
