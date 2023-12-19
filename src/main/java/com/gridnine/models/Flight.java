package com.gridnine.models;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс создания перелёта
 * Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public List<Segment> segments() {
        return segments;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Flight) obj;
        return Objects.equals(this.segments, that.segments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segments);
    }


}
