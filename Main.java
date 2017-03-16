import org.eclipse.swt.SWT;

public class Main {

	public static void main(String[] args) { 
		String[] data = null;
		Communicator cm = new Communicator("127.0.0.0", 8020);
		
		
		try {
			Client window = new Client();
			ChooseStat popup = new ChooseStat();
			window.setCm(cm);
			popup.setMainWindow(window);
			window.open(data, popup);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
