ppackage ExceptionHandling;

import java.util.Scanner;

class MinorageException extends Exception
{
	@Override
	public String getMessage()
	{
		return "Applicant age is too low";
	}
}

class OverAgeException extends Exception
{
	@Override
	public String getMessage()
	{
		return "Applicant is too old";
	}
}


class applicant
{ private int age;
	void input()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the age");
		age = scan.nextInt();

	}

	void verify() throws MinorageException, OverAgeException
	{
		if(age>=18 && age <=65 ) {
			System.out.println("age limit valid, User can apply for license");
			System.exit(0);

		}
		
		else if(age<18)
		{
			MinorageException mae = new MinorageException();
			System.out.println(mae.getMessage());
			throw mae;
		}
		else if(age>65)
		{
			OverAgeException oae = new OverAgeException();
			System.out.println(oae.getMessage());
			throw oae;
		}

	}

}


class rto

{
	void operate()
	{
		applicant ap = new applicant();
		
		try {
			ap.input();
			ap.verify();

		}
		catch(Exception e)
		{
			System.out.println("1 attempt/s over");
			try {
				ap.input();
				ap.verify();

				}
			catch(Exception e1)
			{
				System.out.println("2 attempt/s over");
				try {
					ap.input();
					ap.verify();

					}
				catch(Exception e2)
				{
					System.out.println("3 attempt/s over");
					System.out.println("User blocked");
					System.exit(0);
					
				}
			}
			
		}
	}
}



public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rto r = new rto();
		r.operate();

	}

}