package employee.com.converter;

import org.springframework.stereotype.Component;

import employee.com.DTO.UserDTO;
import employee.com.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO userConverter(UserEntity userEnity) {
		UserDTO userDto = new UserDTO();
		userDto.setId(userEnity.getId());
		userDto.setAge(userEnity.getAge());
		userDto.setDayStart(userEnity.getDayStart());
		userDto.setEmail(userEnity.getEmail());
		userDto.setName(userEnity.getName());
		userDto.setNickName(userEnity.getNickName());
		userDto.setProfile(userEnity.getProfile());
		userDto.setStatus(userEnity.getStatus());
		return userDto;
	}
}
