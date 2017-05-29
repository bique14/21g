import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class loginFrame extends JFrame {
	public String name;
	JTextField txtName;
	JLabel lblName, lblDetail;
	JButton btnOk;
	String regex = "[a-zA-Z0-9]{4,10}";
	JPanel panel;

	public loginFrame() {
		setBounds(100, 100, 400, 300);
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(null);

		lblDetail = new JLabel("created by bique14");
		lblDetail.setBounds(5, 243, 424, 14);
		panel.add(lblDetail);

		lblName = new JLabel("input your name");
		lblName.setBounds(157, 51, 115, 14);
		panel.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(85, 76, 224, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		btnOk = new JButton("submit");
		btnOk.setBounds(150, 117, 89, 23);

		txtName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkName();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkName();
			}
		});
		panel.add(btnOk);

		this.setResizable(false);
		this.setTitle("login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void checkName() {
		if (txtName.getText().matches(regex)) {
			setName(txtName.getText());
			System.out.println("SUCCESS");
			openGameFrame(getName());
		} else {
			if (txtName.getText().length() < 4 || txtName.getText().length() > 10) {
				if (txtName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please input your name");
				} else
					JOptionPane.showMessageDialog(null, "name length between 4 - 10 characterse");
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void openGameFrame(String name) {
		gameFrame gf = new gameFrame(name);
		gf.setVisible(true);
		this.dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new loginFrame().setVisible(true);
	}

}