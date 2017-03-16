import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Communicator {
	private String[] data = null;
	private String ip;
	private int port;
	
	public Communicator(String ip, int port){
		this.ip = ip;
		this.port = port;
	}	
	
	public void standByForIncData(){
		try {
			ServerSocket ser = new ServerSocket(port);
			Socket soc = ser.accept();
			
			InputStream o = soc.getInputStream();
	        ObjectInput s = new ObjectInputStream(o);
	        
	        data = (String[]) s.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg){
		try {
	          // Create a socket
	          Socket soc = new Socket(ip, port);

	          // Serialize today's date to a outputstream associated to the socket
	          OutputStream o = soc.getOutputStream();
	          ObjectOutput s = new ObjectOutputStream(o);

	          s.writeObject(msg);
	          s.flush();
	          s.close();
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	          System.out.println("Error during serialization");
	          System.exit(1);
	      }
	}
	
	
	public String[] getDataArray(){
		return data;
	}
}
