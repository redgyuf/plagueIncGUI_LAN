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
	private Communicator cm;
	private String choosedStat;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open(String[] data, ChooseStat popup) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\5fb2756cdf746a3ec3b99c89a0675bac407.jpg"));
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(800, 600);
		shell.setText("Plague Inc. - Client");
		
		this.shell = shell;
		this.cm = cm;
		
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
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				popup.open();
			}
		});
		btnNewButton.setBounds(289, 99, 75, 25);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(139, 99, 75, 25);
		btnNewButton_1.setText("New Button");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		canvas.setBounds(473, 130, 250, 370);
		
		Button button = new Button(canvas, SWT.FLAT | SWT.CENTER);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\Plague_Inc_Evolved_Card_7.png"));
		button.setBounds(10, 10, 230, 265);
		
		CLabel label = new CLabel(canvas, SWT.NONE);
		label.setText("Lethality :");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label.setBounds(10, 281, 99, 21);
		
		CLabel label_1 = new CLabel(canvas, SWT.NONE);
		label_1.setText("New Label");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(160, 281, 61, 21);
		
		Label label_2 = new Label(canvas, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 306, 230, 2);
		
		CLabel label_3 = new CLabel(canvas, SWT.NONE);
		label_3.setText("Victims :");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_3.setBounds(10, 309, 99, 21);
		
		CLabel label_4 = new CLabel(canvas, SWT.NONE);
		label_4.setText("New Label");
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_4.setAlignment(SWT.CENTER);
		label_4.setBounds(160, 309, 61, 21);
		
		Label label_5 = new Label(canvas, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(10, 336, 230, 2);
		
		CLabel label_6 = new CLabel(canvas, SWT.NONE);
		label_6.setText("Incubation Time :");
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_6.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_6.setBounds(10, 339, 128, 21);
		
		CLabel label_7 = new CLabel(canvas, SWT.NONE);
		label_7.setText("New Label");
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_7.setAlignment(SWT.CENTER);
		label_7.setBounds(160, 339, 61, 21);
		
		Button ImageCurrentPlayerCardBackPlate = new Button(canvas, SWT.NONE);
		ImageCurrentPlayerCardBackPlate.setBounds(0, 0, 250, 370);
		ImageCurrentPlayerCardBackPlate.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\cardBack.jpg"));
		
		Label label_8 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setBounds(400, 80, 374, 2);
		
		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setMaximum(10);
		progressBar.setSelection(2);
		progressBar.setBounds(537, 41, 170, 17);
		
		CLabel label_9 = new CLabel(shell, SWT.NONE);
		label_9.setText("Unknown Soldier");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.ITALIC));
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		label_9.setAlignment(SWT.CENTER);
		label_9.setBounds(537, 10, 170, 21);
		
		CLabel lblEnemysName = new CLabel(shell, SWT.NONE);
		lblEnemysName.setText("Enemy name :");
		lblEnemysName.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblEnemysName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblEnemysName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblEnemysName.setBounds(400, 10, 113, 21);
		
		CLabel lblEnemyPoints = new CLabel(shell, SWT.NONE);
		lblEnemyPoints.setText("Enemy points :");
		lblEnemyPoints.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblEnemyPoints.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblEnemyPoints.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblEnemyPoints.setBounds(400, 39, 119, 21);
		
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
	public Communicator getCm() {
		return cm;
	}
	public void setChoosedStat(String choosedStat) {
		this.choosedStat = choosedStat;
	}
	public void setCm(Communicator cm) {
		this.cm = cm;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public Shell getShell() {
		return shell;
	}
}
