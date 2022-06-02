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
        AirportDAO.deleteById(14);
    }
}
