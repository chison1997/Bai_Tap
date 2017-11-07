import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ScoreBoard {
	Subject monHoc;
	ArrayList<StudentScore> sinhVien;
	String maHocKy;
	int soLuongSV;
	
	public ScoreBoard(Path path) throws IOException
	{
		if (Files.notExists(path))
		{
			Files.createFile(path);
		}
		else
		{
			BufferedReader buf = Files.newBufferedReader(path);
			String line = buf.readLine();
			StringTokenizer s = new StringTokenizer(line, "|");
			
//			monHoc = new Subject();
//			monHoc.setMaMonHoc(s.nextToken());
//			
//			maHocKy = s.nextToken();
//			
//			soLuongSV = 0;
//			while(line != null)
//			{
//				for(int i = 0; i < line.length(); i++)
//				{
//					if(line.charAt(i) == '*')
//						soLuongSV ++;
//				}
//				line = buf.readLine();
//			}
			
			monHoc = new Subject();
			
			s.nextToken();
			monHoc.setMaMonHoc(s.nextToken());
			
			line = buf.readLine();
			s.nextToken();
			monHoc.setTenMonHoc(s.nextToken());
			
			line = buf.readLine();
			s.nextToken();
			monHoc.setHeSoQuaTrinh(Float.parseFloat(s.nextToken()) / 100);
			monHoc.setHeSoCuoiKy(Float.parseFloat(s.nextToken()) / 100);
			
			line = buf.readLine();
			s.nextToken();
			maHocKy = s.nextToken();
			
			line = buf.readLine();
			s.nextToken();
			soLuongSV = Integer.parseInt(s.nextToken());
			
			while (true)
			{
				line = buf.readLine();
				if (line == null)
					break;
				StudentScore SV = new StudentScore(line);
				sinhVien.add(SV);
			}
			
		}
	}

	
	public Subject getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(Subject monHoc) {
		this.monHoc = monHoc;
	}

	public String getMaHocKy() {
		return maHocKy;
	}

	public void setMaHocKy(String maHocKy) {
		this.maHocKy = maHocKy;
	}

	public int getSoLuongSV() {
		return soLuongSV;
	}

	public void setSoLuongSV(int soLuongSV) {
		this.soLuongSV = soLuongSV;
	}

	


	

}
