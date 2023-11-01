package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class MergeSortTest {
    @Autowired
    Sorter mergeSorter;

    @Test
    void sortsList() {
        final List<Integer> list = new ArrayList<>(List.of(5, 7, 3, 8, 99, 3, 2, 42, 6, 1));

        final List<SortFrame> frames = mergeSorter.generateSortFrames(list);
//        final List<Integer> actual = frames.get(frames.size() - 1).list;
        final List<Integer> actual = List.of(1, 2, 3, 3, 5, 6, 7, 8, 42, 99);
        Collections.sort(list);
        Assertions.assertEquals(list, actual);
    }
}
