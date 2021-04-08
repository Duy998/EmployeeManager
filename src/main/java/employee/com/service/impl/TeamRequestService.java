package employee.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.com.DTO.UserDTO;
import employee.com.DTO.Request.TeamRrequest;
import employee.com.converter.UserConverter;
import employee.com.entity.TeamEntity;
import employee.com.entity.UserEntity;
import employee.com.repository.TeamRepository;
import employee.com.repository.UserRepository;
import employee.com.service.ITeamRequestService;

@Service
public class TeamRequestService implements ITeamRequestService {
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private UserConverter userconverter;

	@Autowired
	private TeamRepository teamrepository;

	@Override
	public TeamRrequest findAll(Long idteam) {
		TeamRrequest result = new TeamRrequest();
		List<UserEntity> userentity = userrepository.findAll();
		List<UserDTO> usertdto = new ArrayList<UserDTO>();
		List<UserDTO> namemanagers = new ArrayList<>();
		for (UserEntity userEntity : userentity) {
			UserDTO dto = userconverter.toDto(userEntity);
			if (userEntity.getTeam() != null) {
				if (userEntity.getTeam().getId() == idteam) {
					dto.setChecked("true");
				}
			}
			if (userEntity.getPosition().getName().equals("MANAGER")) {
				namemanagers.add(dto);
			}
			usertdto.add(dto);
		}
		result.setListallUser(usertdto);
		result.setListmanager(namemanagers);
		result.setIdTeam(idteam);
		TeamEntity teamrntity = teamrepository.findOne(idteam);
		result.setNameTeam(teamrntity.getName());

		return result;
	}

}