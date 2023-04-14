package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;

import java.util.List;

public class MergeSorter extends Sorter {

    public List<SortFrame> generateSortFrames() {
        return this.frames;
    }
}
