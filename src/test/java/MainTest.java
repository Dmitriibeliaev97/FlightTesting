import com.gridnine.FlightBuilder;
import com.gridnine.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.filters.DepartureBeforeNowFilter;
import com.gridnine.filters.LayoverTimeFilter;
import com.gridnine.filters.interfaces.FlightFilterInterface;
import com.gridnine.models.Flight;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MainTest {

    @Test
    public void testDepartureBeforeNowFilter() {;
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterInterface departureBeforeNowFilter = new DepartureBeforeNowFilter();
        List<Flight> filteredFlights = departureBeforeNowFilter.filter(flights);
        assertEquals(5, filteredFlights.size());
        assertEquals(flights.get(0), filteredFlights.get(0));
    }

    @Test
    public void testArrivalBeforeDepartureFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterInterface arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = arrivalBeforeDepartureFilter.filter(flights);
        assertEquals(5, filteredFlights.size());
        assertEquals(flights.get(0), filteredFlights.get(0));
    }

    @Test
    public void testLayoverTimeFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterInterface layoverTimeFilter = new LayoverTimeFilter();
        List<Flight> filteredFlights = layoverTimeFilter.filter(flights);
        assertEquals(4, filteredFlights.size());
        assertEquals(flights.get(0), filteredFlights.get(0));
    }

}
