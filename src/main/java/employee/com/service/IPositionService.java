package employee.com.service;

import java.util.List;

import employee.com.DTO.PositionDTO;

public interface IPositionService {
	List<PositionDTO> findAll();

	 void savePosition(PositionDTO dto); 

	void deletePosition(Long id);

	void updatePosition(PositionDTO dto, Long id);

	void deleteListUser(Long[] ids);
}
