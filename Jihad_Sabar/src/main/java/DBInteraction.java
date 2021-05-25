
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	



	public class DBInteraction {
		static String url;
		static Connection con;
		static Statement st;
		public static void connect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				System.out.println("problem en connect 1" );
			}
			url = " jdbc:mysql://localhost:3306/mydb";
			try {
				con= DriverManager.getConnection(url,"root","Mama");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("problem en connect 2" );
			}
			 try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("problem en connect 3" );
			}
			
		}
		public static int Maj(String sql)
		{int nb=0;
		try {
			nb=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("problem en Maj 1" );
		}
		return nb;
		}
		public static ResultSet select(String sql) {
	     ResultSet  res = null;
		try {
			
			res=st.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("problem en select 1" );
		}
		return res;
		}
	public static void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

