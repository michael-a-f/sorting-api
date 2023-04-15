package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSorter implements Sorter {

    public List<SortFrame> generateSortFrames(List<Integer> list) {
        List<SortFrame> frames = new ArrayList<>();
        int n = list.size();
        if (n == 0) {
            return frames;
        }
        frames.add(new SortFrame(new ArrayList<>(list), 0));
        for (int currIdx = 1; currIdx < n; currIdx++) {
            frames.add(new SortFrame(new ArrayList<>(list), currIdx));
            int right = currIdx;
            int left = right - 1;
            while ((left > -1) && (list.get(right) < list.get(left))) {
                Collections.swap(list, left, right);
                frames.add(new SortFrame(new ArrayList<>(list), left));
                left--;
                right--;
            }
        }
        frames.add(new SortFrame(new ArrayList<>(list), null));
        return frames;
    }
}
