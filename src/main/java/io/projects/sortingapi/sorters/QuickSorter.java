package io.projects.sortingapi.sorters;

import io.projects.sortingapi.Frame;
import io.projects.sortingapi.Sorter;

import java.util.List;

public class QuickSorter implements Sorter {
    public List<Integer> list;
    public List<Frame> frames;

    public QuickSorter setList(List<Integer> list) {
        this.list = list;
        return this;
    }

    public QuickSorter setFrames(List<Frame> frames) {
        this.frames = frames;
        return this;
    }

    public List<Frame> generateSortFrames() {
        return this.frames;
    }
}
