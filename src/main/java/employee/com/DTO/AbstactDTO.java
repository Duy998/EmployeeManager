package employee.com.DTO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstactDTO<T> {

	private Long id;
	private Long[] ids;
	private List<T> listresult = new ArrayList<T>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<T> getListresult() {
		return listresult;
	}
	public void setListresult(List<T> listresult) {
		this.listresult = listresult;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
	
}
