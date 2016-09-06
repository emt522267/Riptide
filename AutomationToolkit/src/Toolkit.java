import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

@SuppressWarnings("serial")
public class Toolkit extends JPanel {
	private JLabel filler;
	private JPanel panel;
	JPanel panel1;
	JTextField txtInput;
	JTextField txtZone;
	Button btnSubmit;
	JTextField txtUSGID;
	JTextField txtCoor;
	private JPanel panel_1;

	public Toolkit() {
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

		// JComponent panel1 = makeTextPanel("Panel #1");
		
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setPanel1(panel1);
		panel1.setLayout(null);

		txtInput = new JTextField();
		txtInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInput.setText("");
			}
		});
		txtInput.setBounds(5, 5, 424, 20);
		txtInput.setText("COORDINATES GO HERE...FORMAT XXX XX XXXXX XXXXX");
		panel1.add(txtInput);
		txtInput.setColumns(10);

		txtZone = new JTextField();
		txtZone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtZone.selectAll();

			}
		});
		txtZone.setBounds(10, 87, 86, 20);
		panel1.add(txtZone);
		txtZone.setColumns(10);

		btnSubmit = new Button("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String input;
				String zone;
				String UDGID;
				String coor;

				input = txtInput.getText().trim();

				zone = input.substring(0, 3);
				txtZone.setText(zone);

				UDGID = input.substring(4, 6);
				txtUSGID.setText(UDGID);

				coor = input.substring(7, 18);
				txtCoor.setText(coor);

				txtInput.setText("COORDINATES GO HERE...FORMAT XXX XX XXXXX XXXXX");
			}
		});
		btnSubmit.setBounds(170, 27, 46, 31);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel1.add(btnSubmit);

		txtUSGID = new JTextField();
		txtUSGID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUSGID.selectAll();

			}
		});
		txtUSGID.setBounds(106, 87, 86, 20);
		panel1.add(txtUSGID);
		txtUSGID.setColumns(10);

		txtCoor = new JTextField();
		txtCoor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCoor.selectAll();
			}
		});
		txtCoor.setBounds(202, 87, 227, 20);
		panel1.add(txtCoor);
		txtCoor.setColumns(10);

		JLabel lblZone = new JLabel("Zone");
		lblZone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblZone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtZone.selectAll();

			}
		});
		lblZone.setBounds(50, 70, 46, 14);
		panel1.add(lblZone);

		JLabel lblkmId = new JLabel("100km ID");
		lblkmId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblkmId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUSGID.selectAll();

			}
		});
		lblkmId.setBounds(124, 70, 68, 14);
		panel1.add(lblkmId);

		JLabel lblCoordinates = new JLabel("Coordinates");
		lblCoordinates.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCoordinates.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCoor.selectAll();
			}
		});
		lblCoordinates.setBounds(309, 70, 120, 14);
		panel1.add(lblCoordinates);

		tabbedPane.addTab("Coordinate Splitter", panel1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

	

		// Add the tabbed pane to this panel.
		add(tabbedPane);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Formation Splitter", null, panel_1, null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { tabbedPane, filler, panel }));
	}

	protected JComponent makeTextPanel(String text) {
		panel = new JPanel(false);
		filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Automation Toolkit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.getContentPane().add(new Toolkit(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}