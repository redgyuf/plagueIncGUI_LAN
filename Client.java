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

import server.Message;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Client {
	
	private Shell shell;
	private Communicator cm;
	private ChooseStat popup;
	private String choosedStat = "lethality";
	
	private CLabel playerName1;
	private ProgressBar progbar1;
	private String cardName1;
	public String getChoosedStat() {
		return choosedStat;
	}
	private CLabel valVictim1;
	private CLabel valLethality1;
	private CLabel valIncTime1;
	
	private CLabel playerName2;
	private ProgressBar progbar2;
	private String cardName2;
	private CLabel valVictim2;
	private CLabel valLethality2;
	private CLabel valIncTime2;
	
	
	
	public void setCurrentPlayerCards(Message msg){
		if(cm.getMyID() == 1){
			if(msg.getPlayerName1() == null)
				playerName1.setText("Unknown Soldier1");
			else
				playerName1.setText(msg.getPlayerName1());
					
			cardName1 = msg.getCardName1();
			valVictim1.setText(String.valueOf(msg.getVictims1()));
			valLethality1.setText(String.valueOf(msg.getLethality1()));
			valIncTime1.setText(String.valueOf(msg.getIncubation1()));
		}else{
			if(msg.getPlayerName2() == null)
				playerName1.setText("Unknown Soldier2");
			else
				playerName1.setText(msg.getPlayerName2());
					
			cardName1 = msg.getCardName2();
			valVictim1.setText(String.valueOf(msg.getVictims2()));
			valLethality1.setText(String.valueOf(msg.getLethality2()));
			valIncTime1.setText(String.valueOf(msg.getIncubation2()));
		}
		
		setOtherPlayerCards(msg);
		
		if(msg.isYourTurn())
			popup.open();		
	}
	
	public void setOtherPlayerCards(Message msg){
		if(cm.getMyID() == 2){
			if(msg.getPlayerName1() == null)
				playerName2.setText("Unknown Soldier1");
			else
				playerName2.setText(msg.getPlayerName1());
					
			cardName2 = msg.getCardName1();
			valVictim2.setText(String.valueOf(msg.getVictims1()));
			valLethality2.setText(String.valueOf(msg.getLethality1()));
			valIncTime2.setText(String.valueOf(msg.getIncubation1()));
		}else{
			if(msg.getPlayerName2() == null)
				playerName2.setText("Unknown Soldier2");
			else
				playerName2.setText(msg.getPlayerName2());
					
			cardName2 = msg.getCardName2();
			valVictim2.setText(String.valueOf(msg.getVictims2()));
			valLethality2.setText(String.valueOf(msg.getLethality2()));
			valIncTime2.setText(String.valueOf(msg.getIncubation2()));
		}	
	}
	
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
		this.popup = popup;
		
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
		progbarCurrentPlayer.setSelection(0);
		
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
		//File menu END
		
		//Settings menu START
		MenuItem mntmSettings = new MenuItem(menu, SWT.CASCADE);
		mntmSettings.setText("Settings");
		
		Menu menu_1 = new Menu(mntmSettings);
		mntmSettings.setMenu(menu_1);
		
		MenuItem mntmSetToPlayer = new MenuItem(menu_1, SWT.RADIO);
		mntmSetToPlayer.setText("Set Client to Player1");
		
		MenuItem mntmSetClientTo = new MenuItem(menu_1, SWT.RADIO);
		mntmSetClientTo.setText("Set Client to Player2");
		//Settings menu END
		
		Label leftHorizontalSeperator = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		leftHorizontalSeperator.setBounds(10, 80, 374, 2);
		
		Canvas canvasCurrentPlayerCard = new Canvas(shell, SWT.NONE);
		canvasCurrentPlayerCard.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		canvasCurrentPlayerCard.setBounds(66, 130, 250, 370);
		Button ImageCurrentPlayerCard = new Button(canvasCurrentPlayerCard, SWT.FLAT | SWT.CENTER);
		
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
		
		Button ImageCurrentPlayerCardBackPlate = new Button(canvasCurrentPlayerCard, SWT.NONE);
		ImageCurrentPlayerCardBackPlate.setBounds(189, 43, 250, 370);
		ImageCurrentPlayerCardBackPlate.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\cardBack.jpg"));
		
			
		
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
				cm.standByForIncData();
			}
		});
		btnNewButton_1.setBounds(139, 99, 75, 25);
		btnNewButton_1.setText("New Button");
		
		Canvas canvasEnemyPlayerCard = new Canvas(shell, SWT.NONE);
		canvasEnemyPlayerCard.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		canvasEnemyPlayerCard.setBounds(473, 130, 250, 370);
		
		Button button = new Button(canvasEnemyPlayerCard, SWT.FLAT | SWT.CENTER);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\danEx\\Desktop\\CodeCool\\java_tw\\plagueIncGUI_LAN\\Client\\src\\pics\\Plague_Inc_Evolved_Card_7.png"));
		button.setBounds(10, 10, 230, 265);
		
		CLabel lblLethality2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		lblLethality2.setText("Lethality :");
		lblLethality2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLethality2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblLethality2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblLethality2.setBounds(10, 281, 99, 21);
		
		CLabel valueLethality2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		valueLethality2.setText("New Label");
		valueLethality2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueLethality2.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueLethality2.setAlignment(SWT.CENTER);
		valueLethality2.setBounds(160, 281, 61, 21);
		
		Label label_2 = new Label(canvasEnemyPlayerCard, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 306, 230, 2);
		
		CLabel lblVictims2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		lblVictims2.setText("Victims :");
		lblVictims2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblVictims2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblVictims2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblVictims2.setBounds(10, 309, 99, 21);
		
		CLabel valueVictims2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		valueVictims2.setText("New Label");
		valueVictims2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueVictims2.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueVictims2.setAlignment(SWT.CENTER);
		valueVictims2.setBounds(160, 309, 61, 21);
		
		Label label_5 = new Label(canvasEnemyPlayerCard, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(10, 336, 230, 2);
		
		CLabel lblIncTime2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		lblIncTime2.setText("Incubation Time :");
		lblIncTime2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblIncTime2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblIncTime2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblIncTime2.setBounds(10, 339, 128, 21);
		
		CLabel valueIncTime2 = new CLabel(canvasEnemyPlayerCard, SWT.NONE);
		valueIncTime2.setText("New Label");
		valueIncTime2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		valueIncTime2.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		valueIncTime2.setAlignment(SWT.CENTER);
		valueIncTime2.setBounds(160, 339, 61, 21);
		
		Label rightHorizontalSeperator = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		rightHorizontalSeperator.setBounds(400, 80, 374, 2);
		
		ProgressBar progbarEnemy = new ProgressBar(shell, SWT.NONE);
		progbarEnemy.setState(SWT.ERROR);
		progbarEnemy.setMaximum(10);
		progbarEnemy.setSelection(2);
		progbarEnemy.setBounds(537, 41, 170, 17);
		
		CLabel lblEnemyPlayerNAME = new CLabel(shell, SWT.NONE);
		lblEnemyPlayerNAME.setText("Unknown Soldier");
		lblEnemyPlayerNAME.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.ITALIC));
		lblEnemyPlayerNAME.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblEnemyPlayerNAME.setAlignment(SWT.CENTER);
		lblEnemyPlayerNAME.setBounds(537, 10, 170, 21);
		
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
		
		playerName1 = lblCurrentPlayerNAME;
		progbar1 = progbarCurrentPlayer;
		valVictim1 = valueVictims;
		valLethality1 = valueLethality;
		valIncTime1 = valueIncubationTime;
		
		playerName2 = lblEnemyPlayerNAME;
		progbar2 = progbarEnemy;
		valVictim2 = valueVictims2;
		valLethality2 = valueLethality2;
		valIncTime2 = valueIncTime2;
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(353, 210, 75, 25);
		btnNewButton_2.setText("New Button");
		
		

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
