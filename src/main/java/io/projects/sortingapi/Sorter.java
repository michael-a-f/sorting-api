package io.projects.sortingapi;


import java.util.ArrayList;
import java.util.List;

public abstract class Sorter {
    public List<Integer> list = new ArrayList<>();
    public List<Frame> frames = new ArrayList<>();

    public Sorter setList(List<Integer> list) {
        this.list = list;
        return this;
    }

    public Sorter setFrames(List<Frame> frames) {
        this.frames = frames;
        return this;
    }


    public abstract List<Frame> generateSortFrames();
}
