package fieldmap;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import fieldmap.FireFieldView;

public class InGameView extends JPanel {
	ImageIcon icon;
	FireFieldView fv;
	GrassFieldView gv;
	WaterFieldView wv;
	EarthFieldView ev;
	//네 가지 지역 선택 화면
	public InGameView(ExecGame jframe) {
		setLayout(new GridLayout(2, 2));
		setBackground(Color.WHITE);

		JButton[] button = new JButton[4];

		button[0] = new JButton(new ImageIcon("image/firebtn.png"));
		button[1] = new JButton(new ImageIcon("image/waterbtn.png"));
		button[2] = new JButton(new ImageIcon("image/grassbtn.png"));
		button[3] = new JButton(new ImageIcon("image/earthbtn.png"));

		for (int i = 0; i < button.length; i++) {
			button[i].setSize(100, 100);
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].setFocusPainted(false);
			add(button[i]);
		}
		button[0].addMouseListener(new MouseAdapter() { // 마우스리스너 (마우스어댑터)
			@Override
			public void mouseEntered(MouseEvent arg0) { // 버튼위에 커서가 올라가면 손가락 모양으로 바뀜
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) { // 버튼에서 벗어나면 원래대로 돌아옴
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) { // 눌렀다떼면 들판지대 필드 맵으로 전환
				jframe.fieldViewMaker();
				jframe.changePanel(new FireFieldView(jframe));
			}
		});

		button[1].addMouseListener(new MouseAdapter() { // 마우스리스너 (마우스어댑터)
			@Override
			public void mouseEntered(MouseEvent arg0) { // 버튼위에 커서가 올라가면 손가락
														// 모양으로 바뀜
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) { // 버튼에서 벗어나면 원래대로 돌아옴
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) { // 눌렀다떼면 땅땅지대 필드 맵으로 전환
				jframe.fieldViewMaker();
				jframe.changePanel(new WaterFieldView(jframe));
			}
		});
		button[2].addMouseListener(new MouseAdapter() { // 마우스리스너 (마우스어댑터)
			@Override
			public void mouseEntered(MouseEvent arg0) { // 버튼위에 커서가 올라가면 손가락
														// 모양으로 바뀜
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) { // 버튼에서 벗어나면 원래대로 돌아옴
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) { // 눌렀다떼면 화산지대 필드 맵으로 전환
				jframe.fieldViewMaker();
				jframe.changePanel(new GrassFieldView(jframe));
			}
		});
		button[3].addMouseListener(new MouseAdapter() { // 마우스리스너 (마우스어댑터)
			@Override
			public void mouseEntered(MouseEvent arg0) { // 버튼위에 커서가 올라가면 손가락
														// 모양으로 바뀜
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) { // 버튼에서 벗어나면 원래대로 돌아옴
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) { // 눌렀다떼면 바다지대 필드 맵으로 전환
				jframe.fieldViewMaker();
				jframe.changePanel(new EarthFieldView(jframe));
			}
		});
	}
}
