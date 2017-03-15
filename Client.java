import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.wb.swt.SWTResourceManager;

public class Client {

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(String[] data) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Plague Inc. - Client");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		
		
		
		Label verticalSeperator = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		verticalSeperator.setBounds(390, 10, 2, 522);
		
		CLabel lblCurrentPlayer = new CLabel(shell, SWT.NONE);
		lblCurrentPlayer.setBounds(10, 10, 90, 21);
		lblCurrentPlayer.setText("Your name :");
		
		CLabel lblCurrentPlayerPoints = new CLabel(shell, SWT.NONE);
		lblCurrentPlayerPoints.setBounds(10, 37, 90, 21);
		lblCurrentPlayerPoints.setText("Your points :");
		
		ProgressBar progbarCurrentPlayer = new ProgressBar(shell, SWT.NONE);
		progbarCurrentPlayer.setMaximum(10);		
		progbarCurrentPlayer.setBounds(106, 39, 170, 17);
		progbarCurrentPlayer.setSelection(2);
		
		CLabel lblCurrentPlayerNAME = new CLabel(shell, SWT.NONE);
		lblCurrentPlayerNAME.setAlignment(SWT.CENTER);
		lblCurrentPlayerNAME.setBounds(106, 10, 170, 21);
		lblCurrentPlayerNAME.setText("Unknown Soldier");
		
		//File menu START
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_File = new Menu(mntmFile);
		mntmFile.setMenu(menu_File);
		
		MenuItem mntmExit = new MenuItem(menu_File, SWT.NONE);
		mntmExit.setText("Exit");
		
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		//File menu END
		
		
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
