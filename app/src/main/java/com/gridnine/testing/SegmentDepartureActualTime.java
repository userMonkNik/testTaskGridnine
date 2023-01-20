package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorting strategy class. Exclude flights with segment departure in the past.
 */
public class SegmentDepartureActualTime implements SortingFlightsStrategy {
    @Override
    public List<Flight> apply(List<Flight> flightList) {
        LocalDateTime now = LocalDateTime.now();

        return flightList.stream().filter(
                (flight -> flight.getSegments()
                        .stream()
                        .allMatch((segment -> segment.getDepartureDate().isAfter(now))))
        ).collect(Collectors.toList());
    }
}
