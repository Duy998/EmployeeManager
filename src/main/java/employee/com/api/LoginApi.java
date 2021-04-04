package employee.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employee.com.DTO.UserDTO;
import employee.com.service.ILoginService;

@RestController
public class LoginApi {
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public UserDTO login(@RequestBody UserDTO userDto){
		userDto = loginService.loginPage(userDto.geteMail(), userDto.getPassWord());
		return userDto;
	}
}