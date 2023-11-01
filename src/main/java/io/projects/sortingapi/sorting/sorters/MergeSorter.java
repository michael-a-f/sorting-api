package io.projects.sortingapi.sorting.sorters;

import io.projects.sortingapi.sorting.SortFrame;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MergeSorter implements Sorter {

    public static class MergeSortFrame extends SortFrame {
        public MergeSortFrame(List<Integer> list, int left, int current, int right) {
            super(List.copyOf(list));
            this.highlights.put("left", left);
            this.highlights.put("current", current);
            this.highlights.put("right", right);
        }
    }

    public List<SortFrame> generateSortFrames(List<Integer> list) {
        final List<SortFrame> frames = new ArrayList<>();
        mergeSort(list, 0, list.size() - 1, frames);
        return frames;
    }

    public void mergeSort(List<Integer> list, int left, int right, List<SortFrame> frames) {

    }
}
