
public class mainserver1
{
	public static void main(String arr[]) throws Exception
	{
		mainthread mt=new mainthread();
		mt.start();
	}
}
class mainthread extends Thread
{
	public void run()
	{
		FileTransferClient c=new FileTransferClient();
		c.start();
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			
		}
		mainthread mt=new mainthread();
		mt.start();
		
	}
}