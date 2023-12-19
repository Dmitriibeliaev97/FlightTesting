package com.gridnine.filters;

import com.gridnine.models.Flight;
import com.gridnine.filters.interfaces.FlightFilterInterface;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сегменты с датой прилёта раньше даты вылета.
 */
public class ArrivalBeforeDepartureFilter implements FlightFilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.segments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
