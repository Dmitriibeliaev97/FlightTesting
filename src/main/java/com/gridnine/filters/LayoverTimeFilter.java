package com.gridnine.filters;

import com.gridnine.models.Flight;
import com.gridnine.models.Segment;
import com.gridnine.filters.interfaces.FlightFilterInterface;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Перелеты, где общее время, проведённое на земле, превышает два часа
 * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).
 */

public class LayoverTimeFilter implements FlightFilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calculateLayoverTime(flight) <= 2)
                .collect(Collectors.toList());
    }

    private long calculateLayoverTime(Flight flight) {
        List<Segment> segments = flight.segments();
        long layoverTime = 0;

        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime departure = segments.get(i + 1).getDepartureDate();
            layoverTime += arrival.until(departure, ChronoUnit.HOURS);
        }
        return layoverTime;
    }
}
