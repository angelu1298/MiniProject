package fieldmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.Ball;
//플레이어의 인벤토리. 다양한 몬스터볼을 구매할 수 있다.
public class Inventory extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 100;
	JButton ball_g_f = null;
	JButton ball_g_w = null;
	JButton ball_g_g = null;
	JButton ball_g_e = null;
	JButton[] addball = new JButton[4];
	JLabel gold = null;
	JTextField[] text = null;
	Ball ball;
	JLabel[] havingballs;
	JPanel ballpanel;

	Inventory() { //인벤토리의 생성자
		super("인벤토리"); //창의 이름설정
		setPreferredSize(new Dimension(400, 650)); //창의 크기
		setLocation(200, 300);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		StageMouseListener.ball = new Ball();
		ball =StageMouseListener.ball;

		// 인벤토리의 이름을 올려놓을 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 600);
		panel.setBackground(Color.WHITE);
		JPanel invenname = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon("image/인벤토리이름패널.png").getImage(), 0, 0, this);
			}
		};
		invenname.setBounds(15, 20, 355, 50);
		invenname.setLayout(null);

		JLabel l_inventoryname = new JLabel(ExecGame.player.getPname() + "의 인벤토리", SwingConstants.CENTER);
		l_inventoryname.setFont(new Font("나눔고딕", Font.BOLD, 22));
		l_inventoryname.setBounds(80, 5, 200, 40);
		invenname.add(l_inventoryname);
		
		// 플레이어의 골드
		JLabel l_gold = new JLabel("골드."); 
		l_gold.setBounds(273, 22, 40, 30);
		l_gold.setFont(new Font("나눔고딕", Font.BOLD, 15));
		l_gold.setBackground(Color.PINK);
		invenname.add(l_gold);
		gold = new JLabel(Long.toString(ExecGame.player.getGold()));
		gold.setBounds(310, 22, 100, 30);
		gold.setFont(new Font("나눔고딕", Font.BOLD, 15));
		gold.setBackground(Color.PINK);
		invenname.add(gold);
		
		panel.add(invenname);

		// 볼 구매할 수 있는 버튼을 올려놓을 패널
		ballpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon("image/itempanel.png").getImage(), 0, 0, this);
			}
		};
		ballpanel.setBackground(Color.WHITE);
		ballpanel.setBounds(0, 70, 400, 530);
		ballpanel.setLayout(null);
		
		// 볼 등급 버튼
		ball_g_f = new JButton("등급");
		ball_g_f.setFont(new Font("나눔고딕", Font.BOLD, 11));
		ball_g_f.setBackground(Color.PINK);
		ball_g_f.setBounds(230, 46, 50, 38);
		ball_g_f.setBorderPainted(false);
		ball_g_f.addActionListener(this);
		ballpanel.add(ball_g_f);

		ball_g_w = new JButton("등급");
		ball_g_w.setFont(new Font("나눔고딕", Font.BOLD, 11));
		ball_g_w.setBackground(Color.PINK);
		ball_g_w.setBounds(230, 170, 50, 38);
		ball_g_w.setBorderPainted(false);
		ball_g_w.addActionListener(this);
		ballpanel.add(ball_g_w);

		ball_g_g = new JButton("등급");
		ball_g_g.setFont(new Font("나눔고딕", Font.BOLD, 11));
		ball_g_g.setBackground(Color.PINK);
		ball_g_g.setBounds(230, 290, 50, 38);
		ball_g_g.setBorderPainted(false);
		ball_g_g.addActionListener(this);
		ballpanel.add(ball_g_g);

		ball_g_e = new JButton("등급");
		ball_g_e.setFont(new Font("나눔고딕", Font.BOLD, 11));
		ball_g_e.setBackground(Color.PINK);
		ball_g_e.setBounds(230, 418, 50, 38);
		ball_g_e.setBorderPainted(false);
		ball_g_e.addActionListener(this);
		ballpanel.add(ball_g_e);
		
		// 수량 적는 텍스트필드
		text = new JTextField[4];
		for (int i = 0; i < text.length; i++) {
			text[i]=new JTextField();
			text[i].setBackground(Color.PINK);
			ballpanel.add(text[i]);
		}
		text[0].setBounds(234, 95, 40, 35);
		text[1].setBounds(234, 219, 40, 35);
		text[2].setBounds(234, 339, 40, 35);
		text[3].setBounds(234, 467, 40, 35);
		
		// + 버튼
		for (int i = 0; i < addball.length; i++) {
			addball[i] = new JButton("구매");
			addball[i].setFont(new Font("나눔고딕", Font.BOLD, 11));
			addball[i].setBackground(Color.PINK);
			addball[i].setBorderPainted(false);
			addball[i].addActionListener(this);
			ballpanel.add(addball[i]);
		}

		addball[0].setBounds(300, 92, 50, 38);	// 구매 버튼위치
		addball[1].setBounds(300, 216, 50, 38);
		addball[2].setBounds(300, 336, 50, 38);
		addball[3].setBounds(300, 464, 50, 38);
				
		panel.add(ballpanel);
		havingballs = new JLabel[4];
		for(int i=0; i<havingballs.length;i++){
			havingballs[i] = new JLabel();
			havingballs[i].setFont(new Font("나눔고딕", Font.BOLD, 15));
			havingballs[i].setBackground(Color.PINK);
			ballpanel.add(havingballs[i]);
		}
		havingballs[0].setBounds(310, 46, 50, 38);
		havingballs[1].setBounds(310, 170, 50, 38);
		havingballs[2].setBounds(310, 290, 50, 38);
		havingballs[3].setBounds(310, 418, 50, 38);
		getContentPane().add(panel);
		getContentPane().setBackground(Color.WHITE);
	}

	// 버튼들을 눌렀을 때 액션리스너 - 플구매하고 싶은 볼타입의 등급을 눌러서 선택하고 플러스 버튼을 누르면 선택한 볼의 소유한 수량이 늘어나고
	// 플레이어의 
	public void actionPerformed(ActionEvent e) {	
		
		
		if (e.getSource() == ball_g_f) {
			String[] st = { "몬스터볼", "슈퍼볼", "하이퍼볼", "마스터볼" };
			int n = JOptionPane.showOptionDialog(this, "볼 등급을 선택하세요.", "볼 등급", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, st, "2");
			switch (n) {
			case 0:
				ball.setBallKey(1);
				ballpanel.repaint();
				havingballs[0].setText(Integer.toString(ExecGame.player.getBallnum(1))+"개");
				break;
			case 1:
				ball.setBallKey(5);
				ballpanel.repaint();
				havingballs[0].setText(Integer.toString(ExecGame.player.getBallnum(5))+"개");
				break;
			case 2:
				ball.setBallKey(9);
				ballpanel.repaint();
				havingballs[0].setText(Integer.toString(ExecGame.player.getBallnum(9))+"개");
				break;
			case 3:
				ball.setBallKey(13);
				ballpanel.repaint();
				havingballs[0].setText(Integer.toString(ExecGame.player.getBallnum(13))+"개");
				break;
			}

		} else if (e.getSource() == ball_g_w) {
			String[] st = { "몬스터볼", "슈퍼볼", "하이퍼볼", "마스터볼" };
			int n = JOptionPane.showOptionDialog(this, "볼 등급을 선택하세요.", "볼 등급", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, st, "2");
			switch (n) {
			case 0:
				ball.setBallKey(2);
				ballpanel.repaint();
				havingballs[1].setText(Integer.toString(ExecGame.player.getBallnum(2))+"개");
				break;
			case 1:
				ball.setBallKey(6);
				ballpanel.repaint();
				havingballs[1].setText(Integer.toString(ExecGame.player.getBallnum(6))+"개");
				break;
			case 2:
				ball.setBallKey(10);
				ballpanel.repaint();
				havingballs[1].setText(Integer.toString(ExecGame.player.getBallnum(10))+"개");
				break;
			case 3:
				ball.setBallKey(14);
				ballpanel.repaint();
				havingballs[1].setText(Integer.toString(ExecGame.player.getBallnum(14))+"개");
				break;
			}
		} else if (e.getSource() == ball_g_g) {
			String[] st = { "몬스터볼", "슈퍼볼", "하이퍼볼", "마스터볼" };
			int n = JOptionPane.showOptionDialog(this, "볼 등급을 선택하세요.", "볼 등급", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, st, "2");
			switch (n) {
			case 0:
				ball.setBallKey(3);
				ballpanel.repaint();
				havingballs[2].setText(Integer.toString(ExecGame.player.getBallnum(3))+"개");
				break;
			case 1:
				ball.setBallKey(7);
				ballpanel.repaint();
				havingballs[2].setText(Integer.toString(ExecGame.player.getBallnum(7))+"개");
				break;
			case 2:
				ball.setBallKey(11);
				ballpanel.repaint();
				havingballs[2].setText(Integer.toString(ExecGame.player.getBallnum(11))+"개");
				break;
			case 3:
				ball.setBallKey(15);
				ballpanel.repaint();
				havingballs[2].setText(Integer.toString(ExecGame.player.getBallnum(15))+"개");
				break;
			}
		} else if (e.getSource() == ball_g_e) {
			String[] st = { "몬스터볼", "슈퍼볼", "하이퍼볼", "마스터볼" };
			int n = JOptionPane.showOptionDialog(this, "볼 등급을 선택하세요.", "볼 등급", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, st, "2");
			switch (n) {
			case 0:
				ball.setBallKey(4);
				ballpanel.repaint();
				havingballs[3].setText(Integer.toString(ExecGame.player.getBallnum(4))+"개");
				break;
			case 1:
				ball.setBallKey(8);
				ballpanel.repaint();
				havingballs[3].setText(Integer.toString(ExecGame.player.getBallnum(8))+"개");
				break;
			case 2:
				ball.setBallKey(12);
				ballpanel.repaint();
				havingballs[3].setText(Integer.toString(ExecGame.player.getBallnum(12))+"개");
				break;
			case 3:
				ball.setBallKey(16);
				ballpanel.repaint();
				havingballs[3].setText(Integer.toString(ExecGame.player.getBallnum(16))+"개");
				break;
			}
		}

		int ballkey =ball.getBallkey();
		
		
		
		for(int i =0; i <addball.length; i++){
			if (e.getSource() == addball[i]) {	// + 버튼을 누르면 볼의 수량이 늘어남
				int buyball = Integer.parseInt(text[i].getText());
				ExecGame.player.setBallnum(ballkey, ExecGame.player.getBallnum(ballkey) + buyball);
				ball.setBallKey(ballkey);
				ball.setBallPrice();
				if(ExecGame.player.getGold()<(ball.getBallPrice()*buyball)){
					JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "구입실패", -1);
				}else{
					ExecGame.player.setGold(-(ball.getBallPrice()*buyball));
					gold.setText(Long.toString(ExecGame.player.getGold()));
					//키를 받아서 가격을 정하고 가격을 가져와서 소유한 골드에서 빼야함
					havingballs[i].setText(Integer.toString(ExecGame.player.getBallnum(ballkey))+"개");
					InvenDB inven = new InvenDB();
					inven.getInven();
				}
		}

	}
		

	}
	
}
