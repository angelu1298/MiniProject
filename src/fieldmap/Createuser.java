package fieldmap;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Database.Player;

//캐릭터 생성창. 여기서 만든 캐릭터의 정보가 DB의 PLAYER 테이블에 추가되며 저장된다.
public class Createuser extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	StartView sv;
	InGameView iv;
	FireFieldView fv;
	GrassFieldView gv;
	WaterFieldView wv;
	EarthFieldView ev;
	ImageIcon icon;

	public Createuser(ExecGame jframe) {
		// 배경화면 지정
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				g.drawImage(new ImageIcon("image/bg_createuser.png").getImage(), 0, 0, this);
				//g.drawImage(new ImageIcon("image/test.gif").getImage(), 0, 0, this);
				setOpaque(false);
			}
		};

		// 아이디 입력 라벨
		JLabel charname = new JLabel(new ImageIcon("image/icon_ID.png"));
		charname.setBounds(140, 20, 60, 60);
		getContentPane().add(charname);

		// 이름 입력 박스 이미지
		JLabel textField_box = new JLabel(new ImageIcon("image/icon_UNDERLINE.png"));
		textField_box.setBounds(200, 20, 200, 50);
		textField_box.setBackground(null);
		textField_box.setBorder(null);
		getContentPane().add(textField_box);

		// 이름 입력 박스 필드
		textField = new JTextField(10); // 이름을 입력하는 텍스트 필드
		textField.setOpaque(false);
		textField.setBackground(new Color(254, 246, 221));
		textField.setBounds(215, 38, 150, 30);
		textField.setBorder(null);
		textField.setFont(new Font("윤고딕", Font.PLAIN, 25));
		getContentPane().add(textField); // 텍스트 필드를 컨텐트 팬에 배치

		// 성별 선택 라디오 버튼 라벨 이미지
		JLabel g_man = new JLabel(new ImageIcon("image/icon_character_m.png"));
		g_man.setBounds(120, 80, 150, 150);
		getContentPane().add(g_man);

		JLabel g_woman = new JLabel(new ImageIcon("image/icon_character_fm.png"));
		g_woman.setBounds(280, 80, 150, 150);
		getContentPane().add(g_woman);

		// 성별 선택 라디오 버튼

		JRadioButton l_man = new JRadioButton();
		l_man.setBounds(185, 215, 59, 27);
		getContentPane().add(l_man);

		JRadioButton l_woman = new JRadioButton();
		l_woman.setBounds(345, 215, 59, 27);
		getContentPane().add(l_woman);

		// 성별 선택 라디오 버튼 그룹(그루핑 해줘야 택 1가능가능)
		ButtonGroup g_group = new ButtonGroup();
		g_group.add(l_man);
		g_group.add(l_woman);

		// 지역선택 라벨 이미지

		JLabel FLabel = new JLabel(new ImageIcon("image/icon_fire.png"));
		FLabel.setBounds(30, 270, 100, 100);
		getContentPane().add(FLabel);

		JLabel WLabel = new JLabel(new ImageIcon("image/icon_water.png"));
		WLabel.setBounds(150, 270, 100, 100);
		getContentPane().add(WLabel);

		JLabel GLabel = new JLabel(new ImageIcon("image/icon_grass.png"));
		GLabel.setBounds(270, 270, 100, 100);
		getContentPane().add(GLabel);

		JLabel ELabel = new JLabel(new ImageIcon("image/icon_earth.png"));
		ELabel.setBounds(390, 270, 100, 100);
		getContentPane().add(ELabel);

		// 지역 선택 라디오버튼

		JRadioButton volcanic = new JRadioButton();
		volcanic.setBounds(66, 290, 50, 150);
		getContentPane().add(volcanic);

		JRadioButton oceanic = new JRadioButton();
		oceanic.setBounds(186, 290, 50, 150);
		getContentPane().add(oceanic);

		JRadioButton grassic = new JRadioButton();
		grassic.setBounds(306, 290, 50, 150);
		getContentPane().add(grassic);

		JRadioButton earthic = new JRadioButton();
		earthic.setBounds(426, 290, 50, 150);
		getContentPane().add(earthic);

		// 지역 선택 라디오 버튼 그룹(그루핑 해줘야 택 1가능가능)
		ButtonGroup m_group = new ButtonGroup();
		m_group.add(earthic);
		m_group.add(grassic);
		m_group.add(volcanic);
		m_group.add(oceanic);

		// 캐릭터 생성하기 버튼 (게임 시작버튼)
		JButton createChar = new JButton(new ImageIcon("image/enter.png"));
		createChar.setBounds(220, 400, 140, 100);
		createChar.setBorderPainted(true);
		createChar.setFocusPainted(true);
		createChar.setContentAreaFilled(false);
		getContentPane().add(createChar);

		createChar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			// public void mouseReleased(MouseEvent arg0) {
			// frame.changePanel(new InGameView(frame));
			// }
		});

		// 배경 패널 관련 설정
		panel.setLayout(null);
		panel.setBounds(0, 0, 550, 550); // 창 위치 크기
		getContentPane().add(panel);
		// 버튼을 눌렀을 때 효과에 대한 메소드 작성
		createChar.addActionListener(new ActionListener() { // 인터페이스인 액션리스너의
															// actionPerformed
															// 메소드 오버라이드
			public void actionPerformed(ActionEvent e) {

				ExecGame.player = new Player();
				if (textField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "캐릭터의 이름을 입력하세요.", "이름입력오류", 2);
				if(!l_man.isSelected() && !l_woman.isSelected())
					JOptionPane.showMessageDialog(null, "캐릭터의 성별을 입력하세요.", "성별입력오류", 2);
				if(!earthic.isSelected() && !grassic.isSelected() && !volcanic.isSelected()
						&& !oceanic.isSelected())
					JOptionPane.showMessageDialog(null, "지역을 선택하세요.", "지역선택오류", 2);
					
				if(!textField.getText().equals("")&&!(!l_man.isSelected() && !l_woman.isSelected())&&!(!earthic.isSelected() && !grassic.isSelected() && !volcanic.isSelected()
						&& !oceanic.isSelected())) {
					
					try {
						ExecGame.player.setPname(textField.getText()); // 텍스트필드로
																		// 입력받은
																		// 캐릭터
																		// 이름을
						// 플레이어 클래스 객체에 입력
					} catch (NullPointerException ex) {
						System.out.println("이름이 입력되지 않았습니다.");
					}
					if (l_man.isSelected())
						ExecGame.player.setGender("남자"); // 남자 라디오버튼 선택시
					else
						ExecGame.player.setGender("여자");// 여자 라디오버튼 선택시

					if (earthic.isSelected()) {
						jframe.fieldViewMaker();
						makeFieldView(jframe);
						jframe.changePanel(ev);

					} else if (grassic.isSelected()) {
						jframe.fieldViewMaker();
						makeFieldView(jframe);
						jframe.changePanel(gv);

					} else if (volcanic.isSelected()) {
						jframe.fieldViewMaker();
						makeFieldView(jframe);
						jframe.changePanel(fv);

					} else {
						jframe.fieldViewMaker();
						makeFieldView(jframe);
						jframe.changePanel(wv);
					}
					FireFieldView.finalflag = 0;
					WaterFieldView.finalflag = 0;
					GrassFieldView.finalflag = 0;
					EarthFieldView.finalflag = 0;
				
					new SaveDB();
					dispose();
				}
			}
		});

	}

	public void makeFieldView(ExecGame jframe) {
		fv = new FireFieldView(jframe);
		// fv.buttonOpen();
		gv = new GrassFieldView(jframe);
		wv = new WaterFieldView(jframe);
		ev = new EarthFieldView(jframe);
	}

}
