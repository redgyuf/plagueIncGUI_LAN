import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ProgressBar;

import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CLabel;

public class ChooseStat {
	private Client mainWindow;
	
	public ChooseStat(Client window) {
		this.mainWindow = window;
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(600, 120);
		shell.setText("Plague Inc. ChooseStat");
		shell.setLocation(mainWindow.getShell().toDisplay(100, 0));
		
		ProgressBar progressBar = new ProgressBar(shell, SWT.APPLICATION_MODAL);		
		progressBar.setBounds(84, 30, 414, 17);
		progressBar.setSelection(100);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(84, 53, 75, 25);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("New Button");
		button_1.setBounds(254, 53, 75, 25);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setText("New Button");
		button_2.setBounds(423, 53, 75, 25);
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblNewLabel.setBounds(228, 3, 126, 21);
		lblNewLabel.setText("Choose a stat!");
		Runnable timer = new Runnable() {
			int i = 100;
		    public void run() {		
		    	if(i <= 0)
		    		shell.setVisible(false);
		    	progressBar.setSelection(i);
		    	i -= 2.5;	        
		    	display.timerExec(250, this);		    	
		    }
		};
		display.timerExec(1, timer);
		
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			
		}
	}
}
