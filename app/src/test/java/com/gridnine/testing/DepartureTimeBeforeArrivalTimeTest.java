package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DepartureTimeBeforeArrivalTimeTest extends AbstractFlightSortingTest {

    @BeforeAll
    public static void setData() {
        sortingFlightsStrategy = new DepartureTimeBeforeArrivalTime();
        setTestFlightList();

        expectedFlightsList = new ArrayList<>();
        expectedFlightsList.add(normalTwoHoursFlight);
        expectedFlightsList.add(multiSegmentFlight);
        expectedFlightsList.add(departingInPastFlight);
        expectedFlightsList.add(moreThanTwoHoursGroundTimeFlight1);
        expectedFlightsList.add(moreThanTwoHoursGroundTimeFlight2);
    }

    @Test
    @Override
    public void test() {
        List<Flight> actualFlightList = sortingFlightsStrategy.apply(testFlightsList);

        Assertions.assertEquals(expectedFlightsList, actualFlightList);
    }
}
