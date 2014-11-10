package subtracton;
import java.util.Scanner;
public class subtraction {
	public static void main(String[] args)
	{
		//StringBuffer buffer=new StringBuffer()
		String s1,s2,s,s3,s4,num1,num2,result;
		int flag=0;
		Scanner in=new Scanner(System.in);
		System.out.println("enter 1st number");
		s1=in.next();
	   System.out.println("enter 2nd number");
		s2=in.next();
		s2="-"+s2;
		if((s2.charAt(0)=='-') && (s2.charAt(1)=='-'))
		{
			s2=s2.substring(1);
		}

		if((s1.charAt(0)=='-') && (s2.charAt(0)=='-'))  //if both are negative numbers
		{
			s=add(s1.substring(1),s2.substring(1));
			s="-"+s;
			System.out.println(s);
            System.exit(0);
		}
		/*if((s1.charAt(0)!='-') && (s2.charAt(0)!='-'))
			s2="-"+s2;*/
		if(s1.charAt(0)=='-')
		{
			s3=s1.substring(1);
		}
		else
			s3=s1;
		if(s2.charAt(0)=='-')
			s4=s2.substring(1);
		else
			s4=s2;
		
		if(s3.equals(s4))
		{
			System.out.println("0");
			System.exit(0);
		}
		num1=checkbig(s3,s4);
		
		if(num1.equals(s3))
			num2=s4;
		else
			num2=s3;
		
		if(s1.equals("-"+num1) || s2.equals("-"+num1))
			flag=1;
		
		result=sub(num1,num2);
		if(flag==1)
			result="-"+result;
			System.out.println(result);
		//System.out.println(num1+" "+num2);
	}
	
	//method to check which integer is bigger
	static String checkbig(String s1,String s2)
	{
		int i,j=0;
		if(s1.length()>s2.length())
			return s1;
		else if(s2.length()>s1.length())
			return s2;
		else
		{
			for(i=0;i<s1.length();i++)
			{
		    if(Integer.parseInt(""+s1.charAt(i))>Integer.parseInt(""+s2.charAt(i)))
		    	return s1;
		    else if(Integer.parseInt(""+s2.charAt(i))>Integer.parseInt(""+s1.charAt(i)))
		    	return s2;
		     else
		      {}
		    }
		   }
		
		return s1;
	}
	
	//method to add two numbers
	static String add(String s1,String s2)
	{
		//System.out.println(s1+" "+s2);
		String s3="",sum="";
		StringBuffer buffer=new StringBuffer();
		
		int n1,n2,i,j,c=0,s=0;
		//appending 0's to 1st integer if necessary
		if(s1.length()<s2.length())
		{
			for(i=1;i<=(s2.length()-s1.length());i++)
				s3=s3+"0";
			s1=s3+s1;
		}
		//appending 0's to 2nd integer if necessary
		else if(s2.length()<s1.length())
		{
			for(i=1;i<=(s1.length()-s2.length());i++)
				s3=s3+"0";
			   s2=s3+s2;
		}
			//performing addition
		for(i=s1.length()-1;i>=0;i--)
		 {
			n1=Integer.parseInt(""+s1.charAt(i));
			n2=Integer.parseInt(""+s2.charAt(i));
		    s=c+n1+n2;
		    c=s/10;
		    s=s%10;
		    buffer.append(s);
	     }
		
		if(c!=0)
		buffer.append(c);
		sum=buffer.reverse().toString();
	    return sum;
	}
	//method to subtract two numbers
	static String sub(String s1,String s2)
	{
		StringBuffer buffer=new StringBuffer();
		int i=0,n1,n2,s,b=0;
		String res,s3="";
		if(s1.length()<s2.length())
		{
			for(i=1;i<=(s2.length()-s1.length());i++)
				s3=s3+"0";
			s1=s3+s1;
		}
		//appending 0's to 2nd integer if necessary
		else if(s2.length()<s1.length())
		{
			for(i=1;i<=(s1.length()-s2.length());i++)
				s3=s3+"0";
			   s2=s3+s2;
		}
		for(i=s1.length()-1;i>=0;i--)
		 {
			n1=Integer.parseInt(""+s1.charAt(i));
			n2=Integer.parseInt(""+s2.charAt(i));
			if(b==1)
				n1=n1-b;
			if(n1>=n2)
			{
		    s=n1-n2;
		    b=0;
			}
			else
			{
				s=(n1+10)-n2;
				b=1;
			}
			//System.out.println("*"+s);
		    buffer.append(s);
	     }
		res=buffer.reverse().toString();
	    return res;
	}
}
