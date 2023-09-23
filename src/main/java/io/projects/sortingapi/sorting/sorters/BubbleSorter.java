package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BubbleSorter implements Sorter {

    public List<SortFrame> generateSortFrames(List<Integer> list) {
        List<SortFrame> frames = new ArrayList<>();
        if (list.size() == 0) {
            return frames;
        }
        boolean isSorted = false;
        int right = list.size() - 1;
        while (!isSorted) {
            int swaps = 0;
            for (int i = 0; i < right; i++) {
                frames.add(new SortFrame(List.copyOf(list)).setCurrent(i));
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i+1);
                    swaps++;
                }
            }
            frames.add(new SortFrame(List.copyOf(list)).setCurrent(right));
            right--;
            if (swaps == 0) {
                isSorted = true;
            }
        }
        return frames;
    }
}
