import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//       create:
        Airport airport02 = new Airport("Barcelona Airport", "Av. del Comandante García Morato, s/n, 29004",
                "Barcelona");
//    AirportDAO.create(airport02);

//    update:
        Airport airportUpdate = new Airport(16, "Palangos Oro Uostas", "Pajurio 55", "Palanga");
//    AirportDAO.updateById(airportUpdate);

//    delete:
//        AirportDAO.deleteById(14);

//        read:
//        creat an object for a data storage:
//        Airport airport = AirportDAO.searchById(16);
//        System.out.println(airport);

//        ArrayList<Airport> airports = AirportDAO.searchById(11);
//        if (airports.size() == 0) {
//            System.out.println("no entries");
//        }
//        else {
//            System.out.println(airports);
//        }

        ArrayList<Airport> airports = AirportDAO.searchByCity("Ka");
        if (airports.size() == 0) {
            System.out.println("no entries");
        } else {
            System.out.println(airports);
        }

    }
}
