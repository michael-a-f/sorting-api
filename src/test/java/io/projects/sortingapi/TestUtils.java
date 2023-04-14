package io.projects.sortingapi;

import io.projects.sortingapi.sorting.SortFrame;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {
    public static void assertFramesMatch(List<SortFrame> expected, List<SortFrame> actual) {
        for (int i = 0; i < actual.size(); i++) {
            List<Integer> actualList = actual.get(i).list;
            Map<String, Integer> actualHighlights = actual.get(i).highlights;
            List<Integer> expectedList = expected.get(i).list;
            Map<String, Integer> expectedHighlights = expected.get(i).highlights;

            assertEquals(expectedList, actualList, "List in Frame " + i + " does not match expected");
            assertEquals(expectedHighlights, actualHighlights, "Highlights in Frame " + i + " do not match expected");
        }
    }
}
