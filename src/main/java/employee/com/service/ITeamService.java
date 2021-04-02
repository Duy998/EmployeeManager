package employee.com.service;

import java.util.List;

import employee.com.DTO.TeamDTO;

public interface ITeamService {

	List<TeamDTO> findAll();
	TeamDTO InsertTeam(TeamDTO dto);
	void UpdateTeam(TeamDTO dto);
	void deleteTeam(Long[] ids);
	TeamDTO findOneByid(Long id);
	List<TeamDTO> LoadTeambeforupdate(Long teamid);
}
