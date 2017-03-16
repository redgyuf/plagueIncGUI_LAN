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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ChooseStat {
	private Client mainWindow;
	private Communicator cm;

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
		
		Button buttonLethality = new Button(shell, SWT.NONE);
		buttonLethality.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				mainWindow.setChoosedStat("lethality");
				shell.setVisible(false);
				cm.sendMessage();
			}
		});
		buttonLethality.setText("Lethality");
		buttonLethality.setBounds(84, 53, 75, 25);
		
		Button buttonVictims = new Button(shell, SWT.NONE);
		buttonVictims.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainWindow.setChoosedStat("victims");
				shell.setVisible(false);
				cm.sendMessage();
			}
		});
		buttonVictims.setText("Victims");
		buttonVictims.setBounds(254, 53, 75, 25);
		
		Button buttonIncubationTime = new Button(shell, SWT.NONE);
		buttonIncubationTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainWindow.setChoosedStat("incubationTime");				
				shell.setVisible(false);
				cm.sendMessage();
			}
		});
		buttonIncubationTime.setText("Inc. Time");
		buttonIncubationTime.setBounds(423, 53, 75, 25);
		
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
		    		//if(!shell.getVisible())
		    			//cm.sendMessage();		    			
		    		shell.setVisible(false);		    	
		    	if(i > 50)
		    		progressBar.setState(SWT.NORMAL);
		    	else
		    		progressBar.setState(SWT.PAUSED);
		    	if(i < 20)
		    		progressBar.setState(SWT.ERROR);
		    	progressBar.setSelection(i);
		    	i -= 1;	        
		    	display.timerExec(1000, this);		    	
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

	public void setCm(Communicator cm) {
		this.cm = cm;
	}

	public void setMainWindow(Client window) {
		this.mainWindow = window;
	}
}
