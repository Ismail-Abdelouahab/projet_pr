package server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	Connection con;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e); // pour afficher l'erreur
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mychat", "root", "");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public Connection obtenirconnexion(){ return con;}
}
