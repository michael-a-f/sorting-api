package io.projects.sortingapi;

import io.projects.sortingapi.sorting.SortFrame;
import io.projects.sortingapi.sorting.SorterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private final SorterFactory sorterFactory;

	public Application(SorterFactory sorterFactory) {
		this.sorterFactory = sorterFactory;
	}

	@PostMapping("/sort")
	@CrossOrigin()
	public @ResponseBody List<SortFrame> sort(@RequestParam String algorithm,
											  @RequestBody List<Integer> list) throws Exception {
		return sorterFactory.getSorter(algorithm).generateSortFrames(list);
	}


//	@PostMapping("/search")
//	@CrossOrigin()
//	public @ResponseBody List<SearchFrame> search(@RequestParam String algorithm,
//												@RequestBody List<Integer> grid) throws Exception {
//		return new SearcherFactory().getSearcher(algorithm)
//				.setGrid(grid)
//				.generateSearchFrames();
//	}
}
