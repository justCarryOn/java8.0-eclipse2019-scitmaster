package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import service.GUIService;
import vo.Person;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class GUI extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JList list;
	private GUIService gs=new GUIService();

	public GUI() {
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(68, 31, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(289, 31, 116, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(14, 34, 62, 18);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		lblNewLabel_1.setBounds(215, 34, 62, 18);
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBounds(14, 83, 391, 27);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 138, 378, 228);
		getContentPane().add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		setTitle("주민등록부_Ver01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(445, 430);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("등록")) {
			String name=textField.getText();
			String ssn=textField_1.getText();
			gs.insertPerson(new Person(name,ssn));

			list.setListData(gs.getpList().toArray());	
			
			textField.setText("");
			textField_1.setText("");
		}
		
	}
}
