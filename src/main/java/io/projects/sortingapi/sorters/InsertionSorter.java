package io.projects.sortingapi.sorters;

import io.projects.sortingapi.Frame;
import io.projects.sortingapi.Sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSorter implements Sorter {

    public void generateSortFrames(List<Integer> list, List<Frame> frames) {
        int n = list.size();
        if (n == 0) {
            return;
        }
        frames.add(new Frame(new ArrayList<>(list), 0));
        for (int currIdx = 1; currIdx < n; currIdx++) {
            frames.add(new Frame(new ArrayList<>(list), currIdx));
            int right = currIdx;
            int left = right - 1;
            while ((left > -1) && (list.get(right) < list.get(left))) {
                Collections.swap(list, left, right);
                frames.add(new Frame(new ArrayList<>(list), left));
                left--;
                right--;
            }
        }
        frames.add(new Frame(new ArrayList<>(list), null));
    }
}
