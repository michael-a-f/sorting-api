package io.projects.sortingapi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSorter implements Sorter {

    public void generateSortFrames(List<Integer> list, List<List<Integer>> frames) {
        int n = list.size();
        frames.add(new ArrayList<>(list));
        for (int currIdx = 1; currIdx < n; currIdx++) {
            int right = currIdx;
            int left = right - 1;
            while ((left > -1) && (list.get(right) < list.get(left))) {
                Collections.swap(list, left, right);
                frames.add(new ArrayList<>(list));
                left--;
                right--;
            }
        }
    }
}
