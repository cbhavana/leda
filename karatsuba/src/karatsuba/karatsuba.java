package karatsuba;

import java.util.Scanner;

public class karatsuba {

	public static void main(String[] args)
	{
		String a="8888",b="4",n,res="";
		int j,flag=0;
		 if(a.charAt(0)=='-') 
         {
         a=a.substring(1,a.length());
         flag++;
        }
    if(b.charAt(0)=='-')
        {
    	 b=b.substring(1,b.length());
        flag++;
        }
      if(a.charAt(0)=='-' && b.charAt(0)=='-' )
         {
    	  a=a.substring(1,a.length());
    	  b=b.substring(1,b.length());
         }
		n=recur(a,b);
		for(int i=0;i<n.length();i++)
		{
			if(n.charAt(i)!='0')
                {
			res=n.substring(i,n.length());
            break;
            }
		}
        if(flag==1)
            res="-"+res;
		System.out.println(res);
		
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
  static String recur(String a,String b)
   {
	  int res,k;
	  String a0,a1,b0,b1,p0,p1,p2,result;
	 
	  
	if(a.length()==1 && b.length()==1)
	{
		res=Integer.parseInt(a)*Integer.parseInt(b);
		return ""+res;
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
		p0=recur(a0,b0);
		p2=recur(a1,b1);
		p1=recur(add(a1,a0),add(b1,b0));
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
