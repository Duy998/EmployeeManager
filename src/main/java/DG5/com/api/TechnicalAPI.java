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

import DG5.com.DTO.TechnicalDTO;
import DG5.com.service.ITechnicalService;

@RestController
@RequestMapping(value = "/api/technical")
public class TechnicalAPI {

	@Autowired
	private ITechnicalService itechnicalservice;

	@GetMapping
	public List<TechnicalDTO> getListTechnical() {
		return itechnicalservice.findAll();
	}

	@PostMapping
	public void insertTechnical(TechnicalDTO techical) {
		 itechnicalservice.saveTechnical(techical);
	}

	@DeleteMapping
	public void deleteTechnical(TechnicalDTO techical) {
		itechnicalservice.deleteTechnical(techical);
	}
	
	@PutMapping("/{id}")
	public void updateTechnical(TechnicalDTO techical,@PathVariable Long id) {
		itechnicalservice.updateTechnical(techical, id);
	}
}
