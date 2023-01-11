package io.projects.sortingapi;

import java.util.List;

public class Frame {
    public List<Integer> list;
    public Integer current;

    public Frame(List<Integer> list, Integer current) {
        this.list = list;
        this.current = current;
    }
}
