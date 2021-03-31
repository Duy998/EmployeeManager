package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.UserDTO;
import employee.com.entity.UserEntity;
import employee.com.repository.UserRepository;
import employee.com.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userrepository;
	
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

}
