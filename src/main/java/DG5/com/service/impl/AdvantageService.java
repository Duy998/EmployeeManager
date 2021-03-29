 package DG5.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DG5.com.DTO.AdvantageDTO;
import DG5.com.entity.AdvantageEntity;
import DG5.com.repository.AdvantageRepository;
import DG5.com.service.IAdvantageService;

@Service
public class AdvantageService implements IAdvantageService {
	@Autowired
	private AdvantageRepository advantagerepository;

	@Override
	public List<AdvantageDTO> findAll() {
		List<AdvantageDTO> result = new ArrayList<>();
		List<AdvantageEntity> entitys = advantagerepository.findAll();
		for (AdvantageEntity advantageEntity : entitys) {
			AdvantageDTO dto = new AdvantageDTO();
			dto.setName(advantageEntity.getName());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void saveAdvantage(AdvantageDTO dto) {
		AdvantageEntity advantageEntity = new AdvantageEntity();
		advantageEntity.setName(dto.getName());
		advantagerepository.save(advantageEntity);
	}
	
	@Override
	public void deleteAdvantage(AdvantageDTO dto) {
		AdvantageEntity advantageEntity = new AdvantageEntity();
		advantageEntity.setName(dto.getName());
		advantagerepository.delete(advantageEntity);
	}

	@Override
	public void updateAdvantage(AdvantageDTO dto, Long id) {
		AdvantageEntity advantageEntity = new AdvantageEntity();
		dto.setId(id);
		advantageEntity.setId(dto.getId());
		advantageEntity.setName(dto.getName());
		advantagerepository.save(advantageEntity);
	}
	
	
}
