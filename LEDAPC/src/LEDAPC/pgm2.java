package LEDAPC;

import java.util.*;

class Node
{
	int cgpa;
	Node next;
   public Node()
   {
	   this.cgpa=0;
	   this.next=null;
   }
   public Node(int data,Node next)
   {
	   this.cgpa=data;
	   this.next=next;
   }
   public void setnext(Node l)
   {
	   next=l;
	   
   }
   public void setcgpa(int d)
   {
	   cgpa=d;
	   
   }
   public Node getnext()
   {
	   return next;
	   
   }
   public int getcgpa()
   {
	   return cgpa;
	   
   }
}
class linkedlist {
	
	Node start;
	Node end;
	int size;
    public linkedlist()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return start == null;
    }
    
    public int getSize()
    {
        return size;
    }  
    
    public void insertAtPos(int val,int pos)
    {
    	Node n=new Node(val,null);
    	Node ptr=start;
    	if(start==null)
    	{
    		start=n;
    		end=start;
    		size++;
    		return;
    	}
    	pos=pos-1;
    	if(pos==0)
    	{
            n.setnext(start);
            start = n;
            size++;
    		return;
    	}
    	if(pos==size)
    	{
            end.setnext(n);
            end = n;
            size++;
    		return;
    	}
    	//System.out.println("hi1");
    	for(int i=1;i<size;i++)
    	{
    		if(i==pos)
    		{
    			Node tmp=ptr.getnext();
    			ptr.setnext(n);
    			n.setnext(tmp);
    			size++;
    			//System.out.println("hi2");
    			break;
    		}
    		ptr=ptr.getnext();
    	}
    	
    }
    public void delAtPos(int pos)
    {
    	 
 	   Node ptr=start;
 	  Node temp=new Node(0,null); 
 	  if(pos==1)
 	  {
 		  start=start.getnext();
          size--;
          return;
 	  }
 	   for(int i=1;i<=size;i++)
 	   {
 		  
 		   if(i==pos-1)
 		   {
 			    temp=ptr;
 		   }
 		   if(i==pos)
 		   {
 			   temp.setnext(ptr.getnext());
 		   }
 		  ptr=ptr.getnext();
 		  
 	   }
 	   size--;
    }
    
    public void display()
    {
        //System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            
            return;
        }    
        if (start.getnext() == null) 
        {
        	//System.out.println("hi");
            System.out.println(start.getcgpa());
            return;
        }
        Node ptr = start;
        System.out.print(start.getcgpa()+ "->");
        ptr = start.getnext();
        while (ptr.getnext() != null)
        {
            System.out.print(ptr.getcgpa()+ "->");
            ptr = ptr.getnext();
        }
        System.out.print(ptr.getcgpa()+ "\n");
    }

}
public class pgm2 {
	
	public static void main(String[] args)
	{
	
		Scanner in=new Scanner(System.in);
		int k=in.nextInt();
		String s=in.next();
		int i=1,m;
		Node a=new Node();
		Node b=new Node();
		linkedlist list=new linkedlist();
		linkedlist sortedlist=new linkedlist();
		for(String n:s.split(","))
		{
			m=Integer.parseInt(n);
			list.insertAtPos(m,i);
			i++;
		}
		list.display();
		a=list.start;
		b=list.start.getnext();
		for(int j=1;j<list.getSize();j++)
		{
			for(i=1;i<=list.getSize();i++)
			{
				if(a.getcgpa()>b.getcgpa())
				{
					a=b;
				}
				b.getnext();
			}
			sortedlist.insertAtPos(j,a.getcgpa());
			a=a.getnext();
			b=a.getnext();
			if(b==null)
			{
				break;
			}
		}
		sortedlist.display();
	}

}
