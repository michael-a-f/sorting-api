package io.projects.sortingapi.integration;

import io.projects.sortingapi.TestUtils;
import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.sorters.BubbleSorter;
import io.projects.sortingapi.sorting.sorters.BubbleSorter.BubbleSortFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.projects.sortingapi.TestUtils.assertFramesMatch;


@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndpointsRestTemplateTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBubbleSortResponse() throws Exception {
        String url = "http://localhost:" + port + "/sort?algorithm=bubble";
        List<Integer> list = new ArrayList<>(List.of(1, 2, 5, 4, 3));

        List<SortFrame> expected = new ArrayList<>();
        expected.add(new BubbleSortFrame(List.of(1, 2, 5, 4, 3), 0));
        expected.add(new BubbleSortFrame(List.of(1, 2, 5, 4, 3), 1));
        expected.add(new BubbleSortFrame(List.of(1, 2, 5, 4, 3), 2));
        expected.add(new BubbleSortFrame(List.of(1, 2, 4, 5, 3), 3));
        expected.add(new BubbleSortFrame(List.of(1, 2, 4, 3, 5), 4));
        expected.add(new BubbleSortFrame(List.of(1, 2, 4, 3, 5), 0));
        expected.add(new BubbleSortFrame(List.of(1, 2, 4, 3, 5), 1));
        expected.add(new BubbleSortFrame(List.of(1, 2, 4, 3, 5), 2));
        expected.add(new BubbleSortFrame(List.of(1, 2, 3, 4, 5), 3));
        expected.add(new BubbleSortFrame(List.of(1, 2, 3, 4, 5), 0));
        expected.add(new BubbleSortFrame(List.of(1, 2, 3, 4, 5), 1));
        expected.add(new BubbleSortFrame(List.of(1, 2, 3, 4, 5), 2));

        HttpEntity<List<Integer>> request = new HttpEntity<>(list);
        ParameterizedTypeReference<List<SortFrame>> ptr = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<SortFrame>> actual = this.restTemplate.exchange(url, HttpMethod.POST, request, ptr);

        assertFramesMatch(expected, Objects.requireNonNull(actual.getBody()));
    }
}
