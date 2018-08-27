
public class subsetsum 
{

  private static boolean[][] validityTable;
  private static boolean validityCreation = false;
  public static boolean check()
  {
	  
	  
	  	validityTable = new boolean[4][11];
	  	validityCreation = true;
	  
     int[] c = {-3,-2,-1,0,1,2,3,4,5,6,7};
     int[] r = {1,-3,2,4};
	  
	  
	  for(int j = 0 ; j < 11 ; j++)
	  {
		  if(c[j] == r[0])
			  validityTable[0][j] = true;
		  
		  else
			  validityTable[0][j] = false;
	  }
	  
	  for(int i = 1 ; i < 4 ; i++)
		  for(int j = 0 ; j < 11 ; j++)
		  {
			 if(c[j] == r[i])
				 validityTable[i][j] = true; 
			 
			 else
			   validityTable[i][j] = validityTable[i-1][j];
			 
			 
			 if(validityTable[i][j] == false)
			 {
				 
				 for(int k = 0; k < 11 ; k++)
				 {
			        if(c[k] == c[j] - r[i])
			        {
					  validityTable[i][j] = validityTable[i-1][k];
					  break;
			        }
				 }
			 }

		  }
	  
	  return validityTable[3][10];
		  
	  
  }
  
  public static void tablePrint()
  {
	  
	  for(int i = 0; i < 4 ; i++)
	  {
		  for(int j = 0 ; j < 11 ; j++)
		  {
			  if(validityTable[i][j] == false)
				  System.out.print("F\t");
			  else
				  System.out.print("T\t");
		  }
		  System.out.println();
	  }
  }
  
  


}
