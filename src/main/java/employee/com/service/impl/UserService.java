package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.UserDTO;
import employee.com.converter.UserConverter;
import employee.com.entity.UserEntity;
import employee.com.repository.UserRepository;
import employee.com.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private UserConverter userconverter;
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userrepository.findAll();
		for (UserEntity userEntity : entity) {
			
				result.add(userconverter.todto(userEntity));
			
			
		}
		return result;
	}
	
	@Override
	public List<UserDTO> findUserByTeamId(Long teamid) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entity = userrepository.findUserByIdTeam(teamid);
		for (UserEntity userEntity : entity) {
			UserDTO dto = userconverter.todto(userEntity);
			
			if(userEntity.getTeam() != null) {
				dto.setTeam(userEntity.getTeam().getName());
				if(userEntity.getTeam().getId() == teamid){
					dto.setChecked("checked");
				}
			}
			
			if(userEntity.getPosition().equals("manager")) {
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
			result.add(userconverter.todto(userEntity));
		}
		return result;
	}

}
