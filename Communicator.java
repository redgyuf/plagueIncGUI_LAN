import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.Message;

public class Communicator {
	private Message data = null;
	private String ip;
	private int port;
	private Socket soc;
	private Client clientGUI;
	private int myID = -1;
	private InputStream o;
	private ObjectInput s;

	public Communicator(String ip, int port, Client clientGUI) {
		this.ip = ip;
		this.port = port;
		this.clientGUI = clientGUI;
		try {
			Scanner sc = new Scanner(System.in);
			int port1 = sc.nextInt();
			this.soc = new Socket("192.168.150.98", port1);
			System.out.println("soc");
			o = soc.getInputStream();
			System.out.println("is");
			s = new ObjectInputStream(o);
			System.out.println("os");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void standByForIncData() {
		try {
			System.out.println("Olvasoban vagyok");
			System.out.println("is");
			System.out.println("os");
			soc.setSoTimeout(0);
			System.out.println("to");

			data = (Message) s.readObject();
			System.out.println(data.toString());
			if (myID == -1) {
				myID = data.getPlayerID();
			}
			clientGUI.setCurrentPlayerCards(data);
			Thread.sleep(1000);

		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getMyID() {
		return myID;
	}

	public void sendMessage() {
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

	public Message getDataArray() {
		return data;
	}
}
