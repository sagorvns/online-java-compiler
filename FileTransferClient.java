
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class FileTransferClient extends Thread
 { 
    
    //public static void main(Strin[] args) throws Exception{
      public void run()
	  {
try{		  
        
		ServerSocket ssock = new ServerSocket(1111);
		Socket socket = ssock.accept();
        byte[] contents = new byte[10000];
        
        
        FileOutputStream fos = new FileOutputStream("C:\\Users\\sms\\Desktop\\server1\\cool.java");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        
        
        int bytesRead = 0; 
        
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead); 
        
        bos.flush(); 
        socket.close(); 
        
        System.out.println("File saved successfully!");
						
		
}
catch(Exception ex)
{
	//System.out.print(ex.getMessage());
}
/*try
		{
			Thread.sleep(8000);
		}
		catch(Exception ex)
		{
			
		}*/
MI m=new MI();
m.run();
    }
}