package employee.com.utils;

import java.util.List;

import employee.com.entity.UserEntity;

public class TeamUtils {
	
	public static Integer CountNumberTeam(String managerName,Long[] list) {
		if(managerName != null && !managerName.equals("---chon---")) {
			return list.length + 1;
		}else {
			return list.length;
		}		
	}
	
	public static Integer CountNumberTeam(String managerName,List<UserEntity> list) {
		if(managerName != null && !managerName.equals("---chon---")) {
			return list.size() + 1;
		}else {
			return list.size();
		}		
	}

}
