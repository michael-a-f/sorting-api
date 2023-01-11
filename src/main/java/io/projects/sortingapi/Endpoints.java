package io.projects.sortingapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Endpoints {
    @PostMapping("/sort")
    @CrossOrigin()
    public @ResponseBody List<Frame> sort(@RequestParam String algorithm,
                                          @RequestBody List<Integer> list) throws Exception {
        List<Frame> frames = new ArrayList<>();
        Sorter sorter = new SorterFactory().getSorter(algorithm);
        sorter.generateSortFrames(list, frames);
        return frames;
    }
}
