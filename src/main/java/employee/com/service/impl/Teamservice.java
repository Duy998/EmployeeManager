package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.TeamDTO;
import employee.com.DTO.UserDTO;
import employee.com.converter.TeamConverter;
import employee.com.converter.UserConverter;
import employee.com.entity.TeamEntity;
import employee.com.entity.UserEntity;
import employee.com.repository.TeamRepository;
import employee.com.repository.UserRepository;
import employee.com.service.ITeamService;

@Service
public class Teamservice implements ITeamService {

	@Autowired
	private TeamRepository teamrepository;

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private UserConverter userconverter;

	@Autowired
	private TeamConverter teamconverter;

	@Override
	public List<TeamDTO> findAll() {
		List<TeamEntity> entitys = teamrepository.findAll();
		List<TeamDTO> result = new ArrayList<>();
		for (TeamEntity team : entitys) {
			result.add(teamconverter.todto(team));
		}
		return result;
	}

	@Override
	public TeamDTO InsertTeam(TeamDTO dto) {	
		return teamconverter.todto(teamrepository.save(teamconverter.toentity(dto)));
		
	}

	
	
	@Override
	public void UpdateTeam(TeamDTO dto) {
		TeamEntity entity = teamrepository.findOne(dto.getId());
		teamrepository.save(teamconverter.toentity(dto, entity));

	}

	@Override
	public void deleteTeam(Long[] ids) {
		
		for (Long id : ids) {
			
			teamrepository.delete(id);
		}

	}

	@Override
	public TeamDTO findOneByid(Long id) {
		TeamEntity entity = teamrepository.findOne(id);
		TeamDTO dto = teamconverter.todto(entity);
		List<UserDTO> userdto = new ArrayList<UserDTO>();
		for (UserEntity userDTO2 : entity.getUsers()) {
			userdto.add(userconverter.todto(userDTO2));
		}
		dto.setUsers(userdto);
		return dto;
	}

	@Override
	public List<TeamDTO> LoadTeambeforupdate(Long teamid) {
		List<TeamEntity> entitys = teamrepository.LoadTeambeforupdate();
		
		List<UserDTO> result = new ArrayList<>();
		for (TeamEntity entity : entitys) {
			for (UserEntity userentity : entity.getUsers()) {
				result.add(userconverter.todto(userentity));
				
			}
			TeamDTO result1 = new TeamDTO();
		}
		
		
		
		return null;
	}

}
