package employee.com.service;

import java.util.List;

import employee.com.DTO.AdvantageDTO;

public interface IAdvantageService {

	List<AdvantageDTO> findAll();

	void saveAdvantage(AdvantageDTO advantagedto);

//	void deleteAdvantage(Long id);

	void deleteListAdvantage(Long[] id);
	
	void updateAdvantage(AdvantageDTO advantagedto, Long id);
}