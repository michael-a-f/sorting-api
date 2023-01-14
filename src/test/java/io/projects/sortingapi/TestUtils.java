package io.projects.sortingapi;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {
    public static void assertFramesMatch(List<Frame> expected, List<Frame> actual) {
        for (int i = 0; i < actual.size(); i++) {
            List<Integer> actualList = actual.get(i).list;
            Integer actualCurrent = actual.get(i).current;
            List<Integer> expectedList = expected.get(i).list;
            Integer expectedCurrent = expected.get(i).current;

            assertEquals(expectedList, actualList, "List in Frame " + i + " does not match expected");
            assertEquals(expectedCurrent, actualCurrent, "Current index in Frame " + i + " does not match expected");
        }
    }
}
