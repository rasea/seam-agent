package org.rasea.agent.seam.identity;

import static org.jboss.seam.annotations.Install.FRAMEWORK;

import javax.security.auth.login.LoginException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.Redirect;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;

@Name("org.jboss.seam.security.identity")
@Scope(ScopeType.SESSION)
@Install(precedence = FRAMEWORK, value = false)
@Startup
public class SingleSignOnIdentity extends Identity {

	public static final String EVENT_AUTO_LOGIN = "org.rasea.agent.seam.security.autoLogin";

	private static final String LOGIN = "org.rasea.agent.seam.security.login";

	private static final long serialVersionUID = -2623218379491680717L;

	private static final String SILENT_LOGIN = "org.jboss.seam.security.silentLogin";

	private boolean authenticating = false;

	private boolean autologin = false;

	private SingleSignOnManager singleSignOnManager;

	@Observer("org.rasea.agent.seam.security.autoLogin")
	public void autoLogin() {
		Redirect.instance().captureCurrentView();
		this.tryLogin();
	}

	private boolean doLogin() {
		boolean ret = false;

		this.loadSSOManager();

		if (this.singleSignOnManager.isLogged()) {
			final Credentials credentials = this.getCredentials();
			credentials.setPassword(this.singleSignOnManager.getPassword());
			credentials.setUsername(this.singleSignOnManager.getUserName());

			this.authenticating = true;

			try {
				this.authenticate();
				Contexts.getEventContext().set(SILENT_LOGIN, true);
				ret = true;
				if (Events.exists())
					Events.instance().raiseEvent(EVENT_LOGIN_SUCCESSFUL);
			} catch (final LoginException e) {
				credentials.invalidate();
			}

			this.authenticating = false;
		}
		return ret;
	}

	private void doLogout() {
		this.unAuthenticate();
		Session.instance().invalidate();
		if (Events.exists())
			Events.instance().raiseEvent(EVENT_LOGGED_OUT);
	}

	@Override
	public boolean isLoggedIn() {
		boolean ret = super.isLoggedIn();

		this.loadSSOManager();
		if (!this.authenticating) {
			if (ret && this.singleSignOnManager.isLogged()) {
				final String username = this.singleSignOnManager.getUserName();
				if (!username.equals(this.getCredentials().getUsername())) {

					this.unAuthenticate();
					Session.instance().invalidate();

					this.autologin = true;

					if (ret)
						Events.instance().raiseEvent(EVENT_AUTO_LOGIN);
				}
			} else if (ret && !this.singleSignOnManager.isLogged()) {
				this.logout();
				ret = false;
			} else if (!ret && !this.autologin) {

				ret = this.singleSignOnManager.isLogged();
				// não tire isso daki, risco de recursao infinita.
				this.autologin = true;

				if (ret)
					Events.instance().raiseEvent(EVENT_AUTO_LOGIN);

			}

		}

		return ret;
	}

	private void loadSSOManager() {
		this.singleSignOnManager = (SingleSignOnManager) Contexts
				.getEventContext().get("singleSignOnManager");
		if (this.singleSignOnManager == null) {
			this.singleSignOnManager = new SingleSignOnManager();
			Contexts.getEventContext().set("singleSignOnManager",
					this.singleSignOnManager);
		}
	}

	@Override
	public String login() {
		String ret = null;

		this.loadSSOManager();

		final String username = this.getCredentials().getUsername();
		final String password = this.getCredentials().getPassword();

		Contexts.getEventContext().set(LOGIN, true);

		this.authenticating = true;
		ret = super.login();
		this.authenticating = false;

		if (ret != null) {
			this.singleSignOnManager.login(username, password);
		}

		return ret;
	}

	@Override
	public void logout() {
		this.loadSSOManager();

		this.singleSignOnManager.logout();

		this.doLogout();
		this.autologin = false;
	}

	@Override
	public boolean tryLogin() {
		boolean ret = false;

		if (!this.isLoggedIn()) {
			ret = this.doLogin();
		}

		return ret || super.isLoggedIn();
	}
}
