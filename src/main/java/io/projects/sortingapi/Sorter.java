package io.projects.sortingapi;


import java.util.List;

public interface Sorter {
    public Sorter setList(List<Integer> list);
    public Sorter setFrames(List<Frame> frames);
    public List<Frame> generateSortFrames();
}
