import java.util.StringTokenizer;

public class StudentScore {
	private String hoTenDem;
	private String ten;
	private String MSSV;
	private float diemQuaTrinh;
	private float diemCuoiKy;
	
	public StudentScore(String hoTenDem, String ten, String MSSV, float diemQuaTrinh, float diemCuoiKy)
	{
		this.hoTenDem = hoTenDem;
		this.ten = ten;
		this.MSSV = MSSV;
		this.diemQuaTrinh = diemQuaTrinh;
		this.diemCuoiKy = diemCuoiKy;
	}
	
	public StudentScore(String line) {
		StringTokenizer s = new StringTokenizer(line, "|");
		
		s.nextToken();
		
		MSSV = s.nextToken();
		
		hoTenDem = s.nextToken();
		
		ten = s.nextToken();
		
		diemQuaTrinh = Float.parseFloat(s.nextToken());
		
		diemCuoiKy = Float.parseFloat(s.nextToken());
	}

	public String getHoTenDem() {
		return hoTenDem;
	}
	public void setHoTenDem(String hoTenDem) {
		this.hoTenDem = hoTenDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public float getDiemQuaTrinh() {
		return diemQuaTrinh;
	}
	public void setDiemQuaTrinh(float diemQuaTrinh) {
		this.diemQuaTrinh = diemQuaTrinh;
	}
	public float getDiemCuoiKy() {
		return diemCuoiKy;
	}
	public void setDiemCuoiKy(float diemCuoiKy) {
		this.diemCuoiKy = diemCuoiKy;
	}
	
	
	
	public char getMark(float heSo)
	{
		float diem = diemQuaTrinh * heSo + diemCuoiKy * (1 - heSo);
		if (diem >= 8.5)
			return 'A';
		else if (diem >= 7)
			return 'B';
		else if (diem >= 5.5)
			return 'C';
		else if (diem >= 4)
			return 'D';
		else
			return 'F';
	}

	public String getMarkLine(float heSo)
	{
		return "S|" + MSSV + "|" + "|" + ten + "| " + diemQuaTrinh + " | " + diemCuoiKy + " | " + getMark(heSo) + " |";
	}

	
	

}
