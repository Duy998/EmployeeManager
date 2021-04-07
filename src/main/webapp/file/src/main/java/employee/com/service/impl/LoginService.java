package employee.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import employee.com.DTO.UserDTO;
import employee.com.converter.UserConverter;
import employee.com.entity.UserEntity;
import employee.com.repository.LoginRepository;
import employee.com.service.ILoginService;
import employee.com.service.IUserService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private IUserService iuserService;

	@Autowired
	MailSender mailSender;

	// Function login
	@Override
	public UserDTO loginPage(String email, String password) {
		String getPass = iuserService.getMD5(password);
		UserEntity userEntity = loginRepository.findByEmailAndPassword(email, getPass);
		UserDTO userDTO = new UserDTO();
		if (userEntity != null && userEntity.getStatus() == 1) {
			userDTO = userConverter.toDto(userEntity);
			userDTO.setMessage("true");
		} else {
			userDTO.setMessage("false");
		}
		return userDTO;
	}

	// Function create password
	@Override
	public UserDTO createPassword(String email, String password, String newPassword) {
		String oldPass = iuserService.getMD5(password);
		UserEntity userEntity = loginRepository.findByEmailAndPassword(email, oldPass);
		UserDTO userDTO = new UserDTO();
		if (userEntity != null && userEntity.getStatus() == 1) {
			String hashPass = iuserService.getMD5(newPassword);
			userEntity.setPassword(hashPass);
			loginRepository.save(userEntity);
			userDTO.setMessage("true");
		} else {
			userDTO.setMessage("false");
		}
		return userDTO;
	}

	// Function send email
	@Override
	public UserDTO sendEmail(String email) {
		UserEntity userEntity = loginRepository.findByEmail(email);
		UserDTO userDTO = new UserDTO();
		if (userEntity != null && userEntity.getStatus() == 1) {
			String password = iuserService.getPass(userEntity.getPassword());
			senderEmail("phamhongnghia13579@gmail.com", email,"Forgot password", password);
			userDTO.setMessage("true");
		} else {
			userDTO.setMessage("false");
		}
		return userDTO;
	}

	@Override
	public void senderEmail(String from, String to, String subject, String content) {
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom(from);
		simpleMail.setTo(to);
		simpleMail.setSubject(subject);
		simpleMail.setText(content);

		mailSender.send(simpleMail);
	}

}
