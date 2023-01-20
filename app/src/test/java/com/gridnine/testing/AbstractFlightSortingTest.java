package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractFlightSortingTest {
    protected static SortingFlightsStrategy sortingFlightsStrategy;

    protected static List<Flight> testFlightsList;
    protected static List<Flight> expectedFlightsList;

    protected static LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    protected static Flight normalTwoHoursFlight = createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    protected static Flight multiSegmentFlight = createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5));
    protected static Flight departingInPastFlight = createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow);
    protected static Flight departsBeforeArrivesFlight = createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6));
    protected static Flight moreThanTwoHoursGroundTimeFlight1 = createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6));
    protected static Flight moreThanTwoHoursGroundTimeFlight2 = createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
            threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7));

    protected static void setTestFlightList() {
        testFlightsList = new ArrayList<>();

        testFlightsList.add(normalTwoHoursFlight);
        testFlightsList.add(multiSegmentFlight);
        testFlightsList.add(departingInPastFlight);
        testFlightsList.add(departsBeforeArrivesFlight);
        testFlightsList.add(moreThanTwoHoursGroundTimeFlight1);
        testFlightsList.add(moreThanTwoHoursGroundTimeFlight2);
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }

    abstract public void test();
}
