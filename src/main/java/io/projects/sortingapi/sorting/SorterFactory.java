package io.projects.sortingapi.sorting;

import io.projects.sortingapi.sorting.sorters.*;

public class SorterFactory {
    public Sorter getSorter(String algorithm) throws Exception {
        if (algorithm.equalsIgnoreCase("insertion")) {
            return new InsertionSorter();
        } else if (algorithm.equalsIgnoreCase("bubble")) {
            return new BubbleSorter();
        } else if (algorithm.equalsIgnoreCase("merge")) {
            return new MergeSorter();
        } else if (algorithm.equalsIgnoreCase("quick")) {
            return new QuickSorter();
        }
        throw new IllegalArgumentException(algorithm + " is not a supported algorithm!");
    }
}
