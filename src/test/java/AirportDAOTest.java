import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class AirportDAOTest {
    Airport localAirport;
    @Before
    public void setUp(){
        localAirport = new Airport("Riga Airport", "Airport road 15", "Riga");
    }
    @Test
    public void createNewEntryTest() {
        AirportDAO.create(localAirport);
        ArrayList<Airport> remoteAirport = AirportDAO.searchByCity("Riga");
        //remoteAirport is ArrayList so comparing with index
        compareAirports(localAirport, remoteAirport.get(0));
    }

    public void compareAirports(Airport localAirport, Airport remoteAirport) {
        Assert.assertEquals(localAirport.getBizName(), remoteAirport.getBizName());
        Assert.assertEquals(localAirport.getAddress(), remoteAirport.getAddress());
        Assert.assertEquals(localAirport.getCity(), remoteAirport.getCity());
    }
}
