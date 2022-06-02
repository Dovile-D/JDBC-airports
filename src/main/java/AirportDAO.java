import java.sql.*;
import java.util.ArrayList;

public class AirportDAO {
    //    global variables:
    private static final String DATABASE_NAME = "airports";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";


    public static void create(Airport airport) {
        // new entry creation query
        // put ? for every table column:
        String query = "INSERT into sb_airports (biz_name, address, city) VALUES (?, ?, ?);";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try {
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
            // prepare database query (read given String):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1(hardcoding is bad for security reasons):
            preparedStatement.setString(1, airport.getBizName());
            preparedStatement.setString(2, airport.getAddress());
            preparedStatement.setString(3, airport.getCity());
            // run prepared query:
            preparedStatement.executeUpdate(); // this method is used to create new entry, update or delete entry
//            preparedStatement.executeQuery(); // this method is used to read entries

            // close connection to a database:
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();
        }
    }

    public static void updateById(Airport airport) {
        // updating query
        // put ? for every table column:
        String query = "UPDATE sb_airports SET biz_name = ?, address = ?, city = ? WHERE biz_id = ?;";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try {
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
            // prepare database query (read given String):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1(hardcoding is bad for security reasons):
            preparedStatement.setString(1, airport.getBizName());
            preparedStatement.setString(2, airport.getAddress());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setInt(4, airport.getBizId());

            // run prepared query:
            preparedStatement.executeUpdate(); // this method is used to create, update or delete entry
//            preparedStatement.executeQuery(); // this method is used to read entries

            // close connection to a database:
            connection.close();
            preparedStatement.close();
            System.out.println("Updating by Id: " + airport.getBizId());
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();
        }
    }

    public static void deleteById(int bizId) {
        // deleting query
        // put ? for every table column:
        String query = "DELETE FROM sb_airports WHERE sb_airports.biz_id = ?;";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try {
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
            // prepare database query (read given String):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1(hardcoding is bad for security reasons):

            preparedStatement.setInt(1, bizId);

            // run prepared query:
            preparedStatement.executeUpdate(); // this method is used to create, update or delete entry
//            preparedStatement.executeQuery(); // this method is used to read entries

            // close connection to a database:
            connection.close();
            preparedStatement.close();
            System.out.println("Deleting by Id: " + bizId);
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();
        }
    }

    public static ArrayList<Airport> searchById(int bizId) {
        String query = "SELECT * FROM sb_airports WHERE biz_id = ?;";

        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        ArrayList<Airport> airports = new ArrayList<>(); // array list to store entries from result set
        try {
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
            // prepare database query (read given String):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1(hardcoding is bad for security reasons):
            preparedStatement.setInt(1, bizId);

            ResultSet resultSet = preparedStatement.executeQuery(); // this method is used to read entries
            // create result set
            while (resultSet.next()) {
                airports.add(new Airport(
                        resultSet.getInt("biz_id"),
                        resultSet.getString("biz_name"),
                        resultSet.getString("address"),
                        resultSet.getString("city")
                ));
            }


            // close connection to a database:
            connection.close();
            preparedStatement.close();
            System.out.println("Searching by Id: " + bizId);
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();

        }
        return airports;
    }

    public static ArrayList<Airport> searchByCity(String city) {
        // searching by a part of the word with LIKE:
        String query = "SELECT * FROM sb_airports WHERE city LIKE ?;";

        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        ArrayList<Airport> airports = new ArrayList<>(); // array list to store entries from result set
        try {
            // create connection to a database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful! ");
            // prepare database query (read given String):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1(hardcoding is bad for security reasons):
            // searching by a part of the word with "%"
            preparedStatement.setString(1, "%" + city + "%");

            ResultSet resultSet = preparedStatement.executeQuery(); // this method is used to read entries
            // create result set
            while (resultSet.next()) {
                airports.add(new Airport(
                        resultSet.getInt("biz_id"),
                        resultSet.getString("biz_name"),
                        resultSet.getString("address"),
                        resultSet.getString("city")
                ));
            }


            // close connection to a database:
            connection.close();
            preparedStatement.close();
            System.out.println("Searching by city: " + city);
        } catch (SQLException e) {
            System.out.println("Connection failed! Read more: ");
            e.printStackTrace();

        }
        return airports;
    }
}

