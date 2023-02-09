package cafeVO;

public class CafeMenuVO {

	private String menuname;
	private int menuprice;
	
	public CafeMenuVO() {}
	
	public CafeMenuVO(String menuname, int menuprice) {
		this.menuname = menuname;
		this.menuprice = menuprice;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}
	
	
	
}
 