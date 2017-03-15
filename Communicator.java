import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
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
	
	
	public String[] getDataArray(){
		return data;
	}
}
