package employee.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.com.DTO.UserDTO;
import employee.com.service.IUserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserAPI {

	@Autowired
	private IUserService iuserservice;

	@GetMapping
	public List<UserDTO> getEmployees() {
		return iuserservice.findAll();
	}

	@GetMapping("/{teamid}/team")
	public List<UserDTO> getUserByteamid(@PathVariable("teamid") Long teamid) {
		return iuserservice.findUserByTeamId(teamid);
	}

	@GetMapping("/{teamid}/position")
	public List<UserDTO> getUserByPositionName(@PathVariable("teamid") String name) {
		return iuserservice.findUserByPositionName(name);
	}
}