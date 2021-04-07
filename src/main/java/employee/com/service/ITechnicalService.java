package employee.com.service;

import java.util.List;

import employee.com.DTO.TechnicalDTO;

public interface ITechnicalService {
	
	TechnicalDTO getTechnical(Long id);
	
	List<TechnicalDTO> findAll();

	void saveTechnical(TechnicalDTO technicaldto);
	
	void deleteTechnical(Long id);
	
	void updateTechnical(TechnicalDTO technicaldto, Long id);
}
