 package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.TechnicalDTO;
import employee.com.entity.TechnicalEntity;
import employee.com.repository.TechnicalRepository;
import employee.com.repository.UserRepository;
import employee.com.service.ITechnicalService;

@Service
public class TechnicalService implements ITechnicalService {
	@Autowired
	private TechnicalRepository technicalRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public TechnicalDTO getTechnical(Long id) {
		return null;
	}
	
	@Override
	public List<TechnicalDTO> findAll() {
		List<TechnicalDTO> result = new ArrayList<>();
		List<TechnicalEntity> entitys = technicalRepository.findAll();
		for (TechnicalEntity technicalEntity : entitys) {
			TechnicalDTO dto = new TechnicalDTO();
			dto.setId(technicalEntity.getId());
			dto.setSkill(technicalEntity.getSkill());
			dto.setLevel(technicalEntity.getLevel());
			dto.setUserId(technicalEntity.getUser().getId());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void saveTechnical(TechnicalDTO dto) {
		TechnicalEntity technicalEntity = new TechnicalEntity();
		technicalEntity.setSkill(dto.getSkill());
		technicalEntity.setLevel(dto.getLevel());
		technicalEntity.setUser(userRepository.getOne(dto.getUserId()));
		technicalRepository.save(technicalEntity);
	}
	
	@Override
	public void deleteTechnical(Long id) {
		TechnicalEntity technicalEntity = new TechnicalEntity();
		technicalEntity.setId(id);
		technicalRepository.delete(technicalEntity);
	}

	@Override
	public void updateTechnical(TechnicalDTO dto, Long id) {
		TechnicalEntity technicalEntity = technicalRepository.getOne(id);
		technicalEntity.setSkill(dto.getSkill());
		technicalEntity.setLevel(dto.getLevel());
		technicalEntity.setUser(userRepository.getOne(dto.getUserId()));
		technicalRepository.save(technicalEntity);
	}
	
}
