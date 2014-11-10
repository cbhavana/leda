package slinkedlist;
//dll without dummy node

import java.util.Scanner;

class Nodes
{
	int data;
	Nodes next;
	Nodes prev;
   public Nodes()
   {
	   this.data=0;
	   this.next=null;
	   this.prev=null;
   }
   public Nodes(int data,Nodes prev,Nodes next)
   {
	   this.data=data;
	   this.next=next;
	   this.prev=prev;
   }
   public void setnext(Nodes n)
   {
	   next=n;
	   
   }
   public void setprev(Nodes p)
   {
	   prev=p;
	   
   }
   public void setData(int d)
   {
	   data=d;
	   
   }
   public Nodes getnext()
   {
	   return next;
	   
   }
   public Nodes getprev()
   {
	   return prev;
	   
   }
   public int getData()
   {
	   return data;
	   
   }
}

class doublinkedlist{
	
	Nodes start;
	Nodes end;
	int size;
    public doublinkedlist()
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
    	Nodes n=new Nodes(val,null,null);
    	Nodes ptr=start;
    	if(start==null)
    	{
    		start=n;
    		end=start;
    		size++;
    		return;
    	}
    	if(pos!=0)
    	pos=pos-1;
    	if(pos==0)
    	{
            n.setnext(start);
            start.setprev(n);
            start = n;
            size++;
    		return;
    	}
    	if(pos==size)
    	{
            end.setnext(n);
            n.setprev(end);
            end = n;
            size++;
    		return;
    	}
    	System.out.println("hi1");
    	for(int i=1;i<size;i++)
    	{
    		if(i==pos)
    		{
    			Nodes tmp=ptr.getnext();
    			ptr.setnext(n);
    			n.setnext(tmp);
    			tmp.setprev(n);
    			size++;
    			System.out.println("hi2");
    			break;
    		}
    		ptr=ptr.getnext();
    	}
    	
    }
    public void delAtPos(int pos)
    {
    	 
 	   Nodes ptr=start;
 	  Nodes temp=new Nodes(0,null,null);
 	 Nodes temp1=new Nodes(0,null,null);
 	  if(pos==1)
 	  {
 		  start=start.getnext();
 		  start.setprev(null);
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
 			   temp1=ptr.getnext();
 			   temp1.setprev(temp);
 		   }
 		  ptr=ptr.getnext();
 		  
 	   }
    }
    
    public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getnext() == null) 
        {
        	//System.out.println("hi");
            System.out.println(start.getData());
            return;
        }
        Nodes ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getnext();
        while (ptr.getnext() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getnext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
public class dlinkedlist {
	  public static void main(String[] args)

	    {             

	        Scanner scan = new Scanner(System.in);
	       int pos=1,i=1;
	       char ch;
	        /* Creating object of class linkedList */

	        doublinkedlist lists = new doublinkedlist(); 
	         
	        do
	        {
	            System.out.println("\nDoubly Linked List Operations\n");
	            System.out.println("1. insert at position");
	            System.out.println("2. delete at position");
	            System.out.println("3. check empty");
	            System.out.println("4. get size");            
	            System.out.println("\nSingle Linked List Operations\n");
	            System.out.println("5. insert at position");
	            System.out.println("6. delete at position");
	            System.out.println("7. check empty");
	            System.out.println("8. get size");            
	            int choice = scan.nextInt();
	            switch (choice)
	            {             
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                int num = scan.nextInt() ;
	                System.out.println("Enter position");
	                 pos = scan.nextInt() ;
	               /* if (pos <= 1 || pos > lists.getSize() )
	                    System.out.println("Invalid position\n");
	                else*/
	                    lists.insertAtPos(num, pos);
	                break;                                          
	            case 2 : 
	                System.out.println("Enter position");
	                int p = scan.nextInt() ;
	                if (p < 1 || p > lists.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                    lists.delAtPos(p);
	                break;
	            case 3 : 
	                System.out.println("Empty status = "+ lists.isEmpty());
	                break;                   
	            case 4 : 
	                System.out.println("Size = "+ lists.getSize() +" \n");
	                break;                         
	             default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            lists.display();
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);                        
	        } while (ch == 'Y'|| ch == 'y');   
	    }

}
