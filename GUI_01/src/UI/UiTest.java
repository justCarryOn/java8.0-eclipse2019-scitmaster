package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiTest extends JFrame implements ActionListener {
	private JTextField textField;

	public UiTest() {
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(81, 10, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(12, 13, 57, 15);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(225, 9, 97, 23);
		getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 450);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("µî·Ï")) {
			System.out.println(textField.getText());
			textField.setText("");
		}
	}
}
