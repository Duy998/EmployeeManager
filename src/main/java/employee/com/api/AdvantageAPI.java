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

import employee.com.DTO.AdvantageDTO;
import employee.com.service.IAdvantageService;

@RestController
@RequestMapping(value = "/{id}/api/advantage")
public class AdvantageAPI {

	@Autowired
	private IAdvantageService iadvantageservice;

	@GetMapping
	public List<AdvantageDTO> getListAdvantage(@PathVariable Long id) {
		return iadvantageservice.findAll(id);
	}

	@PostMapping
	public void insertAdvantage(@RequestBody AdvantageDTO advantage) {
		iadvantageservice.saveAdvantage(advantage);
	}

//	@DeleteMapping("/{id}")
//	public void deleteAdvantage(@PathVariable Long id) {
//		iadvantageservice.deleteAdvantage(id);
//	}
	
	@DeleteMapping ("/{ids}")
	public void deleteListAdvantage(@PathVariable("ids") Long[] ids) {
		iadvantageservice.deleteListAdvantage(ids);
	}
	
	
	@PutMapping("/{id}")
	public void updateAdvantage(@RequestBody AdvantageDTO advantage, @PathVariable("id") Long id) {
		iadvantageservice.updateAdvantage(advantage, id);
	}
}
