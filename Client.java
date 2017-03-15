import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.LVCOLUMN;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Client {
	
	private Shell shell;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	
	
	public void open(String[] data, ChooseStat popup) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(800, 600);
		shell.setText("Plague Inc. - Client");
		
		this.shell = shell;
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		CLabel lblCurrentPlayer = new CLabel(shell, SWT.NONE);
		lblCurrentPlayer.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblCurrentPlayer.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCurrentPlayer.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblCurrentPlayer.setBounds(10, 10, 97, 21);
		lblCurrentPlayer.setText("Your name :");
		
		CLabel lblCurrentPlayerPoints = new CLabel(shell, SWT.NONE);
		lblCurrentPlayerPoints.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCurrentPlayerPoints.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblCurrentPlayerPoints.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblCurrentPlayerPoints.setBounds(10, 39, 102, 21);
		lblCurrentPlayerPoints.setText("Your points :");
		
		ProgressBar progbarCurrentPlayer = new ProgressBar(shell, SWT.NONE);
		progbarCurrentPlayer.setMaximum(10);		
		progbarCurrentPlayer.setBounds(118, 41, 170, 17);
		progbarCurrentPlayer.setSelection(2);
		
		CLabel lblCurrentPlayerNAME = new CLabel(shell, SWT.NONE);
		lblCurrentPlayerNAME.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.ITALIC));
		lblCurrentPlayerNAME.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblCurrentPlayerNAME.setAlignment(SWT.CENTER);
		lblCurrentPlayerNAME.setBounds(118, 10, 170, 21);
		lblCurrentPlayerNAME.setText("Unknown Soldier");
		
		//File menu START
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_File = new Menu(mntmFile);
		mntmFile.setMenu(menu_File);
		
		MenuItem mntmExit = new MenuItem(menu_File, SWT.NONE);
		mntmExit.setText("Exit");
		
		Label leftHorizontalSeperator = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		leftHorizontalSeperator.setBounds(10, 80, 374, 2);
		
		Canvas canvasCurrentPlayerCard = new Canvas(shell, SWT.NONE);
		canvasCurrentPlayerCard.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		canvasCurrentPlayerCard.setBounds(66, 130, 250, 370);
		Button ImageCurrentPlayerCard = new Button(canvasCurrentPlayerCard, SWT.FLAT | SWT.CENTER);
		ImageCurrentPlayerCard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		ImageCurrentPlayerCard.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\Plague_Inc_Evolved_Card_7.png"));
		ImageCurrentPlayerCard.setBounds(10, 10, 230, 265);		
		
		CLabel lblLethality = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		lblLethality.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblLethality.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLethality.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblLethality.setBounds(10, 281, 99, 21);
		lblLethality.setText("Lethality :");
		
		CLabel valueLethality = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		valueLethality.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueLethality.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueLethality.setAlignment(SWT.CENTER);
		valueLethality.setBounds(160, 281, 61, 21);
		valueLethality.setText("New Label");
		
		Label cardSeperator1 = new Label(canvasCurrentPlayerCard, SWT.SEPARATOR | SWT.HORIZONTAL);
		cardSeperator1.setBounds(10, 306, 230, 2);
		
		CLabel lblVictims = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		lblVictims.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblVictims.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblVictims.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblVictims.setText("Victims :");
		lblVictims.setBounds(10, 309, 99, 21);
		
		CLabel valueVictims = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		valueVictims.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueVictims.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueVictims.setAlignment(SWT.CENTER);
		valueVictims.setText("New Label");
		valueVictims.setBounds(160, 309, 61, 21);
		
		Label cardSeperator2 = new Label(canvasCurrentPlayerCard, SWT.SEPARATOR | SWT.HORIZONTAL);
		cardSeperator2.setBounds(10, 336, 230, 2);
		
		CLabel lblIncubationTime = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		lblIncubationTime.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblIncubationTime.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblIncubationTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblIncubationTime.setText("Incubation Time :");
		lblIncubationTime.setBounds(10, 339, 128, 21);
		
		CLabel valueIncubationTime = new CLabel(canvasCurrentPlayerCard, SWT.NONE);
		valueIncubationTime.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueIncubationTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueIncubationTime.setAlignment(SWT.CENTER);
		valueIncubationTime.setText("New Label");
		valueIncubationTime.setBounds(160, 339, 61, 21);
		
			
		
		Label verticalSeperator = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		verticalSeperator.setBounds(390, 10, 2, 522);
		
		Button ImageCurrentPlayerCardBackPlate = new Button(shell, SWT.NONE);
		ImageCurrentPlayerCardBackPlate.setBounds(477, 130, 250, 370);
		ImageCurrentPlayerCardBackPlate.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\cardBack.jpg"));
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				popup.open();
			}
		});
		btnNewButton.setBounds(289, 99, 75, 25);
		btnNewButton.setText("New Button");
		
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
	public Shell getShell() {
		return shell;
	}
}
