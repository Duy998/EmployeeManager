package employee.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.com.DTO.TechnicalDTO;
import employee.com.service.ITechnicalService;

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
	public void insertTechnical(@RequestBody TechnicalDTO technical) {
		itechnicalservice.saveTechnical(technical);
	}

	@DeleteMapping
	public void deleteTechnical(@RequestBody Long id) {
		itechnicalservice.deleteTechnical(id);
	}
	
	@PutMapping("/{id}")
	public void updateTechnical(@RequestBody TechnicalDTO technical,@PathVariable Long id) {
		itechnicalservice.updateTechnical(technical, id);
	}
}
