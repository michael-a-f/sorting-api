package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
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
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("i", -1, "pivot", 4, "j", 0)));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("i", -1, "pivot", 4, "j", 1)));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("i", -1, "pivot", 4, "j", 2)));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("i", -1, "pivot", 4, "j", 3)));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("i", 0, "pivot", 4, "j", 3)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 5, 3, 4, 2)), Map.of("i", 0, "pivot", 4, "j", 3)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 5, 3, 4, 2)), Map.of("i", 1, "pivot", 4)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 4, "pivot", 1)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 1, "pivot", 4, "j", 2)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 2, "pivot", 4, "j", 2)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 2, "pivot", 4, "j", 3)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 3, "pivot", 4, "j", 3)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 4, "pivot", 4)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 1, "pivot", 3, "j", 2)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 2, "pivot", 3, "j", 2)));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("i", 3, "pivot", 3)));

        assertFramesMatch(expected, actual);
    }
}
