package employee.com.service;

import java.util.List;

import employee.com.DTO.UserDTO;

public interface IUserService {

	List<UserDTO> findAll();
	List<UserDTO> findUserByTeamId(Long teamid);
	List<UserDTO> findUserByPositionName(String name);
}
