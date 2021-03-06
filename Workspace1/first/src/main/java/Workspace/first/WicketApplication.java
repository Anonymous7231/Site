package Workspace.first;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

public class WicketApplication extends AuthenticatedWebApplication {
	@Override
	public void init() {
		super.init();
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);
		mountPage("table", Table.class);
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return WicketSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return HomePage.class;
	}
}