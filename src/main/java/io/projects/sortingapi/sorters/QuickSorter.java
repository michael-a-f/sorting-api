package io.projects.sortingapi.sorters;

import io.projects.sortingapi.Frame;
import io.projects.sortingapi.Sorter;

import java.util.List;

public class QuickSorter extends Sorter {

    public List<Frame> generateSortFrames() {
        return this.frames;
    }
}
