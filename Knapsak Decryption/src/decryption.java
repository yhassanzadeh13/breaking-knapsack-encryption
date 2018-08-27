import java.lang.instrument.Instrumentation;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class decryption 
{
	 static ArrayList<symbol> subTable1 = new ArrayList<symbol>();
	 static ArrayList<symbol> subTable2 = new ArrayList<symbol>();


	 public static long mod = 0;
	 static String password = new String();
	 public static void main(String[] args)
	 {
        getInput();
		mod =  (long) Math.pow(2, system.size*system.alphabetSize);
		System.out.println("Started at " + LocalTime.now());
		String passBin = passTable.binaryConvert(password);
		long passDec = Long.parseLong(passBin,2);
//		passTable.loadingFile();

			
		System.out.println("Loading SubTable1");
		for(int i = 0 ; i < system.tableSize / 2 ; i++)
		{
			subTable1.add(passTable.table.get(i));
		}
		
	   
		System.out.println("Loading SubTable2");
		for(int i = system.tableSize / 2 ; i < system.tableSize ; i++)
		{
			subTable2.add(passTable.table.get(i));

		}		
//		System.out.println(system.tableSize);        
		
		int subResultSize =  (int) Math.pow(2, subTable2.size());
		ArrayList<symbol> subResult = new ArrayList<symbol>();
		System.out.println("Calculating the subset sums of subResult started at " + LocalTime.now());
		for(int index = 0 ; index < subResultSize; index++)
		{
			   subResult.add(subSetDecSum(passTable.padding(Long.toBinaryString(index), subTable2.size()), 2));
//			   if(index % 1000000 == 0)
//				   System.out.println("i = " + index / 1000000 + " milion states checked!");
		}
				
		
		System.out.println("Calculating the subset sums of subResult finished at " + LocalTime.now());
		
	    Comparator<symbol> c = new Comparator <symbol>() 
	    		{
			        public int compare(symbol u1, symbol u2) 
			        {
			          return Long.compare(u1.getDec(), u2.getDec());
			        		  
			        }
	    		};
	    			
        System.out.println("Sorting started at " + LocalTime.now());
	    Collections.sort(subResult, c);
        System.out.println("Sorting finished at " + LocalTime.now() );
	    
		int bruteForceSize =  (int) Math.pow(2, subTable1.size());
        System.out.println("Enhanced bruteforce started");
	    for(int i = 0 ; i < bruteForceSize ; i++)
	    {
	    	symbol b = subSetDecSum(passTable.padding(Long.toBinaryString(i), subTable1.size()), 1);

	    	long searchTarget = passDec - b.getDec();
	    	if(searchTarget < 0)
	    	  searchTarget = searchTarget + mod;
	    	else
	    		searchTarget = searchTarget % mod;
	    	
	    	symbol r = new symbol();
	    	r.set(searchTarget);
	    	
	    	int searchIndex = Collections.binarySearch(subResult, r , c);

	    	if(searchIndex >= 0)
	    	{
	    	  //System.out.println(b.getIndex() + " " + subResult2.get(searchIndex).getIndex());
	    	  long plaintext	= r.combineIndex(subResult.get(searchIndex).getIndex(), b.getIndex());    	  
	    	  System.out.println("a match found: " + passTable.asciiConvert(passTable.padding(Long.toBinaryString(plaintext), system.tableSize)));
	    	}
	    	
//			if(i % 1000000 == 0)
//	        	   System.out.println("i = " + i / 1000000);
	    	
	    	
	    }
	    
	    System.out.println("Finished at " + LocalDateTime.now());
	    
	    
	    
		
		
	 }
	
		
		private static symbol subSetDecSum(String index, int st)
		 {
			 
			 long result = 0;
			 symbol p = new symbol();
			 for(int i = 0 ; i < index.length() ; i++)
			 {
				 if(index.charAt(i) == '1')
				 { 
					 if(st == 1)
					 {
						 result = (result + subTable1.get(i).getDec()) % mod;
						 p.set(result);
						 p.combineIndex(p.getIndex(), subTable1.get(i).getIndex());
					 }
				 
					 else
					 {
						 result = (result + subTable2.get(i).getDec()) % mod;
						 p.set(result);
						 p.combineIndex(p.getIndex(), subTable2.get(i).getIndex());
					 }
				 }
			 }

			return p;	  

		 }
		
		private static void getInput()
		{
			 Scanner a = new Scanner(System.in);
			 System.out.println("Enter the name of file (Public Key): ");;
			 String input = a.nextLine();
			 system.tableAddress = input;		 
			 passTable.loadingFile();
			 System.out.println("File loaded");
			 System.out.println("Enter the encrypted password: ");
			 input = a.nextLine();
			 password = input;
		}
		 	
		
}
