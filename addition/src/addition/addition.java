package addition;
import java.util.*;
import java.io.*;

public class addition {
	
public static void main(String[] args)
{
	String s1,s2,s3="",sum="";
	Scanner in=new Scanner(System.in);
	System.out.println("enter 1st number");
	s1=in.next();
	System.out.println("enter 2nd number");
	s2=in.next();
	
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
    System.out.println(sum);
 }
}


