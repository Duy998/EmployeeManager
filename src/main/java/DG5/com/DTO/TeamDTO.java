package DG5.com.DTO;

import java.util.ArrayList;
import java.util.List;

import DG5.com.entity.UserEntity;

public class TeamDTO extends AbstactDTO<TeamDTO>{
	private String name;
	private String namemanager;
	private Integer number;
	private List<UserEntity> users = new ArrayList<>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNamemanager() {
		return namemanager;
	}
	public void setNamemanager(String namemanager) {
		this.namemanager = namemanager;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
}
