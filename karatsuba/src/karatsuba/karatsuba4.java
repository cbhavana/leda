package karatsuba;

import java.io.*;
import java.util.*;
public class karatsuba4 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    String a="",b="",n,m,res="";
		int j,flag=0,d,f;
		long a1,a2,a3,a4;
		Scanner in=new Scanner(System.in);
		d=in.nextInt();
        //System.out.println(d);
		for(int i=0;i<d;i++)
		{
			a=a+(int)(Math.random()*10);
            b=b+(int)(Math.random()*10);
		}
		if(a.charAt(0)=='0')
			a=a.substring(1)+(int)(Math.random()*10);
		if(b.charAt(0)=='0')
			b=b.substring(1)+(int)(Math.random()*10);
		//System.out.println(a+"\n"+b);
        a1=System.currentTimeMillis();
		n=k4(a,b);
		a2=System.currentTimeMillis();
		a4=System.currentTimeMillis();
		m=k32(a,b);
		a3=System.currentTimeMillis();
		System.out.println(Math.round((double)(a2-a1)/(double)(a3-a4)));

    }
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
	 static String mul(String s1,String s2)
	 {
		 String sum1="",sum2="0";
			//StringBuffer buffer=new StringBuffer();
			int n1,n2,i,j=0,c=0,s=0,flag=0,k=0,m,n;
			
			
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
		        return sum2;
	 }
  static String k4(String a,String b)
   {
	  int k;
	  String a0,a1,b0,b1,p0,p1,p2,result,res;
	if(a.length()<=4 && b.length()<=4)
	{
		res=mul(a,b);
		return res;
	}
	else
	{
		 if((a.length()%2)!=0)
			  a="0"+a;
		  if((b.length()%2)!=0)
			  b="0"+b;
		  if(a.length()<b.length())
			  a=pow(b.length()-a.length())+a;
		  
		  if(a.length()>b.length())
			  b=pow(a.length()-b.length())+b;
		  
		k=a.length()/2;
		a0=a.substring(k);
		a1=a.substring(0, k);
		b0=b.substring(k);
		b1=b.substring(0,k);
		p0=k4(a0,b0);
		p2=k4(a1,b1);
		p1=k4(add(a1,a0),add(b1,b0));
		result=add((p2+pow(2*k)),add(sub(p1,(add(p2,p0)))+pow(k),p0));
	}
	return ""+result;
	
   }
  static String k32(String a,String b)
  {
	  int k;
	  String a0,a1,b0,b1,p0,p1,p2,result,res;
	if(a.length()<=32 && b.length()<=32)
	{
		res=mul(a,b);
		return res;
	}
	else
	{
		 if((a.length()%2)!=0)
			  a="0"+a;
		  if((b.length()%2)!=0)
			  b="0"+b;
		  if(a.length()<b.length())
			  a=pow(b.length()-a.length())+a;
		  
		  if(a.length()>b.length())
			  b=pow(a.length()-b.length())+b;
		  
		k=a.length()/2;
		a0=a.substring(k);
		a1=a.substring(0, k);
		b0=b.substring(k);
		b1=b.substring(0,k);
		p0=k32(a0,b0);
		p2=k32(a1,b1);
		p1=k32(add(a1,a0),add(b1,b0));
		result=add((p2+pow(2*k)),add(sub(p1,(add(p2,p0)))+pow(k),p0));
	}
	return ""+result;
	
  }
  static String pow(int k)
  {
	  String a="";
	  for(int i=1;i<=k;i++)
		  a=a+"0";
	  return a;
  }
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
    
}
