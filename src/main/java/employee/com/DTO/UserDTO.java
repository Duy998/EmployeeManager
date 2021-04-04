package employee.com.DTO;

public class UserDTO extends AbstactDTO<UserDTO>{

	
	private String name;	
	private String nickName;	
	private String age;	
	private String dayStart;	
	private String proFile;	
	private Integer status;
	private String eMail;
	private String posiTion;
	private String team;
	private String messger;
	private String passWord;
	private String checked;
	
	
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMessger() {
		return messger;
	}
	public void setMessger(String messger) {
		this.messger = messger;
	}
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
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPosiTion() {
		return posiTion;
	}
	public void setPosiTion(String posiTion) {
		this.posiTion = posiTion;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	
	
	
	
	
}
