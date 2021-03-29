package DG5.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DG5.com.DTO.AdvantageDTO;
import DG5.com.service.IAdvantageService;

@RestController
@RequestMapping(value = "/api/advantage")
public class AdvantageAPI {

	@Autowired
	private IAdvantageService iadvantageservice;

	@GetMapping
	public List<AdvantageDTO> getListTechnical() {
		return iadvantageservice.findAll();
	}

	@PostMapping
	public void insertAdvantage(AdvantageDTO advantage) {
		iadvantageservice.saveAdvantage(advantage);
	}

	@DeleteMapping
	public void deleteAdvantage(AdvantageDTO advantage) {
		iadvantageservice.deleteAdvantage(advantage);
	}
	
	@PutMapping("/{id}")
	public void updateAdvantage(AdvantageDTO advantage,@PathVariable Long id) {
		iadvantageservice.updateAdvantage(advantage, id);
	}
}
