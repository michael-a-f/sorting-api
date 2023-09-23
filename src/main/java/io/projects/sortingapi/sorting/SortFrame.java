package io.projects.sortingapi.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortFrame {
    public List<Integer> list;
    public Map<String, Integer> highlights = new HashMap<>();

    public SortFrame(List<Integer> list, Map<String, Integer> highlights) {
        this.list = list;
        this.highlights = highlights;
    }

    public SortFrame(List<Integer> list) {
        this.list = list;
    }

    public SortFrame setList(List<Integer> list) {
        this.list = list;
        return this;
    }

    public SortFrame setCurrent(int current) {
        this.highlights.put("current", current);
        return this;
    }
}
