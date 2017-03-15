import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
