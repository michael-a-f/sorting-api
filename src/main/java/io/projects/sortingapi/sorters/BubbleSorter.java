package io.projects.sortingapi.sorters;

import io.projects.sortingapi.Frame;
import io.projects.sortingapi.Sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSorter extends Sorter {

    public List<Frame> generateSortFrames() {
        if (list.size() == 0) {
            return frames;
        }
        boolean isSorted = false;
        int right = list.size() - 1;
        while (!isSorted) {
            int swaps = 0;
            for (int i = 0; i < right; i++) {
                frames.add(new Frame(new ArrayList<>(list), i));
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i+1);
                    swaps++;
                }
            }
            frames.add(new Frame(new ArrayList<>(list), right));
            right--;
            if (swaps == 0) {
                isSorted = true;
            }
        }
        frames.add(new Frame(new ArrayList<>(list), null));
        return this.frames;
    }
}
