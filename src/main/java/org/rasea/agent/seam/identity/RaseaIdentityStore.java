package org.rasea.agent.seam.identity;

import static org.jboss.seam.ScopeType.APPLICATION;
import static org.jboss.seam.annotations.Install.FRAMEWORK;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.AuthorizationException;
import org.jboss.seam.security.management.IdentityStore;
import org.rasea.agent.seam.configuration.Configuration;
import org.rasea.agent.seam.configuration.Mode;
import org.rasea.agent.seam.exception.AgentException;
import org.rasea.agent.seam.locator.ServicePortLocator;
import org.rasea.agent.seam.permission.PartnerApplication;
import org.rasea.agent.seam.proxy.AccessControl;
import org.rasea.agent.seam.proxy.AddRole;
import org.rasea.agent.seam.proxy.AddUser;
import org.rasea.agent.seam.proxy.AssignUser;
import org.rasea.agent.seam.proxy.AssignedRoles;
import org.rasea.agent.seam.proxy.AssignedUsers;
import org.rasea.agent.seam.proxy.ChangePassword;
import org.rasea.agent.seam.proxy.DeassignUser;
import org.rasea.agent.seam.proxy.DeleteRole;
import org.rasea.agent.seam.proxy.DeleteUser;
import org.rasea.agent.seam.proxy.DisableUser;
import org.rasea.agent.seam.proxy.EnableUser;
import org.rasea.agent.seam.proxy.ListRoles;
import org.rasea.agent.seam.proxy.ListUsers;
import org.rasea.agent.seam.proxy.Management;
import org.rasea.agent.seam.proxy.RaseaServiceException;
import org.rasea.agent.seam.proxy.RaseaServiceHeader;
import org.rasea.agent.seam.proxy.Role;
import org.rasea.agent.seam.proxy.RoleDetail;
import org.rasea.agent.seam.proxy.User;
import org.rasea.agent.seam.proxy.UserDetail;
import org.rasea.agent.seam.proxy.UserEnabled;

@Name("org.jboss.seam.security.identityStore")
@Install(precedence = FRAMEWORK)
@Scope(APPLICATION)
public class RaseaIdentityStore implements IdentityStore {

	private static final int PERMISSION_DENIED = 1;

	private AccessControl accessControlService;

	private List<String> allRoles;

	private List<String> allUsers;

	private Management managementService;

	@In(create = true)
	private PartnerApplication partnerApplication;

	@In
	@Out(required = true)
	private RaseaServiceHeader raseaServiceHeader;

	public boolean addRoleToGroup(final String role, final String group) {
		return false;
	}

	public boolean authenticate(final String username, final String password) {
		boolean authenticated = false;

		try {
			if (Configuration.instance().getMode().equals(Mode.DEFAULT)) {
				authenticated = this.getAccessControlService().authenticate(
						username, password);
			} else {
				authenticated = true;
			}

			this.raseaServiceHeader = new RaseaServiceHeader();
			this.raseaServiceHeader.setUsername(username);
			this.raseaServiceHeader.setPassword(password);

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return authenticated;
	}

	public boolean changePassword(final String name, final String password) {
		boolean result;

		try {
			final ChangePassword request = new ChangePassword();
			request.setUsername(name);
			request.setPassword(password);

			result = this.getAccessControlService().changePassword(request,
					this.raseaServiceHeader).isChanged();

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	private RuntimeException createException(final RaseaServiceException cause) {

		if (cause.getFaultInfo().getErrorCode() == PERMISSION_DENIED) {
			return new AuthorizationException(cause.getMessage());
		}

		return new AgentException(cause);
	}

	public boolean createRole(final String role) {
		boolean result = false;

		final Role raseaRole = new Role();
		raseaRole.setName(role);
		raseaRole.setDescription(role);

		try {
			final AddRole request = new AddRole();
			request.setApplication(this.partnerApplication.getAppName());
			request.setRole(raseaRole);
			this.getManagementService().addRole(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean createUser(final String username, final String password) {
		return this.createUser(username, password, null, null);
	}

	public boolean createUser(final String username, final String password,
			final String firstName, final String lastName) {
		return this.createUser(username, password, firstName, lastName, null);
	}

	public boolean createUser(final String username, final String password,
			final String firstName, final String lastName, final String email) {
		boolean result = false;

		final User user = new User();
		user.setUsername(username);
		user.setDisplayName(firstName);

		if (lastName != null && !"".equals(lastName.trim())) {
			if (user.getDisplayName() != null) {
				user.setDisplayName(user.getDisplayName() + " " + lastName);
			} else {
				user.setDisplayName(lastName);
			}
		}

		user.setEmail(email);

		final AddUser request = new AddUser();
		request.setPassword(password);
		request.setUser(user);

		try {
			this.getManagementService().addUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean deleteRole(final String role) {
		boolean result = false;

		final DeleteRole request = new DeleteRole();
		request.setApplication(this.partnerApplication.getAppName());
		request.setRole(role);
		try {
			this.getManagementService().deleteRole(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean deleteUser(final String name) {
		boolean result = false;

		final DeleteUser request = new DeleteUser();
		request.setUsername(name);
		try {
			this.getManagementService().deleteUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean disableUser(final String name) {
		boolean result = false;

		final DisableUser request = new DisableUser();
		request.setUsername(name);
		try {
			this.getManagementService().disableUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean enableUser(final String name) {
		boolean result = false;

		final EnableUser request = new EnableUser();
		request.setUsername(name);
		try {
			this.getManagementService().enableUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	private synchronized AccessControl getAccessControlService() {
		if (this.accessControlService == null) {
			this.accessControlService = ServicePortLocator.instance()
					.getAccessControlServicePort();
		}

		return this.accessControlService;
	}

	public String getDisplayName(final String username) {
		String result = null;

		try {
			if (Configuration.instance().getMode().equals(Mode.DEFAULT)) {
				final UserDetail request = new UserDetail();
				request.setUsername(username);

				final User user = this.getAccessControlService().userDetail(
						request, this.raseaServiceHeader).getUser();

				result = user.getDisplayName();
			} else {
				result = "Mode: " + Configuration.instance().getMode();
			}

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public String getEmail(final String username) {
		String result = null;

		try {
			final UserDetail request = new UserDetail();
			request.setUsername(username);

			final User user = this.getAccessControlService().userDetail(
					request, this.raseaServiceHeader).getUser();

			result = user.getEmail();

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.seam.security.management.IdentityStore#getGrantedRoles(java
	 * .lang.String)
	 */
	public List<String> getGrantedRoles(final String name) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.seam.security.management.IdentityStore#getImpliedRoles(java
	 * .lang.String)
	 */
	public List<String> getImpliedRoles(final String name) {
		final List<String> roles = new ArrayList<String>();
		final AssignedRoles request = new AssignedRoles();
		request.setApplication(this.partnerApplication.getAppName());
		request.setUsername(name);
		try {
			if (Configuration.instance().getMode().equals(Mode.DEFAULT)) {
				for (final Role role : this.getAccessControlService()
						.assignedRoles(request, this.raseaServiceHeader)
						.getRoles()) {
					roles.add(role.getName());
				}
			}

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return roles;
	}

	private synchronized Management getManagementService() {
		if (this.managementService == null) {
			this.managementService = ServicePortLocator.instance()
					.getManagementServicePort();
		}

		return this.managementService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jboss.seam.security.management.IdentityStore#getRoleGroups(java.lang
	 * .String)
	 */
	public List<String> getRoleGroups(final String name) {
		return null;
	}

	public boolean grantRole(final String name, final String role) {
		boolean result = false;
		final AssignUser request = new AssignUser();
		request.setApplication(this.partnerApplication.getAppName());
		request.setRole(role);
		request.setUsername(name);
		try {
			this.getManagementService().assignUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean isUserEnabled(final String name) {
		boolean result = false;
		final UserEnabled request = new UserEnabled();
		request.setUsername(name);
		try {
			result = this.getAccessControlService().userEnabled(request,
					this.raseaServiceHeader).isEnabled();

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public List<String> listGrantableRoles() {
		return this.listRoles();
	}

	public List<Principal> listMembers(final String role) {
		final List<Principal> principals = new ArrayList<Principal>();

		List<User> assignedUsers = null;
		final AssignedUsers request = new AssignedUsers();
		request.setApplication(this.partnerApplication.getAppName());
		request.setRole(role);
		try {
			assignedUsers = this.getAccessControlService().assignedUsers(
					request, this.raseaServiceHeader).getUsers();
		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		Principal principal;
		for (final User user : assignedUsers) {

			principal = new Principal() {
				public String getName() {
					return user.getUsername();
				}
			};

			principals.add(principal);
		}

		return principals;
	}

	public List<String> listRoles() {
		final ListRoles request = new ListRoles();
		request.setApplication(this.partnerApplication.getAppName());
		if (this.allRoles == null) {
			try {
				final List<Role> roles = this.getAccessControlService()
						.listRoles(request, this.raseaServiceHeader).getRoles();
				this.allRoles = new ArrayList<String>();

				for (final Role role : roles) {
					this.allRoles.add(role.getName());
				}

			} catch (final RaseaServiceException cause) {
				throw this.createException(cause);
			}
		}

		return this.allRoles;
	}

	public List<String> listUsers() {

		if (this.allUsers == null) {
			try {
				final List<User> users = this.getAccessControlService()
						.listUsers(new ListUsers(), this.raseaServiceHeader)
						.getUsers();
				this.allUsers = new ArrayList<String>();

				for (final User user : users) {
					this.allUsers.add(user.getUsername());
				}

			} catch (final RaseaServiceException cause) {
				throw this.createException(cause);
			}
		}

		return this.allUsers;
	}

	public List<String> listUsers(final String filter) {
		final List<String> users = new ArrayList<String>();

		for (final String user : this.listUsers()) {
			if (user.indexOf(filter) >= 0) {
				users.add(user);
			}
		}

		return users;
	}

	public boolean removeRoleFromGroup(final String role, final String group) {
		return false;
	}

	public boolean requestConfirmationCode(final String username) {
		boolean ret = false;
		try {
			ret = this.getAccessControlService().requestConfirmationCode(
					username);
		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return ret;
	}

	public boolean resetPassword(final String username,
			final String confirmationCode) {
		boolean ret = false;
		try {
			ret = this.getAccessControlService().resetPassword(username,
					confirmationCode);
		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return ret;
	}

	public boolean revokeRole(final String name, final String role) {
		boolean result = false;
		final DeassignUser request = new DeassignUser();
		request.setApplication(this.partnerApplication.getAppName());
		request.setRole(role);
		request.setUsername(name);
		try {
			this.getManagementService().deassignUser(request,
					this.raseaServiceHeader);
			result = true;

		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return result;
	}

	public boolean roleExists(final String name) {
		boolean result = false;
		final RoleDetail request = new RoleDetail();
		request.setApplication(this.partnerApplication.getAppName());
		request.setRole(name);
		try {
			final Role role = this.getAccessControlService().roleDetail(
					request, this.raseaServiceHeader).getRole();
			result = (role != null);

		} catch (final RaseaServiceException cause) {

			if (cause.getFaultInfo().getErrorCode() == 0) {
				result = false;
			}
			throw this.createException(cause);
		}

		return result;
	}

	public boolean supportsFeature(final Feature feature) {
		return true;
	}

	public boolean userExists(final String name) {
		User user = null;
		final UserDetail request = new UserDetail();
		request.setUsername(name);
		try {
			user = this.getAccessControlService().userDetail(request,
					this.raseaServiceHeader).getUser();
		} catch (final RaseaServiceException cause) {
			throw this.createException(cause);
		}

		return user != null;
	}
}
