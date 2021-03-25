package DG5.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DG5.com.DTO.TeamDTO;
import DG5.com.entity.TeamEntity;
import DG5.com.repository.TeamRepository;
import DG5.com.service.ITeamService;

@Service
public class Teamservice implements ITeamService{

	@Autowired
	private TeamRepository teamrepository;
	
	@Override
	public List<TeamDTO> findAll() {
		List<TeamEntity> entitys = teamrepository.findAll();
		List<TeamDTO> result = new ArrayList<>();
		for (TeamEntity team : entitys) {
			TeamDTO dto = new TeamDTO();
			dto.setName(team.getName());
			dto.setNamemanager(team.getNameManager());
			dto.setNumber(team.getNumber());
			result.add(dto);
		}
		return result;
	}

}
