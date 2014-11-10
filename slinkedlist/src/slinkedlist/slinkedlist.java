package slinkedlist;
//sll without dummy node

 import java.io.*;
 import java.util.*;
class Node
{
	int data;
	Node link;
   public Node()
   {
	   this.data=0;
	   this.link=null;
   }
   public Node(int data,Node link)
   {
	   this.data=data;
	   this.link=link;
   }
   public void setLink(Node l)
   {
	   link=l;
	   
   }
   public void setData(int d)
   {
	   data=d;
	   
   }
   public Node getLink()
   {
	   return link;
	   
   }
   public int getData()
   {
	   return data;
	   
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
            n.setLink(start);
            start = n;
            size++;
    		return;
    	}
    	if(pos==size)
    	{
            end.setLink(n);
            end = n;
            size++;
    		return;
    	}
    	System.out.println("hi1");
    	for(int i=1;i<size;i++)
    	{
    		if(i==pos)
    		{
    			Node tmp=ptr.getLink();
    			ptr.setLink(n);
    			n.setLink(tmp);
    			size++;
    			System.out.println("hi2");
    			break;
    		}
    		ptr=ptr.getLink();
    	}
    	
    }
    public void delAtPos(int pos)
    {
    	 
 	   Node ptr=start;
 	  Node temp=new Node(0,null); 
 	  if(pos==1)
 	  {
 		  start=start.getLink();
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
 			   temp.setLink(ptr.getLink());
 		   }
 		  ptr=ptr.getLink();
 		  
 	   }
 	   size--;
    }
    
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            
            return;
        }    
        if (start.getLink() == null) 
        {
        	System.out.println("hi");
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }

}


public class slinkedlist{

    public static void main(String[] args)

    {             

        Scanner scan = new Scanner(System.in);
       int pos=1,i=1;
       char ch;
        /* Creating object of class linkedList */

        linkedlist list = new linkedlist(); 
         
        System.out.println("Singly Linked List Test\n");          

            System.out.println("1. insert at begining");
           for(i=1;i<=5;i++)
            {
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                list.insertAtPos(num, pos);
                
            }
           list.insertAtPos(10,1);
               /* System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);                                        
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");*/
           System.out.println("1. insert at middle");
           int num = scan.nextInt();
           pos=3;
           list.insertAtPos(num, pos);
            list.display();
            System.out.println("enter a number to delete at positon");
             num = scan.nextInt();
             list.delAtPos(num);
             list.display();
    }
}


