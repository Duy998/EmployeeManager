package employee.com.service;

import java.util.List;

import employee.com.DTO.UserDTO;

public interface IUserService {

	// Find All
	List<UserDTO> findAll();

	List<UserDTO> findUserByTeamId(Long teamid);

	List<UserDTO> findUserByPositionName(String name);

	// Find check role
	UserDTO checkRole(String email);

	// Convert password to MD5
	String getMD5(String password);

	String getPass(String getMd5);
}
