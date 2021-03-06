import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiServer {
	

	public static void main(String[] args) throws IOException{
		final ServerSocket server= new ServerSocket(7000);
		System.out.println(new Date()+"-->Server waits for clients...");
		
		while(true)	{
			final Socket socket=server.accept();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					String clientAddress="";
					try{
						clientAddress=socket.getInetAddress()+":"+socket.getPort();
						System.out.println(new Date()+"-->Client connected from "+ clientAddress);
						DataInputStream inputStream=new DataInputStream(socket.getInputStream());
						PrintStream outputStream=new PrintStream(socket.getOutputStream());
						outputStream.println("Welcom to server!");
						
						String line="";
						while(!line.equals("goodbye")) {
							line=inputStream.readLine();
							outputStream.println(line);
							System.out.println(new Date() + ": "+line);
						}
					}catch(IOException e) {System.err.println(e);}}
				}).start();
				}
				}			
}