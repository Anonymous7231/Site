package Workspace.first;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

//import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.markup.html.form.PasswordTextField;
//import org.apache.wicket.markup.html.form.Button;
//import org.apache.wicket.validation.validator.StringValidator;
//import org.apache.wicket.model.PropertyModel;
//import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 534038934800291291L;
	
//	private String Login;
//	private String Password;
	
	public HomePage() {
		super();
		
		Form<Void> MyForm = new Form<Void>("MyForm");
		add(MyForm);
		
		//Label feedback = new Label("feedback", "");
		//MyForm.add(feedback);
		
		MyForm.add(new SignInPanel("signInPanel"));
		
		Boolean result = AuthenticatedWebSession.get().isSignedIn();
		
		if (result) {
			setResponsePage(Table.class);
		}
		
//		TextField<String> LoginField = new TextField<String>("Login", new PropertyModel<String>(this, "Login"));
//		MyForm.add(LoginField);
//		LoginField.setRequired(true);
//		LoginField.add(StringValidator.minimumLength(3));
//		
//		PasswordTextField PasswordField = new PasswordTextField("Password", new PropertyModel<String>(this, "Password"));
//		MyForm.add(PasswordField);
//		PasswordField.setRequired(true);
//		PasswordField.add(StringValidator.minimumLength(3));
		
//		Button EnterButton = new Button("EnterButton") {
//			@Override
//			public void onSubmit() {
//				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//				
//				try {
//					Class.forName(driver);
//				}
//				catch (ClassNotFoundException e1) {
//					e1.printStackTrace();
//				}
//				
//				//sslProtocol=TLSv1.2
//				//cryptoprotocolversion=TLSv1.2
//				String connectionUrl = "jdbc:sqlserver://;servername=USER-????\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
//				
//				try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//					String SQL = "SELECT COUNT(*) FROM ???????????????????????? WHERE Login='"+ LoginField.getDefaultModelObjectAsString() + "' AND Password='" + PasswordField.getDefaultModelObjectAsString() + "'";
//					ResultSet rs = stmt.executeQuery(SQL);
//					while (rs.next()) {
//						if (rs.getString(1).equals("1")) {
//							feedback.setDefaultModelObject("?????????? ????????????????????, " + LoginField.getDefaultModelObjectAsString() + "!");
//							LoginField.setDefaultModelObject("");
//							PasswordField.setDefaultModelObject("");
//							//setResponsePage(HomePage.class);
//						}
//						else {
//							feedback.setDefaultModelObject("???????????? ???????????????? ?????????? ?????? ????????????.");
//						}
//		            }
//					rs.close();
//		            stmt.close();
//		            con.close();
//				}
//				catch (SQLException e) {
//					feedback.setDefaultModelObject(e.getMessage());
//		        }
//			}
//		};
//		MyForm.add(EnterButton);
	}
	public HomePage(final PageParameters parameters)
	{
		add(new SignInPanel("signInPanel"));
	}
}