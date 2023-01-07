package io.projects.sortingapi;

import io.projects.sortingapi.sorting.Sorter;
import io.projects.sortingapi.sorting.SorterFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Endpoints {
    @PostMapping("/sort")
    public @ResponseBody List<Integer> sort(@RequestParam String algorithm,
                                            @RequestBody List<Integer> list) throws Exception {
        Sorter sorter = new SorterFactory().getSorter(algorithm);
        sorter.sort(list);
        return list;
    }
}
