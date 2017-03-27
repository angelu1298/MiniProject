package fieldmap;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import fieldmap.LoadSlot;

public class StartView extends JPanel {
	ImageIcon icon;
	JPanel panel;

	public StartView(ExecGame jframe) {

		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);

		JButton brandNewStart = new JButton();
		brandNewStart.setIcon(new ImageIcon("image/startbutton.png"));
		brandNewStart.setBorderPainted(false);
		brandNewStart.setContentAreaFilled(false);
		brandNewStart.setFocusPainted(false);
		brandNewStart.setBounds(90, 550, 125, 125);
		brandNewStart.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
				Createuser cu = new Createuser(jframe);
				cu.setVisible(true);
				cu.setSize(550, 550);
				cu.setTitle("캐릭터 생성");		
				
			}
		});
	
		add(brandNewStart);

		JButton loading = new JButton();
		loading.setIcon(new ImageIcon("image/loadbutton.png"));
		loading.setBorderPainted(false);
		loading.setContentAreaFilled(false);
		loading.setFocusPainted(false);
		loading.setBounds(340, 550, 125, 125);
		loading.setFont(new Font("나눔고딕코딩", Font.PLAIN, 17));
		loading.addMouseListener(new MouseAdapter(){	// 불러오기 버튼 마우스리스너
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	// 눌렀다떼면 어떤 캐릭터를 불러올지 선택할 수 있는 LoadSlot창이 뜸
				LoadSlot loadFile = new LoadSlot(jframe);
				loadFile.setBounds(new Rectangle(0, 0, 400, 400));
				loadFile.setVisible(true);			
			}
		});
		add(loading);

		JButton closing = new JButton();
		closing.setIcon(new ImageIcon("image/exitbutton.png"));
		closing.setBorderPainted(false);
		closing.setContentAreaFilled(false);
		closing.setFocusPainted(false);
		closing.setBounds(590, 550, 125, 125);
		closing.setFont(new Font("나눔고딕코딩", Font.PLAIN, 17));
		closing.addMouseListener(new MouseAdapter(){	// 끝내기 버튼 마우스리스너
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	// 눌렀다떼면 프로그램이 끝나면서 창이 닫힘
				if(ExecGame.player!=null)
				ExecGame.player.setLogoutTime();
				jframe.dispose();	
			}
		});
		
		add(closing);

		setLayout(null);
		icon = new ImageIcon("image/초기화면배경.png");

	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(icon.getImage(), 0, 0, this);
	}
}
