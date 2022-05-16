package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JButton upButton;
	private JButton downButton;
	private JLabel label;
	public static Number save;
	
	public MyFrame() throws ClassNotFoundException, IOException {
		save = new Number();
		ReadState readState = new ReadState();
		save = readState.number;
		
		this.setSize(300, 100);
		this.setTitle("Zikirmatik v0.1");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		ImageIcon appLogo = new ImageIcon("res/img/icons8-up-24.png");
		this.setIconImage(appLogo.getImage());

		panel = new JPanel();
		panel.setBackground(new Color(0xADD8E6)); // light blue: 0xADD8E6
		
		
		label = new JLabel();
		label.setText("" + save.getNumber());
		label.setFont(new Font("Roboto", Font.BOLD, 20));


		upButton = new JButton();
		upButton.setPreferredSize(new Dimension(50, 50));
		upButton.addActionListener(this);
		upButton.setUI(new StyledButtonUI());
		upButton.setBackground(new Color(0x90EE90)); // light green: 0x90EE90
		ImageIcon upIcon = new ImageIcon("res/img/icons8-up-48.png");
		upButton.setIcon(upIcon);

		downButton = new JButton();
		downButton.setPreferredSize(new Dimension(50, 50));
		downButton.addActionListener(this);
		downButton.setUI(new StyledButtonUI());
		downButton.setBackground(new Color(0xFF7F7F)); // light red: 0xFF7F7F
		ImageIcon downIcon = new ImageIcon("res/img/icons8-down-48.png");
		downButton.setIcon(downIcon);

		panel.add(downButton);
		panel.add(label);
		panel.add(upButton);

		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == upButton) {
			save.setNumber(save.getNumber() + 1);
			label.setText("" + save.getNumber());
		}

		if (e.getSource() == downButton) {
			if (save.getNumber() > 0) {
				save.setNumber(save.getNumber() - 1);
			}
			label.setText("" + save.getNumber());
		}
		
		try {
			@SuppressWarnings("unused")
			SaveState state = new SaveState(save);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
