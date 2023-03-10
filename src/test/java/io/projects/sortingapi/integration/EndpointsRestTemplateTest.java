package io.projects.sortingapi.integration;

import io.projects.sortingapi.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndpointsRestTemplateTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testInsertionSortResponse() throws Exception {
        String url = "http://localhost:" + port + "/sort?algorithm=insertion";
        List<Integer> requestBody = Stream.of(1, 2, 5, 4, 3).collect(Collectors.toList());

        List<Frame> expectedResponseBody = new ArrayList<>();
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 5, 4, 3)), 0));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 5, 4, 3)), 1));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 5, 4, 3)), 3));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 4, 5, 3)), 2));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 4, 5, 3)), 4));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 4, 3, 5)), 3));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 2));
        expectedResponseBody.add(new Frame(new ArrayList<>(List.of(1, 2, 3, 4, 5)), null));

        ResponseEntity<List> actualResponse = this.restTemplate.postForEntity(url,
                new HttpEntity<>(requestBody), List.class);
        Assertions.assertEquals(expectedResponseBody, actualResponse.getBody());
    }
}
