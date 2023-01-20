package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LessOrTwoHoursGroundTimeTest extends AbstractFlightSortingTest {

    @BeforeAll
    public static void setData() {
        sortingFlightsStrategy = new LessOrTwoHoursGroundTime();
        setTestFlightList();

        expectedFlightsList = new ArrayList<>();
        expectedFlightsList.add(normalTwoHoursFlight);
        expectedFlightsList.add(multiSegmentFlight);
        expectedFlightsList.add(departingInPastFlight);
        expectedFlightsList.add(departsBeforeArrivesFlight);
    }

    @Test
    @Override
    public void test() {
        List<Flight> actualFlightList = sortingFlightsStrategy.apply(testFlightsList);

        Assertions.assertEquals(expectedFlightsList, actualFlightList);
    }
}
