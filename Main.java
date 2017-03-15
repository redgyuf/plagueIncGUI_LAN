import org.eclipse.swt.SWT;

public class Main {

	public static void main(String[] args) {
		String[] data = null;
		
		
		try {
			Client window = new Client();
			ChooseStat popup = new ChooseStat(window);
			window.open(data, popup);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
