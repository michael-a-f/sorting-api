package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSorter extends Sorter {

    public List<SortFrame> generateSortFrames() {
        if (list.size() == 0) {
            return frames;
        }
        boolean isSorted = false;
        int right = list.size() - 1;
        while (!isSorted) {
            int swaps = 0;
            for (int i = 0; i < right; i++) {
                frames.add(new SortFrame(new ArrayList<>(list), i));
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i+1);
                    swaps++;
                }
            }
            frames.add(new SortFrame(new ArrayList<>(list), right));
            right--;
            if (swaps == 0) {
                isSorted = true;
            }
        }
        frames.add(new SortFrame(new ArrayList<>(list), null));
        return this.frames;
    }
}
