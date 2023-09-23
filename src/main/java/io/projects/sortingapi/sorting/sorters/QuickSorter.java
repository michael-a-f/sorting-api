package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class QuickSorter implements Sorter {

    public List<SortFrame> generateSortFrames(List<Integer> list) {
        final List<SortFrame> frames = new ArrayList<>();
        quickSort(list, 0, list.size() - 1, frames);
        return frames;
    }

    public void quickSort(List<Integer> list, int left, int right, List<SortFrame> frames) {
        if (left < right) {
            int partitionIndex = partition(list, left, right, frames);
            quickSort(list, left, partitionIndex - 1, frames);
            quickSort(list, partitionIndex + 1, right, frames);
        }
    }

    private int partition(@NonNull List<Integer> list, int left, int right, List<SortFrame> frames) {
        int valAtPivot = list.get(right);
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            frames.add(new SortFrame(new ArrayList<>(list), Map.of("pivot", right, "j", j, "i", i)));
            if (list.get(j) <= valAtPivot) {
                i++;
                frames.add(new SortFrame(new ArrayList<>(list), Map.of("pivot", right, "j", j, "i", i)));
                if (!Objects.equals(list.get(i), list.get(j))) {
                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                    frames.add(new SortFrame(new ArrayList<>(list), Map.of("pivot", right, "j", j, "i", i)));
                }
            }
        }

        frames.add(new SortFrame(new ArrayList<>(list), Map.of("pivot", right, "i", i + 1)));
        if (!Objects.equals(list.get(i+1), list.get(right))) {
            int tmp = list.get(i + 1);
            list.set(i + 1, list.get(right));
            list.set(right, tmp);
            frames.add(new SortFrame(new ArrayList<>(list), Map.of("pivot", i + 1, "i", right)));
        }

        return i + 1;
    }
}
