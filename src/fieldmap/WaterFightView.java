package fieldmap;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Database.Ball;
import Database.Monster;

public class WaterFightView extends JPanel {
	ImageIcon img;
	ImageIcon monster_img;
	Monster monster;
	Ball ball;
	int attcnt = 0;
	String monstername;
	JLabel ballimg;
	WaterFightView(ExecGame frame) {
		monster = new Monster().WaterEasyMonster(); // ���� ����
		ball = StageMouseListener.ball;// ������ �־�� ��
		String[] monname = {"���α�", "����Ĵ�","��ì��","�մ���","�ߵ�","����","��ġ","�����縮"};
		ImageIcon[] charicon = {new ImageIcon("image/009.png"),new ImageIcon("image/010.png"),new ImageIcon("image/011.png"),new ImageIcon("image/012.png"),
				new ImageIcon("image/013.png"),new ImageIcon("image/014.png"),new ImageIcon("image/015.png"),new ImageIcon("image/016.png")
				
		};
		for (int i = 0; i<8 ; i++){
			if(WaterFieldView.flag == i)
				{monster.setMname(monname[i]);
				monstername = monster.getMname();
				monster_img = charicon[i];
				}
		}

		setLayout(null);// ������ �������� �ʾƼ� ��ġ�� ���� �����ؾ���
		img = new ImageIcon("image/waterfight.png");
		Font font = new Font("�������", Font.BOLD, 19);

		// ĳ�����̹���
		JLabel user;
		user = new JLabel(new ImageIcon("image/ĳ����.png"));
		user.setSize(240, 311);
		user.setLocation(70, 190);
		add(user);

		// ���� �̹���
		JLabel mon;
		mon = new JLabel(monster_img);
		mon.setSize(260, 260);
		mon.setLocation(480, 240);
		add(mon);

		// �÷��̾� ������ ����, ȹ��, ���� ��ư�� �÷����� �г�.
		JPanel playerpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/�����г�.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};
		playerpanel.setLayout(null);
		playerpanel.setSize(250, 200);
		playerpanel.setLocation(90, 520);

		// �÷��̾� �г� �ȿ� �÷����� �󺧵�
		String name = ExecGame.player.getPname();
		JLabel playername = new JLabel(name);
		playername.setBounds(30, 30, 100, 20);
		playername.setFont(font);
		playername.setForeground(Color.WHITE);
		double Mhp = monster.getOMhp();    //������ ���� ü��
		JLabel monsterhp = new JLabel("ü��         " + (int) monster.getOMhp() + " / " + (int) Mhp);
		// Player��ü�� �޾ƿ;���.


		// JLabel level = newk
		// JLabel(Integer.toString(player.getLevel().getLev()) + " ����");
		JLabel level = new JLabel("Lv . " + ExecGame.player.getLevel().getLev());  //�÷��̾��� ���� ����
		level.setBounds(150, 30, 80, 20);
		level.setFont(font);
		level.setForeground(Color.WHITE);
		JLabel attcount = new JLabel("���� ���� Ƚ��	       " + attcnt);
		attcount.setBounds(30, 75, 200, 20);
		attcount.setFont(font);
		attcount.setForeground(Color.WHITE);

		JButton attbutton = new JButton("����");
		attbutton.setBounds(25, 130, 60, 50);

		int n = ExecGame.player.getLevel().getLev();
		JPanel monsterpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/�����г�.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};
		attbutton.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				attcnt++;
				ball.setBallType();
				String b_type = ball.getBallType(); // ���� �÷��̾ ��� �� ���� Ÿ�԰�������
				int ballkey = ball.getBallkey();
				int num = ExecGame.player.getBallnum(ballkey);	// ���� �÷��̾ ��� �� ���� Ÿ���� ������ num�� ����

				//num <= 0 �� ���� ��. ������ ���ݹ�ư���� ���� �پ��� ȹ���ư�� �����ϱ� -1�� �Ǽ� numm == 0�� �ȸ԰� ������ ��ӵ�.
				if (num<=0) { //���ͺ� ��� ���� ��..... ��������
					JOptionPane.showMessageDialog(null, "�����ϰ� �ִ� ���ͺ��� ��� ������ ������ �� �����ϴ�...", "���ݽ���", -1);
					monster = new Monster().WaterEasyMonster();
					monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
					frame.changePanel(new WaterFieldView(frame));
					attcnt = 0;
					attcount.setText("���� ���� Ƚ��	       " + attcnt);
					ExecGame.player.setBallnum(ballkey, 0);
					ExecGame.player.setBallnum(ballkey, num);
				}else{
					if (attcnt >= monster.getMaxattcnt()) {      //����Ƚ�� �ʰ���....��������
						JOptionPane.showMessageDialog(null, "�ִ� ����Ƚ���� �ʰ��ϼ̽��ϴ�...", "ȹ�����", -1);
						monster = new Monster().WaterEasyMonster();
						monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
						frame.changePanel(new WaterFieldView(frame));
						attcnt = 0;
						attcount.setText("���� ���� Ƚ��	       " + attcnt);
						ExecGame.player.setBallnum(ballkey, num);
					}
					else{
						MovingBall mb = new MovingBall();
						ballimg = mb.returnBall();
						add(ballimg);
						mb.start();
						if (b_type.equals(monster.getMtype().getOppAtt())) {
							monster.setMhp(monster.getMhp() - (int) (10 * Math.pow(1.25, n - 1) * 1.5));
						} else {
							monster.setMhp(monster.getMhp() - (int)(10 *  Math.pow(1.25, n - 1))); // ��Ÿ����
																									// ��񿡼�
																									// �޾ƿ´�
						}
						monster.setMrate();
						level.setText("Lv . " + ExecGame.player.getLevel().getLev());
						monsterhp.setText("ü��         " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcount.setText("���� ���� Ƚ��	       " + attcnt);
						ExecGame.player.setBallnum(ballkey, --num);
					}
				}
				
			}
		});

		JButton catchbutton = new JButton("ȹ��");
		catchbutton.setBounds(95, 130, 60, 50);
		catchbutton.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				int ballkey = ball.getBallkey();
				int num = ExecGame.player.getBallnum(ballkey);
				int n = (int) (Math.random() * 99) + 1;
				
				// ���� 0���� �� ������ �Ǹ� �ȵ�.
				if (num<=0) { //���ͺ� ��� ���� ��..... ��������
					JOptionPane.showMessageDialog(null, "�����ϰ� �ִ� ���ͺ��� ��� ������ ȹ���� �� �����ϴ�...", "ȹ�����", -1);
					monster = new Monster().WaterEasyMonster();
					monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
					frame.changePanel(new WaterFieldView(frame));
					attcnt = 0;
					attcount.setText("���� ���� Ƚ��	       " + attcnt);
					ExecGame.player.setBallnum(ballkey, 0);
					ExecGame.player.setBallnum(ballkey, num);
				}else{
					if (n > monster.getMrate()*(1+ball.getBallGetrate() )* 100) {	// ���� �ҽ� ������� �����
						JOptionPane.showMessageDialog(null, "�̷� �͵� ��ġ�ٴ�.... ", "ȹ�����", -1);
						monster = new Monster().WaterEasyMonster();
						monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcnt = 0;
						attcount.setText("���� ���� Ƚ��	       " + attcnt);
						frame.changePanel(new WaterFieldView(frame));
						ExecGame.player.setBallnum(ballkey, --num);
					} 
					
					else {
						JOptionPane.showMessageDialog(null, "���� ���� ����� ��! ", "ȹ�漺��", -1);
						ExecGame.player.setMonlist(monster.getMname());
						ExecGame.player.setExp(monster.getExp());
						ExecGame.player.setGold(monster.getMmoney());
						WaterFieldView.flag++;
						if (WaterFieldView.finalflag <= WaterFieldView.flag)
							WaterFieldView.finalflag = WaterFieldView.flag;
						frame.fieldViewMaker();
						frame.changePanel(new WaterFieldView(frame));
						monster = new Monster().WaterEasyMonster();
						attcnt = 0;
						monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcount.setText("���� ���� Ƚ��	       " + attcnt);
						ExecGame.player.setBallnum(ballkey, --num);
					}
				}
				
			}
		});

		JButton escapebutton = new JButton("����");
		escapebutton.setBounds(165, 130, 60, 50);
		escapebutton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseReleased(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "������ �޾Ƴ�����? ������!!", "��������", JOptionPane.YES_NO_OPTION);
				switch (n) {
				case 0:
					monster = new Monster().WaterEasyMonster();
					monsterhp.setText("ü��          " + (int) monster.getMhp() + " / " + (int) Mhp);
					attcnt = 0;
					attcount.setText("���� ���� Ƚ��	       " + attcnt);
					frame.changePanel(new WaterFieldView(frame));
					break;
				case 1:
					break;
				}
			}
		});

		playerpanel.add(playername);
		playerpanel.add(level);
		playerpanel.add(attcount);
		playerpanel.add(attbutton);
		playerpanel.add(catchbutton);
		playerpanel.add(escapebutton);

		// ������ ������ �÷����� �г�
		monsterpanel.setSize(250, 200);
		monsterpanel.setLocation(480, 520);
		monsterpanel.setLayout(null);

		// ���� �г� �ȿ� �÷����� �󺧵�
		
		JLabel mon_name;
		mon_name = new JLabel(monstername);
		mon_name.setFont(font);
		mon_name.setBounds(100, 25, 100, 20);
		mon_name.setForeground(Color.WHITE);

		// ���� ���� ü�� : ü�¿��� �÷��̾���ݷ�*����Ƚ�� //monster.getMHp()
		monsterhp.setBounds(30, 70, 200, 20);
		monsterhp.setFont(font);
		monsterhp.setForeground(Color.WHITE);

		JLabel monstergrade = new JLabel("���                " + monster.getMGrade() + " ���");
		monstergrade.setBounds(30, 115, 200, 20);
		monstergrade.setFont(font);
		monstergrade.setForeground(Color.WHITE);

		JLabel monsterattr = new JLabel("�Ӽ�              " + monster.getMtype());
		monsterattr.setBounds(30, 160, 200, 20);
		monsterattr.setFont(font);
		monsterattr.setForeground(Color.WHITE);

		monsterpanel.add(monsterhp);
		monsterpanel.add(monstergrade);
		monsterpanel.add(monsterattr);
		monsterpanel.add(mon_name);

		add(playerpanel);
		add(monsterpanel);

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(img.getImage(), 0, 0, this);
		setOpaque(true);
	}
}
