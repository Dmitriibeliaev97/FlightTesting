package com.gridnine.filters.interfaces;

import com.gridnine.models.Flight;

import java.util.List;

/**
 * Интерфейс для создания фильтров полёта
 */
public interface FlightFilterInterface {
    List<Flight> filter(List<Flight> flights);
}
