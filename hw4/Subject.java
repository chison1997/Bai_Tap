
public class Subject {
	private String maMonHoc;
	private String tenMonHoc;
	private int heSoQuaTrinh;
	private int heSoCuoiKy;
	
	public Subject(String maMonHoc, String tenMonHoc, int heSoQuaTrinh)
	{
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSoQuaTrinh = heSoQuaTrinh;
		this.heSoCuoiKy = 100 - heSoQuaTrinh;
	}

	public Subject() {
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getHeSoQuaTrinh() {
		return heSoQuaTrinh;
	}

	public void setHeSoQuaTrinh(int heSoQuaTrinh) {
		this.heSoQuaTrinh = heSoQuaTrinh;
	}

	public int getHeSoCuoiKy() {
		return heSoCuoiKy;
	}

	public void setHeSoCuoiKy(int heSoCuoiKy) {
		this.heSoCuoiKy = heSoCuoiKy;
	}
	
	
	
}
