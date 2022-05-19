import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AirportDAO {
    public static void create(Airport airport) {
        // new entry creation query
        String query = "";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + "airports";
        try{
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, "root","");
            System.out.println("Connection successful! ");
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();
        }
    }
}
