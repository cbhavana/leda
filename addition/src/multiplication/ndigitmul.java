package multiplication;

import java.util.Scanner;

public class ndigitmul {
	public static void main(String[] args)
	{
		String s1,s2="",sum1="",sum2="0";
		//StringBuffer buffer=new StringBuffer();
		int n1,n2,i,j=0,c=0,s=0,flag=0,k=0,m,n;
		
		Scanner in=new Scanner(System.in);
		System.out.println("enter 1st number");
		s1=in.next();
	   System.out.println("enter 2nd number");
		s2=in.next();
		
	        if(s1.charAt(0)=='-') 
	            {
	            j=1;
	            flag=1;
	            /*if(s1.charAt(1)=='0')
	                j=2;*/
	           }
	       if(s2.charAt(0)=='-')
	           {
	    	   k=1;
	           flag=1;
	           }
	         if(s1.charAt(0)=='-' && s2.charAt(0)=='-' )
	            {
	            j=1;
	            k=1;
	            flag=0;
	            /* if(s1.charAt(1)=='0')
	                j=2;*/
	            }
	       /* if(s1.charAt(0)=='0')
	                j=1;*/
	         
	   for(m=s1.length()-1;m>=j;m--)
	    {
		   StringBuffer buffer=new StringBuffer(); 
		   c=0;
		for(i=s2.length()-1;i>=k;i--)
		 {
			n1=Integer.parseInt(""+s2.charAt(i));
			n2=Integer.parseInt(""+s1.charAt(m));
		    s=c+(n1*n2);
		    c=s/10;
		    s=s%10;
		    buffer.append(s);
	    }
		if(c!=0)
			buffer.append(c);
		sum1=buffer.reverse().toString();
		for(n=0;n<(s1.length()-1-m);n++)
			sum1=sum1+0;
		sum2=add(sum1,sum2);
	         }
	        if(flag==1)
	       sum2="-"+sum2;
	        
	   System.out.println(sum2);
	    }
	
static String add(String s1,String s2)
{
	System.out.println(s1+" "+s2);
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

}
