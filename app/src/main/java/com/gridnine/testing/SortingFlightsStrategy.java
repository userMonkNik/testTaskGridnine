package com.gridnine.testing;

import java.util.List;

/**
 * Sorting strategy interface.
 */
public interface SortingFlightsStrategy {
    List<Flight> apply(List<Flight> flightList);
}
