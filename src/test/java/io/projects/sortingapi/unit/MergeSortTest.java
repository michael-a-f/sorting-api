package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.MergeSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MergeSortTest {
    @Autowired
    MergeSorter mergeSorter;

    @Test
    void sortsList() {
        final int NUMS = 50;
        final List<SortFrame> frames = new ArrayList<>();

        // create random list
        List<Integer> list = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < NUMS; i++) {
            list.add(rand.nextInt(100));
        }

        // get the expected sorted list
        List<Integer> expected = new ArrayList<>(list);
        Collections.sort(expected);
        System.out.println(expected);

        // get sorted list per algo
        mergeSorter.mergeSort(list, 0, list.size() - 1, frames);
        System.out.println(list);

        Assertions.assertEquals(expected, list);
    }
}
