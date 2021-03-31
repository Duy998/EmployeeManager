package employee.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.UserDTO;
import employee.com.converter.UserConverter;
import employee.com.entity.UserEntity;
import employee.com.repository.LoginRepository;
import employee.com.service.ILoginService;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserDTO loginPage(String email, String password) {
		UserEntity userEntity = loginRepository.findByEmailAndPassword(email, password);
		UserDTO userDto = new UserDTO();
		if(userEntity != null && userEntity.getStatus() == 1) {
			userDto = userConverter.userConverter(userEntity);
			userDto.setMessage("true");
		}else {
			userDto.setMessage("false");
		}
		return userDto;
	}
}
