package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import employee.com.DTO.UserDTO;
import employee.com.converter.UserConverter;
import employee.com.entity.PositionEntity;
import employee.com.entity.UserEntity;
import employee.com.repository.PositionRepository;
import employee.com.repository.UserRepository;
import employee.com.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private PositionRepository positionRepository;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userRepository.findAll();
		for (UserEntity userEntity : entity) {
			UserDTO dto = new UserDTO();
			dto = userConverter.toDto(userEntity);
			dto.setRoleName(userEntity.getPosition().getName());
			result.add(dto);
		}
		return result;
	}

	@Override
	public void saveUser(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.toEntity(dto);
		PositionEntity position = positionRepository.findOne(dto.getIdRole());
		userEntity.setPassword(getMD5(dto.getPassword()));
		userEntity.setPosition(position);
		userRepository.save(userEntity);
	}

	@Override
	public void deleteUser(Long id) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userRepository.delete(id);

	}

	@Override
	public UserDTO updateUser(UserDTO dto, Long id) {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findOne(id);
		userEntity = userConverter.toEntity(dto);
		userEntity.setId(id);
		PositionEntity positionEntity = positionRepository.findOne(dto.getIdRole());
		userEntity.setPosition(positionEntity);
		UserDTO userDTO = new UserDTO();
		userRepository.save(userEntity);
		userDTO.setMessage("true");
		return userDTO;
	}

	@Override
	public void deleteListUser(Long[] ids) {
		for (Long id : ids) {
			userRepository.delete(id);
		}
	}

	@Override
	public List<UserDTO> findUserByTeamId(Long teamid) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userRepository.findUserByIdTeam(teamid);
		for (UserEntity userEntity : entity) {
			UserDTO dto = userConverter.toDto(userEntity);

			if (userEntity.getTeam() != null) {
				dto.setTeam(userEntity.getTeam().getName());
				if (userEntity.getTeam().getId() == teamid) {
					dto.setChecked("checked");
				}
			}

			if (userEntity.getPosition().equals("MANAGER")) {
				dto.setPosiTion(userEntity.getPosition().getName());
			}
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<UserDTO> findUserByPositionName(String name) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userRepository.findUserByPositionName(name);
		for (UserEntity userEntity : entity) {
			result.add(userConverter.toDto(userEntity));
		}
		return result;
	}

	// Check role user
	@Override
	public UserDTO checkRole(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		UserDTO userDTO = new UserDTO();
		if (userEntity != null) {
			userDTO.setRoleName(userEntity.getPosition().getName());
			userDTO.setMessage("true");
		} else {
			userDTO.setMessage("false");
		}
		return userDTO;
	}

	// MD5
	@Override
	public String getMD5(String password) {
		String hashPass = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return hashPass;
	}

}
