package com.gridnine.testing;

import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Main {
    /*public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println(flightList);

        SortingFlightsStrategy actualDepartureTime = new ActualSegmentDepartureTime();
        SortingFlightsStrategy arrivalAfterDeparture = new DepartureTimeBeforeArrivalTime();
        SortingFlightsStrategy lessOrTwoHoursBetweenSegments = new LessOrTwoHoursBetweenSegments();

        System.out.println(actualDepartureTime.apply(flightList));
        System.out.println(arrivalAfterDeparture.apply(flightList));
        System.out.println(lessOrTwoHoursBetweenSegments.apply(flightList));
    }*/

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();
        SortingFlightsStrategyController sortingController = new SortingFlightsStrategyController();
        sortingController.setFlightList(flightList);

        sortingController.setSortingFlightsStrategy(new SegmentDepartureActualTime());
        printList(sortingController.execute());

        sortingController.setSortingFlightsStrategy(new DepartureTimeBeforeArrivalTime());
        printList(sortingController.execute());

        sortingController.setSortingFlightsStrategy(new LessOrTwoHoursGroundTime());
        printList(sortingController.execute());
    }

    private static void printList(List<Flight> flightList) {

        System.out.println(flightList);
    }

}
