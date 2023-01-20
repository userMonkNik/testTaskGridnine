package com.gridnine.testing;

import java.util.List;

/**
 * Sorting strategy controller.
 */
public class SortingFlightsStrategyController {

    private List<Flight> flightList;

    private SortingFlightsStrategy sortingFlightsStrategy;

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public void setSortingFlightsStrategy(SortingFlightsStrategy sortingFlightsStrategy) {
        this.sortingFlightsStrategy = sortingFlightsStrategy;
    }

    public List<Flight> execute() {

        if (flightList == null) {
            throw new RuntimeException("Please, set flight list before executing...");

        } else if (sortingFlightsStrategy == null) {
            throw new RuntimeException("Please, set sorting strategy before executing...");
        }

        return sortingFlightsStrategy.apply(flightList);
    }

}
