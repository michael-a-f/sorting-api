package io.projects.sortingapi.sorting.sorters;


import io.projects.sortingapi.sorting.SortFrame;

import java.util.List;

public interface Sorter {
    List<SortFrame> generateSortFrames(List<Integer> list);
}
