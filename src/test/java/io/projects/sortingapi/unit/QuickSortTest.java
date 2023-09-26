package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.QuickSorter;
import io.projects.sortingapi.sorting.sorters.QuickSorter.QuickSortFrame;
import io.projects.sortingapi.sorting.sorters.Sorter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.projects.sortingapi.TestUtils.assertFramesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class QuickSortTest {

    @Autowired
    Sorter quickSorter;

    @Test
    void sortsList() {
        final List<Integer> list = new ArrayList<>(Stream.of(4, 5, 3, 1, 2).toList());
        final List<Integer> expected = List.of(1, 2, 3, 4, 5);
        final List<SortFrame> sortedFrames = quickSorter.generateSortFrames(list);
        final List<Integer> actual = sortedFrames.get(sortedFrames.size() - 1).list;
        assertEquals(expected, actual);
    }

    @Test
    void sortsAndHighlights() {
        final List<Integer> list = Stream.of(4, 5, 3, 1, 2).collect(Collectors.toList());
        final List<SortFrame> actual = quickSorter.generateSortFrames(list);

        final List<SortFrame> expected = new ArrayList<>();
        expected.add(new QuickSortFrame(List.of(4, 5, 3, 1, 2), 4, 0, -1));
        expected.add(new QuickSortFrame(List.of(4, 5, 3, 1, 2), 4, 1, -1));
        expected.add(new QuickSortFrame(List.of(4, 5, 3, 1, 2), 4, 2, -1));
        expected.add(new QuickSortFrame(List.of(4, 5, 3, 1, 2), 4, 3, -1));
        expected.add(new QuickSortFrame(List.of(4, 5, 3, 1, 2), 4, 3, 0));
        expected.add(new QuickSortFrame(List.of(1, 5, 3, 4, 2), 4, 3, 0));
        expected.add(new QuickSortFrame(List.of(1, 5, 3, 4, 2), 4, 1));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 1, 4));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 4, 2, 1));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5),4, 2, 2));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 4, 3, 2));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 4, 3, 3));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 4, 4));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 3, 2, 1));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 3, 2, 2));
        expected.add(new QuickSortFrame(List.of(1, 2, 3, 4, 5), 3, 3));

        assertFramesMatch(expected, actual);
    }
}
