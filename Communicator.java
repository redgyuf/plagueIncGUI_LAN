import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import server.Message;

public class Communicator {
	private Message data = null;
	private String ip;
	private int port;
	private Socket soc;
	private Client clientGUI;
	private int myID = -1;
	
	public Communicator(String ip, int port, Client clientGUI){
		this.ip = ip;
		this.port = port;
		this.clientGUI=clientGUI;
		try {
			this.soc = new Socket("192.168.150.98", 8020);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void standByForIncData(){
		try {
			System.out.println("Olvasoban vagyok");
			InputStream o = soc.getInputStream();
	        ObjectInput s = new ObjectInputStream(o);
	        soc.setSoTimeout(0);
	        
	        data = (Message) s.readObject();
	        System.out.println(data.toString());
	        if(myID == -1){
	        	myID = data.getPlayerID();
	        }	        
	        clientGUI.setCurrentPlayerCards(data);
			
	        
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getMyID() {
		return myID;
	}

	public void sendMessage(){
		try {
	          // Create a socket
	          Message msg = new Message();

	          // Serialize today's date to a outputstream associated to the socket
	          OutputStream o = soc.getOutputStream();
	          ObjectOutput s = new ObjectOutputStream(o);
	          
	          msg.setChoosedStat(clientGUI.getChoosedStat());
	          System.out.println("Küldtem");
	          s.writeObject(msg);
	          s.flush();
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	          System.out.println("Error during serialization");
	      }
		
		standByForIncData();
	}
	
	
	public Message getDataArray(){
		return data;
	}
}
