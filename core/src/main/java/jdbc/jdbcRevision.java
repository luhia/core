package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcRevision {
	private static String URL= "jdbc:mysql://localhost:3306/test?serverTimezone=GMT";
	private static String USER= "root";
	private static String PWD= "mysql";
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Connexion à la DB");
			String query = "select * from compte";
					
			Statement st = con.createStatement();
			boolean entrees = st.execute(query);
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				double solde = rs.getDouble("solde");
				
				System.out.println("ID:" + id + ", Nom: " + nom 
									+ " Solde : " + solde);
			}
			String q2 = "insert into compte (nom, solde)"
						+ "values('tom', 100)";
			
			st = con.createStatement();
			int success = st.executeUpdate(q2);
			System.out.println("Nbre inserer: " + success);
					
		} catch (SQLException e) {
			System.out.println("Pas de connexion, Erreur...");
			e.printStackTrace();
		}
		
	}
		
}
