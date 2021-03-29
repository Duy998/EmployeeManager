package DG5.com.DTO;


public class TechnicalDTO extends AbstactDTO<TechnicalDTO> {
	private String skill;
	
	private String level;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
