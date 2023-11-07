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
        public MergeSortFrame(List<Integer> list, int left, int right) {
            super(List.copyOf(list));
            this.highlights.put("left", left);
            this.highlights.put("right", right);
        }
    }

    public List<SortFrame> generateSortFrames(List<Integer> list) {
        List<SortFrame> frames = new ArrayList<>();
        mergeSort(list, 0, list.size() - 1, frames);
        return frames;
    }

    public void mergeSort(List<Integer> list, int leftIndex, int rightIndex, List<SortFrame> frames) {
        if (leftIndex < rightIndex) {
            final int midIndex = (leftIndex + rightIndex) / 2;
            mergeSort(list, leftIndex, midIndex, frames);
            mergeSort(list, midIndex + 1, rightIndex, frames);
            merge(list, leftIndex, midIndex, midIndex + 1, rightIndex, frames);
        }
    }

    void merge(List<Integer> list, int leftIndex1, int rightIndex1, int leftIndex2, int rightIndex2, List<SortFrame> frames) {
        // left and right sub lists are already sorted, first elements are min
        int leftMin = leftIndex1;
        int rightMin = leftIndex2;

        while (rightMin <= rightIndex2 && leftMin <= rightMin) {
            int leftVal = list.get(leftMin);
            int rightVal = list.get(rightMin);
            frames.add(new MergeSortFrame(list, leftMin, rightMin));
            if (rightVal < leftVal) {
                int toFront = list.remove(rightMin);
                list.add(leftMin, toFront);
                frames.add(new MergeSortFrame(list, leftMin, rightMin));
                // left is now sorted, and right was shifted
                leftMin++;
                rightMin++;
            } else {
                leftMin++;
            }
            frames.add(new MergeSortFrame(list, leftMin, rightMin));
        }
    }
}
