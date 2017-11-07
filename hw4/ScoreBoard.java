import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
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

			monHoc = new Subject();
			
			s.nextToken();
			monHoc.setMaMonHoc(s.nextToken());
			
			line = buf.readLine();
			s.nextToken();
			monHoc.setTenMonHoc(s.nextToken());
			
			line = buf.readLine();
			s.nextToken();
			monHoc.setHeSoQuaTrinh(Integer.parseInt(s.nextToken()));
			
			monHoc.setHeSoCuoiKy(Integer.parseInt(s.nextToken()));
			
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

	
public ArrayList<StudentScore> getSinhVien() {
		return sinhVien;
	}


	public void editScore(String MSSV)
	{
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		String choose;
		for(StudentScore sv: sinhVien)
		{
			if (MSSV.equals(sv.getMSSV()))
			{
				flag = true;
				System.out.println(sv.toString());
				System.out.print("Ban muon sua diem khong? (Y/N): ");
				choose = input.nextLine();
				
				if (choose.charAt(0) == 'Y')
				{
					System.out.print("Ban muon sua diem qua trinh hay cuoi ky? (Q/C)");
					choose = input.nextLine();
					if (choose.charAt(0) == 'Q')
					{
						System.out.print("Sua diem qua trinh thanh: "); 
						sv.setDiemQuaTrinh(input.nextFloat());
						System.out.println("Da sua diem qua trinh");
					}
					else if (choose.charAt(0) == 'C')
					{
						System.out.print("Sua diem cuoi ky thanh: "); 
						sv.setDiemCuoiKy(input.nextFloat());
						System.out.println("Da sua diem cuoi ky");
					}
				}
				
			}
		}
		
		if (flag == false)
		{
			System.out.print("Khong tim thay, ban co muon them sinh vien vao bang diem khong? (Y/N): ");
			choose = input.nextLine();
			
			if (choose.charAt(0) == 'Y')
			{
				StudentScore sv = new StudentScore();
				sinhVien.add(sv);
			}
		}
	}
	

	public boolean delete(String MSSV)
	{
		for(StudentScore sv: sinhVien)
		{
			if (MSSV.equals(sv.getMSSV()))
			{
				sinhVien.remove(sv);
				return true;
			}
		}
		return false;
	}
	
	public void update()
	{
		String path = (monHoc.getMaMonHoc() + monHoc.getMaMonHoc() + ".txt");
		
		try {
			FileWriter wr = new FileWriter(path);
			
			wr.write("SubjectID|" + monHoc.getMaMonHoc() + "\n");
			wr.write("Subject|" + monHoc.getTenMonHoc() + "\n");
			wr.write("F|" + monHoc.getHeSoQuaTrinh() + "|" + monHoc.getHeSoCuoiKy() + "\n");
			wr.write("Semester|" + monHoc.getTenMonHoc() + "\n");
			wr.write("StudentCount|" + soLuongSV);
			
			for(StudentScore sv : sinhVien)
			{
				wr.write(sv.getMarkLine(monHoc.getHeSoQuaTrinh()));
			}
			
			wr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void report()
	{
		String path = monHoc.getMaMonHoc() + "_" + maHocKy + "_rp.txt";
		
		if (Files.notExists(Paths.get(path)))
		{
			try {
				Files.createFile(Paths.get(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter wr = new FileWriter(path);
			
			float highestMark = 0, lowestMark = 10, average = 0;
			int count[] = new int[5];
			float mark;
			String highestMarkStudent = new String(), lowestMarkStudent = new String();
			for(StudentScore sv: sinhVien)
			{
				mark = (sv.getDiemQuaTrinh() * monHoc.getHeSoQuaTrinh() + sv.getDiemCuoiKy() * monHoc.getHeSoCuoiKy()) / 100;
				average += mark;
				if (mark > highestMark)
				{
					highestMark = mark;
					highestMarkStudent = sv.getHoTenDem() + " " + sv.getTen();
				}
				else if (mark < lowestMark)
				{
					lowestMark = mark;
					lowestMarkStudent = sv.getHoTenDem() + " " + sv.getTen();
				}
				
				count[sv.getMark(monHoc.getHeSoQuaTrinh()) - 'A'] ++;
			}
			
			highestMarkStudent.toUpperCase();
			lowestMarkStudent.toLowerCase();
			average /= sinhVien.size();
			
			wr.write("The student with the highes mark is: " + highestMarkStudent + "\n");
			wr.write("The student with the lowest mark is: " + lowestMarkStudent + "\n");
			wr.write("The average mark is: " + average + "\n\n");
			wr.write("A histogram of the subject " + monHoc.getMaMonHoc() + " is: \n");
			
			for(char c = 'A'; c <= 'F'; c++)
			{
				wr.write(c + ": ");
				for(int i = 0; i < count[c - 'A']; i++)
					wr.write("*");
				wr.write("\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
