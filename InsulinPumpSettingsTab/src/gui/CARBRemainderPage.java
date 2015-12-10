package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class CARBRemainderPage {

	protected Shell shlCarbAndRemainder;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CARBRemainderPage window = new CARBRemainderPage();
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
		shlCarbAndRemainder.open();
		shlCarbAndRemainder.layout();
		while (!shlCarbAndRemainder.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCarbAndRemainder = new Shell();
		shlCarbAndRemainder.setSize(323, 262);
		shlCarbAndRemainder.setText("CARB and Remainder");
		
		Group grpCarbSetting = new Group(shlCarbAndRemainder, SWT.NONE);
		grpCarbSetting.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		grpCarbSetting.setText("CARB Setting");
		grpCarbSetting.setBounds(10, 0, 295, 106);
		
		Label lblNewLabel = new Label(grpCarbSetting, SWT.NONE);
		lblNewLabel.setBounds(10, 32, 149, 22);
		lblNewLabel.setText("CARB Value");
		
		Label lblNewLabel_1 = new Label(grpCarbSetting, SWT.NONE);
		lblNewLabel_1.setBounds(10, 68, 149, 22);
		lblNewLabel_1.setText("Authentication PIN");
		
		Spinner spinner = new Spinner(grpCarbSetting, SWT.BORDER);
		spinner.setBounds(206, 29, 72, 22);
		
		text = new Text(grpCarbSetting, SWT.BORDER);
		text.setBounds(206, 65, 72, 21);
		
		Group grpRemainder = new Group(shlCarbAndRemainder, SWT.NONE);
		grpRemainder.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		grpRemainder.setText("Remainder");
		grpRemainder.setBounds(0, 112, 306, 106);
		
		Button btnNewButton = new Button(grpRemainder, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnNewButton.setBounds(183, 38, 113, 41);
		btnNewButton.setText("INJECT BOLUS");
		
		Button btnNewButton_1 = new Button(grpRemainder, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlCarbAndRemainder.close();
			}
		});
		btnNewButton_1.setBounds(10, 38, 80, 41);
		btnNewButton_1.setText("Cancel");
		
		Button btnNewButton_2 = new Button(grpRemainder, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setBounds(96, 38, 81, 41);
		btnNewButton_2.setText("Snooze");

	}
}
