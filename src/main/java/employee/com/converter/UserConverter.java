package employee.com.converter;

import org.springframework.stereotype.Component;

import employee.com.DTO.UserDTO;
import employee.com.entity.UserEntity;

@Component
public class UserConverter {

	// Converter Entity to DTO
	public UserDTO toDto(UserEntity userEnity) {
		UserDTO userDto = new UserDTO();
		userDto.setId(userEnity.getId());
		userDto.setAge(userEnity.getAge());
		userDto.setDayStart(userEnity.getDayStart());
		userDto.setEmail(userEnity.getEmail());
		userDto.setName(userEnity.getName());
		userDto.setNickName(userEnity.getNickName());
		userDto.setProfile(userEnity.getProfile());
		userDto.setStatus(userEnity.getStatus());
		userDto.setSex(userEnity.getSex());
		/*
		 * userDto.setIdRole(userEnity.getPosition().getId());
		 * userDto.setRoleName(userEnity.getPosition().getName()); 
		 * 
		 * cái này ở đâu vậy của who vậy YOU (Thành) You edit hả cái của I không có cái này
		 * I edited YOU có j Ib Cho I
		 */
		return userDto;
	}

	// Converter DTO to Entity
	public UserEntity toEntity(UserDTO dto) {
		UserEntity userentity = new UserEntity();
		userentity.setAge(dto.getAge());
		userentity.setDayStart(dto.getDayStart());
		userentity.setEmail(dto.getEmail());
		userentity.setPassword(dto.getPassword());
		userentity.setName(dto.getName());
		userentity.setNickName(dto.getNickName());
		userentity.setProfile(dto.getProfile());
		userentity.setSex(dto.getSex());
		userentity.setStatus(dto.getStatus());
		return userentity;
	}
}
