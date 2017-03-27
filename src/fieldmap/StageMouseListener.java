// 모든 필드맵에서 적용할 수 있게 만듬.
package fieldmap;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Database.Ball;

public class StageMouseListener implements MouseListener {
	ExecGame frame;
	JButton[] buttons;
	JPanel fieldview;
	static Ball ball;

	StageMouseListener(JButton[] buttons, ExecGame frame, JPanel fieldview) {
		this.buttons = buttons;// 마우스를 클릭하는 버튼의 주소를 가져온다.
		this.frame = frame; // 메인 창의 주소를 가져온다
		this.fieldview = fieldview; // 각 지역의 버튼임을 인식하기 위한 값

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// if (fieldview instanceof FireFieldView) {
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) { // 몇번 버튼에 마우스가 올라가는 지 인식하고 그 떄 커서
												// 모양을 바꿔준다.
				buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
		// } else if (fieldview instanceof WaterFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		// }
		// }
		// } else if (fieldview instanceof GrassFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		// }
		// }
		// } else if (fieldview instanceof EarthFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		// }
		// }
		// }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// if (fieldview instanceof FireFieldView) {
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) { // 버튼위에서 마우스커서를 치웠을 때 기본 커서모양으로
												// 돌아온다.
				buttons[i].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
		// } else if (fieldview instanceof WaterFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		// }
		// }
		// } else if (fieldview instanceof GrassFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		// }
		// }
		// } else if (fieldview instanceof EarthFieldView) {
		// for (int i = 0; i < buttons.length; i++) {
		// if (e.getSource() == buttons[i]) {
		// buttons[i].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		// }
		// }
		// }
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 볼의 타입을 가져온다.
		if (ball == null) {
			choiceBalltype();
			if (fieldview instanceof FireFieldView) {

				// 스테이지 버튼 눌렀을 떄 전투화면으로 변환
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) { // i번 버튼이 눌렸다면
						FireFieldView.flag = i; // 불지역의 스태틱 변수 플래그를 그 번호로 바꾼다.
												// 나중 전투 패널에서 그 번호에 맞는 몬스터를
												// 불러온다.
					}
					frame.fightViewMaker();
					frame.changePanel(new FireFightView(frame));
				}

			} else if (fieldview instanceof WaterFieldView) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						WaterFieldView.flag = i;
					}
					frame.fightViewMaker();
					frame.changePanel(new WaterFightView(frame));
				}
			} else if (fieldview instanceof GrassFieldView) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						GrassFieldView.flag = i;
					}
					frame.fightViewMaker();
					frame.changePanel(new GrassFightView(frame));
				}
			} else if (fieldview instanceof EarthFieldView) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						EarthFieldView.flag = i;// 순서중요
					}
					frame.fightViewMaker();
					frame.changePanel(new EarthFightView(frame));
				}
			}
		} else {
			choiceBalltype();
			if (fieldview instanceof FireFieldView) {

				// 스테이지 버튼 눌렀을 떄 전투화면으로 변환
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) { // i번 버튼이 눌렸다면
						FireFieldView.flag = i; // 불지역의 스태틱 변수 플래그를 그 번호로 바꾼다.
												// 나중 전투 패널에서 그 번호에 맞는 몬스터를
					}
					frame.fightViewMaker();
					frame.changePanel(new FireFightView(frame));
				}

			} else if (fieldview instanceof WaterFieldView) {

				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						WaterFieldView.flag = i;
					}
					frame.fightViewMaker();
					frame.changePanel(new WaterFightView(frame));
				}
			} else if (fieldview instanceof GrassFieldView) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						GrassFieldView.flag = i;
					}
					frame.fightViewMaker();
					frame.changePanel(new GrassFightView(frame));
				}
			} else if (fieldview instanceof EarthFieldView) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						EarthFieldView.flag = i;// 순서중요
					}
					frame.fightViewMaker();
					frame.changePanel(new EarthFightView(frame));
				}
			}
		}
	}

	public void makeView() {
		if (fieldview instanceof FireFieldView) {
			frame.fightViewMaker();
			frame.changePanel(new FireFightView(frame));
		} else if (fieldview instanceof WaterFieldView) {
			frame.fightViewMaker();
			frame.changePanel(new WaterFightView(frame));
		} else if (fieldview instanceof GrassFieldView) {
			frame.fightViewMaker();
			frame.changePanel(new GrassFightView(frame));
		} else if (fieldview instanceof EarthFieldView) {
			frame.fightViewMaker();
			frame.changePanel(new EarthFightView(frame));
		}
	}

	public void choiceBalltype() {
		JFrame monball = new JFrame("몬스터볼을 고르세요");
		monball.setLayout(new GridLayout(2, 1));
		JPanel buttonPanel = new JPanel();
		JPanel comboboxPanel = new JPanel();
		JButton f_type = new JButton("불 타입");
		JButton w_type = new JButton("물 타입");
		JButton g_type = new JButton("풀 타입");
		JButton e_type = new JButton("땅 타입");
		Vector<String> type = new Vector<String>();
		type.add("C 등급");
		type.add("B 등급");
		type.add("A 등급");
		type.add("S 등급");

		JComboBox<String> grade = new JComboBox<String>(type);
		grade.setFont(new Font("나눔고딕", Font.BOLD, 15));
		grade.setSize(100, 18);
		buttonPanel.setLayout(new FlowLayout());
		monball.getContentPane().add(comboboxPanel);
		monball.getContentPane().add(buttonPanel);

		buttonPanel.add(f_type);
		buttonPanel.add(w_type);
		buttonPanel.add(g_type);
		buttonPanel.add(e_type);

		comboboxPanel.add(grade, SwingConstants.CENTER);
		f_type.setSize(new Dimension(100, 30));
		w_type.setSize(new Dimension(100, 30));
		g_type.setSize(new Dimension(100, 30));
		e_type.setSize(new Dimension(100, 30));

		f_type.addActionListener(new ActionListener() {// 볼타입이 불인 경우 액션리스너

			public void actionPerformed(ActionEvent arg0) {
				ball = new Ball(); // 볼을 선택하지 않는 경우 전투를 할 수 없게 하기 위해서 버튼을 눌렀을 때만
									// 볼의 객체를 생성해 준다.
				if (grade.getSelectedItem().equals("C 등급")) // 콤보박스에서 c등급을 골랐을
															// 경우
					ball.setBallKey(1);							 // 볼 키를 1로 준다. 이 볼 키는 플레이어가 소유한 볼의 개수를
																// 가져오기 위함. 종류가 16개 이므로 1부터 차례로 키값을 주었다.
				else if (grade.getSelectedItem().equals("B 등급"))
					ball.setBallKey(5);
				else if (grade.getSelectedItem().equals("A 등급"))
					ball.setBallKey(9);
				else if (grade.getSelectedItem().equals("S 등급"))
					ball.setBallKey(13);
				ball.setBallType();
				makeView();
				monball.dispose();
			}// DB연동부분

		});
		w_type.addActionListener(new ActionListener() {// 물타입 볼인 경우 리스너

			public void actionPerformed(ActionEvent arg0) {
				ball = new Ball();
				if (grade.getSelectedItem().equals("C 등급")) {
					ball.setBallKey(2);
				} else if (grade.getSelectedItem().equals("B 등급"))
					ball.setBallKey(6);
				else if (grade.getSelectedItem().equals("A 등급"))
					ball.setBallKey(10);
				else if (grade.getSelectedItem().equals("S 등급"))
					ball.setBallKey(14);
				ball.setBallType();
				makeView();
				monball.dispose();
			}// DB연동부분

		});
		g_type.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ball = new Ball();
				if (grade.getSelectedItem().equals("C 등급"))
					ball.setBallKey(3);
				else if (grade.getSelectedItem().equals("B 등급"))
					ball.setBallKey(7);
				else if (grade.getSelectedItem().equals("A 등급"))
					ball.setBallKey(11);
				else if (grade.getSelectedItem().equals("S 등급"))
					ball.setBallKey(15);
				ball.setBallType();
				makeView();
				monball.dispose();
			}// DB연동부분

		});
		e_type.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ball = new Ball();
				if (grade.getSelectedItem().equals("C 등급"))
					ball.setBallKey(4);
				else if (grade.getSelectedItem().equals("B 등급"))
					ball.setBallKey(8);
				else if (grade.getSelectedItem().equals("A 등급"))
					ball.setBallKey(12);
				else if (grade.getSelectedItem().equals("S 등급"))
					ball.setBallKey(16);
				ball.setBallType();
				makeView();
				monball.dispose();
			}// DB연동부분

		});
		monball.setBounds(300, 100, 200, 100);
		monball.pack();
		monball.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		monball.setVisible(true);

	}
}
