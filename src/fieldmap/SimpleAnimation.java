package fieldmap;

import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation extends Panel {
	int x = 70;
	int y = 70;

//	public static void main(String[] args)
	public SimpleAnimation() {
//		SimpleAnimation gui = new SimpleAnimation();
		go();

	}

	public void go() {

		MyDrawPanel drawPanel = new MyDrawPanel();
		add(drawPanel);
		setSize(300, 300);

		for (int i = 0; i < 130; i++) {
			x++;
			y = (int) (Math.pow(x - 135, 2)/80);

			drawPanel.repaint();

			try {
				Thread.sleep(10);
			} catch (Exception ex) {

			}

		}
	}

	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new ImageIcon("땅볼.png").getImage(), x, y, this);
			setOpaque(true);
		}
	}

}

