package employee.com.converter;

import org.springframework.stereotype.Component;

import employee.com.DTO.UserDTO;
import employee.com.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO todto(UserEntity entity) {
		UserDTO result = new UserDTO();

		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setNickName(entity.getNickName());
		result.setDayStart(entity.getDayStart());
		result.seteMail(entity.getEmail());
		result.setAge(entity.getAge());
		result.setProFile(entity.getProfile());
		result.setStatus(entity.getStatus());
		result.setExPe(entity.getExPe());
		return result;
	}
	
	public UserEntity toentity(UserDTO entity) {
		UserEntity result = new UserEntity();

		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setNickName(entity.getNickName());
		result.setDayStart(entity.getDayStart());
		result.setEmail(entity.geteMail());
		result.setAge(entity.getAge());
		result.setProfile(entity.getProFile());
		result.setStatus(entity.getStatus());

		return result;
	}
}
