package org.rasea.agent.seam.identity;

import javax.servlet.http.Cookie;

import org.jboss.seam.util.Base64;

public class CookieParser {
	
	public static final int COOKIE_MAX_AGE = 86400; // 1 day (in seconds)
	
	public static final String COOKIE_NAME = "org.rasea.agent.seam.security";
	
	public static final String COOKIE_PATH = "/";
	
	private static final char SEPARADOR = ':';
	
	private Cookie cookie;
	
	private boolean logged;
	
	private String password;
	
	private String userName;
	
	public CookieParser(final Cookie cookie) {
		if (cookie != null) {
			this.cookie = cookie;
			this.parseFromCookie();
		} else {
			this.cookie = this.createCookie();
		}
	}
	
	public Cookie createCookie() {
		final Cookie cookie = new Cookie(CookieParser.COOKIE_NAME, "");
		cookie.setMaxAge(COOKIE_MAX_AGE);
		cookie.setPath(COOKIE_PATH);
		
		return cookie;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public boolean isLogged() {
		return this.logged;
	}
	
	public void parseFromCookie() {
		final String cookieValue = this.cookie.getValue();
		
		this.logged = false;
		
		if (cookieValue != null) {
			try {
				final String decoded = new String(Base64.decode(cookieValue));
				this.userName = decoded.substring(0, decoded.indexOf(SEPARADOR));
				this.password = decoded.substring(decoded.indexOf(SEPARADOR) + 1);
				
				this.logged = true;
			} catch (final Exception ex) {
			}
		}
	}
	
	public Cookie parseToCookie() {
		this.createCookie();
		
		final StringBuilder sb = new StringBuilder();
		sb.append(this.userName);
		sb.append(SEPARADOR);
		sb.append(this.password);
		
		this.cookie.setValue(Base64.encodeBytes(sb.toString().getBytes()));
		this.cookie.setPath(COOKIE_PATH);
		this.cookie.setMaxAge(COOKIE_MAX_AGE);
		return this.cookie;
	}
	
	public void setLogged(final boolean logged) {
		this.logged = logged;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public void setUserName(final String userName) {
		this.userName = userName;
	}
}
