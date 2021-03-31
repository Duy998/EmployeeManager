package employee.com.service;

import employee.com.DTO.UserDTO;

public interface ILoginService {
	UserDTO loginPage(String email, String password);
}
