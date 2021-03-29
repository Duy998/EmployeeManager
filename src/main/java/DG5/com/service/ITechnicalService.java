package DG5.com.service;

import java.util.List;

import DG5.com.DTO.TechnicalDTO;

public interface ITechnicalService {

	List<TechnicalDTO> findAll();

	void saveTechnical(TechnicalDTO technicaldto);
	
	void deleteTechnical(TechnicalDTO technicaldto);
	
	void updateTechnical(TechnicalDTO technicaldto, Long id);
}
