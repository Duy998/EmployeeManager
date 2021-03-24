package DG5.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "team")
@Entity
public class TeamEntity extends BaseEntity{

	@Column
	private String name;
	
	@Column
	private Integer number;
	
	
	@OneToMany(mappedBy = "team")
	private List<UserEntity> users = new ArrayList<>();
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	
}
