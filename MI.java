
import java.util.*;
import java.io.*;
public class MI 
{
	
	public void run()
	{
		try{
Runtime rt = Runtime.getRuntime();

Process proc = rt.exec("javac cool.java");

BufferedReader stdInput = new BufferedReader(new 
     InputStreamReader(proc.getInputStream()));

BufferedReader stdError = new BufferedReader(new 
     InputStreamReader(proc.getErrorStream()));



String s = null;
while ((s = stdInput.readLine()) != null) {
    System.out.println(s);
	
}
File f = new File("Output.txt");
		FileOutputStream fos = new FileOutputStream(f); 
		PrintWriter pw = new PrintWriter(fos);


while ((s = stdError.readLine()) != null) {
    System.out.println(s);
	

		pw 	.write(s);
		
	
		}
pw.flush();
		fos.close();
		
		pw.close();
		
		
		}
		catch(Exception ex)
{
	
}
FileTransferServer s=new FileTransferServer();
		s.start();
	}
}