package io.projects.sortingapi.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SortFrame {
    public List<Integer> list;
    public Map<String, Integer> highlights;

    public SortFrame(List<Integer> list) {
        this.list = list;
        this.highlights = new HashMap<>();
    }
}
