 package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.AdvantageDTO;
import employee.com.entity.AdvantageEntity;
import employee.com.repository.AdvantageRepository;
import employee.com.service.IAdvantageService;

@Service
public class AdvantageService implements IAdvantageService {
	@Autowired
	private AdvantageRepository advantageRepository;
	
	@Override
	public List<AdvantageDTO> findAll() {
		List<AdvantageDTO> result = new ArrayList<>();
		List<AdvantageEntity> entitys = advantageRepository.findAll();
		for (AdvantageEntity advantageEntity : entitys) {
			AdvantageDTO dto = new AdvantageDTO();
			dto.setId(advantageEntity.getId());
			dto.setName(advantageEntity.getName());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void saveAdvantage(AdvantageDTO dto) {
		AdvantageEntity advantageEntity = new AdvantageEntity();
		advantageEntity.setName(dto.getName());
		advantageRepository.save(advantageEntity);
	}
	
//	@Override
//	public void deleteAdvantage(Long id) {
//		AdvantageEntity advantageEntity = new AdvantageEntity();
//		advantageEntity.setId(id);
//		advantageRepository.delete(advantageEntity);
//	}

	@Override
	public void deleteListAdvantage(Long[] ids) {
		for(Long id : ids) {
			advantageRepository.delete(id);
		}
	}
	
	@Override
	public void updateAdvantage(AdvantageDTO dto, Long id) {
		AdvantageEntity advantageEntity = advantageRepository.getOne(id);
		advantageEntity.setName(dto.getName());
		advantageRepository.save(advantageEntity);
	}
	
	
}
