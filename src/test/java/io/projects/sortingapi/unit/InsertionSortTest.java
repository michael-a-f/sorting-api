package io.projects.sortingapi.unit;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.InsertionSorter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.projects.sortingapi.TestUtils.assertFramesMatch;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InsertionSortTest {

    @Test
    void alreadySorted() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);

        List<SortFrame> expected = new ArrayList<>();
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 2));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 3));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 4));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), null));

        assertFramesMatch(expected, actual);
    }

    @Test
    void reverseSorted() {
        List<Integer> list = Stream.of(5, 4, 3, 2, 1).collect(Collectors.toList());
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);

        List<SortFrame> expected = new ArrayList<>();
        expected.add(new SortFrame(new ArrayList<>(List.of(5, 4, 3, 2, 1)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(5, 4, 3, 2, 1)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 2, 1)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 5, 3, 2, 1)), 2));
        expected.add(new SortFrame(new ArrayList<>(List.of(4, 3, 5, 2, 1)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(3, 4, 5, 2, 1)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(3, 4, 5, 2, 1)), 3));
        expected.add(new SortFrame(new ArrayList<>(List.of(3, 4, 2, 5, 1)), 2));
        expected.add(new SortFrame(new ArrayList<>(List.of(3, 2, 4, 5, 1)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(2, 3, 4, 5, 1)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(2, 3, 4, 5, 1)), 4));
        expected.add(new SortFrame(new ArrayList<>(List.of(2, 3, 4, 1, 5)), 3));
        expected.add(new SortFrame(new ArrayList<>(List.of(2, 3, 1, 4, 5)), 2));
        expected.add(new SortFrame(new ArrayList<>(List.of(2, 1, 3, 4, 5)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), null));

        assertFramesMatch(expected, actual);
    }

    @Test
    void allSameValue() {
        List<Integer> list = Stream.of(1, 1, 1, 1, 1, 1, 1).collect(Collectors.toList());
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);

        List<SortFrame> expected = new ArrayList<>();
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 0));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 1));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 2));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 3));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 4));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 5));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), 6));
        expected.add(new SortFrame(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1)), null));

        assertFramesMatch(expected, actual);
    }

    @Test
    void emptyList() {
        List<Integer> list = new ArrayList<>();
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);

        List<SortFrame> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }


    @Disabled
    @Test
    void nullValueInList() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(null);
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);
    }

    @Disabled
    @Test
    void nullList() {
        List<Integer> list = null;
        List<SortFrame> actual = new InsertionSorter().generateSortFrames(list);
    }
}
