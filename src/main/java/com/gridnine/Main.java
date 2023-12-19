package com.gridnine;

import com.gridnine.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.filters.DepartureBeforeNowFilter;
import com.gridnine.filters.LayoverTimeFilter;
import com.gridnine.filters.interfaces.FlightFilterInterface;
import com.gridnine.models.Flight;
import com.gridnine.models.Segment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем тестовые перелеты
        List<Flight> flights = FlightBuilder.createFlights();

        // Применяем фильтры и выводим результат в консоль
        System.out.println("Исходные перелеты:");
        printFlights(flights);

        System.out.println("\nПравило 1: Вылет до текущего момента времени:");
        FlightFilterInterface departureBeforeNowFilter = new DepartureBeforeNowFilter();
        printFlights(departureBeforeNowFilter.filter(flights));

        System.out.println("\nПравило 2: Сегменты с датой прилёта раньше даты вылета:");
        FlightFilterInterface arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        printFlights(arrivalBeforeDepartureFilter.filter(flights));

        System.out.println("\nПравило 3: Продолжительность времени на земле больше двух часов:");
        FlightFilterInterface layoverTimeFilter = new LayoverTimeFilter();
        printFlights(layoverTimeFilter.filter(flights));

    }

    /**
     * Метод выводит перелёты в нужном формате
     * @param flights
     */
    private static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Перелет:");
            for (Segment segment : flight.segments()) {
                System.out.println("  " + segment.getDepartureDate() + " - " + segment.getArrivalDate());
            }
        }
    }
}