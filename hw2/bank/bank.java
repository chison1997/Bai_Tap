package Samsung.java.hw2.bank;

import java.util.Date;
import java.util.Scanner;

public class bank {
	static SavingAccount A[] = new SavingAccount[50];
	static int num = 0;
	static Scanner input = new Scanner(System.in);
	
	public static int find(String taiKhoan)
	{
		for(int i = 0; i < num; i++)
		{
			if (taiKhoan.equals(A[i].getSoTaiKhoan()))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static void append()
	{
		if (num == 50)
		{
			System.out.println("Khong the them nua");
			return;
		}
		
		String soTaiKhoan;
		String tenTaiKhoan;
		double tienGoc;
		double laiSuat;
		
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
		
		} while(find(soTaiKhoan) != -1);
		
		System.out.println("Ten tai khoan: "); tenTaiKhoan = input.nextLine();
		System.out.println("Tien goc: "); tienGoc = input.nextDouble();
		System.out.println("Lai suat: "); laiSuat = input.nextDouble();
		
		A[num] = new SavingAccount(soTaiKhoan, tenTaiKhoan, tienGoc, null, laiSuat);
		
		num++;
		
	}
	
	public static void withdrawInterest()
	{
		String soTaiKhoan;
		int index = 0;
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
			index = find(soTaiKhoan);
		
		} while(index == -1);
		
		A[index].rutTienLai();
		
	}
	
	public static void partialyWithdraw()
	{
		String soTaiKhoan;
		int index = 0;
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
			index = find(soTaiKhoan);
		
		} while(index == -1);
		
		A[index].rutTienLaiGoc();
	}
	
	public static void totallyWithdraw()
	{
		String soTaiKhoan;
		int index = 0;
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
			index = find(soTaiKhoan);
		
		} while(index == -1);
		
		A[index].tatToan();
	}
	
	public static void deposit()
	{
		String soTaiKhoan;
		int index = 0;
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
			index = find(soTaiKhoan);
		
		} while(index == -1);
		
		A[index].guiThem();
	}
	
	public static void display()
	{
		String soTaiKhoan;
		int index = 0;
		do
		{
			System.out.println("So tai khoan: "); soTaiKhoan = input.nextLine();
			index = find(soTaiKhoan);
		
		} while(index == -1);
		
		A[index].display();
	}
	
	
	public static void main(String[] args) {
		
		char choice;
		for(;;)
		{
			System.out.println("Bank Management System");
			System.out.println("----------------------------------");
			System.out.println("1. Append new account");
			System.out.println("2. Withdraw interest");
			System.out.println("3. Partialy withdraw");
			System.out.println("4. Totally withdraw");
			System.out.println("5. Deposit");
			System.out.println("6. Display information");
			System.out.println("Your choice (1-6, other to quit) : ");
			choice = input.nextLine().charAt(0);
			
			System.out.println("\n---------------------\n");
			switch(choice)
			{
			case '1':
				append();
				break;
			case '2':
				withdrawInterest();
				break;
				
			case '3':
				partialyWithdraw();
				break;
			case '4':
				totallyWithdraw();
				break;
			case '5':
				deposit();
				break;
			case '6':
				display();
				break;
			default:
				System.exit(0);
			}
			System.out.println("\n--------------------------------------\n\n");
			input.nextLine();
		}
		
		
		
	}

}
