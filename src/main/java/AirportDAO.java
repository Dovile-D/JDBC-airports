import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AirportDAO {
//    global variables:
    private  static  final String DATABASE_NAME = "airports";
    private static  final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void create(Airport airport) {
        // new entry creation query
        String query = "INSERT into sb_airports (biz_id, biz_name, address, city) VALUES ('Karmelavos oro uostas', " +
                "'Karmelava, Kauno r', 'Kaunas');";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try{
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME,DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();
        }
    }
}
