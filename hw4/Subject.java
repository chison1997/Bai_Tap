
public class Subject {
	private String maMonHoc;
	private String tenMonHoc;
	private float heSoQuaTrinh;
	private float heSoCuoiKy;
	
	public Subject(String maMonHoc, String tenMonHoc, float heSoQuaTrinh)
	{
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSoQuaTrinh = heSoQuaTrinh;
		this.heSoCuoiKy = 1 - heSoQuaTrinh;
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

	public float getHeSoQuaTrinh() {
		return heSoQuaTrinh;
	}

	public void setHeSoQuaTrinh(float heSoQuaTrinh) {
		this.heSoQuaTrinh = heSoQuaTrinh;
	}

	public float getHeSoCuoiKy() {
		return heSoCuoiKy;
	}

	public void setHeSoCuoiKy(float heSoCuoiKy) {
		this.heSoCuoiKy = heSoCuoiKy;
	}
	
	
	
}
