package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.projects.sortingapi.TestUtils.assertFramesMatch;

@Disabled
@SpringBootTest
public class QuickSortTest {

    @Autowired
    Sorter quickSorter;

    // TODO: implement the quick sort algorithm correctly first before doing frames
    @Test
    void sortsList() {
        List<Integer> list = Stream.of(4, 5, 3, 1, 2).toList();
        List<Integer> expected = Stream.of(1, 2, 3, 4, 5).toList();
        List<SortFrame> actual = quickSorter.generateSortFrames(list);

        Assertions.assertEquals(null, actual);
    }

    @Test
    void generatesSortFrames() {
        List<Integer> list = Stream.of(4, 5, 3, 1, 2).collect(Collectors.toList());
        List<SortFrame> actual = quickSorter.generateSortFrames(list);

        List<SortFrame> expected = new ArrayList<>();
//        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 1, 2)), Map.of("current", 0)));
//        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("current", 1)));
//        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("current", 2)));
//        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("current", 3)));
//        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("current", 4)));
//        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), Map.of("current", null)));

        assertFramesMatch(expected, actual);
    }
}
