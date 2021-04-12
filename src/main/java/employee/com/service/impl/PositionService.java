package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.PositionDTO;
import employee.com.entity.PositionEntity;
import employee.com.repository.PositionRepository;
import employee.com.service.IPositionService;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private PositionRepository positionRepository;

	@Override
	public List<PositionDTO> findAll() {
		List<PositionDTO> result = new ArrayList<>();
		List<PositionEntity> entity = positionRepository.findAll();
		for (PositionEntity positionEntity : entity) {
			PositionDTO dto = new PositionDTO();
			dto.setId(positionEntity.getId());
			dto.setName(positionEntity.getName());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void savePosition(PositionDTO dto) {

		PositionEntity entity = new PositionEntity();
		entity.setName(dto.getName());
		positionRepository.save(entity);

	}

	@Override
	public void deletePosition(Long id) {
		PositionEntity positionEntity = new PositionEntity();
		positionEntity.setId(id);
		positionRepository.delete(id);
	}

	@Override
	public void updatePosition(PositionDTO dto, Long id) {
		PositionEntity entity = new PositionEntity();
		entity.setName(dto.getName());
		entity.setId(id);
		positionRepository.save(entity);
	}

	@Override
	public void deleteListUser(Long[] ids) {
		for (Long id : ids) {
			positionRepository.delete(id);
		}
	}

}
