package employee.com.DTO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstactDTO<T> {

	private Long id;
	private Long[] ids;
	private List<T> listresult = new ArrayList<T>();
	
//	pageable
	private Integer page;
	private Integer limit;
	private Integer totalPage;
	private Integer totalItem;
	
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
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
