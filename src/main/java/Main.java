public class Main {
    public static void main(String[] args) {

//       create:

    Airport airport01 = new Airport("Paris de Gaulle", "Roissy-en-France", "Paris" );
    AirportDAO.create(airport01);

    Airport airport02 = new Airport("Malaga Airport", "Av. del Comandante García Morato, s/n, 29004",
            "Malaga" );
    AirportDAO.create(airport01);

    AirportDAO.create(airport02);

//    update:

    }
}
