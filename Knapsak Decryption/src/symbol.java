import java.math.*;

public class symbol
{

  private long   decRep = 0; //decimal representation of the symbol
  private long   index  = 0;

  
  public void set(long pass)
  {
	  decRep = pass;
  }
    
  public long getDec()  
  {
	  return decRep;
  }
  
  public void initIndex(int k)
  {
	  index = (long)Math.pow(2, system.alphabetSize*system.size - k - 1);
  }
  
  public long combineIndex(long i1, long i2)
  {
//	  System.out.println("Combining:");
//	  System.out.println(passTable.padding(Long.toBinaryString(i1), system.tableSize));
//	  System.out.println(passTable.padding(Long.toBinaryString(i2), system.tableSize));
//	  System.out.println(passTable.asciiConvert(passTable.padding(Long.toBinaryString(i1), system.tableSize)));
//	  System.out.println(passTable.asciiConvert(passTable.padding(Long.toBinaryString(i2), system.tableSize)));
	  if(i1 == 0)
	  {
		  index = i2;
		  return index;
	  }
	  
	  else if(i2 == 0)
	  {
		  index = i1;
		  return index;
	  }
	  
      index = i1 | i2;
	  
//      System.out.println(passTable.padding(Long.toBinaryString(index), system.tableSize));
	  return index;
  }
  
  public long getIndex()
  {
	  return index;
  }
  
 
}
