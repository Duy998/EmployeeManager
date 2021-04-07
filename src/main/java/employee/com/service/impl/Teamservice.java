package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import employee.com.DTO.TeamDTO;
import employee.com.DTO.UserDTO;
import employee.com.DTO.Request.TeamRrequest;
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
	public TeamDTO findAll(int page,int limit) {
		Pageable pageable = new PageRequest(page-1, limit);
		
		List<TeamEntity> entitys = teamrepository.findAll(pageable).getContent();
		
		TeamDTO result = new TeamDTO();
		List<TeamDTO> listteam = new ArrayList<>();
		for (TeamEntity team : entitys) {
			TeamDTO teamDTO = teamconverter.todto(team);
			teamDTO.setNumber(team.getUsers().size());
			listteam.add(teamDTO);
		}
		result.setListresult(listteam);
		result.setPage(page);
		return result;
	}
	@Override
	public TeamDTO InsertTeam(TeamDTO dto) {	
		return teamconverter.todto(teamrepository.save(teamconverter.toentity(dto)));
		
	}
//	@Override
//	public void UpdateTeam(TeamDTO dto) {
//		TeamEntity entity = teamrepository.findOne(dto.getId());
//		teamrepository.save(teamconverter.toentity(dto, entity));
//
//	}

	@Override
	@Transactional
	public void deleteTeam(Long[] ids) {	
		for (Long id : ids) {
			//update by teamid ve null
			List<UserEntity> users = userrepository.findByTeam_id(id);
			for (UserEntity user  : users) {
				user.setTeam(null);
				userrepository.save(user);
			}
			teamrepository.delete(id);
		}
	}

	@Override
	public TeamDTO findOneByid(Long id) {
		TeamEntity entity = teamrepository.findOne(id);
		TeamDTO dto = teamconverter.todto(entity);
		List<UserDTO> userdto = new ArrayList<UserDTO>();
		for (UserEntity userDTO2 : entity.getUsers()) {
			userdto.add(userconverter.toDto(userDTO2));
		}
		dto.setUsers(userdto);
		return dto;
	}

//	@Override
//	public List<TeamDTO> LoadTeambeforupdate(Long teamid) {
//		List<TeamEntity> entitys = teamrepository.LoadTeambeforupdate();
//		
//		List<UserDTO> result = new ArrayList<>();
//		for (TeamEntity entity : entitys) {
//			for (UserEntity userentity : entity.getUsers()) {
//				result.add(userconverter.todto(userentity));		
//			}
//			TeamDTO result1 = new TeamDTO();
//		}
//		return null;
//	}

//	@Override
//	public TeamDTO updateTeam(TeamDTO dto) {
//		TeamEntity result = new TeamEntity();
//		result.setId(dto.getId());
//		result.setName(dto.getName());
//		result.setNameManager(dto.getNameManager());
//		result.setNumber(dto.getCountNumber().length);
//		
//		List<UserEntity> userentity = new ArrayList<UserEntity>();
//		for (Long iterable_element : dto.getCountNumber()) {
//			userentity.add(userrepository.findOne(iterable_element));
//		}	
//		result.setUsers(userentity);
//		return teamconverter.todto(teamrepository.save(result));
//	}
	
	
	@Override
	public TeamDTO Inforteam(Long id) {
		TeamEntity result = teamrepository.findOne(id);
		TeamDTO dto = new TeamDTO();
		dto.setName(result.getName());
		dto.setNameManager(result.getNameManager());
		List<UserDTO> listteam = new ArrayList<>();
		for (UserEntity userentity : result.getUsers()) {
			UserDTO userDTO = userconverter.toDto(userentity);
			userDTO.setPosiTion(userentity.getPosition().getName());
			listteam.add(userDTO);
		}
		dto.setUsers(listteam);
		
		return dto;
	}
	
	
	@Override
	public TeamDTO UpdateTeam(TeamRrequest dto) {
		TeamEntity result = new TeamEntity();
		result.setId(dto.getIdTeam());
		result.setName(dto.getNameTeam());
		result.setNameManager(dto.getManagername());
		List<UserEntity> listUserentity = new ArrayList<UserEntity>();
		for (Long idTeam : dto.getCheckeds()) {
			UserEntity userEntity =	userrepository.findOne(idTeam);
			listUserentity.add(userEntity);
		}
		result.setUsers(listUserentity);
		result.setNumber(listUserentity.size());
		return teamconverter.todto(teamrepository.save(result));
	}
	
	@Override
	public int getTotalItem() {
		return (int) userrepository.count();
	}

}
