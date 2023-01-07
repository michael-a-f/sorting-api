package io.projects.sortingapi;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndpointsRestTemplateTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void insertionSortReturnsSortedList() throws Exception {
        List<Integer> list = Stream.of(1, 2, 5, 4, 3).collect(Collectors.toList());
        String url = "http://localhost:" + port + "/sort?algorithm=insertion";
        HttpEntity<List<Integer>> request = new HttpEntity<>(list);
        ResponseEntity<List> result = this.restTemplate.postForEntity(url, request, List.class);
        Assertions.assertEquals(list.stream().sorted().toList(), result.getBody());
    }
}
