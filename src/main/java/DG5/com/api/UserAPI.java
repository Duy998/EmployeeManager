package DG5.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DG5.com.DTO.UserDTO;
import DG5.com.service.IUserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserAPI {

	@Autowired
	private IUserService iuserservice;
	
	@GetMapping
    public List<UserDTO> getEmployees() {  	
        return iuserservice.findAll();
    }
	
}
