package com.gridnine.testing;

import java.util.List;

public class Main {

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
