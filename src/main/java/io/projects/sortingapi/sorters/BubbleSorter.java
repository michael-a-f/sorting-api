package io.projects.sortingapi.sorters;

import io.projects.sortingapi.Frame;
import io.projects.sortingapi.Sorter;

import java.util.List;

public class BubbleSorter implements Sorter {
    public List<Integer> list;
    public List<Frame> frames;

    public BubbleSorter setList(List<Integer> list) {
        this.list = list;
        return this;
    }

    public BubbleSorter setFrames(List<Frame> frames) {
        this.frames = frames;
        return this;
    }

    public List<Frame> generateSortFrames() {
        return this.frames;
    }
}
