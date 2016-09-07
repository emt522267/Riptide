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
import javax.swing.JButton;

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
	private JPanel panel2;
	private JTextField txtIn;
	private JTextField txtOut;

	public Toolkit() {
		Dimension minimumSize = new Dimension(100, 100);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 450, 300);
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

		tabbedPane.setMinimumSize(minimumSize);

		// JComponent panel1 = makeTextPanel("Panel #1");

		panel1 = new JPanel();
		panel1.setBorder(null);
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
				String fixedCoor;

				input = txtInput.getText().trim();

				fixedCoor = coordinates(input);

				zone = fixedCoor.substring(0, 3);
				txtZone.setText(zone);

				UDGID = fixedCoor.substring(4, 6);
				txtUSGID.setText(UDGID);

				coor = fixedCoor.substring(7, 17);
				txtCoor.setText(coor);

				txtInput.setText("COORDINATES GO HERE...FORMAT XXX XX XXXXX XXXXX");
			}
		});
		btnSubmit.setBounds(170, 27, 68, 31);
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
		setLayout(null);
		lblCoordinates.setBounds(309, 70, 120, 14);
		panel1.add(lblCoordinates);

		tabbedPane.addTab("Coordinate Splitter", panel1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Remove Special Chars", null, panel2, null);

		txtIn = new JTextField();
		txtIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				txtIn.selectAll();
			}
		});
		txtIn.setBounds(10, 29, 223, 20);
		panel2.add(txtIn);
		txtIn.setColumns(10);

		txtOut = new JTextField();
		txtOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOut.selectAll();
			}
		});
		txtOut.setBounds(10, 117, 223, 20);
		panel2.add(txtOut);
		txtOut.setColumns(10);

		JLabel lblNewLabel = new JLabel("In:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(187, 11, 46, 14);
		panel2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Out:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(187, 97, 46, 14);
		panel2.add(lblNewLabel_1);

		JButton btnTransform = new JButton("Transform");
		btnTransform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String in;

				in = txtIn.getText().trim();

				in = in.replaceAll("[^\\d.]", "");

				txtOut.setText(in);

			}
		});
		btnTransform.setBounds(10, 169, 115, 23);
		panel2.add(btnTransform);
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
		// frame.pack();
		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	public String coordinates(String coord) {

		System.out.println("Lenght of " + coord + " is " + coord.length());

		String tempA;
		String tempB;

		if (coord.length() == 18) {
			tempA = coord.substring(7, 12);
			tempB = coord.substring(13, 18);
			coord = coord.substring(0, 6) + " " + tempA + tempB;
			System.out.println("Again, Lenght of " + coord + " is " + coord.length());
		}

		if (coord.length() == 12) // 11S NU 79 00
		{
			tempA = coord.substring(7, 9);
			tempB = coord.substring(10, 12);
			coord = coord.substring(0, 6) + " " + tempA + "000" + tempB + "000";
			System.out.println("Again, Lenght of " + coord + " is " + coord.length());
		}

		if (coord.length() == 14)// 11S NU 791 691
		{
			tempA = coord.substring(7, 10);
			tempB = coord.substring(11, 14);
			coord = coord.substring(0, 6) + " " + tempA + "00" + tempB + "00";
			System.out.println("Again, Lenght of " + coord + " is " + coord.length());
		}
		if (coord.length() == 16)// 11S NU 7910 6910
		{
			tempA = coord.substring(7, 11);
			tempB = coord.substring(12, 16);
			coord = coord.substring(0, 6) + " " + tempA + "0" + tempB + "0";
			System.out.println("Again, Lenght of " + coord + " is " + coord.length());
		}

		return coord;

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