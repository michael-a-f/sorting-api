package io.projects.sortingapi.sorting;

import java.util.Collections;
import java.util.List;

public class QuickSorter implements Sorter {
    public void sort(List<Integer> list) {
        Collections.sort(list);
    }
}
