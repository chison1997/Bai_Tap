package Samsung.java.hw2.bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SavingAccount {
	private String soTaiKhoan;
	private String tenTaiKhoan;
	private double tienGoc;
	private Date ngayGui;
	private double laiSuat;
	
	
	
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}



	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}



	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}



	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}



	public double getTienGoc() {
		return tienGoc;
	}



	public void setTienGoc(double tienGoc) {
		this.tienGoc = tienGoc;
	}



	public Date getNgayGui() {
		return ngayGui;
	}



	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	public void setNgayGui(String dateInString)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		
		try {
			ngayGui = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public double getLaiSuat() {
		return laiSuat;
	}



	public void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}



	public double tienLai()
	{
		Date date = new Date();
		System.out.println(TimeUnit.DAYS.convert(date.getTime() - ngayGui.getTime(), TimeUnit.MILLISECONDS));
		return tienGoc * laiSuat * (TimeUnit.DAYS.convert(date.getTime() - ngayGui.getTime(), TimeUnit.MILLISECONDS));
	}
	
	public void rutTienLai()
	{
		System.out.println("Tien lai: " + tienLai());
	
		ngayGui = new Date();
	}
	
	public void rutTienLaiGoc()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("Ban dang co %f tien goc va %f tien lai\nBan muon rut het tien lai va bao nhieu tien goc? ", getTienGoc(), tienLai());
		double tienRut = input.nextDouble();
		
		while(tienRut > getTienGoc() || tienRut < 0)
		{
			System.out.print("So tien ban nhap khong hop le, moi ban nhap lai: ");
			tienRut = input.nextDouble();
		}
		
		
		System.out.println("\nSo tien ban nhan duoc: " + (tienRut + tienLai()));
		
		tienGoc -= tienRut;
		
		ngayGui = new Date();
		
	}
	
	public void guiThem()
	{
		rutTienLai();
		
		Scanner input = new Scanner(System.in);
		System.out.printf("Ban dang co %f tien goc va %f tien lai\nBan muon rut het tien lai va bao nhieu tien goc? ", getTienGoc(), tienLai());
		double tienThem = input.nextDouble();
		
		while( tienThem <= 0)
		{
			System.out.print("So tien ban nhap khong hop le, moi ban nhap lai: ");
			tienThem = input.nextDouble();
		}
		
		tienGoc += tienThem;
		
	}
	
	public void tatToan()
	{
		System.out.println("So tien ban nhan: " + (tienGoc + tienLai()));
		tienGoc = 0;
		ngayGui = new Date();
	}
	
	
	public void display()
	{
		System.out.println("So tai khoan: " + soTaiKhoan);
		System.out.println("Ten tai khoan: " + tenTaiKhoan);
		System.out.println("Tai khoan goc: " + tienGoc);
		System.out.println("Ngay gui: " + ngayGui.toString());
		System.out.println("Lai suat: " + laiSuat);
		System.out.println("Tien lai: " + tienLai());
	}
	
	
	public SavingAccount()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("So tai khoan: "); soTaiKhoan = input.nextLine();
		System.out.print("Ten tai khoan: "); tenTaiKhoan = input.nextLine();
		tienGoc = 0;
		ngayGui = new Date();
	}
	
	public SavingAccount(String soTaiKhoan, String tenTaiKhoan, double tienGoc, Date ngayGui, double laiSuat)
	{
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.tienGoc = tienGoc;
		if (ngayGui != null)
		{
			this.ngayGui = ngayGui;
		}
		else
		{
			this.ngayGui = new Date();
		}
		this.laiSuat = laiSuat;
	}
	
}


