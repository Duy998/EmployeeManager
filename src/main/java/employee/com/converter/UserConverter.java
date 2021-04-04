package employee.com.converter;

import org.springframework.stereotype.Component;

import employee.com.DTO.UserDTO;
import employee.com.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO todto(UserEntity entity) {
		UserDTO dto = new UserDTO();

			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setNickName(entity.getNickName());
			dto.setDayStart(entity.getDayStart());
			dto.seteMail(entity.getEmail());
			dto.setAge(entity.getAge());
			dto.setProFile(entity.getProfile());
			dto.setStatus(entity.getStatus());
			dto.setPosiTion(entity.getPosition().getName()); 

		return dto;
	}
}
