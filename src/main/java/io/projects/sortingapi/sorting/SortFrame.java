package io.projects.sortingapi.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortFrame {
    public List<Integer> list;
    public Map<String, Integer> highlights = new HashMap<>();

    public SortFrame(List<Integer> list, Integer current) {
        this.list = list;
        this.highlights.put("current", current);
    }
}
