package subtracton;

import java.util.Scanner;

public class resultcheck {
	public static void main(String[] args)
	{
		String s1,s2,s3;
		int num1,num2,num3,res,n;
		Scanner in=new Scanner(System.in);
		 System.out.println("enter 1st number");
		 s1=in.next();
	     System.out.println("enter 2nd number");
		 s2=in.next();
		 System.out.println("enter product");
		 s3=in.next();
		 
		 num1=check(s1);
		 num2=check(s2);
		 n=num1*num2;
		 num3=check(""+n);
		 res=check(s3);
		 System.out.println(num1+"\n"+num2+"\n"+num3+"\n"+res);
	}
	static int check(String s)
	{
		int n;
		while(true)
		{
			n=0;
		for(int i=0;i<s.length();i++)
			n=n+Integer.parseInt(""+s.charAt(i));
		if(n<10)
			break;
		else
			s=""+n;
		}
		return n;
	}

}
