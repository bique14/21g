import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class gameFrame extends JFrame {
	JLabel lblYourName, lblWelcome, lblM, lblYourMoney, lblYourBet;
	int money = 1000, bet = 0;
	JPanel welcPanel;
	JPanel gamePanel, btnPanel, betPanel, centerPanel;
	JButton btnHit, btnStand, btnIncrease, btnDecrease, btnStart;
	Timer time;
	ColorName cn;

	public gameFrame(String name) {
		this.setLayout(new BorderLayout());
		time = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNextColorName();
			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				time.start();
			}
		});

		welcPanel = new JPanel(new FlowLayout());
		lblWelcome = new JLabel("Welcome .. ");
		lblYourName = new JLabel();
		lblYourName.setText(name);
		lblYourName.setText(lblYourName.getText());
		lblM = new JLabel(", Your Money : ");
		lblYourMoney = new JLabel();
		lblYourMoney.setText(String.valueOf(money));
		cn = ColorName.RED;
		lblYourName.setForeground(cn.getColor());

		welcPanel.add(lblWelcome);
		welcPanel.add(lblYourName);
		welcPanel.add(lblM);
		welcPanel.add(lblYourMoney);

		betPanel = new JPanel(new FlowLayout());
		btnIncrease = new JButton("+");
		btnDecrease = new JButton("-");
		lblYourBet = new JLabel();
		lblYourBet.setText(String.valueOf(bet));
		betPanel.add(btnDecrease);
		betPanel.add(lblYourBet);
		betPanel.add(btnIncrease);

		centerPanel = new JPanel(new BorderLayout());
		gamePanel = new JPanel();
		centerPanel.setBackground(Color.BLACK);
		gamePanel.setOpaque(true);
		gamePanel.setBackground(Color.red);
		btnPanel = new JPanel(new FlowLayout());
		btnStart = new JButton("START");
		btnHit = new JButton("HIT");
		btnStand = new JButton("STAND");
		btnPanel.add(btnStart);
		btnPanel.add(btnHit);
		btnPanel.add(btnStand);

		centerPanel.add(betPanel, BorderLayout.NORTH);
		centerPanel.add(gamePanel, BorderLayout.CENTER);

		this.add(welcPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);

		this.setTitle("21");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// betAction();
		btnIncrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (bet >= 0 && money != 0) {
					money -= 50;
					bet += 50;
					lblYourMoney.setText(String.valueOf(money));
					lblYourBet.setText(String.valueOf(bet));
				}
			}
		});

		btnDecrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((bet - 50) >= 0) {
					money += 50;
					bet -= 50;
					lblYourMoney.setText(String.valueOf(money));
					lblYourBet.setText(String.valueOf(bet));
				}
			}
		});

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (bet > 0)
					gameOn();
			}
		});
	}

	public void gameOn() {
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("A");
			}
		});
	}

	public void setNextColorName() {
		cn = cn.next();
		lblYourName.setForeground(cn.getColor());
		repaint();
	}

}