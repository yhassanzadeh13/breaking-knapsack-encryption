import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class passTable 
{
	public static ArrayList<symbol> table = new ArrayList<symbol>();  
	
	public static void loadingFile()
	{
		try 
		{   
			//System.out.println(system.tableAddress + " is loading!");
			BufferedReader  in	 = new BufferedReader(new FileReader(system.tableAddress));
			String line = in.readLine();
			for(int i = 0; line != null; i++)
			{
//				if(line.length() != system.size)
//				{
//					System.out.println("Mismatch error: The system size is not equal to the length of passwords");
//					System.out.println("System size = " + system.size +"  password size in " + system.tableAddress + " is = " + line.length());
//					System.exit(0);
//				}
				if(i == 0)
				{
					system.size = line.length();
					System.out.println("System size is set to " + system.size);
				}
				symbol p = new symbol();
				p.set(Long.parseLong(binaryConvert(line),2));
				p.initIndex(i);
//				System.out.println(passTable.padding(Long.toBinaryString(p.getIndex()), 25));
				table.add(p);
			    line = in.readLine();
			}
			
			system.tableSize = table.size();
//			System.out.println("tablesize " + table.size() );
			in.close();
			
		} 
		
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	
	public static String binaryConvert(String line)
	{
		int decBuffer = 0;
		String binBuffer = new String();
		for(int i = 0 ; i < line.length() ; i++)
			if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
			{
				decBuffer = (int)(line.charAt(i)) - 97;
				binBuffer = binBuffer + padding(Integer.toBinaryString(decBuffer));
			}
			else if(line.charAt(i) >= '0' && line.charAt(i) <= '5')
			{
				decBuffer = (int)(line.charAt(i)) - 22;
				binBuffer = binBuffer + padding(Integer.toBinaryString(decBuffer));
			}
			else
			{
				System.out.println("Illigal Charachter!: ");
				System.out.println("File name: " + system.tableAddress);
				System.out.println("Line: " + line);
				System.out.println("Char: " + line.charAt(i));
				System.out.println("All chars must be between a-z or 1-6");
				System.exit(0);
			}
				
		return binBuffer;			
	}
	
	public static String asciiConvert(String binaryString)
	{
		String[] Split = binaryString.split("(?<=\\G.{5})");
		int decBuffer = 0;
		char charBuffer = 0;
		String result = new String();
		for(int i = 0 ; i < Split.length ; i++)
		{
			decBuffer = Integer.parseInt(Split[i], 2);
			if(decBuffer >= 0 && decBuffer <= 25) // a-z
				charBuffer = (char) (decBuffer + 97);       
			else                                  // 0-5
				charBuffer = (char) (decBuffer + 22);
			
			result = result + charBuffer;
		}
		
		return result;
	}
	
	
	static String padding(String binaryString)
	{
	
		while(binaryString.length() < system.alphabetSize)
			binaryString = "0" + binaryString;

		return binaryString;
	}
	
	static String padding(String binaryString, int size)
	{
		
		while(binaryString.length() < size)
			binaryString = "0" + binaryString;
		
		
		return binaryString;
	}
	
	
//	public static String add(String a, String b)
//	{
//		char carry = '0';
//		//System.out.println("c = " + carry);
//		//System.out.println(carry);
//		if(a.length() != system.size * system.alphabetSize && b.length() != system.size * system.alphabetSize)
//		{
//			System.out.println("Addition Error: ");
//			System.out.println("Length mismatch: ");
//			System.out.println(a);
//			System.out.println(b);
//			System.exit(0);
//		}
//		
//		String result = new String();
//		//System.out.println(result);
//		for(int i = a.length()-1 ; i >= 0  ; i--)
//		{
//		   if(a.charAt(i) == '0' && b.charAt(i) == '0')
//		   {
//				   result = carry + result;
//				   carry  = '0';
//				   //System.out.println(result);
//		   }
//		   
//		   else if((a.charAt(i) == '0' && b.charAt(i) == '1')
//				   ||(a.charAt(i) == '1' && b.charAt(i) == '0'))
//		   {
//				 if(carry == '0')
//			         result = '1' + result;
//				 else
//					 result = '0' + result;
//				 
//				 
//		   }
//		   
//		   else if(a.charAt(i) == '1' && b.charAt(i) == '1')
//		   {
//			   if(carry == '0')
//			   {
//				   result = '0' + result;
//				   carry = '1';
//			   }
//			   
//			   else
//			   {
//				   result = '1' + result;
//				   carry = '1';
//			   }
//		   }
//		   
//		}
//		
//		
//		return result;
//	}
	

}
