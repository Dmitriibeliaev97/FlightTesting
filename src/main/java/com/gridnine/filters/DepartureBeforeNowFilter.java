package com.gridnine.filters;

import com.gridnine.models.Flight;
import com.gridnine.filters.interfaces.FlightFilterInterface;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Вылет до текущего момента времени
 */
public class DepartureBeforeNowFilter implements FlightFilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.segments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
