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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

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
	private JPanel panel4;
	private JTextField txtIn;
	private JTextField txtOut;
	JPanel panel3;
	JPanel panel5 = new JPanel();
	private JTextField txtCompare;
	private JLabel lblLookup;
	private JLabel lblImage;
	private JTextField txtFormation;
	private JLabel lblFormation;
	private JTextField txtSpacing;
	private JLabel lblSpacing;
	private JTextField txtCMIn;

	public Toolkit() {
		Dimension minimumSize = new Dimension(100, 100);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 450, 300);
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

		tabbedPane.setMinimumSize(minimumSize);

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

		panel3 = new JPanel();
		panel3.setBorder(null);
		// setpanel3(panel3);
		panel3.setLayout(null);

		tabbedPane.addTab("Image Compare", panel3);

		txtCompare = new JTextField();
		txtCompare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCompare.setText("");
			}
		});
		txtCompare.setBounds(10, 31, 425, 20);
		panel3.add(txtCompare);
		txtCompare.setColumns(10);

		lblLookup = new JLabel("Lookup:");
		lblLookup.setBounds(389, 11, 46, 14);
		panel3.add(lblLookup);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.MAGENTA);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(10, 200, 425, 10);
		panel3.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.YELLOW);
		separator_1.setBackground(Color.MAGENTA);
		separator_1.setBounds(10, 251, 425, 10);
		panel3.add(separator_1);
		lblImage = new JLabel("");

		lblImage.setBounds(96, 210, 243, 40);
		panel3.add(lblImage);

		Button btnGo = new Button("Submit");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String input;

				String formation;
				String spacing;

				input = txtCompare.getText().trim();

				String[] items = input.split("/");
				System.out.println(Arrays.toString(items));

				formation = items[0].trim();

				try {

					spacing = items[1].trim();
				} catch (ArrayIndexOutOfBoundsException ex) {
					spacing = "n/a";
				}

				spacing = spacing.replace("m", "");

				txtFormation.setText(formation);
				txtSpacing.setText(spacing);

				BufferedImage myPicture = null;
				try {

					myPicture = ImageIO.read(ResourceLoader.load(getImage(formation)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblImage.setIcon(new ImageIcon(myPicture));

				txtCompare.setText("");

			}
		});
		btnGo.setBounds(163, 57, 70, 22);
		panel3.add(btnGo);

		txtFormation = new JTextField();
		txtFormation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtFormation.selectAll();
			}
		});
		txtFormation.setBounds(10, 125, 185, 20);
		panel3.add(txtFormation);
		txtFormation.setColumns(10);

		lblFormation = new JLabel("Formation:");
		lblFormation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFormation.setBounds(96, 107, 99, 14);
		panel3.add(lblFormation);

		txtSpacing = new JTextField();
		txtSpacing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtSpacing.selectAll();

			}
		});
		txtSpacing.setBounds(250, 125, 185, 20);
		panel3.add(txtSpacing);
		txtSpacing.setColumns(10);

		lblSpacing = new JLabel("Spacing:");
		lblSpacing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSpacing.setBounds(336, 107, 99, 14);
		panel3.add(lblSpacing);

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

		JLabel lblIn = new JLabel("In:");
		lblIn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIn.setBounds(187, 11, 46, 14);
		panel2.add(lblIn);

		JLabel lblOut = new JLabel("Out:");
		lblOut.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOut.setBounds(187, 97, 46, 14);
		panel2.add(lblOut);

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
		setLayout(null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		panel4 = new JPanel();
		panel4.setBorder(null);
		// setpanel4(panel4);
		panel4.setLayout(null);
		setLayout(null);

		tabbedPane.addTab("Other", panel4);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// Add the tabbed pane to this panel.
		add(tabbedPane);
		setLayout(null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		panel5.setBorder(null);
		// setpanel4(panel4);
		panel5.setLayout(null);

		tabbedPane.addTab("Control Measures", panel5);

		JLabel lblPassFail = new JLabel("");
		lblPassFail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassFail.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassFail.setBounds(116, 215, 196, 27);
		panel5.add(lblPassFail);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.ORANGE);
		separator_2.setBackground(Color.BLUE);
		separator_2.setBounds(144, 242, 140, 2);
		panel5.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLUE);
		separator_3.setBackground(Color.ORANGE);
		separator_3.setBounds(144, 215, 140, 2);
		panel5.add(separator_3);

		txtCMIn = new JTextField();
		txtCMIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				txtCMIn.setText("");

			}
		});
		txtCMIn.setBounds(10, 23, 425, 20);
		panel5.add(txtCMIn);
		txtCMIn.setColumns(10);

		final JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 105, 425, 14);
		panel5.add(lblName);

		final JLabel lblType = new JLabel("Type:");
		lblType.setBounds(10, 130, 425, 14);
		panel5.add(lblType);

		final JLabel lblLocations = new JLabel("Location(s):");
		lblLocations.setBounds(10, 155, 425, 14);
		panel5.add(lblLocations);

		final JLabel lblOverlay = new JLabel("Overlay:");
		lblOverlay.setBounds(10, 180, 425, 14);
		panel5.add(lblOverlay);

		JButton btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cmIn;
				String[] splitIn;
				int i = 0;

				cmIn = txtCMIn.getText().trim();

				splitIn = cmIn.split(",");

				lblName.setText("Name: " + splitIn[0]);
				lblType.setText("Type: " + splitIn[1]);
				lblLocations.setText("Location(s): " + splitIn[2]);
				lblOverlay.setText("Overlay: " + splitIn[3]);

				

				txtCMIn.setText("");

			}
		});
		btnBegin.setBounds(168, 54, 89, 23);
		panel5.add(btnBegin);

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
		frame.setSize(475, 350);
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

	public String getImage(String f) {

		String img = "";
		f = f.toLowerCase();

		if (f.equals("column") == true) {

			img = "column";
		}

		if (f.equals("column facing left") == true) {

			img = "colleft";
		}

		if (f.equals("column facing right") == true) {

			img = "colright";
		}

		if (f.equals("diamond") == true) {

			img = "diamond";
		}

		if (f.equals("echelon left") == true) {

			img = "eleft";
		}

		if (f.equals("echelon right") == true) {

			img = "eright";
		}

		if (f.equals("file") == true) {

			img = "file";
		}

		if (f.equals("line") == true) {

			img = "line";
		}

		if (f.equals("line left") == true) {

			img = "lineleft";
		}

		if (f.equals("line right") == true) {

			img = "lineright";
		}

		if (f.equals("overlap echelon right") == true) {

			img = "overlaperight";
		}

		if (f.equals("staggered column") == true) {

			img = "staggeredcol";
		}

		if (f.equals("staggered column with lead element advanced") == true) {

			img = "staggeredcolwith";
		}

		if (f.equals("vee") == true) {

			img = "v";
		}

		if (f.equals("staggered column") == true) {

			img = "staggeredcol";
		}

		if (f.equals("wedge") == true) {

			img = "wedge";
		}

		if (f.equals("wedge left") == true) {

			img = "wedgeleft";
		}

		if (f.equals("wedge right") == true) {

			img = "wedgeright";
		}

		if (f.equals("insurgents") == true) {

			img = "Insurgents";
		}

		if (f.equals("usmc") == true) {

			img = "USMC";
		}

		if (f.equals("civilian") == true) {

			img = "Civilians";
		}

		img = img + ".png";

		return img;
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