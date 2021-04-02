package employee.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.com.DTO.TeamDTO;
import employee.com.service.ITeamService;

@RestController
@RequestMapping(value = "/api/team")
public class TeamAPI {
	
	@Autowired
	private ITeamService iteamservice;
	
	@GetMapping
	public List<TeamDTO> getlistteam() {
		return iteamservice.findAll();
	}
	
	@PostMapping
	public TeamDTO insertteam(@RequestBody TeamDTO dto) {
		return iteamservice.InsertTeam(dto);
	}
	
	@PutMapping
	public void updateteam(@RequestBody TeamDTO dto) {
		iteamservice.UpdateTeam(dto);
	}
	
	@DeleteMapping
	public void deleteteam(@RequestBody Long[] dto) {
		System.out.println(dto);
		/* iteamservice.deleteTeam(dto.getIds()); */
	}
	
	@GetMapping("/{teamid}")
	public TeamDTO selectTeamByIteam(@PathVariable("teamid") Long teamid) {
		return iteamservice.findOneByid(teamid);
	}
	
	/* ===========loadUserAnd Insert or Update=========== */
	
	
	
	
	/* ===========/loadUserAnd Insert or Update===========*/
	
	@GetMapping("/loadteam/{teamid}")
	public List<TeamDTO> loadteambeforupdate(@PathVariable("teamid") Long teamid) {
		return iteamservice.LoadTeambeforupdate(teamid);
	}
	
}
