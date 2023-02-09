package cafeVO;

public class CafePayVO {

	private String me;
	private String ondo;
	private int soo;
	
	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	public String getOndo() {
		return ondo;
	}

	public void setOndo(String ondo) {
		this.ondo = ondo;
	}

	public int getSoo() {
		return soo;
	}

	public void setSoo(int soo) {
		this.soo = soo;
	}

	public CafePayVO() {}
	
	public CafePayVO(String me, String ondo,int soo) {
		this.me = me;
		this.ondo = ondo;
		this.soo = soo;
	}

	
}
