package DG5.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{

	@Column
	private String name;
	
	@Column(name = "nickname")
	private String nickName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "daystart")
	private String dayStart;
	
	@Column(name = "profile")
	private String profile;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "email")
	private String email;
	
	//with PositionEntity
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionid")
    private PositionEntity position;
	
	//with TeamEntity
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamid")
    private TeamEntity team;
	
	@OneToMany(mappedBy = "user")
	private List<TechnicalEntity> technicals = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "user")
	private List<AdvantageEntity> advantages = new ArrayList<>();
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public List<TechnicalEntity> getTechnicals() {
		return technicals;
	}

	public void setTechnicals(List<TechnicalEntity> technicals) {
		this.technicals = technicals;
	}

	public List<AdvantageEntity> getAdvantages() {
		return advantages;
	}

	public void setAdvantages(List<AdvantageEntity> advantages) {
		this.advantages = advantages;
	}
	
	
	
	
	
	
	
	
	
}
