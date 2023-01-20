package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorting strategy class. Exclude flights with common ground time between segments more than 2 hours.
 */
public class LessOrTwoHoursGroundTime implements SortingFlightsStrategy {
    @Override
    public List<Flight> apply(List<Flight> flightList) {
        return flightList.stream()
                .filter(LessOrTwoHoursGroundTime::lessOrEqualTwoHours)
                .collect(Collectors.toList());
    }

    public static boolean lessOrEqualTwoHours(Flight flight) {
        List<Segment> segmentList = flight.getSegments();
        long sumTimeOnGround = 0;

        for (int i = 0; i < (segmentList.size() - 1); i++) {

            LocalDateTime currentSegmentArrival = segmentList.get(i).getArrivalDate();
            LocalDateTime nextSegmentDeparture = segmentList.get(i + 1).getDepartureDate();

            sumTimeOnGround += ChronoUnit.SECONDS.between(currentSegmentArrival, nextSegmentDeparture);
            long timeLimitOnGround = 60 * 60 * 2;

            if (sumTimeOnGround > timeLimitOnGround) {

                return false;
            }
        }

        return true;
    }
}
