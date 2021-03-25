package DG5.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DG5.com.DTO.TeamDTO;
import DG5.com.service.ITeamService;

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
	public void insertteam() {
			iteamservice.findAll();
	}
}
