package io.projects.sortingapi.sorting;

import io.projects.sortingapi.sorting.sorters.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SorterFactory {
    private final Sorter insertionSorter;
    private final Sorter bubbleSorter;
    private final Sorter mergeSorter;
    private final Sorter quickSorter;

    public SorterFactory(Sorter insertionSorter, Sorter bubbleSorter,
                         Sorter mergeSorter, Sorter quickSorter) {
        this.insertionSorter = insertionSorter;
        this.bubbleSorter = bubbleSorter;
        this.mergeSorter = mergeSorter;
        this.quickSorter = quickSorter;
    }

    public Sorter getSorter(String algorithm) {
        return switch (SortingAlgorithm.valueOf(algorithm.toUpperCase())) {
            case BUBBLE -> bubbleSorter;
            case INSERTION -> insertionSorter;
            case QUICK -> quickSorter;
            case MERGE -> mergeSorter;
        };
    }
}
