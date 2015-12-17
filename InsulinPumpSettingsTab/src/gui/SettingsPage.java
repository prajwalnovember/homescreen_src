package gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;


public class SettingsPage {

	protected Shell shlSettings;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */ 
	public static void main(String[] args) {
		try {
			SettingsPage window = new SettingsPage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSettings.open();
		shlSettings.layout();
		while (!shlSettings.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSettings = new Shell();
		shlSettings.setSize(545, 506);
		shlSettings.setText("Settings");
		shlSettings.setLayout(null);
		
		Group grpDe = new Group(shlSettings, SWT.SHADOW_OUT);
		grpDe.setText("Default CARB Settings");
		grpDe.setBounds(10, 207, 509, 129);
		
		Label lblNewLabel_9 = new Label(grpDe, SWT.NONE);
		lblNewLabel_9.setBounds(10, 30, 106, 21);
		lblNewLabel_9.setText("Breakfast Calories");
		
		Label lblNewLabel_10 = new Label(grpDe, SWT.NONE);
		lblNewLabel_10.setText("Lunch Calories");
		lblNewLabel_10.setBounds(10, 67, 106, 15);
		
		Label lblNewLabel_11 = new Label(grpDe, SWT.NONE);
		lblNewLabel_11.setBounds(10, 102, 106, 15);
		lblNewLabel_11.setText("Dinner Calories");
		
		Label lblBreakfastTime = new Label(grpDe, SWT.NONE);
		lblBreakfastTime.setText("Breakfast Time");
		lblBreakfastTime.setBounds(301, 30, 83, 21);
		
		Label lblLunchTime = new Label(grpDe, SWT.NONE);
		lblLunchTime.setText("Lunch Time");
		lblLunchTime.setBounds(301, 67, 83, 15);
		
		Label lblDinnerTime = new Label(grpDe, SWT.NONE);
		lblDinnerTime.setText("Dinner Time");
		lblDinnerTime.setBounds(301, 102, 83, 15);
		
		Spinner spinner = new Spinner(grpDe, SWT.BORDER);
		spinner.setBounds(118, 30, 47, 22);
		
		Spinner spinner_1 = new Spinner(grpDe, SWT.BORDER);
		spinner_1.setBounds(118, 60, 47, 22);
		
		Spinner spinner_2 = new Spinner(grpDe, SWT.BORDER);
		spinner_2.setBounds(118, 95, 47, 22);
		
		Spinner spinner_3 = new Spinner(grpDe, SWT.BORDER);
		spinner_3.setBounds(390, 27, 47, 22);
		
		Spinner spinner_4 = new Spinner(grpDe, SWT.BORDER);
		spinner_4.setBounds(390, 64, 47, 22);
		
		Spinner spinner_5 = new Spinner(grpDe, SWT.BORDER);
		spinner_5.setBounds(390, 99, 47, 22);
		
		Group group = new Group(shlSettings, SWT.NONE);
		group.setBounds(10, 342, 509, 84);
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setBounds(109, 30, 171, 23);
		
		Label lblNewLabel_7 = new Label(group, SWT.NONE);
		lblNewLabel_7.setBounds(10, 33, 127, 23);
		lblNewLabel_7.setText("Enter Password");
		
		Button btnNewButton_1 = new Button(group, SWT.NONE);
		btnNewButton_1.setBounds(328, 28, 155, 25);
		btnNewButton_1.setGrayed(true);
		btnNewButton_1.setSelection(true);
		btnNewButton_1.setText("Reset Password");
		
		Group group_1 = new Group(shlSettings, SWT.NONE);
		group_1.setBounds(10, 0, 509, 201);
		
		Label lblNewLabel = new Label(group_1, SWT.NONE);
		lblNewLabel.setLocation(10, 12);
		lblNewLabel.setSize(179, 23);
		lblNewLabel.setText("Enter User Weight");
		
		Label lblNewLabel_5 = new Label(group_1, SWT.NONE);
		lblNewLabel_5.setBounds(10, 168, 179, 23);
		lblNewLabel_5.setText("Basal Insulin Dose (mg/dl)");
		
		Label lblUsuallyOf = new Label(group_1, SWT.NONE);
		lblUsuallyOf.setBounds(358, 168, 126, 21);
		lblUsuallyOf.setText("Usually 40% of TDD");
		
		Label lblNewLabel_4 = new Label(group_1, SWT.NONE);
		lblNewLabel_4.setBounds(10, 135, 179, 23);
		lblNewLabel_4.setText("Basal Insulin Dose (mg/dl)");
		
		Label lblNewLabel_6 = new Label(group_1, SWT.NONE);
		lblNewLabel_6.setBounds(358, 135, 126, 21);
		lblNewLabel_6.setText("Usually 60% of TDD");
		
		Label lblNewLabel_3 = new Label(group_1, SWT.NONE);
		lblNewLabel_3.setBounds(10, 101, 179, 23);
		lblNewLabel_3.setText("Insulin CARB Ratio (ICR)");
		
		text_3 = new Text(group_1, SWT.BORDER);
		text_3.setBounds(261, 98, 76, 21);
		
		Label lblNewLabel_2 = new Label(group_1, SWT.NONE);
		lblNewLabel_2.setBounds(10, 70, 180, 23);
		lblNewLabel_2.setText("Insulin Sensitivity Factor (ISF)");
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(261, 67, 76, 21);
		
		Label lblNewLabel_1 = new Label(group_1, SWT.NONE);
		lblNewLabel_1.setBounds(10, 41, 179, 23);
		lblNewLabel_1.setText("Total Daily Dosage (TDD)");
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(261, 38, 76, 21);
		
		text = new Text(group_1, SWT.BORDER);
		text.setBounds(261, 11, 76, 21);
		
		Label lblKilograms = new Label(group_1, SWT.NONE);
		lblKilograms.setBounds(352, 14, 55, 15);
		lblKilograms.setText("Kilograms");
		
		Label lblUnitsOfInsulin = new Label(group_1, SWT.NONE);
		lblUnitsOfInsulin.setBounds(358, 41, 115, 19);
		lblUnitsOfInsulin.setText("Units of Insulin");
		
		Spinner spinner_6 = new Spinner(group_1, SWT.BORDER);
		spinner_6.setBounds(261, 136, 76, 22);
		
		Spinner spinner_7 = new Spinner(group_1, SWT.BORDER);
		spinner_7.setBounds(261, 168, 76, 22);
		
		Button btnNewButton_2 = new Button(shlSettings, SWT.NONE);
		btnNewButton_2.setBounds(339, 432, 75, 25);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setTouchEnabled(true);
		btnNewButton_2.setGrayed(true);
		btnNewButton_2.setSelection(true);
		btnNewButton_2.setText("Cancel");
		
		Button btnNewButton = new Button(shlSettings, SWT.NONE);
		btnNewButton.setBounds(420, 432, 75, 25);
		btnNewButton.setTouchEnabled(true);
		btnNewButton.setSelection(true);
		btnNewButton.setGrayed(true);
		btnNewButton.setText("Submit");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

	}
}
