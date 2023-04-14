package io.projects.sortingapi.sorting.sorters;


import io.projects.sortingapi.sorting.SortFrame;

import java.util.ArrayList;
import java.util.List;

public abstract class Sorter {
    public List<Integer> list = new ArrayList<>();
    public List<SortFrame> frames = new ArrayList<>();

    public Sorter setList(List<Integer> list) {
        this.list = list;
        return this;
    }

    public Sorter setFrames(List<SortFrame> frames) {
        this.frames = frames;
        return this;
    }


    public abstract List<SortFrame> generateSortFrames();
}
