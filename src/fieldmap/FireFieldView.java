package fieldmap;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Database.Ball;

public class FireFieldView extends JPanel {
	private static final long serialVersionUID = 100;
	ImageIcon icon;
	Ball ball;
	JButton[] stage;
	ImageIcon b_icon;
	StageMouseListener sa;
	ExecGame frame;
	static int flag;
	static int finalflag;
	FireFieldView(ExecGame frame) {
		setLayout(null);
		this.frame = frame;
		stage = new JButton[8];
		icon = new ImageIcon("image/firefield.png");

		b_icon = new ImageIcon("image/발자국_불.png");
		StageMouseListener sa = new StageMouseListener(stage, frame, this);
		stage[0] = new JButton(b_icon);
		stage[0].setSize(80, 80);
		stage[0].setBorderPainted(false);
		stage[0].setContentAreaFilled(false);
		stage[0].setFocusPainted(false);
		stage[0].addMouseListener(sa);
		stage[0].setLocation(125, 645);
		add(stage[0]);
		for (int i = 1; i < stage.length; i++) {
			stage[i] = new JButton(new ImageIcon("image/자국_불.png"));
			stage[i].setSize(80, 80);
			stage[i].setBorderPainted(false);
			stage[i].setContentAreaFilled(false);
			stage[i].setFocusPainted(false);
			add(stage[i]);
		}
		for (int i = 1; i < stage.length; i++) {
			if (finalflag >= i) {
				stage[i].setIcon(b_icon);
				stage[i].addMouseListener(sa);

			}
		}
		stage[1].setLocation(240, 565);
		stage[2].setLocation(360, 527);
		stage[3].setLocation(500, 480);
		stage[4].setLocation(550, 350);
		stage[5].setLocation(463, 260);
		stage[6].setLocation(360, 165);
		stage[7].setLocation(350, 50);
		ball = StageMouseListener.ball;

		JButton exitbtn = new JButton(new ImageIcon("image/fieldexit.png"));
		exitbtn.setBounds(600, 30, 170, 70);
		exitbtn.setBorderPainted(false);
		exitbtn.setContentAreaFilled(false);
		exitbtn.setFocusPainted(false);

		exitbtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseReleased(MouseEvent arg0) {
				frame.changePanel(new InGameView(frame));
			}
		});
		add(exitbtn);
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(icon.getImage(), 0, 0, this);
		setOpaque(true);

	}

}
