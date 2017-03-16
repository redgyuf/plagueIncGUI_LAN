

public class Main {

	public static void main(String[] args) { 
		String[] data = null;
		
		
		
		try {
			Client window = new Client();
			ChooseStat popup = new ChooseStat();
			Communicator cm = new Communicator("127.0.0.1", 8020, window);
			window.setCm(cm);
			popup.setMainWindow(window);
			popup.setCm(cm);
			window.open(data, popup);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
