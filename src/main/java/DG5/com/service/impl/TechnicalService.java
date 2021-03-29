 package DG5.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DG5.com.DTO.TechnicalDTO;
import DG5.com.entity.TechnicalEntity;
import DG5.com.repository.TechnicalRepository;
import DG5.com.service.ITechnicalService;

@Service
public class TechnicalService implements ITechnicalService {
	@Autowired
	private TechnicalRepository technicalrepository;

	@Override
	public List<TechnicalDTO> findAll() {
		List<TechnicalDTO> result = new ArrayList<>();
		List<TechnicalEntity> entitys = technicalrepository.findAll();
		for (TechnicalEntity technicalEntity : entitys) {
			TechnicalDTO dto = new TechnicalDTO();
			dto.setSkill(technicalEntity.getSkill());
			dto.setLevel(technicalEntity.getLevel());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void saveTechnical(TechnicalDTO dto) {
		TechnicalEntity technicalEntity = new TechnicalEntity();
		technicalEntity.setSkill(dto.getSkill());
		technicalEntity.setLevel(dto.getLevel());
		technicalrepository.save(technicalEntity);
	}
	
	@Override
	public void deleteTechnical(TechnicalDTO dto) {
		TechnicalEntity technicalEntity = new TechnicalEntity();
		technicalEntity.setSkill(dto.getSkill());
		technicalEntity.setLevel(dto.getLevel());
		technicalrepository.delete(technicalEntity);
	}

	@Override
	public void updateTechnical(TechnicalDTO dto, Long id) {
		TechnicalEntity technicalEntity = new TechnicalEntity();
		dto.setId(id);
		technicalEntity.setId(dto.getId());
		technicalEntity.setSkill(dto.getSkill());
		technicalEntity.setLevel(dto.getLevel());
		technicalrepository.save(technicalEntity);
	}
	
	
}
