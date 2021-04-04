package employee.com.Uitils;

import java.util.List;

import org.springframework.stereotype.Component;

import employee.com.entity.UserEntity;

@Component
public class Utils {

public int CountIdUserByTeam(List<UserEntity> entity){
		
		int count = 0;
		for (UserEntity userEntity : entity) {
			count++;
		}
		
		return count;
		
	}
}
