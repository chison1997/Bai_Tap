package Samsung.java.hw2.Subject;

import java.io.IOException;
import java.util.Scanner;

public class SubjectManagement {
	
	static Subject s[] = new Subject[50];
	static int num = 0;
	static Scanner input = new Scanner(System.in);
	
	public static int find(String id)
	{
		for(int i = 0; i < num; i++)
		{
			if (s[i].getSubjectID().equals(id))
				return i;
		}
		return -1;
	}
	
	public static void append()
	{
		String name, id;
		int quota;
		System.out.print("Subject name: "); name = input.nextLine();
		
		do
		{
			System.out.print("Subject id: "); id = input.nextLine();
		}while(find(id) != -1);
		
		System.out.print("Quota: "); quota = input.nextInt();
		
		s[num] = new Subject(id, name, quota, 0);
		num ++;
		
	}
	
	public static void update()
	{
		if (num == 0)
		{
			System.out.println("There isn't any subject");
			return;
		}
		String id;
		int index;
		
		do
		{
			System.out.print("Subject id: "); id = input.nextLine();
			index = find(id);
		}while(index == -1);
		
		s[index].displaySubjectInfo();
		
		System.out.println("-----------------");
		
		System.out.print("New subject name: "); s[index].setSubjectName(input.nextLine());
		
		do
		{
			System.out.print("New subject id: "); id = input.nextLine();
		}while(find(id) != -1);
		s[index].setSubjectID(id);
		
		System.out.print("New quota: "); s[index].setQuota(input.nextInt());
		
		System.out.print("New current enrolment : "); s[index].setCurrentEnrolment(input.nextInt());
	}
	
	public static void display()
	{
		String id;
		int index;
		
		System.out.print("Subject id: "); id = input.nextLine();
		index = find(id);
		
		if (index == -1)
		{
			System.out.println("Subject not found");
		}
		else
		{
			s[index].displaySubjectInfo();
		}
	}
	
	public static void menu()
	{
		Scanner pressKey = new Scanner(System.in);
		
		System.out.println("Press Enter to continue...");
		try
		{
			System.in.read();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		pressKey.nextLine();
	}
	
	
	public static void main(String[] args) {
		char choice;
		
		
		System.out.println("Subject Management System");
		System.out.println("---------------------------------");
		System.out.println("1. Append new subject");
		System.out.println("2. Update subject");
		System.out.println("3. Display the information of subject");
		System.out.println("4. Enrol new student");
		System.out.println("5. Unenrol student");
		System.out.print("Your choice (1-5, other to quit): "); choice = input.nextLine().charAt(0);
		
		switch(choice)
		{
		case '1':
			System.out.println("1");
			append();
			menu();
			break;
			
		case '2':
			System.out.println("2");
			update();
			menu();
			break;
			
		case '3':
			System.out.println("3");
			display();
			menu();
			break;
			
		case '4':
			System.out.println("4");
			break;
			
		case '5':
			System.out.println("5");
			break;
		default:
			System.out.println("Default");
			
				
		}

	}

}
