public class Main {
    public static void main(String[] args) {



    Airport airport01 = new Airport("Paris de Gaulle", "Roissy-en-France", "Paris" );
    AirportDAO.create(airport01);
    }
}
