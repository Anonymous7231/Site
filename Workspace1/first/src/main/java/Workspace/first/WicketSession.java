package Workspace.first;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class WicketSession extends AuthenticatedWebSession{
	public WicketSession(Request request) {
		super(request);
	}

	@Override
	protected boolean authenticate(String username, String password) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//sslProtocol=TLSv1.2
		//cryptoprotocolversion=TLSv1.2
		String connectionUrl = "jdbc:sqlserver://;servername=USER-ПК\\SQLEXPRESS;port=1433;database=MyPage;integratedSecurity=false;user=sa;password=qwerty";
		
		Boolean mybool = false;
		
		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			String SQL = "SELECT COUNT(*) FROM Пользователи WHERE Login='"+ username + "' AND Password='" + password + "'";
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
		
		return mybool;
	}

	@Override
	public Roles getRoles() {
		if (isSignedIn())
        {
            return new Roles(Roles.ADMIN);
        }
		return null;
	}
}