package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import employee.com.DTO.UserDTO;
import employee.com.converter.UserConverter;
import employee.com.entity.UserEntity;
import employee.com.repository.UserRepository;
import employee.com.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private UserConverter userconverter;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userrepository.findAll();
		for (UserEntity userEntity : entity) {
			UserDTO dto = new UserDTO();
			dto.setId(userEntity.getId());
			dto.setName(userEntity.getName());
			dto.setNickName(userEntity.getNickName());
			dto.setAge(userEntity.getAge());
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<UserDTO> findUserByTeamId(Long teamid) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userrepository.findUserByIdTeam(teamid);
		for (UserEntity userEntity : entity) {
			UserDTO dto = userconverter.toDto(userEntity);

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
		List<UserEntity> entity = userrepository.findUserByPositionName(name);
		for (UserEntity userEntity : entity) {
			result.add(userconverter.toDto(userEntity));
		}
		return result;
	}

	@Override
	public UserDTO checkRole(String email) {
		UserEntity userEntity = userrepository.findByEmail(email);
		UserDTO userDTO = new UserDTO();
		if (userEntity != null) {
			userDTO.setRoleName(userEntity.getPosition().getName());
			userDTO.setMessage("true");
		} else {
			userDTO.setMessage("false");
		}
		return userDTO;
	}

	@Override
	public String getMD5(String password) {
		String hashPass = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return hashPass;
	}

	@Override
	public String getPass(String getMd5) {
		byte[] getByte = DigestUtils.md5Digest(getMd5.getBytes());
		return getByte.toString();
	}

}
