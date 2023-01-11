package io.projects.sortingapi;

import io.projects.sortingapi.sorters.BubbleSorter;
import io.projects.sortingapi.sorters.InsertionSorter;
import io.projects.sortingapi.sorters.MergeSorter;
import io.projects.sortingapi.sorters.QuickSorter;

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
        throw new Exception("This algorithm is not supported!");
    }
}
