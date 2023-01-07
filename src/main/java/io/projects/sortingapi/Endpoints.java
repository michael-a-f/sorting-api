package io.projects.sortingapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {
    @GetMapping("/")
    public @ResponseBody String hello() {
        return "Hello World";
    }
}
