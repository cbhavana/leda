package multiplication;
import java.util.*;

public class multiplication {
	
	public static void main(String[] args)
	{
		String s1="87178291200",s2="15",s3="",sum="";
		StringBuffer buffer=new StringBuffer();
		int n1,n2,i,j=0,c=0,s=0,flag=0;
		
		//Scanner in=new Scanner(System.in);
		//System.out.println("enter 1st number");
		//s1=in.next();
		//System.out.println("enter 2nd number");
		//s2=in.next();
		
	        if(s1.charAt(0)=='-') 
	            {
	            j=1;
	            flag=1;
	            if(s1.charAt(1)=='0')
	                j=2;
	           }
	       if(s2.charAt(0)=='-')
	           {
	           flag=1;
	           }
	         if(s1.charAt(0)=='-' && s2.charAt(0)=='-' )
	            {
	            j=1;
	            flag=0;
	             if(s1.charAt(1)=='0')
	                j=2;
	            }
	        if(s1.charAt(0)=='0')
	                j=1;
		for(i=s1.length()-1;i>=j;i--)
		 {
	        if(s1.charAt(i)=='-')
	            {
	            i++;
	        buffer.append(s);
	        }
			n1=Integer.parseInt(""+s1.charAt(i));
			n2=Integer.parseInt(""+s2.charAt((s2.length()-1)));
		    s=c+(n1*n2);
		    c=s/10;
		    s=s%10;
		    buffer.append(s);
	    }
		
		if(c!=0)
		buffer.append(c);
	        if(flag==1)
	            buffer.append("-");
		sum=buffer.reverse().toString();
	   System.out.println(sum);
	    }
}