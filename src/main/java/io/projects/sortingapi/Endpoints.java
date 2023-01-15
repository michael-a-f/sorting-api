package io.projects.sortingapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Endpoints {
    @PostMapping("/sort")
    @CrossOrigin()
    public @ResponseBody List<Frame> sort(@RequestParam String algorithm,
                                          @RequestBody List<Integer> list) throws Exception {
        return new SorterFactory().getSorter(algorithm).setList(list).generateSortFrames();
    }
}
