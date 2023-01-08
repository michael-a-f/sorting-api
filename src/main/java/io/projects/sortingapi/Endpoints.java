package io.projects.sortingapi;

import io.projects.sortingapi.sorting.Sorter;
import io.projects.sortingapi.sorting.SorterFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Endpoints {
    @PostMapping("/sort")
    public @ResponseBody List<List<Integer>> sort(@RequestParam String algorithm,
                                            @RequestBody List<Integer> list) throws Exception {
        List<List<Integer>> frames = new ArrayList<>();
        Sorter sorter = new SorterFactory().getSorter(algorithm);
        sorter.generateSortFrames(list, frames);
        return frames;
    }
}
