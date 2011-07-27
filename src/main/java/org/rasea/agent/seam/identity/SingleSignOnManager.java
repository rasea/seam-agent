package org.rasea.agent.seam.identity;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SingleSignOnManager {
	
	private CookieParser cookieParser;
	
	public SingleSignOnManager() {
		final Cookie cookie = this.getCookie();
		this.cookieParser = new CookieParser(cookie);
	}
	
	protected void clearCookieValue() {
		final Cookie cookie = this.getCookie();
		
		if (cookie != null) {
			final HttpServletResponse response = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			
			cookie.setValue(null);
			cookie.setPath(CookieParser.COOKIE_PATH);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			try {
				response.flushBuffer();
			} catch (final IOException e) {
				// TODO rever isso! ate então esse erro não significa
				// muito, e a transação de logout deve continuar
			}
		}
	}
	
	protected Cookie getCookie() {
		final FacesContext fctx = FacesContext.getCurrentInstance();
		Cookie cok = null;
		
		if (fctx != null) {
			cok = (Cookie) fctx.getExternalContext().getRequestCookieMap().get(
					CookieParser.COOKIE_NAME);
		}
		
		return cok;
	}
	
	public String getPassword() {
		return this.cookieParser.getPassword();
	}
	
	public String getUserName() {
		return this.cookieParser.getUserName();
	}
	
	public boolean isLogged() {
		boolean ret = false;
		
		if (this.cookieParser != null) {
			ret = this.cookieParser.isLogged();
		} else {
			this.cookieParser = new CookieParser(this.getCookie());
			ret = this.cookieParser.isLogged();
		}
		
		return ret;
	}
	
	public void login(final String userName, final String password) {
		
		this.cookieParser = new CookieParser(this.getCookie());
		this.setPassword(password);
		this.setUserName(userName);
		if (this.validate()) {
			this.persistValue();
			this.cookieParser.setLogged(true);
		}
	}
	
	public void logout() {
		if (this.cookieParser != null) {
			this.clearCookieValue();
			this.cookieParser = null;
		}
	}
	
	protected void persistValue() {
		final Cookie cookie = this.cookieParser.parseToCookie();
		
		if (cookie != null) {
			final FacesContext facesContext = FacesContext.getCurrentInstance();
			if (facesContext != null) {
				final ExternalContext ext = facesContext.getExternalContext();
				if (ext != null) {
					final HttpServletResponse response = (HttpServletResponse) ext.getResponse();
					response.addCookie(cookie);
					
					try {
						response.flushBuffer();
					} catch (final IOException e) {
						// TODO rever isso! ate então esse erro não significa
						// muito, e a transação de login deve continuar
					}
				}
			}
		}
	}
	
	public void setPassword(final String password) {
		this.cookieParser.setPassword(password);
	}
	
	public void setUserName(final String userName) {
		this.cookieParser.setUserName(userName);
	}
	
	public boolean validate() {
		boolean ret = true;
		
		if (this.cookieParser.getUserName() == null) {
			ret = false;
		} else if (this.cookieParser.getPassword() == null) {
			ret = false;
		}
		
		return ret;
	}
}
