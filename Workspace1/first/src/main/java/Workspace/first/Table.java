package Workspace.first;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

@AuthorizeInstantiation("ADMIN")
public class Table extends WebPage {

	private static final long serialVersionUID = -7069442361446618597L;
	
	private String AddLogin;
	private String AddPassword;
	private String RemoveLogin;
	private String EditID;
	private String EditLogin;
	private String EditPassword;
	
	public Table() {
		super();
		
		Form<Void> MyForm = new Form<Void>("MyForm");
		add(MyForm);
		
		//Label feedback = new Label("feedback", "");
		//MyForm.add(feedback);
		
		Form<Void> MyForm5 = new Form<Void>("MyForm5");
		add(MyForm5);
		
		Button LogOut = new Button("LogOut") {
			@Override
			public void onSubmit() {
				getSession().invalidate();
				setResponsePage(HomePage.class);
			}
		};
		MyForm5.add(LogOut);
		
		Label addfeedback = new Label("addfeedback", "");
		MyForm.add(addfeedback);
		
		TextField<String> AddLoginField = new TextField<String>("AddLogin", new PropertyModel<String>(this, "AddLogin"));
		MyForm.add(AddLoginField);
		
		PasswordTextField AddPasswordField = new PasswordTextField("AddPassword", new PropertyModel<String>(this, "AddPassword"));
		MyForm.add(AddPasswordField);
		
		Button AddButton = new Button("AddButton") {
			@Override
			public void onSubmit() {
				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				
				try {
					Class.forName(driver);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				//sslProtocol=TLSv1.2
				//cryptoprotocolversion=TLSv1.2
				String connectionUrl = "jdbc:sqlserver://;servername=USER-????\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
				String SQL = "INSERT INTO ????????????????????????(Login, Password) VALUES ('" + AddLoginField.getDefaultModelObjectAsString() + "', '" + AddPasswordField.getDefaultModelObjectAsString() +"')";
				try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement insert = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);) {
					insert.execute();
					
					insert.close();
					con.close();
					addfeedback.setDefaultModelObject("???????????????????????? ?????????????? ????????????????!");
					AddLoginField.setDefaultModelObject("");
					AddPasswordField.setDefaultModelObject("");
				}
				catch (SQLException e) {
					addfeedback.setDefaultModelObject(e.getMessage());
		        }
			}
		};
		MyForm.add(AddButton);
		
		Form<Void> MyForm2 = new Form<Void>("MyForm2");
		add(MyForm2);
		
		Label removefeedback = new Label("removefeedback", "");
		MyForm2.add(removefeedback);
		
		TextField<String> RemoveLoginField = new TextField<String>("RemoveLogin", new PropertyModel<String>(this, "RemoveLogin"));
		MyForm2.add(RemoveLoginField);
		
		Button RemoveButton = new Button("RemoveButton") {
			@Override
			public void onSubmit() {
				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				
				try {
					Class.forName(driver);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				//sslProtocol=TLSv1.2
				//cryptoprotocolversion=TLSv1.2
				String connectionUrl = "jdbc:sqlserver://;servername=USER-????\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
				
				Boolean mybool = false;
				
				try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					String SQL = "SELECT COUNT(*) FROM ???????????????????????? WHERE Login='"+ RemoveLoginField.getDefaultModelObjectAsString() + "'";
					ResultSet rs = stmt.executeQuery(SQL);
					while (rs.next()) {
						if (rs.getString(1).equals("1")) {
				            mybool = true;
						}
						else {
				            mybool = false;
						}
		            }
					rs.close();
					stmt.close();
					con.close();
				}
				catch (SQLException e) {
					mybool = false;
		        }
				if (mybool) {
					String SQL = "DELETE FROM ???????????????????????? WHERE Login='" + RemoveLoginField.getDefaultModelObjectAsString() +"'";
					try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement delete = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);) {
						delete.execute();
						
						delete.close();
						con.close();
						removefeedback.setDefaultModelObject("???????????????????????? ????????????!");
						RemoveLoginField.setDefaultModelObject("");
					}
					catch (SQLException e) {
						removefeedback.setDefaultModelObject(e.getMessage());
			        }
				}
				else {
					removefeedback.setDefaultModelObject("?????????????? ???????????????????????? ???? ????????????????????!");
				}
			}
		};
		MyForm2.add(RemoveButton);
		
		Form<Void> MyForm3 = new Form<Void>("MyForm3");
		add(MyForm3);
		
		Form<Void> MyForm4 = new Form<Void>("MyForm4");
		add(MyForm4);
		
		Label editfeedback = new Label("editfeedback", "");
		MyForm4.add(editfeedback);
		
		TextField<String> EditIDField = new TextField<String>("EditID", new PropertyModel<String>(this, "EditID"));
		MyForm3.add(EditIDField);
		
		TextField<String> EditLoginField = new TextField<String>("EditLogin", new PropertyModel<String>(this, "EditLogin"));
		MyForm4.add(EditLoginField);
		EditLoginField.setVisible(false);
		
		PasswordTextField EditPasswordField = new PasswordTextField("EditPassword", new PropertyModel<String>(this, "EditPassword"));
		MyForm4.add(EditPasswordField);
		EditPasswordField.setVisible(false);
		
		Button EditButton = new Button("EditButton") {
			@Override
			public void onSubmit() {
				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				
				try {
					Class.forName(driver);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				//sslProtocol=TLSv1.2
				//cryptoprotocolversion=TLSv1.2
				String connectionUrl = "jdbc:sqlserver://;servername=USER-????\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
				String SQL = "UPDATE ???????????????????????? SET Login='" + EditLoginField.getDefaultModelObjectAsString() + "', Password='" + EditPasswordField.getDefaultModelObjectAsString() + "' WHERE ID=" + EditIDField.getDefaultModelObjectAsString();
				try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement update = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);) {
					update.execute();
					
					update.close();
					con.close();
					editfeedback.setDefaultModelObject("???????????????????????? ?????????????? ??????????????!");
					EditLoginField.setDefaultModelObject("");
					EditPasswordField.setDefaultModelObject("");
					EditIDField.setDefaultModelObject("");
					EditLoginField.setVisible(false);
					EditPasswordField.setVisible(false);
					this.setVisible(false);
				}
				catch (SQLException e) {
					EditLoginField.setDefaultModelObject("");
					EditPasswordField.setDefaultModelObject("");
					EditIDField.setDefaultModelObject("");
					EditLoginField.setVisible(false);
					EditPasswordField.setVisible(false);
					this.setVisible(false);
					editfeedback.setDefaultModelObject(e.getMessage());
		        }
			}
		};
		MyForm4.add(EditButton);
		EditButton.setVisible(false);
		
		Button ConfirmButton = new Button("ConfirmButton") {
			@Override
			public void onSubmit() {
				EditLoginField.setVisible(false);
				EditPasswordField.setVisible(false);
				EditButton.setVisible(false);
				
				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				
				try {
					Class.forName(driver);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				//sslProtocol=TLSv1.2
				//cryptoprotocolversion=TLSv1.2
				String connectionUrl = "jdbc:sqlserver://;servername=USER-????\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
				
				Boolean mybool = false;
				
				try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					String SQL = "SELECT COUNT(*) FROM ???????????????????????? WHERE ID="+ EditIDField.getDefaultModelObjectAsString();
					ResultSet rs = stmt.executeQuery(SQL);
					while (rs.next()) {
						if (rs.getString(1).equals("1")) {
				            mybool = true;
						}
						else {
				            mybool = false;
						}
		            }
					rs.close();
					stmt.close();
					con.close();
				}
				catch (SQLException e) {
					mybool = false;
		        }
				if (mybool) {
					EditLoginField.setVisible(true);
					EditPasswordField.setVisible(true);
					EditButton.setVisible(true);
					editfeedback.setDefaultModelObject("?????????????? ?????????? ?????????? ?? ????????????.");
				}
				else {
					EditLoginField.setVisible(false);
					EditPasswordField.setVisible(false);
					EditButton.setVisible(false);
					editfeedback.setDefaultModelObject("???????????????????????? ?? ???????????? ID ???? ????????????????????!");
				}
			}
		};
		MyForm3.add(ConfirmButton);
	}
}