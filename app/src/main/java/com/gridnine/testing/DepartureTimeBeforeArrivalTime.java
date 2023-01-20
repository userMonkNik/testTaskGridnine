package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorting strategy class. Exclude flights with segment arrival time before departure time.
 */
public class DepartureTimeBeforeArrivalTime implements SortingFlightsStrategy {
    @Override
    public List<Flight> apply(List<Flight> flightList) {

        return flightList.stream().filter(
                (flight -> flight.getSegments()
                        .stream()
                        .allMatch((segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()))))
        ).collect(Collectors.toList());
    }
}
