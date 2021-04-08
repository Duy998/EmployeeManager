package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.RoleDTO;
import employee.com.entity.RoleEntity;
import employee.com.repository.RoleRepository;
import employee.com.service.IPositionService;

@Service
public class RoleService implements IPositionService {

	@Autowired
	private RoleRepository positionRepository;

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> result = new ArrayList<>();
		List<RoleEntity> entity = positionRepository.findAll();
		for (RoleEntity positionEntity : entity) {
			RoleDTO dto = new RoleDTO();
			dto.setId(positionEntity.getId());
			dto.setName(positionEntity.getName());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void savePosition(RoleDTO dto) {

		RoleEntity entity = new RoleEntity();
		entity.setName(dto.getName());
		positionRepository.save(entity);

	}

	@Override
	public void deletePosition(Long id) {
		RoleEntity positionEntity = new RoleEntity();
		positionEntity.setId(id);
		positionRepository.delete(id);
	}

	@Override
	public void updatePosition(RoleDTO dto, Long id) {
		RoleEntity entity = new RoleEntity();
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
