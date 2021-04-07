package employee.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

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

	@Column(name = "status", columnDefinition = "TINYINT(1)")
	private int status;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "expe")
	private String exPe;

	// with PositionEntity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "positionid")
	private PositionEntity position;

	// with TeamEntity
	@ManyToOne()
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getExPe() {
		return exPe;
	}

	public void setExPe(String exPe) {
		this.exPe = exPe;
	}

	
}
