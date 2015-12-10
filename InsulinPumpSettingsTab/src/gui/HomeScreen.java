package gui;

import java.util.Random;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import util.Constants;
/**
 * Newly Imported from google.
 */

public class HomeScreen {

	protected Shell shlHomeScreen;
	protected ProgressBar pbBattery;
	protected ProgressBar pbInsulinReservoir;
	protected ProgressBar pbGlucagonReservoir;
	private Label lblPumpStatus;
	private Label lblGlucoseSensorstatus;
	private Label lblNeedleStatus ;
	private Label lblAlarmStatus;
	
	
	private String statusImg = Constants.STATUS_OK_IMG;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHomeScreen.open();
		shlHomeScreen.layout();
		while (!shlHomeScreen.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	public void setBatteryLife(int value){
		pbBattery.setSelection(value);
		pbBattery.setState(SWT.NORMAL);
		if(value <=30){
			pbBattery.setState(SWT.ERROR);
		}else if(value > 30 && value <=50){
			pbBattery.setState(SWT.PAUSED);
		}
	}
	
	public void setStatus(String iconPath, String statusTxt){
		
	}
	
	
	public void setInsulinReservoir (int value){
		pbInsulinReservoir.setSelection(value);
		pbInsulinReservoir.setState(SWT.NORMAL);
		if (value <=30){
			pbInsulinReservoir.setState(SWT.ERROR);
			}else if(value > 30 && value <=50){
				pbInsulinReservoir.setState(SWT.PAUSED);
				
			}
		
	
	}
	
	public void setGlucagonReservoir (int value){
		pbGlucagonReservoir.setSelection(value);
		pbGlucagonReservoir.setState(SWT.NORMAL);
		if (value <=30){
			pbGlucagonReservoir.setState(SWT.ERROR);
			}else if(value > 30 && value <=50){
				pbGlucagonReservoir.setState(SWT.PAUSED);
				
			}
		
	
	}
	
	public void setPreConditionStatus (boolean status, String component){
		// PUMP
		if(component.equals(Constants.COMPONENT_PUMP)){
			if(status){ // All is well
				lblPumpStatus.setText("OK");
				lblPumpStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
			}else{
				lblPumpStatus.setText("FAULTY");
				lblPumpStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));
			}
		}
		//Needle Assembly
		if(component.equals(Constants.COMPONENT_NEEDLE_ASSEMBLY)){
			if(status){ // All is well
				lblNeedleStatus.setText("OK");
				lblNeedleStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
			}else{
				lblNeedleStatus.setText("FAULTY");
				lblNeedleStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));
			}
		}
	
	//Glucose Sensor
			if(component.equals(Constants.COMPONENT_GLUCOSE_SENSOR)){
				if(status){ // All is well
					lblGlucoseSensorstatus.setText("OK");
					lblGlucoseSensorstatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}else{
					lblGlucoseSensorstatus.setText("FAULTY");
					lblGlucoseSensorstatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));	
				}
			}	
	
			//Alarm Status
			if(component.equals(Constants.COMPONENT_ALARM)){
				if(status){ // All is well
					lblAlarmStatus.setText("OK");
					lblAlarmStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}else{
					lblAlarmStatus.setText("FAULTY");
					lblAlarmStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));	
				}
			}	
	}
	public int getRandom(){
		Random rn = new Random();
		int range = 100 - 0 + 1;
		int randomNum =  rn.nextInt(range) + 0;
		return randomNum;
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHomeScreen = new Shell();
		shlHomeScreen.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlHomeScreen.setSize(748, 520);
		shlHomeScreen.setText("TWO HARMONE SIMULATOR PUMP : GROUP D");
		
		Group grpStatus = new Group(shlHomeScreen, SWT.NONE);
		grpStatus.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		grpStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpStatus.setBounds(10, 0, 441, 82);
		
		Label lblStatusIndicator = new Label(grpStatus, SWT.NONE);
		lblStatusIndicator.setImage(SWTResourceManager.getImage(HomeScreen.class, statusImg));
		lblStatusIndicator.setBounds(10, 20, 38, 52);
		
		Label lblStatusMessage = new Label(grpStatus, SWT.NONE);
		lblStatusMessage.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblStatusMessage.setText("Last Bolus dosage delivered at 16.30");
		lblStatusMessage.setBounds(54, 29, 377, 43);
		
		Group grpCriticalIndicators = new Group(shlHomeScreen, SWT.NONE);
		grpCriticalIndicators.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpCriticalIndicators.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		grpCriticalIndicators.setText("Critical Indicators");
		grpCriticalIndicators.setBounds(457, 43, 265, 388);
		
		pbBattery = new ProgressBar(grpCriticalIndicators, SWT.NONE);
		pbBattery.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		pbBattery.setBounds(132, 32, 123, 25);
		
		
		setBatteryLife(getRandom());
		
		Label lblBattery = new Label(grpCriticalIndicators, SWT.NONE);
		lblBattery.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBattery.setBounds(10, 42, 55, 15);
		lblBattery.setText("Battery");
		
		pbInsulinReservoir = new ProgressBar(grpCriticalIndicators, SWT.NONE);
		pbInsulinReservoir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		pbInsulinReservoir.setBounds(132, 79, 123, 25);
		
		setInsulinReservoir(getRandom());
		
		Label lblInsulinReservoir = new Label(grpCriticalIndicators, SWT.NONE);
		lblInsulinReservoir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblInsulinReservoir.setBounds(10, 89, 102, 15);
		lblInsulinReservoir.setText("Insulin Reservoir");
		
		
		pbGlucagonReservoir = new ProgressBar(grpCriticalIndicators, SWT.NONE);
		pbGlucagonReservoir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		pbGlucagonReservoir.setBounds(132, 131, 123, 25);
		
		setGlucagonReservoir(getRandom());
		
		
		
		
		Label lblGlucagonReservoir = new Label(grpCriticalIndicators, SWT.NONE);
		lblGlucagonReservoir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGlucagonReservoir.setBounds(10, 141, 116, 15);
		lblGlucagonReservoir.setText("Glucagon Reservoir");
		
		Label lblPump = new Label(grpCriticalIndicators, SWT.NONE);
		lblPump.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPump.setBounds(10, 207, 116, 15);
		lblPump.setText("Pump");
		
		Label lblBloodGlucoseSensor = new Label(grpCriticalIndicators, SWT.NONE);
		lblBloodGlucoseSensor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBloodGlucoseSensor.setBounds(10, 251, 129, 15);
		lblBloodGlucoseSensor.setText("Blood Glucose Sensor");
		
		Label lblNeedleAssembly = new Label(grpCriticalIndicators, SWT.NONE);
		lblNeedleAssembly.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNeedleAssembly.setBounds(10, 294, 116, 15);
		lblNeedleAssembly.setText("Needle Assembly");
		
		Label lblAalarm = new Label(grpCriticalIndicators, SWT.NONE);
		lblAalarm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAalarm.setBounds(10, 342, 116, 15);
		lblAalarm.setText("Alarm");
		
		lblPumpStatus = new Label(grpCriticalIndicators, SWT.NONE);
		lblPumpStatus.setText("OK");
		lblPumpStatus.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblPumpStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPumpStatus.setBounds(171, 202, 68, 25);
		setPreConditionStatus(true, Constants.COMPONENT_PUMP);
		
		//lblPumpStatus.setText("NOT OK");
		//lblPumpStatus.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		
		lblGlucoseSensorstatus = new Label(grpCriticalIndicators, SWT.NONE);
		lblGlucoseSensorstatus.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblGlucoseSensorstatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGlucoseSensorstatus.setText("OK");
		lblGlucoseSensorstatus.setBounds(171, 251, 55, 25);
		setPreConditionStatus(true, Constants.COMPONENT_GLUCOSE_SENSOR);
		
		lblNeedleStatus = new Label(grpCriticalIndicators, SWT.NONE);
		lblNeedleStatus.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNeedleStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNeedleStatus.setText("OK");
		lblNeedleStatus.setBounds(171, 294, 55, 25);
		setPreConditionStatus(true, Constants.COMPONENT_NEEDLE_ASSEMBLY);
		
		lblAlarmStatus = new Label(grpCriticalIndicators, SWT.NONE);
		lblAlarmStatus.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblAlarmStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAlarmStatus.setText("OK");
		lblAlarmStatus.setBounds(171, 342, 55, 25);
		setPreConditionStatus(true, Constants.COMPONENT_ALARM);
		
		Group group_1 = new Group(shlHomeScreen, SWT.NONE);
		group_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		group_1.setBounds(10, 82, 441, 61);
		
		Label lblLatestSugarLevels = new Label(group_1, SWT.NONE);
		lblLatestSugarLevels.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLatestSugarLevels.setFont(SWTResourceManager.getFont("Calibri", 14, SWT.BOLD));
		lblLatestSugarLevels.setBounds(10, 22, 171, 26);
		lblLatestSugarLevels.setText("Latest Sugar Levels");
		
		Label lblExpectedValue = new Label(group_1, SWT.NONE);
		lblExpectedValue.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblExpectedValue.setBounds(267, 28, 164, 15);
		lblExpectedValue.setText("Expected Value 70 - 120 mg/dl");
		
		Label lblMgdl = new Label(group_1, SWT.NONE);
		lblMgdl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMgdl.setText("??? mg/dl");
		lblMgdl.setBounds(176, 28, 55, 25);
		
		Group grpNextBolusDosage = new Group(shlHomeScreen, SWT.NONE);
		grpNextBolusDosage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpNextBolusDosage.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		grpNextBolusDosage.setText("Next Bolus Dosage");
		grpNextBolusDosage.setBounds(10, 147, 441, 55);
		
		Label lblDinner = new Label(grpNextBolusDosage, SWT.NONE);
		lblDinner.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDinner.setBounds(10, 25, 140, 20);
		lblDinner.setText("Dinner ???");
		
		Button btnAdjustCarb = new Button(grpNextBolusDosage, SWT.PUSH);
		btnAdjustCarb.addSelectionListener(new SelectionAdapter() {
			//.setVisible(true)@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				CARBRemainderPage crp = new CARBRemainderPage();
				crp.open();
				while (null != crp.shlCarbAndRemainder && !crp.shlCarbAndRemainder.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
		btnAdjustCarb.setBounds(348, 20, 75, 25);
		btnAdjustCarb.setText("Adjust CARB");
		
		Label lblTNextDinnerTime = new Label(grpNextBolusDosage, SWT.NONE);
		lblTNextDinnerTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTNextDinnerTime.setBounds(171, 25, 171, 20);
		lblTNextDinnerTime.setText("Next Dinner Time");
		
		Group grpGraph = new Group(shlHomeScreen, SWT.NONE);
		grpGraph.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpGraph.setBounds(10, 200, 441, 191);
		
		Group grpActivityLog = new Group(shlHomeScreen, SWT.NONE);
		grpActivityLog.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpActivityLog.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		grpActivityLog.setText("Activity Log");
		grpActivityLog.setBounds(10, 389, 441, 82);
		
		StyledText styledText = new StyledText(grpActivityLog, SWT.BORDER);
		styledText.setBounds(0, 21, 441, 61);
		
		Button btnHelp = new Button(shlHomeScreen, SWT.NONE);
		btnHelp.setBounds(467, 446, 81, 25);
		btnHelp.setText("Help");
		
		Button btnGraphView = new Button(shlHomeScreen, SWT.NONE);
		btnGraphView.setBounds(554, 446, 81, 25);
		btnGraphView.setText("Graph View");
		
		Button btnSettings = new Button(shlHomeScreen, SWT.PUSH);
		btnSettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				SettingsPage sp = new SettingsPage();
				sp.open();
				while (null != sp.shlSettings && !sp.shlSettings.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
		btnSettings.setBounds(641, 446, 81, 25);
		btnSettings.setText("Settings");
		//m_bindingContext = initDataBindings();

	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
