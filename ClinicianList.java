import java.io.*;
import java.util.*;
public class ClinicianList 
/*
 * @Author Christopher Lopez
 * */
{
	private static CNode head = null;
	private int size;
 
	private static class CNode // ClinicianNode
	{
		
		private CNode next = null;
		private int CID;   // ClinicianID
		private String ins;//institution
		private String name;
		private int vacInv; // Vaccine inventory
		
		
		
		private int size = 0;public CNode(String name,String ins,
			     int CID,int vacInv)
	{
		this.name = name;
		this.CID = CID;
       this.next = null;
       this.ins = ins;
       this.vacInv = vacInv;
   }
		
		public CNode(String name,String ins,
				int CID,int vacInv, CNode next)
		{
			this.name = name;
			this.CID = CID;
            this.next = next;
            this.ins = ins;
            this.vacInv = vacInv;
        }
		
		
		public CNode()
	{
		this.name = null;
		this.CID = 0;
       this.next =null;
       this.ins = null;
       this.vacInv = 0;
   }
		
		
		
		
		
	}
	
	
	
	// add the the list 
	 
		 public  void  addFirst(String name, String ins, int CID, int vacInv)
			{
			// Create a new node with given data
			CNode new_node = new CNode(name, ins, CID, vacInv);
			new_node.next = null;
			
			// If the Linked List is empty,
			// then make the new node as head
			if (head == null) {
			head = new_node;
			}
			else {
			// Else traverse till the last node
			// and insert the new_node there
			CNode last = head;
			while (last.next != null) {
			last = last.next;
			}
			
			// Insert the new_node at last node
			last.next = new_node;
			}
			
			
			}
					 ///////////////////get all information regarding an entity
		 public static void getInfo() 
			{
				
				CNode current =  head;
				if (current.next == null) 
				{
					System.out.println(current.name+" "+ current.ins + " ID:" + current.CID+ " In Stock: "+ current.vacInv);
				}else {
				while(current.next!= null) 
				{
					System.out.println(current.name+" "+ current.ins + " ID:" + current.CID+ " In Stock: "+ current.vacInv);
					current = current.next;
				
				}System.out.println(current.name+" "+ current.ins + " ID:" + current.CID+ " In Stock: "+ current.vacInv);
				}
			} 
	 ///////////////////////////////////// update Invetory 
		 public void updateInv(String Cname, int Inv) 
		    { 
			
			if (Inv < 0)
			{
				System.out.println("Number must be positive");
				
			} else
			{
				
			
		      CNode ref = head;
		      // checks if head is empty 
		      if (ref == null)
		      {//System.out.println("0"); // test
		    	 return;     
		    	 // checks if head next is empty
		       }else if (ref.next == null) 
		      {
		    	   if (ref.name.equals(Cname))
			    	  {
			    		 // removes value
			     ref.vacInv = Inv;
			     // System.out.println("1"); // test 
			    		 return;
			    	  }
		    	 
		      }
		      // check if head next next is empty
		      while(ref.next!= null) 
		      {
		    	// check input versus current name value in list
		    	 if (ref.name.equals(Cname))
		    	  {
		    		 // removes value
		    		 ref.vacInv = Inv;
		   //   System.out.println("2"); // test 
		    		  break;
		    	  }ref = ref.next;
		    	  if (ref.next == null) 
			      {
			    	   if (ref.name.equals(Cname))
				    	  {
				    		 // removes value
			    		   ref.vacInv = Inv;
				   //   System.out.println("1"); // test 
				    		 return;
				    	  }}
		    	 // System.out.println("3"); // test 
		      }
		    //  System.out.println("4"); // test 
		    //  ref.next = null ;
		      
		      
		      return;
		      
			}  
		    } 
	/////////////////////////////////// // getNames needs work
	
	public static void getNames() 
	{
		
		CNode current =  head;
		while(current.next!= null) 
		{
			System.out.println(current.name);
			current = current.next;
		
		}System.out.println(current.name);
		
	} 
	////////////////////////////////////// Get inst
	public static void getIns() 
	{
		
		CNode current =  head;
		while(current.next!= null) 
		{
			System.out.println(current.name+" "+ current.ins);
			current = current.next;
		
		}System.out.println(current.name+ " "+current.ins);
		
	} 
	  //////////////////////////////////////// // remove name
	 public void removeName(String Cname) 
	    { 
		
	      CNode ref = head;
	      // checks if head is empty 
	      if (ref == null)
	      {//System.out.println("0"); // test
	    	 return;     
	    	 // checks if head next is empty
	       }else if (ref.next == null) 
	      {
	    	  // System.out.println("1"); // test 
	    	  head = null ;
	    	  return;
	      }
	      // check if head next next is empty
	      while(ref.next.next!= null) 
	      {
	    	// check input versus current name value in list
	    	 if (ref.name.equals(Cname))
	    	  {
	    		 // removes value
	      head.next = head.next.next;
	   //   System.out.println("2"); // test 
	    		  break;
	    	  }ref = ref.next;
	    //	  System.out.println("3"); // test 
	      }
	   //   System.out.println("4"); // test 
	      ref.next = null ;
	      
	      
	      return;
	      
	    		  
	    } 
	 // end
	 
	 
	 
	 ////////////////////////////////// Attempt to update information 
	
		 public void updateIns(String Cname, String inst) 
		
			
		
			{
				
			
		      CNode ref = head;
		      // checks if head is empty 
		      if (ref == null)
		      {//System.out.println("0"); // test
		    	 return;     
		    	 // checks if head next is empty
		       }else if (ref.next == null) 
		      {
		    	   if (ref.name.equals(Cname))
			    	  {
			    		 // removes value
			     ref.ins =inst;
			    //  System.out.println("1"); // test 
			    		 return;
			    	  }
		    	 
		      }
		      // check if head next next is empty
		      while(ref.next!= null) 
		      {
		    	// check input versus current name value in list
		    	 if (ref.name.equals(Cname))
		    	  {
		    		 // removes value
		     ref.ins = inst;
		    //  System.out.println("2"); // test 
		    		  break;
		    	  }ref = ref.next;
		    	  if (ref.next == null) 
			      {
			    	   if (ref.name.equals(Cname))
				    	  {
				    		 // removes value
				     ref.ins = inst;
				 //     System.out.println("1"); // test 
				    		 return;
				    	  }}
		    	//  System.out.println("3"); // test 
		      }
		   //   System.out.println("4"); // test 
		    //  ref.next = null ;
		      
		      
		      return;
		      
			}  
		    
		    
	//////////////////////////////////////// // update CID
	 public void updateCID(String Cname, int CID) 
	    
		{
			
		
	      CNode ref = head;
	      // checks if head is empty 
	      if (ref == null)
	      {//System.out.println("0"); // test
	    	 return;     
	    	 // checks if head next is empty
	       }else if (ref.next == null) 
	      {
	    	   if (ref.name.equals(Cname))
		    	  {
		    		 // removes value
		     ref.CID = CID;
		      System.out.println("1"); // test 
		    		 return;
		    	  }
	    	 
	      }
	      // check if head next next is empty
	      while(ref.next!= null) 
	      {
	    	// check input versus current name value in list
	    	 if (ref.name.equals(Cname))
	    	  {
	    		 // removes value
	     ref.CID = CID;
	   //   System.out.println("2"); // test 
	    		  break;
	    	  }ref = ref.next;
	    	  if (ref.next == null) 
		      {
		    	   if (ref.name.equals(Cname))
			    	  {
			    		 // removes value
			     ref.CID = CID;
			  //    System.out.println("1"); // test 
			    		 return;
			    	  }}
	    	//  System.out.println("3"); // test 
	      }
	    //  System.out.println("4"); // test 
	    //  ref.next = null ;
	      
	      
	      return;
	      
		}  
	    
	 
	 
	 
	 
	 
	 
	 
	 
	// returns the whole list as an array 
	
	public String toString()
	{
        String s = "";
        String ins = "";
        String ID = "";
        String Vac = "";
        CNode current = head;
       while (current.next != null)
        {
    	  // ID += current.CID;
    	   //ins += current.ins;
            s +=" "+current.name +" "+current.ins +" ID: " + current.CID  +" Stock: "+ current.vacInv;
          //  Vac +=current.vacInv;
            if (current.next!= null) 
            {
            //	Vac += ", ";
            	//ins += ", ";
            	s += ",\n";
            	//ID += ", ";
            } current = current.next;
            
         //  
        }  s +=" " +current.name +" "+current.ins +" ID: " + current.CID  +" Stock: "+ current.vacInv;
     
        return s;
       
    }
	
	
	public int getCID(String Cname) 
	{
		

		 CNode ref = head;
	      // checks if head is empty 
	      if (ref == null)
	      {//System.out.println("0"); // test
	    	 return 0;     
	    	 // checks if head next is empty
	       }else if (ref.next == null) 
	      {
	    	   if (ref.name.equals(Cname))
		    	  {
		    		 // removes value
		
		      //System.out.println("1"); // test 
		    		 return ref.CID;
		    	  }
	    	 
	      }
	      // check if head next next is empty
	      while(ref.next!= null) 
	      {
	    	// check input versus current name value in list
	    	 if (ref.name.equals(Cname))
	    	  {
	    		 // removes value
	    		 return ref.CID;
	    	  }ref = ref.next;
	    	  if (ref.next == null) 
		      {
		    	   if (ref.name.equals(Cname))
			    	  {
			    		 // removes value
		    		   return ref.CID;
			    		
			    	  }}
	    	  //System.out.println("3"); // test 
	      }
	      //System.out.println("4"); // test 
	    //  ref.next = null ;
	      
	      
	      return 0;
	        
	      
	  
	    		  
	 } 
	
	
	}
	
	
	

