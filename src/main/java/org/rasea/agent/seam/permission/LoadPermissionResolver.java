package org.rasea.agent.seam.permission;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.rasea.agent.seam.exception.AgentException;
import org.rasea.agent.seam.locator.ServicePortLocator;
import org.rasea.agent.seam.proxy.AddApplication;
import org.rasea.agent.seam.proxy.AddOperation;
import org.rasea.agent.seam.proxy.AddPermission;
import org.rasea.agent.seam.proxy.AddResource;
import org.rasea.agent.seam.proxy.AddRole;
import org.rasea.agent.seam.proxy.Application;
import org.rasea.agent.seam.proxy.ApplicationDetail;
import org.rasea.agent.seam.proxy.ApplicationDetailResponse;
import org.rasea.agent.seam.proxy.AssignOwner;
import org.rasea.agent.seam.proxy.AssignUser;
import org.rasea.agent.seam.proxy.AssignedRoles;
import org.rasea.agent.seam.proxy.AssignedRolesResponse;
import org.rasea.agent.seam.proxy.GrantPermission;
import org.rasea.agent.seam.proxy.ListRoles;
import org.rasea.agent.seam.proxy.ListRolesResponse;
import org.rasea.agent.seam.proxy.Operation;
import org.rasea.agent.seam.proxy.OperationDetail;
import org.rasea.agent.seam.proxy.OperationDetailResponse;
import org.rasea.agent.seam.proxy.Permission;
import org.rasea.agent.seam.proxy.RaseaServiceException;
import org.rasea.agent.seam.proxy.RaseaServiceHeader;
import org.rasea.agent.seam.proxy.Resource;
import org.rasea.agent.seam.proxy.ResourceDetail;
import org.rasea.agent.seam.proxy.ResourceDetailResponse;
import org.rasea.agent.seam.proxy.ResourceOperations;
import org.rasea.agent.seam.proxy.ResourceOperationsResponse;
import org.rasea.agent.seam.proxy.Role;

public class LoadPermissionResolver implements RaseaPermissionResolver {
	
	private static final long serialVersionUID = 2576702480509669772L;
	
	private Application application;
	
	private final Credentials credentials;
	
	private final RaseaServiceHeader header;
	
	@SuppressWarnings("unused")
	private final Log log;
	
	private final Map<String, Operation> operations = new HashMap<String, Operation>();
	
	private final PartnerApplication partnerApplication;
	
	private final Map<String, Permission> permissions = new HashMap<String, Permission>();
	
	private final Map<String, Resource> resources = new HashMap<String, Resource>();
	
	private Role role;
	
	public LoadPermissionResolver(final PartnerApplication partnerApplication,
			final Credentials credentials, final RaseaServiceHeader header, final Log log) {
		
		this.partnerApplication = partnerApplication;
		this.credentials = credentials;
		this.header = header;
		this.log = log;
	}
	
	public void filterSetByAction(final Set<Object> targets, final String action) {
		// TODO Auto-generated method stub
	}
	
	private Application getApplication() throws RaseaServiceException {
		if (this.application == null) {
			this.application = this.loadApplication();
		}
		
		return this.application;
	}
	
	private Operation getOperation(final String name) throws RaseaServiceException {
		Operation result = this.operations.get(name);
		
		if (result == null) {
			result = this.loadOperation(name);
			this.operations.put(name, result);
		}
		
		return result;
	}
	
	private Permission getPermission(final String resource, final String operation)
			throws RaseaServiceException {
		final String key = resource + "\n" + operation;
		Permission result = this.permissions.get(key);
		
		if (result == null) {
			result = this.loadPermission(resource, operation);
			this.permissions.put(key, result);
		}
		
		return result;
	}
	
	private Resource getResource(final String name) throws RaseaServiceException {
		Resource result = this.resources.get(name);
		
		if (result == null) {
			result = this.loadResource(name);
			this.resources.put(name, result);
		}
		
		return result;
	}
	
	private Role getRole() throws RaseaServiceException {
		if (this.role == null) {
			this.role = this.loadRole();
		}
		
		return this.role;
	}
	
	public boolean hasPermission(final Object target, final String action) {
		boolean result = false;
		
		try {
			final String resource = (String) target;
			final String operation = action;
			
			this.getResource(resource);
			this.getOperation(operation);
			this.getPermission(resource, operation);
			
			result = true;
			
		} catch (final RaseaServiceException cause) {
			throw new AgentException(cause);
		}
		
		return result;
	}
	
	public void load() {
		try {
			this.getApplication();
			this.getRole();
			
		} catch (final RaseaServiceException cause) {
			throw new AgentException(cause);
		}
	}
	
	private Application loadApplication() throws RaseaServiceException {
		final ApplicationDetail request1 = new ApplicationDetail();
		final String name = this.partnerApplication.getAppName();
		
		request1.setApplication(name);
		
		final ApplicationDetailResponse response = ServicePortLocator.instance()
				.getMaintenanceServicePort().applicationDetail(request1, this.header);
		
		Application result = response.getApplication();
		if (result == null) {
			final Application app = new Application();
			app.setName(name);
			app.setDescription(name);
			
			final AddApplication request2 = new AddApplication();
			request2.setApplication(app);
			
			ServicePortLocator.instance().getMaintenanceServicePort().addApplication(request2,
					this.header);
			
			result = app;
		}
		
		if (result != null) {
			final AssignOwner request3 = new AssignOwner();
			request3.setApplication(result.getName());
			request3.setUsername(this.credentials.getUsername());
			
			ServicePortLocator.instance().getMaintenanceServicePort().assignOwner(request3,
					this.header);
		}
		
		return result;
	}
	
	private Operation loadOperation(final String name) throws RaseaServiceException {
		final OperationDetail request = new OperationDetail();
		request.setApplication(this.getApplication().getName());
		request.setOperation(name);
		
		final OperationDetailResponse response = ServicePortLocator.instance()
				.getMaintenanceServicePort().operationDetail(request, this.header);
		
		Operation result = response.getOperation();
		if (result == null) {
			final Operation op = new Operation();
			op.setName(name);
			
			final AddOperation add = new AddOperation();
			add.setApplication(this.getApplication().getName());
			add.setOperation(op);
			
			ServicePortLocator.instance().getMaintenanceServicePort()
					.addOperation(add, this.header);
			
			result = op;
		}
		
		return result;
	}
	
	private Permission loadPermission(final String resource, final String operation)
			throws RaseaServiceException {
		final ResourceOperations request1 = new ResourceOperations();
		request1.setApplication(this.getApplication().getName());
		request1.setResource(resource);
		
		final ResourceOperationsResponse response = ServicePortLocator.instance()
				.getMaintenanceServicePort().resourceOperations(request1, this.header);
		
		boolean valid = false;
		Permission result = null;
		for (final Operation op : response.getOperations()) {
			if (op.getName().equals(operation) && op.getName().equals(operation)) {
				result = new Permission();
				result.setResource(resource);
				result.setOperation(op.getName());
				
				valid = true;
				break;
			}
		}
		
		if (!valid) {
			final AddPermission request2 = new AddPermission();
			request2.setApplication(this.getApplication().getName());
			request2.setResource(this.getResource(resource));
			request2.setOperation(this.getOperation(operation));
			
			ServicePortLocator.instance().getMaintenanceServicePort().addPermission(request2,
					this.header);
			
			result = new Permission();
			result.setResource(resource);
			result.setOperation(operation);
		}
		
		if (result != null) {
			final GrantPermission request3 = new GrantPermission();
			request3.setApplication(this.getApplication().getName());
			request3.setRole(this.getRole().getName());
			request3.setPermission(result);
			request3.setAllowed(true);
			
			ServicePortLocator.instance().getManagementServicePort().grantPermission(request3,
					this.header);
		}
		
		return result;
	}
	
	private Resource loadResource(final String name) throws RaseaServiceException {
		final ResourceDetail request = new ResourceDetail();
		request.setApplication(this.getApplication().getName());
		request.setResource(name);
		
		final ResourceDetailResponse response = ServicePortLocator.instance()
				.getMaintenanceServicePort().resourceDetail(request, this.header);
		
		Resource result = response.getResource();
		if (result == null) {
			final Resource res = new Resource();
			res.setName(name);
			res.setDescription(name);
			
			final AddResource add = new AddResource();
			add.setApplication(this.getApplication().getName());
			add.setResource(res);
			
			ServicePortLocator.instance().getMaintenanceServicePort().addResource(add, this.header);
			result = res;
		}
		
		return result;
	}
	
	private Role loadRole() throws RaseaServiceException {
		Role result = null;
		final String username = this.credentials.getUsername();
		final Application app = this.getApplication();
		
		if (result == null) {
			final AssignedRoles request = new AssignedRoles();
			request.setApplication(app.getName());
			request.setUsername(username);
			
			final AssignedRolesResponse response = ServicePortLocator.instance()
					.getAccessControlServicePort().assignedRoles(request, this.header);
			
			if (response.getRoles() != null && !response.getRoles().isEmpty()) {
				result = response.getRoles().get(0);
			}
		}
		
		if (result == null) {
			final ListRoles request = new ListRoles();
			request.setApplication(app.getName());
			
			final ListRolesResponse response = ServicePortLocator.instance()
					.getAccessControlServicePort().listRoles(request, this.header);
			
			if (response.getRoles() != null && !response.getRoles().isEmpty()) {
				result = response.getRoles().get(0);
			}
		}
		
		if (result == null) {
			final Role role = new Role();
			role.setName("admin");
			role.setDescription("admin");
			
			final AddRole request1 = new AddRole();
			request1.setApplication(app.getName());
			request1.setRole(role);
			
			ServicePortLocator.instance().getManagementServicePort().addRole(request1, this.header);
			
			final AssignUser request2 = new AssignUser();
			request2.setApplication(app.getName());
			request2.setUsername(username);
			request2.setRole(role.getName());
			
			ServicePortLocator.instance().getManagementServicePort().assignUser(request2,
					this.header);
			
			result = role;
		}
		
		return result;
	}
}
