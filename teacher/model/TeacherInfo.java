package teacher.model;

public class TeacherInfo {
	private String lxdh;
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	private String bm;
	private String xm;
	private String zgh;
	private String qx;




	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}

	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getZgh() {
		return zgh;
	}
	public void setZgh(String zgh) {
		this.zgh = zgh;
	}
	@Override
	public String toString() {
		return "TeacherInfo [lxdh=" + lxdh + ", bm=" + bm + ", xm=" + xm
				+ ", zgh=" + zgh + ", qx=" + qx + "]";
	}
	
	
	
}
