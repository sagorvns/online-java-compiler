
import java.util.*;
import java.io.*;
 
class test
{
  public static void main(String[] args)
  {

																													Runtime rs=Runtime.getRuntime();
																													try 
	System.out.println("HEllo");																												{
																														 rs.exec("javac tt.java");
																													  rs.exec("java tt"); 
																													}
																													catch (IOException ex) 
																													{
																													  System.out.println(ex);
																													} 
	}																												
																												}
}