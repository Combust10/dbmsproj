package TM;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

public class SQLite {


		static Connection con;
		private static boolean hasData = false;
	public static void getConnection() throws ClassNotFoundException, SQLException
		{
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:resource:Database.db");
			initialise();
		}
		static void initialise() throws SQLException {
				con=DriverManager.getConnection("jdbc:sqlite:src/TM/Database.db");
				Statement state=con.createStatement();
				state.execute("CREATE TABLE IF NOT EXISTS login(id integer,"+"username varchar(60),"+"password varchar(60),"+"sq varchar(100),"+"ans varchar(60));");
				state.execute("CREATE TABLE IF NOT EXISTS package(no integer,"+"date varchar(60),"+"id integer,"+"packageno varchar(60));");
				state.execute("CREATE TABLE IF NOT EXISTS customers(no integer,"+"name varchar(60),"+"phone integer,"+"id integer,"+"age integer,"+"address varchar(60));");
				state.execute("CREATE TABLE IF NOT EXISTS company(id integer,"+"compname varchar(60),"+"compdets varchar(200));");
				state.execute("CREATE TABLE IF NOT EXISTS settings(id integer,"+"name varchar(60),"+"line1 varchar(200),"+"line2 varchar(200),"+"fs integer);");
				PreparedStatement prep4=con.prepareStatement("INSERT INTO login values(?,?,?,?,?);");
				prep4.setString(2, "admin");
				prep4.setString(3, "password");
				prep4.execute();
				prep4=con.prepareStatement("INSERT INTO settings values(?,?,?,?,?);");
				prep4.setInt(5,0);
				prep4.execute();
				con.close();
		
	}

}
