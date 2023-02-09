package cafeVO;

public class CafeMemVO {
	
	private String memname;
	private String memtel;
	
	public CafeMemVO() {}
	
	public CafeMemVO(String memname, String memtel) {
		this.memname = memname;
		this.memtel = memtel;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getMemtel() {
		return memtel;
	}

	public void setMemtel(String memtel) {
		this.memtel = memtel;
	}
	
	
	

}
