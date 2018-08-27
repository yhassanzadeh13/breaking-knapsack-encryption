//
//public class validityCheck
//{
//  private static boolean[][] validityTable;
//  private static boolean validityCreation = false;
//  public static boolean check(String binPass)
//  {
//	  long decPass = Long.parseLong(binPass,2);
//	  
//	  if(system.tableSize > 0)
//	  {
//	  	validityTable = new boolean[system.tableSize][(int) (decPass+1)];
//	  	validityCreation = true;
//	  }
//	  
//	  else
//	  {
//		  System.out.println("Error: Wrong time for creating the validity table!");
//		  System.out.println("The pass table was not loaded form " + system.tableAddress);
//	  }
//	  
//	  
//	  
//	  for(int j = 0 ; j <= decPass ; j++)
//	  {
//		  if(j == passTable.table.get(0).getDec())
//			  validityTable[0][j] = true;
//		  
//		  else
//			  validityTable[0][j] = false;
//	  }
//	  
//	  for(int i = 1; i < system.tableSize ; i++)
//		  for(int j = 0 ; j <= decPass ; j++)
//		  {
//			 if(j == passTable.table.get(i).getDec())
//				 validityTable[i][j] = true; 
//			 
//			 else
//			   validityTable[i][j] = validityTable[i-1][j];
//			 
//			 
//			 if(j >= passTable.table.get(i).getDec()  && validityTable[i][j] == false)
//				 validityTable[i][j] = validityTable[i-1][(int) (j - passTable.table.get(i).getDec())];
//
//		  }
//	  
//	  return validityTable[system.tableSize-1][(int) decPass];
//		  
//	  
//  }
//  
//
//  
//  
//}
