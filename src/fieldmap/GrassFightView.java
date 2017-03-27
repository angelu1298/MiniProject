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

public class GrassFightView extends JPanel{
	ImageIcon img;
	ImageIcon monster_img;
	Monster monster;
	Ball ball;
	int attcnt = 0;
	String monstername;
	JLabel ballimg;
	
	GrassFightView(ExecGame frame) {
		monster = new Monster().GrassEasyMonster(); // 몬스터 생성
		ball = StageMouseListener.ball;// 볼선택 있어야 함
		String[] monname = {"이상해씨", "캐터피","뿔충이","뚜벅쵸","파라스","콘팡","아라리","두두"};
		ImageIcon[] charicon = {new ImageIcon("image/017.png"),new ImageIcon("image/018.png"),new ImageIcon("image/019.png"),new ImageIcon("image/020.png"),
				new ImageIcon("image/021.png"),new ImageIcon("image/022.png"),new ImageIcon("image/023.png"),new ImageIcon("image/024.png")
				
		};
		for (int i = 0; i<8 ; i++){
			if(GrassFieldView.flag == i)
				{monster.setMname(monname[i]);
				monstername = monster.getMname();
				monster_img = charicon[i];
				}
		}

		setLayout(null);// 구역을 나눠놓지 않아서 위치를 따로 지정해야함
		img = new ImageIcon("image/grassfight.png");
		Font font = new Font("나눔고딕", Font.BOLD, 19);

		// 캐릭터이미지
		JLabel user;
		user = new JLabel(new ImageIcon("image/캐릭터.png"));
		user.setSize(240, 311);
		user.setLocation(70, 190);
		add(user);

		// 몬스터 이미지
		JLabel mon;
		mon = new JLabel(monster_img);
		mon.setSize(260, 260);
		mon.setLocation(480, 240);
		add(mon);

		// 플레이어 정보와 공격, 획득, 도망 버튼을 올려놓은 패널.
		JPanel playerpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/정보패널.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};
		playerpanel.setLayout(null);
		playerpanel.setSize(250, 200);
		playerpanel.setLocation(90, 520);

		// 플레이어 패널 안에 올려놓을 라벨들
		String name = ExecGame.player.getPname();

		JLabel playername = new JLabel(name);
		// playername.setText(name);
		playername.setBounds(30, 30, 100, 20);
		playername.setFont(font);
		playername.setForeground(Color.WHITE);
		double Mhp = monster.getOMhp();    //몬스터의 원래 체력
		JLabel monsterhp = new JLabel("체력         " + (int) monster.getOMhp() + " / " + (int) Mhp);
		// Player객체를 받아와야함.

		JLabel level = new JLabel("Lv . " + ExecGame.player.getLevel().getLev());  //플레이어의 현재 레벨
		level.setBounds(150, 30, 80, 20);
		level.setFont(font);
		level.setForeground(Color.WHITE);
		JLabel attcount = new JLabel("현재 공격 횟수	       " + attcnt);
		attcount.setBounds(30, 75, 200, 20);
		attcount.setFont(font);
		attcount.setForeground(Color.WHITE);

		JButton attbutton = new JButton("공격");
		attbutton.setBounds(25, 130, 60, 50);

		int n = ExecGame.player.getLevel().getLev();
		JPanel monsterpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/정보패널.png").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};
		attbutton.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				attcnt++;
				ball.setBallType();
				String b_type = ball.getBallType(); // 현재 플레이어가 들고 온 볼의 타입가져오기
				int ballkey = ball.getBallkey();
				int num = ExecGame.player.getBallnum(ballkey);	// 현재 플레이어가 들고 온 볼의 타입의 개수를 num에 저장

				//num <= 0 이 들어가야 함. 이유는 공격버튼으로 볼을 다쓰고 획득버튼을 누르니까 -1이 되서 numm == 0이 안먹고 공격이 계속됨.
				if (num<=0) { //몬스터볼 모두 소진 시..... 전투종료
					JOptionPane.showMessageDialog(null, "소지하고 있는 몬스터볼이 모두 떨어져 공격할 수 없습니다...", "공격실패", -1);
					monster = new Monster().GrassEasyMonster();
					monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
					frame.changePanel(new GrassFieldView(frame));
					attcnt = 0;
					attcount.setText("현재 공격 횟수	       " + attcnt);
					ExecGame.player.setBallnum(ballkey, 0);
					ExecGame.player.setBallnum(ballkey, num);
				}else{
					if (attcnt >= monster.getMaxattcnt()) {      //공격횟수 초과시....전투종료
						JOptionPane.showMessageDialog(null, "최대 공격횟수를 초과하셨습니다...", "획득실패", -1);
						monster = new Monster().GrassEasyMonster();
						monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
						frame.changePanel(new GrassFieldView(frame));
						attcnt = 0;
						attcount.setText("현재 공격 횟수	       " + attcnt);
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
							monster.setMhp(monster.getMhp() - (int)(10 *  Math.pow(1.25, n - 1))); // 볼타입은
																									// 디비에서
																									// 받아온당
						}
						monster.setMrate();
						level.setText("Lv . " + ExecGame.player.getLevel().getLev());
						monsterhp.setText("체력         " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcount.setText("현재 공격 횟수	       " + attcnt);
						ExecGame.player.setBallnum(ballkey, --num);
					}
				}
				
			}
		});

		JButton catchbutton = new JButton("획득");
		catchbutton.setBounds(95, 130, 60, 50);
		catchbutton.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				int ballkey = ball.getBallkey();
				int num = ExecGame.player.getBallnum(ballkey);
				int n = (int) (Math.random() * 99) + 1;
				
				// 볼이 0개일 때 게임이 되면 안됨.
				if (num<=0) { //몬스터볼 모두 소진 시..... 전투종료
					JOptionPane.showMessageDialog(null, "소지하고 있는 몬스터볼이 모두 떨어져 획득할 수 없습니다...", "획득실패", -1);
					monster = new Monster().GrassEasyMonster();
					monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
					frame.changePanel(new GrassFieldView(frame));
					attcnt = 0;
					attcount.setText("현재 공격 횟수	       " + attcnt);
					ExecGame.player.setBallnum(ballkey, 0);
					ExecGame.player.setBallnum(ballkey, num);
				}else{
					if (n > monster.getMrate()*(1+ball.getBallGetrate() )* 100) {	// 여기 소스 언니한테 물어보기
						JOptionPane.showMessageDialog(null, "이런 것도 놓치다니.... ", "획득실패", -1);
						monster = new Monster().GrassEasyMonster();
						monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcnt = 0;
						attcount.setText("현재 공격 횟수	       " + attcnt);
						frame.changePanel(new GrassFieldView(frame));
						ExecGame.player.setBallnum(ballkey, --num);
					} 
					
					else {
						JOptionPane.showMessageDialog(null, "이제 나는 당신의 것! ", "획득성공", -1);
						ExecGame.player.setMonlist(monster.getMname());
						ExecGame.player.setExp(monster.getExp());
						ExecGame.player.setGold(monster.getMmoney());
						GrassFieldView.flag++;
						if (GrassFieldView.finalflag <= GrassFieldView.flag)
							GrassFieldView.finalflag = GrassFieldView.flag;
						frame.fieldViewMaker();
						frame.changePanel(new GrassFieldView(frame));
						monster = new Monster().GrassEasyMonster();
						attcnt = 0;
						monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
						attcount.setText("현재 공격 횟수	       " + attcnt);
						ExecGame.player.setBallnum(ballkey, --num);
					}
				}
				
			}
		});

		JButton escapebutton = new JButton("도망");
		escapebutton.setBounds(165, 130, 60, 50);
		escapebutton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseReleased(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "정말로 달아날꺼야? 겁쟁이!!", "도망가기", JOptionPane.YES_NO_OPTION);
				switch (n) {
				case 0:
					monster = new Monster().GrassEasyMonster();
					monsterhp.setText("체력          " + (int) monster.getMhp() + " / " + (int) Mhp);
					attcnt = 0;
					attcount.setText("현재 공격 횟수	       " + attcnt);
					frame.changePanel(new GrassFieldView(frame));
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

		// 몬스터의 정보를 올려놓은 패널
		monsterpanel.setSize(250, 200);
		monsterpanel.setLocation(480, 520);
		monsterpanel.setLayout(null);

		// 몬스터 패널 안에 올려놓을 라벨들
		
		JLabel mon_name;
		mon_name = new JLabel(monstername);
		mon_name.setFont(font);
		mon_name.setBounds(100, 25, 100, 20);
		mon_name.setForeground(Color.WHITE);

		// 몬스터 남은 체력 : 체력에서 플레이어공격력*어택횟수 //monster.getMHp()
		monsterhp.setBounds(30, 70, 200, 20);
		monsterhp.setFont(font);
		monsterhp.setForeground(Color.WHITE);

		JLabel monstergrade = new JLabel("등급                " + monster.getMGrade() + " 등급");
		monstergrade.setBounds(30, 115, 200, 20);
		monstergrade.setFont(font);
		monstergrade.setForeground(Color.WHITE);

		JLabel monsterattr = new JLabel("속성              " + monster.getMtype());
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
