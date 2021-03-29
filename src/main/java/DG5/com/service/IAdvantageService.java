package DG5.com.service;

import java.util.List;

import DG5.com.DTO.AdvantageDTO;

public interface IAdvantageService {

	List<AdvantageDTO> findAll();

	void saveAdvantage(AdvantageDTO advantagedto);

	void deleteAdvantage(AdvantageDTO advantagedto);

	void updateAdvantage(AdvantageDTO advantagedto, Long id);
}
